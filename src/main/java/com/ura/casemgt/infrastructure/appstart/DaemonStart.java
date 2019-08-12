/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ura.casemgt.infrastructure.appstart;

import com.ura.casemgt.core.exception.ReadXmlException;
import com.ura.casemgt.infrastructure.Logging.log4j.ExceptionLogger;
import com.ura.casemgt.infrastructure.Logging.log4j.LoggerUtilities;
import com.ura.casemgt.infrastructure.database.hibernate.CustomHibernate;
import com.ura.casemgt.infrastructure.utilities.XmlPojoBinder;
import com.ura.casemgt.infrastructure.properties.JettyConfig;
import com.ura.casemgt.infrastructure.properties.Properties;
import com.ura.casemgt.infrastructure.server.embedded_jetty.JettyServer;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.lang.exception.ExceptionUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author smallGod
 */
public class DaemonStart
        implements Daemon, ServletContextListener {

    private static final int NUM_OF_THREADS = 50; //TO-DO: Put these in props file
    private static final int STOP_DELAY = 5;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;
    private TaskExecutor taskExecutor;

    private static DaemonContext daemonContext;

    private ExceptionLogger logger;
    private JettyServer server;
    private CustomHibernate database;

    private String profile;
    private String projectDir;
    private String configsDir;
    private String xsdDir;
    private String configsXsdFile;
    private String configsXmlFile;
    private String logsDir;
    private String uploadsDir;

    private Properties properties;
    private JettyConfig configs;

    private String hibernateFile;
    private String log4JFile;

    public static void main(String[] args) {
    }

    @Override
    public void init(DaemonContext context) {

        this.daemonContext = context;

        this.initStartupProperties();
        this.initAppProperties();
        this.initLoggerProperties();
        this.initServerProperties();
        this.initDatabaseProperties();

        try {

            //Make all these singletons
            //ExceptionLogger.getInstance().withProperties().configure();
            logger = new ExceptionLogger(log4JFile, logsDir);
            logger.configure();

            server = new JettyServer(configs, projectDir);
            server.configure();

            database = CustomHibernate.getInstance()
                    .addSessionFactory(hibernateFile);

            taskExecutor = TaskExecutor.getInstance()
                    .configurePool(NUM_OF_THREADS, STOP_DELAY, TIME_UNIT);

        } catch (Exception ex) {
            failDaemon("Error @initialisation", ex);
        }
    }

    @Override
    public void start() {

        try {

            if (!server.startServer()) {
                failDaemon("Error starting Server!");
            }

            LoggerUtilities log = new LoggerUtilities(this.getClass());
            log.debug("TEST DEBUG!!! ");
            log.info("TEST INFO!!!! ");
            log.warn("TEST WARN!!!! ");
            log.error("TEST ERROR!!! ");
            log.fatal("TEST FATAL!!!");

            //server.join(); //hangs, put in executor
        } catch (Exception ex) {
            failDaemon("Error starting Server!", ex);
        }
        System.out.println("Jesus is Wisdom, URA e-Case Mgt started!");
    }

    @Override
    public void stop() {

        try {
            server.stopServer();
            database.shutdown();
            taskExecutor.shutdownPool();
        } catch (Exception ex) {
            failDaemon("Error shutting down", ex);
        }
    }

    @Override
    public void destroy() {
        System.out.println("URA e-Case Mgt destroyed!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet context init: " + sce.getClass().getName());
        //put init variables here for whole container
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet context destroyed: " + sce.getClass().getName());
    }

    private void failDaemon(String failureMsg) {
        failDaemon(failureMsg, new Exception("Daemon failed to start!"));
    }

    private void failDaemon(String failureMsg, Exception failureException) {

        try {
            this.daemonContext.getController()
                    .fail(failureMsg, failureException);

        } catch (IllegalStateException ise) {

            String stackTrace = ExceptionUtils
                    .getFullStackTrace(failureException);
            System.err.println("Stopping daemon! " + stackTrace);
        }
    }

    private String[] loadCommandLineArgs() {

        String[] commandLineArgs = null;

        try {
            commandLineArgs = this.daemonContext
                    .getArguments();

            int expectedArgs = 8;
            if (commandLineArgs.length < expectedArgs) {
                failDaemon("Expected: " + expectedArgs
                        + " startup args");
            }

        } catch (Exception ex) {
            failDaemon("Can't read arguments", ex);
        }
        return commandLineArgs;
    }

    private void initStartupProperties() {

        String[] cmdArgs
                = loadCommandLineArgs();
        this.profile = cmdArgs[0];
        this.projectDir = cmdArgs[1];
        this.configsDir = cmdArgs[2];
        this.xsdDir = cmdArgs[3];
        this.configsXsdFile = cmdArgs[4];
        this.configsXmlFile = cmdArgs[5];
        this.logsDir = cmdArgs[6];
        this.uploadsDir = cmdArgs[7];

        int x = 0;
        for (String cmdLineArg : cmdArgs) {
            System.out.println("cmdLineArg. " + x + " : " + cmdLineArg);
            x++;
        }
    }

    private void initLoggerProperties() {
        this.log4JFile = this.configsDir + File.separator + this.profile + File.separator
                + properties.getConfigurationFiles().getLog4J();
    }

    private void initAppProperties() {
        try {
            this.properties = (Properties) XmlPojoBinder
                    .convertXmlToPojo(
                            this.configsXmlFile,
                            this.configsXsdFile,
                            Properties.class);
        } catch (ReadXmlException ex) {
            failDaemon("Can't init app properties", (Exception) ex.getCause());
        }
    }

    private void initDatabaseProperties() {

        this.hibernateFile = this.configsDir + File.separator + this.profile + File.separator
                + properties.getConfigurationFiles().getHibernate();
    }

    private void initServerProperties() {

        String serverProps = this.configsDir + File.separator + this.profile + File.separator
                + properties.getConfigurationFiles().getWebServer();
        String xsdFile = this.xsdDir + File.separator + "jetty.xsd";

        try {
            this.configs = (JettyConfig) XmlPojoBinder
                    .convertXmlToPojo(serverProps, xsdFile, JettyConfig.class);
        } catch (ReadXmlException ex) {
            failDaemon("Can't init Server properties", (Exception) ex.getCause());
        }
    }
}
