/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ura.casemgt.infrastructure.Logging.log4j;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;


/**
 * @author smallGod
 */
public final class ExceptionLogger {

    private final String log4jFile;
    private final String logDir;

    public ExceptionLogger(final String log4jFile, final String logDir) {
        this.log4jFile = log4jFile;
        this.logDir = logDir;
    }

    public void configure()
            throws FileNotFoundException {

        System.setProperty("log4j.configurationFile", this.log4jFile);
        System.setProperty("logDir", this.logDir);

        LoggerContext context = (LoggerContext) LogManager
                .getContext(true);
        File file = new File(this.log4jFile);

        if (file.exists()) {
            context.setConfigLocation(file.toURI());
        } else {
            throw new FileNotFoundException();
        }
    }
}

