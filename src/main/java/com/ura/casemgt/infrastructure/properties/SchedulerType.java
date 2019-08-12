package com.ura.casemgt.infrastructure.properties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scheduler-type",
        namespace = "https://cases.ura.go.ug/properties/v1_0/types",
        propOrder = {

})
public class SchedulerType {

    @XmlElement(required = true)
    protected String triggername;
    @XmlElement(required = true)
    protected String jobname;
    @XmlElement(required = true)
    protected String groupname;
    protected int interval;

    /**
     * Gets the value of the triggername property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTriggername() {
        return triggername;
    }

    /**
     * Sets the value of the triggername property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTriggername(String value) {
        this.triggername = value;
    }

    /**
     * Gets the value of the jobname property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getJobname() {
        return jobname;
    }

    /**
     * Sets the value of the jobname property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setJobname(String value) {
        this.jobname = value;
    }

    /**
     * Gets the value of the groupname property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * Sets the value of the groupname property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGroupname(String value) {
        this.groupname = value;
    }

    /**
     * Gets the value of the interval property.
     *
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     *
     */
    public void setInterval(int value) {
        this.interval = value;
    }

}