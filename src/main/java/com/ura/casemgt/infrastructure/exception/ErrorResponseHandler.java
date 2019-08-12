
package com.ura.casemgt.infrastructure.exception;

import com.ura.casemgt.core.DisplayMsg;
import com.ura.casemgt.core.Validate;
import com.ura.casemgt.core.exception.DisplayMsgException;
import com.ura.casemgt.core.exception.ErrorCode;
import com.ura.casemgt.infrastructure.Logging.log4j.LoggerUtilities;
import com.ura.casemgt.infrastructure.interfaces.web.json.utils.JsonConverter;
import com.ura.casemgt.infrastructure.interfaces.web.json.utils.JsonUtils;

import org.apache.commons.lang.exception.ExceptionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * @author smallGod
 */
public class ErrorResponseHandler extends HttpServlet {

    private static final LoggerUtilities logger
            = new LoggerUtilities(ErrorResponseHandler.class);

    private static final long serialVersionUID = -1884977557720523777L;

    protected void processError(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpURLConnection.HTTP_OK); //for clients that can't handle status code 500
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");

        Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Class className = (Class) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE);//class name of the exception instance that caused the error (or null)
        String errorMessage = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);//error message
        Integer errorStatusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);//status code of the error (e.g. 404, 500 etc.)

        String servletName = (String) request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME);//The Servlet name of the servlet that the errored request was dispatched to
        String requestUri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);//URI of the errored request

        String jsonResponse;
        String displayMsg;
        ErrorCode errorCode;

        if (throwable instanceof DisplayMsgException) {

            DisplayMsgException ex = (DisplayMsgException) throwable;
            displayMsg = ex.getDisplayMsg();
            errorCode = ex.getErrorCode();

        } else {

            if(className == Error.class) {
                displayMsg = DisplayMsg.OOPS_NOT_YOUR_FAULT;
                errorCode = ErrorCode.INTERNAL_ERR;

            } else {

                switch (errorStatusCode) {

                    case HttpURLConnection.HTTP_NOT_FOUND:
                        displayMsg = DisplayMsg.NOT_FOUND;
                        errorCode = ErrorCode.BAD_REQUEST_ERR;
                        break;

                    default:
                        displayMsg = DisplayMsg.CONTACT_ADMIN;
                        errorCode = ErrorCode.INTERNAL_ERR;
                        break;
                }
            }

        }
        logError(errorCode, displayMsg, errorMessage, className, throwable);

        try {

            ExceptionResponse error
                    = createExceptionResponse(errorCode,
                    displayMsg,
                    className,
                    throwable);

            jsonResponse = JsonConverter
                    .convertToJson(error, ExceptionResponse.class);

        } catch (RuntimeException ex) {

            jsonResponse = "" +
                    "{\n" +
                    "        \"success\":false,\n" +
                    "        \"data\":{\n" +
                    "            \"error_code\":" + errorCode + ",\n" +
                    "            \"display_message\":" + displayMsg + ",\n" +
                    "            \"additional_details\":" + className + ", another error writing JSON\n" +
                    "         }\n" +
                    "}";

            logger.error("Error! while converting error to JSON " +
                    "- original error is: " + ex.getMessage());

        } catch (Exception  ex) {

            jsonResponse = "" +
                    "{\n" +
                    "        \"success\":false,\n" +
                    "        \"data\":{\n" +
                    "            \"error_code\":" + errorCode + ",\n" +
                    "            \"display_message\":" + displayMsg + ",\n" +
                    "            \"additional_details\":" + className + ", another error writing JSON\n" +
                    "         }\n" +
                    "}";

            logger.error("Error! while converting error to JSON " +
                    "- original error is: " + ex.getMessage());
        }

        JsonUtils.writeResponse(response, jsonResponse);
    }

    /**
     * Create error response
     * sent to error-page
     *
     * @return
     */
    private ExceptionResponse createExceptionResponse(ErrorCode errorCode,
                                                      String displayMsg,
                                                      Class errorClass,
                                                      Throwable throwable) {
        String localisedMsg = errorClass + " : ";
        if (Validate.isNotNull(throwable)) {
            localisedMsg += throwable.getLocalizedMessage();
        }
        ExceptionResponse response = new ExceptionResponse();
        ExceptionResponse.Data data = response.new Data();
        response.setData(data);

        data.setErrorCode(errorCode);
        data.setDisplayMessage(displayMsg);
        data.setAdditionalDetails(localisedMsg);

        return response;
    }

    private void logError(ErrorCode errorCode,
                          String displayMsg,
                          String errorMessage,
                          Class className,
                          Throwable throwable) {

        logger.error("Error Code   : " + errorCode.getValue());
        logger.error("Error Display: " + displayMsg);
        logger.error("Error Message: " + errorMessage);
        logger.error("Error Class  : " + className);
        logger.error(ExceptionUtils.getFullStackTrace(throwable));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    @Override
    public String getServletInfo() {
        return "This is an error response servlet!";
    }
}