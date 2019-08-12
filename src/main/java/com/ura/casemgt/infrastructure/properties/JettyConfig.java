package com.ura.casemgt.infrastructure.properties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "jetty-config")
public class JettyConfig {

    @XmlElement(name = "http-port")
    protected int httpPort;
    @XmlElement(name = "https-port")
    protected int httpsPort;
    @XmlElement(name = "admin-port")
    protected int adminPort;
    @XmlElement(name = "output-buffersize")
    protected int outputBuffersize;
    @XmlElement(name = "request-headersize")
    protected int requestHeadersize;
    @XmlElement(name = "response-headersize")
    protected int responseHeadersize;
    @XmlElement(name = "context-path", required = true)
    protected String contextPath;
    @XmlElement(name = "relative-resourcedir", required = true)
    protected String relativeResourcedir;
    @XmlElement(name = "webxml-file", required = true)
    protected String webxmlFile;
    @XmlElement(name = "webapp-warfile", required = true)
    protected String webappWarfile;
    @XmlElement(name = "keystore-pass", required = true)
    protected String keystorePass;
    @XmlElement(name = "keystore-path", required = true)
    protected String keystorePath;
    @XmlElement(name = "keystore-managerpass", required = true)
    protected String keystoreManagerpass;
    @XmlElement(name = "welcome-files", required = true)
    protected String welcomeFiles;

    /**
     * Gets the value of the httpPort property.
     *
     */
    public int getHttpPort() {
        return httpPort;
    }

    /**
     * Sets the value of the httpPort property.
     *
     */
    public void setHttpPort(int value) {
        this.httpPort = value;
    }

    /**
     * Gets the value of the httpsPort property.
     *
     */
    public int getHttpsPort() {
        return httpsPort;
    }

    /**
     * Sets the value of the httpsPort property.
     *
     */
    public void setHttpsPort(int value) {
        this.httpsPort = value;
    }

    /**
     * Gets the value of the adminPort property.
     *
     */
    public int getAdminPort() {
        return adminPort;
    }

    /**
     * Sets the value of the adminPort property.
     *
     */
    public void setAdminPort(int value) {
        this.adminPort = value;
    }

    /**
     * Gets the value of the outputBuffersize property.
     *
     */
    public int getOutputBuffersize() {
        return outputBuffersize;
    }

    /**
     * Sets the value of the outputBuffersize property.
     *
     */
    public void setOutputBuffersize(int value) {
        this.outputBuffersize = value;
    }

    /**
     * Gets the value of the requestHeadersize property.
     *
     */
    public int getRequestHeadersize() {
        return requestHeadersize;
    }

    /**
     * Sets the value of the requestHeadersize property.
     *
     */
    public void setRequestHeadersize(int value) {
        this.requestHeadersize = value;
    }

    /**
     * Gets the value of the responseHeadersize property.
     *
     */
    public int getResponseHeadersize() {
        return responseHeadersize;
    }

    /**
     * Sets the value of the responseHeadersize property.
     *
     */
    public void setResponseHeadersize(int value) {
        this.responseHeadersize = value;
    }

    /**
     * Gets the value of the contextPath property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContextPath() {
        return contextPath;
    }

    /**
     * Sets the value of the contextPath property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContextPath(String value) {
        this.contextPath = value;
    }

    /**
     * Gets the value of the relativeResourcedir property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRelativeResourcedir() {
        return relativeResourcedir;
    }

    /**
     * Sets the value of the relativeResourcedir property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRelativeResourcedir(String value) {
        this.relativeResourcedir = value;
    }

    /**
     * Gets the value of the webxmlFile property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWebxmlFile() {
        return webxmlFile;
    }

    /**
     * Sets the value of the webxmlFile property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWebxmlFile(String value) {
        this.webxmlFile = value;
    }

    /**
     * Gets the value of the webappWarfile property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWebappWarfile() {
        return webappWarfile;
    }

    /**
     * Sets the value of the webappWarfile property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWebappWarfile(String value) {
        this.webappWarfile = value;
    }

    /**
     * Gets the value of the keystorePass property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKeystorePass() {
        return keystorePass;
    }

    /**
     * Sets the value of the keystorePass property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKeystorePass(String value) {
        this.keystorePass = value;
    }

    /**
     * Gets the value of the keystorePath property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKeystorePath() {
        return keystorePath;
    }

    /**
     * Sets the value of the keystorePath property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKeystorePath(String value) {
        this.keystorePath = value;
    }

    /**
     * Gets the value of the keystoreManagerpass property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKeystoreManagerpass() {
        return keystoreManagerpass;
    }

    /**
     * Sets the value of the keystoreManagerpass property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKeystoreManagerpass(String value) {
        this.keystoreManagerpass = value;
    }

    /**
     * Gets the value of the welcomeFiles property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWelcomeFiles() {
        return welcomeFiles;
    }

    /**
     * Sets the value of the welcomeFiles property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWelcomeFiles(String value) {
        this.welcomeFiles = value;
    }

}