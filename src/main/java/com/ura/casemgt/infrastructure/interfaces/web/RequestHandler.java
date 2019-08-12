package com.ura.casemgt.infrastructure.interfaces.web;

import com.ura.casemgt.api.service.ServiceName;
import com.ura.casemgt.infrastructure.Logging.log4j.LoggerUtilities;
import com.ura.casemgt.infrastructure.controllers.ChainProcessorBase;
import com.ura.casemgt.infrastructure.interfaces.web.json.utils.JsonUtils;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author smallGod
 */
public class RequestHandler extends HttpServlet {

    private static final LoggerUtilities logger
            = new LoggerUtilities(RequestHandler.class);

    private ServiceName serviceName;
    private String jsonRequest;
    private static final long serialVersionUID = -7470512984394456827L;

    //But you should also realize that you should never assign any request or session scoped data as
    //an instance variable of a servlet or filter. It will be shared among all other requests in other sessions.
    //That's threadunsafe!
    //private static JsonProcessor processor; //i think this is not session scoped

    /**
     * The init method is designed to be called only once. It is called when the
     * servlet is first created, and not called again for each user request. So,
     * it is used for one-time initializations, just as with the init method of
     * applets. The servlet is normally created when a user first invokes a URL
     * corresponding to the servlet, but you can also specify that the servlet
     * be loaded when the server is first started. When a user invokes a
     * servlet, a single instance of each servlet gets created, with each user
     * request resulting in a new thread that is handed off to doGet or doPost
     * as appropriate. The init() method simply creates or loads some data that
     * will be used throughout the life of the servlet.
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {

        ServletContext context = getServletContext();
        //processor = (JsonProcessor) context.getAttribute(NamedConstants.JSON_API_SERVER_HANDLER);
    }

    /**
     * The destroy() method is called only once at the end of the life cycle of
     * a servlet. This method gives your servlet a chance to close database
     * connections, halt background threads, write cookie lists or hit counts to
     * disk, and perform other such cleanup activities. After the destroy()
     * method is called, the servlet object is marked for garbage collection
     */
    @Override
    public void destroy() {
        ;
        System.out.println("Put finalisation code here..");
    }

    /**
     * Processes requests for both
     * HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RuntimeException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        logger.debug("Request Handler HITTTT");

        this.jsonRequest = JsonUtils.extractJson(request);
        final String prettyJson = JsonUtils.toPrettyJson(this.jsonRequest);

        logger.info("Begin, Incoming request:----------------------");
        logger.info(prettyJson);
        logger.info("End,   Incoming request:----------------------");

        this.serviceName = JsonUtils
                .getServiceName(jsonRequest);

        final ChainProcessorBase processorInitialiser
                = new ChainProcessorBase() {

            @Override
            public String call() {
                return null;
            }
        };

        String jsonResponse = processorInitialiser
                .moveToNextInChain(-1,
                        RequestHandler.this.jsonRequest,
                        RequestHandler.this.serviceName);

       JsonUtils.writeResponse(response, jsonResponse);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "All requests Handler servlet";
    }
}