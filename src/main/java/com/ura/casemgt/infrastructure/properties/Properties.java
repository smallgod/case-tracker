package com.ura.casemgt.infrastructure.properties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "properties",
        namespace = "https://cases.ura.go.ug/properties/v1_0")
public class Properties {

    @XmlElement(name = "connection-parameters", required = true)
    protected Properties.ConnectionParameters connectionParameters;
    @XmlElement(name = "configuration-files", required = true)
    protected Properties.ConfigurationFiles configurationFiles;
    @XmlElement(name = "job-schedulers", required = true)
    protected Properties.JobSchedulers jobSchedulers;

    /**
     * Gets the value of the connectionParameters property.
     *
     * @return
     *     possible object is
     *     {@link Properties.ConnectionParameters }
     *
     */
    public Properties.ConnectionParameters getConnectionParameters() {
        return connectionParameters;
    }

    /**
     * Sets the value of the connectionParameters property.
     *
     * @param value
     *     allowed object is
     *     {@link Properties.ConnectionParameters }
     *
     */
    public void setConnectionParameters(Properties.ConnectionParameters value) {
        this.connectionParameters = value;
    }

    /**
     * Gets the value of the configurationFiles property.
     *
     * @return
     *     possible object is
     *     {@link Properties.ConfigurationFiles }
     *
     */
    public Properties.ConfigurationFiles getConfigurationFiles() {
        return configurationFiles;
    }

    /**
     * Sets the value of the configurationFiles property.
     *
     * @param value
     *     allowed object is
     *     {@link Properties.ConfigurationFiles }
     *
     */
    public void setConfigurationFiles(Properties.ConfigurationFiles value) {
        this.configurationFiles = value;
    }

    /**
     * Gets the value of the jobSchedulers property.
     *
     * @return
     *     possible object is
     *     {@link Properties.JobSchedulers }
     *
     */
    public Properties.JobSchedulers getJobSchedulers() {
        return jobSchedulers;
    }

    /**
     * Sets the value of the jobSchedulers property.
     *
     * @param value
     *     allowed object is
     *     {@link Properties.JobSchedulers }
     *
     */
    public void setJobSchedulers(Properties.JobSchedulers value) {
        this.jobSchedulers = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="log4j" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="hibernate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="hibernate-customtypes" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="web-server" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="sms-server" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="whitelist" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class ConfigurationFiles {

        @XmlElement(name = "log4j", required = true)
        protected String log4J;
        @XmlElement(required = true)
        protected String hibernate;
        @XmlElement(name = "hibernate-customtypes", required = true)
        protected String hibernateCustomtypes;
        @XmlElement(name = "web-server", required = true)
        protected String webServer;
        @XmlElement(name = "sms-server", required = true)
        protected String smsServer;
        @XmlElement(required = true)
        protected String whitelist;

        /**
         * Gets the value of the log4J property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getLog4J() {
            return log4J;
        }

        /**
         * Sets the value of the log4J property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setLog4J(String value) {
            this.log4J = value;
        }

        /**
         * Gets the value of the hibernate property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getHibernate() {
            return hibernate;
        }

        /**
         * Sets the value of the hibernate property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setHibernate(String value) {
            this.hibernate = value;
        }

        /**
         * Gets the value of the hibernateCustomtypes property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getHibernateCustomtypes() {
            return hibernateCustomtypes;
        }

        /**
         * Sets the value of the hibernateCustomtypes property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setHibernateCustomtypes(String value) {
            this.hibernateCustomtypes = value;
        }

        /**
         * Gets the value of the webServer property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getWebServer() {
            return webServer;
        }

        /**
         * Sets the value of the webServer property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setWebServer(String value) {
            this.webServer = value;
        }

        /**
         * Gets the value of the smsServer property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSmsServer() {
            return smsServer;
        }

        /**
         * Sets the value of the smsServer property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSmsServer(String value) {
            this.smsServer = value;
        }

        /**
         * Gets the value of the whitelist property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getWhitelist() {
            return whitelist;
        }

        /**
         * Sets the value of the whitelist property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setWhitelist(String value) {
            this.whitelist = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="conn-timeout" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="read-timeout" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="max-total-conns" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="connections-per-route" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class ConnectionParameters {

        @XmlElement(name = "conn-timeout")
        protected int connTimeout;
        @XmlElement(name = "read-timeout")
        protected int readTimeout;
        @XmlElement(name = "max-total-conns")
        protected int maxTotalConns;
        @XmlElement(name = "connections-per-route")
        protected int connectionsPerRoute;

        /**
         * Gets the value of the connTimeout property.
         *
         */
        public int getConnTimeout() {
            return connTimeout;
        }

        /**
         * Sets the value of the connTimeout property.
         *
         */
        public void setConnTimeout(int value) {
            this.connTimeout = value;
        }

        /**
         * Gets the value of the readTimeout property.
         *
         */
        public int getReadTimeout() {
            return readTimeout;
        }

        /**
         * Sets the value of the readTimeout property.
         *
         */
        public void setReadTimeout(int value) {
            this.readTimeout = value;
        }

        /**
         * Gets the value of the maxTotalConns property.
         *
         */
        public int getMaxTotalConns() {
            return maxTotalConns;
        }

        /**
         * Sets the value of the maxTotalConns property.
         *
         */
        public void setMaxTotalConns(int value) {
            this.maxTotalConns = value;
        }

        /**
         * Gets the value of the connectionsPerRoute property.
         *
         */
        public int getConnectionsPerRoute() {
            return connectionsPerRoute;
        }

        /**
         * Sets the value of the connectionsPerRoute property.
         *
         */
        public void setConnectionsPerRoute(int value) {
            this.connectionsPerRoute = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="processor-job" type="{https://cases.ura.go.ug/properties/v1_0/types}scheduler-type"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class JobSchedulers {

        @XmlElement(name = "processor-job", required = true)
        protected SchedulerType processorJob;

        /**
         * Gets the value of the processorJob property.
         *
         * @return
         *     possible object is
         *     {@link SchedulerType }
         *
         */
        public SchedulerType getProcessorJob() {
            return processorJob;
        }

        /**
         * Sets the value of the processorJob property.
         *
         * @param value
         *     allowed object is
         *     {@link SchedulerType }
         *
         */
        public void setProcessorJob(SchedulerType value) {
            this.processorJob = value;
        }

    }

}
