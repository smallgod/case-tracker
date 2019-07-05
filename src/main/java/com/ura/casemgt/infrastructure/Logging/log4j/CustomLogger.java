/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ura.casemgt.infrastructure.Logging.log4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author smallGod
 */
public final class CustomLogger {

    private static final String logTag = "URA - eCase Manager: ";
    private Logger LOGGER;

    public CustomLogger() throws FileNotFoundException, Exception {
    }

    /**
     * Configure the log4J2.xml file
     *
     * @param log4jFile
     * @throws FileNotFoundException
     * @throws Exception
     */
    public static void configureLog4J(String log4jFile)
            throws FileNotFoundException, Exception {

        System.out.println("configureLog4J Called, yay!");

        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File file = new File(log4jFile);
        if (file.exists()) {
            context.setConfigLocation(file.toURI());
        } else {
            throw new FileNotFoundException("Failed to find file @: " + log4jFile);
        }

        //Properties props = new Properties();
        //props.put("logsFolder", paramsToPass);
        //DOMConfigurator.setParameter(elem, propSetter, props);
        //DOMConfigurator.configure(log4jFile); //XML configurator
        //MapLookup.setMainArguments(paramsToPass);
        //PropertyConfigurator.configure(log4jPropsFileLoc);//Property file configurator
    }

    /**
     * Configure the log4J2.xml file
     *
     * @param log4jFile
     * @param logDir
     * @throws FileNotFoundException
     * @throws Exception
     */
    public static void configureLog4J(String log4jFile, String logDir)
            throws FileNotFoundException, Exception {

        System.out.println("configureLog4J Called, yay!");

        System.setProperty("log4j.configurationFile", log4jFile);
        System.setProperty("logDir", logDir);

        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File file = new File(log4jFile);
        if (file.exists()) {
            context.setConfigLocation(file.toURI());
        } else {
            throw new FileNotFoundException("Failed to find file @: " + log4jFile);
        }

        //Properties props = new Properties();
        //props.put("logsFolder", paramsToPass);
        //DOMConfigurator.setParameter(elem, propSetter, props);
        //DOMConfigurator.configure(log4jFile); //XML configurator
        //MapLookup.setMainArguments(paramsToPass);
        //PropertyConfigurator.configure(log4jPropsFileLoc);//Property file configurator
    }

    /**
     * Get Default DateTimeNow with Kampala timezone and date-time-dash format
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

    public <T> void addLogger(final Class<T> loggerClass) {
        //this.LOGGER = LoggerFactory.getLogger(loggerClass);
        this.LOGGER = LogManager.getLogger(loggerClass);

    }

    public void debug(String debugLogText) {

        String log = formatLog(debugLogText);

        if (this.LOGGER != null) {
            this.LOGGER.debug(log);
        } else {
            System.out.println(log);
        }
    }

    public void info(String infoLogText) {

        String log = formatLog(infoLogText);

        if (LOGGER != null) {
            LOGGER.info(log);
        } else {
            System.out.println(log);
        }
    }

    public void error(String errorLogText) {

        String log = formatLog(errorLogText);

        if (LOGGER != null) {
            LOGGER.error(log);
        } else {
            System.err.println(log);
        }
    }

    public void warn(String warnLogText) {

        String log = formatLog(warnLogText);

        if (LOGGER != null) {
            LOGGER.warn(log);
        } else {
            System.out.println(log);
        }
    }

    public void fatal(String fatalLogText) {

        String log = formatLog(fatalLogText);

        if (LOGGER != null) {
            LOGGER.error(log);
            System.exit(-1);
        } else {
            System.err.println(log);
            System.exit(-1);
        }

    }

    /**
     * Format Log message
     *
     * @param logText
     * @return
     */
    private String formatLog(String logText) {

        Map<String, Object> map = new HashMap<>();
        map.put("dateTime", getDefaultDateTimeNow());
        map.put("logger", this.LOGGER != null ? this.LOGGER.getClass().getSimpleName() : "LOGGER is NULL");
        map.put("logText", logText);

        String log = "[{dateTime}] [{logger}] - {logText}";
        //return (MapFormat.format(log, map));

        return logTag + logText;

    }
}

