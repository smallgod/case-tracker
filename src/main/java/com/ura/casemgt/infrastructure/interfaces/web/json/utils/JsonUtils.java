package com.ura.casemgt.infrastructure.interfaces.web.json.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.ura.casemgt.api.service.ServiceName;
import com.ura.casemgt.core.DisplayMsg;
import com.ura.casemgt.core.Validate;
import com.ura.casemgt.core.exception.JsonBadException;
import com.ura.casemgt.core.exception.JsonExtractionException;
import com.ura.casemgt.core.utilities.NamedConstants;
import com.ura.casemgt.infrastructure.Logging.log4j.LoggerUtilities;
import org.apache.commons.lang.exception.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public final class JsonUtils {

    private static final LoggerUtilities logger
            = new LoggerUtilities(JsonUtils.class);

    /**
     * Extracts a JSON string from the request
     *
     * @param request
     * @return
     * @throws JsonExtractionException
     */
    public static String extractJson(HttpServletRequest request)
            throws JsonExtractionException {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        JsonExtractionException err = null;
        String s;

        try {

            reader = request.getReader();
            do {
                s = reader.readLine();
                if (s != null) {
                    sb.append(s);
                } else {
                    break;
                }
            } while (true);

        } catch (IllegalStateException | IOException exception) {
            err = new JsonExtractionException(exception);

        } catch (RuntimeException exception) {
            err = new JsonExtractionException(exception);

        } catch (Exception exception) {
            err = new JsonExtractionException(exception);

        } finally {
            closeBufferedReader(reader);
        }

        String json = sb.toString().trim();

        if (Validate.isNotNull(err) || json.length() < 1) {
            throw err;
        }
        return json;
    }

    /**
     * Convert a JSON string to pretty print version
     *
     * @param jsonString
     * @return
     * @throws JsonBadException
     */
    public static String toPrettyJson(String jsonString)
            throws JsonBadException {

        try {

            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(jsonString).getAsJsonObject();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            return gson.toJson(json);

        } catch (JsonIOException | JsonSyntaxException exception) {
            throw new JsonBadException(exception);

        } catch (JsonParseException exception) {
            throw new JsonBadException(exception);
        }
    }


    /**
     * Get the method name value with key "method" if Json request or enclosing
     * method root name if xml request
     *
     * @param jsonRequest
     * @return
     * @throws IOException
     */
    public static ServiceName getServiceName(String jsonRequest)
            throws JsonParseException, IOException, JsonBadException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonRequest);

        JsonNode returnNode = rootNode
                .path(NamedConstants.JSON_METHOD_NODENAME);

        if (returnNode.isMissingNode() || returnNode.isNull()) {
            throw new JsonBadException(new Throwable(DisplayMsg.BAD_JSON));
        } else {

            ServiceName serviceName = ServiceName
                    .convertToEnum(returnNode.asText());
            return serviceName;
        }
    }


    private static void closeBufferedReader(BufferedReader reader) {

        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ex) {
                logger.error("Error, closing buffered reader");
                logger.error(ExceptionUtils.getFullStackTrace(ex));
            }
        }
    }


    /**
     * Write a response back to client
     *
     * @param response
     * @param responseToWrite
     * @throws IOException
     */
    public static void writeResponse(HttpServletResponse response,
                                     String responseToWrite)
            throws IOException {

        PrintWriter out = response.getWriter();
        out.write(responseToWrite);
        out.flush();
        response.flushBuffer();
    }
}
