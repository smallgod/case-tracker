package com.ura.casemgt.infrastructure.server.embedded_jetty;

import com.ura.casemgt.infrastructure.properties.JettyConfig;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

import java.io.File;
import java.io.FileNotFoundException;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;

/**
 * @author smallGod
 */
public class JettyServer {

    private final JettyConfig serverConfig;
    private final Server server;

    private final ServerConnectorFactory serverConnectorFactory;
    private final ServerHandlerFactory serverHandlerFactory;
    private HttpConfiguration defaultHTTPConfig;

    private String webResourcesDir;

    public JettyServer(JettyConfig serverConfig, String baseDir) {

        this.server = new Server();
        this.server.setStopAtShutdown(true); //see where to put these
        this.server.setStopTimeout(60 * 1000);

        this.serverConfig = serverConfig;
        this.webResourcesDir = baseDir + File.separator
                + this.serverConfig.getRelativeResourcedir();

        defaultHTTPConfig = new HttpConfiguration();

        serverConnectorFactory = new ServerConnectorFactory();
        serverHandlerFactory = new ServerHandlerFactory();
    }

    public void defaultConfigure() {

        this.addDefaultConnector();
        this.addDefaultHandler();
    }

    public void addHttpConfigs(
            boolean isSendServerVersion,
            boolean isSendDateHeader) {

        defaultHTTPConfig = serverConnectorFactory
                .createHTTPConfigs(server,
                        defaultHTTPConfig,
                        serverConfig.getOutputBuffersize(),
                        serverConfig.getRequestHeadersize(),
                        serverConfig.getResponseHeadersize(),
                        isSendServerVersion,
                        isSendDateHeader);
    }

    public ServerConnector addConnectorConfigs(
            ServerConnector serverConnector,
            long IDLE_TIMEOUT) {
        return serverConnectorFactory.setConnectorConfigs(serverConnector, IDLE_TIMEOUT);
    }

    private void addDefaultConnector() {

        addHttpConnector();
    }

    public void addHttpConnector() {

        Connector httpConnector
                = serverConnectorFactory.createHttpConnector(
                server, defaultHTTPConfig, serverConfig.getHttpPort());
        server.addConnector(httpConnector);
    }

    public void addHttpsConnector(
            final int HTTPS_PORT,
            final String KEYSTORE_PATH,
            final String KEYSTORE_PASS,
            final String KEYSTORE_MGR_PASS
    ) throws FileNotFoundException {

        Connector httpsConnector = serverConnectorFactory
                .createHttpsConnector(server, defaultHTTPConfig,
                        HTTPS_PORT,
                        KEYSTORE_PATH,
                        KEYSTORE_PASS,
                        KEYSTORE_MGR_PASS);
        server.addConnector(httpsConnector);
    }

    public void addAdminConnector(final int ADMIN_PORT) {

        Connector adminConnector = serverConnectorFactory
                .createAdminConnector(server, defaultHTTPConfig, ADMIN_PORT);
        server.addConnector(adminConnector);
    }

    /**
     * Add web app context handler with the default values passed in constructor
     */
    public void addWebAppContextHandler() {

        System.out.println("Resource Dir  : " + webResourcesDir);

        Handler webAppContextHandler
                = serverHandlerFactory.createWebAppContextHandler(
                serverConfig.getContextPath(),
                webResourcesDir, webResourcesDir + serverConfig.getWebxmlFile());
        server.setHandler(webAppContextHandler);
    }

    /**
     * Add web app context handler with the default values passed in constructor
     *
     * @return
     */
    private void addDefaultHandler() {
        addWebAppContextHandler();
    }

    /**
     * Looks for a matching file in the local directory to serve
     *
     * @param welcomeFiles
     * @param isDirectoriesListed
     */
    public void addResourceHandler(String[] welcomeFiles, Boolean isDirectoriesListed) {
        Handler resourceHandler = serverHandlerFactory
                .createResourceHandler(welcomeFiles,
                        webResourcesDir,
                        isDirectoriesListed);
        server.setHandler(resourceHandler);
    }

    /**
     * A ContextHandler is a HandlerWrapper that responds only to requests that
     * have a URI prefix that matches the configured context path. Requests that
     * match the context path have their path methods updated accordingly, and
     * the following optional context features applied as appropriate: A Thread
     * Context classloader. A set of attributes A set of init parameters A
     * resource base (aka document root) A set of virtual host names. Requests
     * that don't match are not handled.
     *
     * @param welcomeFiles
     */
    public void addContextHandler(String[] welcomeFiles) {
        Handler contextHandler = serverHandlerFactory.createContextHandler(welcomeFiles,
                webResourcesDir,
                serverConfig.getContextPath());
        server.setHandler(contextHandler);
    }

    /**
     * A ServletContextHandler is a specialization of ContextHandler with
     * support for standard servlets.
     *
     * @param welcomeFiles
     */
    public void getServletContextHandler(String[] welcomeFiles) {
        Handler servletHander = serverHandlerFactory.createServletContextHandler(welcomeFiles,
                webResourcesDir,
                serverConfig.getContextPath());
        server.setHandler(servletHander);
    }

    /**
     * Add one or multiple connectors
     *
     * @param connectors
     */
    private void addConnectors(Connector... connectors) {
        server.setConnectors(connectors);
        //server.setConnectors(new Connector[]{ connector0, connector1, ssl_connector });
    }


    /**
     * Exactly one handler can be set here
     *
     * @param handler
     */
    private void addHandler(Handler handler) {
        server.setHandler(handler);
    }

    /**
     * Add one or multiple handlers
     *
     * @param handlers
     */
    private void addHandlers(Handler... handlers) {
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(handlers);
        server.setHandler(contexts);
    }

    /**
     * Start Jetty server
     *
     * @return true if server is started
     * @throws java.lang.Exception
     */
    public boolean startServer() throws Exception {

        boolean isStarted = Boolean.FALSE;

        // Extra options
        server.setDumpAfterStart(true);
        server.setDumpBeforeStop(true);
        server.setStopAtShutdown(true);

        if (!(server.isRunning() || server.isStarting() || server.isStarted())) {

            server.start();
            server.dumpStdErr();
            //server.join(); //think of putting this inside an executor so that it doesn't hang

            if (server.isStarted() || server.isStarting() || server.isRunning()) {
                isStarted = Boolean.TRUE;
            } else {
                System.out.println("Couldn't start server despite a non-conflicting state: " + server.getState());
            }

        } else {
            System.out.println("Can't start server - state: " + server.getState());
        }
        return isStarted;
    }

    /**
     * Try to stop the server
     *
     * @return true if server is stopped
     * @throws java.lang.Exception
     */
    public boolean stopServer() throws Exception {

        boolean isStopped = Boolean.FALSE;

        server.stop();

        if (server.isStopped() || server.isStopping()) {
            System.out.println("Jetty server successful stopped or is stopping.. - " + server.getState());
            isStopped = Boolean.TRUE;
        }

        return isStopped;
    }

    /**
     * Method needs to be called first
     * before the start method
     */
    public void configure() {

        addHttpConfigs(true, true);
        addHttpConnector();
        addWebAppContextHandler();
    }
}

