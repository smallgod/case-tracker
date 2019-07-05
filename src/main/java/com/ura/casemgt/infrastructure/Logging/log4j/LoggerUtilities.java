/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ura.casemgt.infrastructure.Logging.log4j;

import java.io.FileNotFoundException;

/**
 *
 * @author smallGod
 */
public final class LoggerUtilities {

    private CustomLogger logger;

    public <T> LoggerUtilities(final Class<T> loggerClass) {

        try {

            logger = new CustomLogger();
            logger.addLogger(loggerClass);

        } catch (Exception ex) {
            System.err.println("Error while initialising logger: " + ex.getMessage());
        }

    }

    /**
     *
     * @param log4jFile
     * @throws FileNotFoundException
     * @throws Exception
     */
    public static void configureLog4J(String log4jFile) throws FileNotFoundException, Exception {
        CustomLogger.configureLog4J(log4jFile);
    }

    /**
     *
     * @param log4jFile
     * @param logDir
     * @throws FileNotFoundException
     * @throws Exception
     */
    public static void configureLog4J(String log4jFile, String logDir) throws FileNotFoundException, Exception {
        CustomLogger.configureLog4J(log4jFile, logDir);
    }

    public void debug(String debugLogText) {

        logger.debug(debugLogText);
    }

    public void info(String infoLogText) {

        logger.info(infoLogText);
    }

    public void error(String errorLogText) {

        logger.error(errorLogText);
    }

    public void warn(String warnLogText) {

        logger.warn(warnLogText);
    }

    public void fatal(String fatalLogText) {

        logger.fatal(fatalLogText);
    }
}

