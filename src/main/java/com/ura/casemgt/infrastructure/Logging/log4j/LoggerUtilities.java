/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ura.casemgt.infrastructure.Logging.log4j;

import org.apache.logging.log4j.LogManager;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smallGod
 */
public final class LoggerUtilities {

    private static final String logTag = "URA - eCase manager: ";
    private Logger LOGGER;

    public <T> LoggerUtilities(final Class<T> loggerClass) {

        try {
            addLogger(loggerClass);
        } catch (UnsupportedOperationException ex) {
            System.err.println("Can't add logger, log to sys print: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Can't add logger, log to sys print: " + ex.getMessage());
        }
    }


    public <T> void addLogger(final Class<T> loggerClass)
            throws UnsupportedOperationException {
        this.LOGGER = LogManager.getLogger(loggerClass);
    }

    public void debug(String debugLogText) {

        String log = formatLog(debugLogText);

        if (this.LOGGER != null) {
            this.LOGGER.debug(log);
        } else {
            System.out.println("Debug: " + log);
        }
    }

    public void info(String infoLogText) {

        String log = formatLog(infoLogText);

        if (LOGGER != null) {
            LOGGER.info(log);
        } else {
            System.out.println("Info: " + log);
        }
    }

    public void error(String errorLogText) {

        String log = formatLog(errorLogText);

        if (LOGGER != null) {
            LOGGER.error(log);
        } else {
            System.err.println("Error: " + log);
        }
    }

    public void warn(String warnLogText) {

        String log = formatLog(warnLogText);

        if (LOGGER != null) {
            LOGGER.warn(log);
        } else {
            System.out.println("Warn: " + log);
        }
    }

    public void fatal(String fatalLogText) {

        String log = formatLog(fatalLogText);

        if (LOGGER != null) {
            LOGGER.fatal(log);
            //System.exit(-1);
        } else {
            System.err.println("Fatal: " + log);
            //System.exit(-1);
        }

    }

    private String formatLog(String logText) {

        Map<String, Object> map = new HashMap<>();
        map.put("dateTime", getDefaultDateTimeNow());
        map.put("logger", this.LOGGER != null ? this.LOGGER.getClass().getSimpleName() : "LOGGER is NULL");
        map.put("logText", logText);
        //String log = "[{dateTime}] [{logger}] - {logText}";
        //return (MapFormat.format(log, map));

        return logTag + logText;
    }

    /**
     * Get Default DateTimeNow with Kampala timezone
     * and date-time-dash format
     *
     * @return
     */
    public static String getDefaultDateTimeNow() {

        DateTime dateNow = DateTime.now();
        DateTimeZone desiredTimeZone = DateTimeZone.forID("Africa/Kampala");
        DateTime dateTime = dateNow.toDateTime(desiredTimeZone);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.print(dateTime);

        return formattedDate;
    }
}

