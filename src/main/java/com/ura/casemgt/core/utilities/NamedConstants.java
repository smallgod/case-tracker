package com.ura.casemgt.core.utilities;

/**
 * @author smallGod
 */
public interface NamedConstants {

    int TASK_TIMEOUT = 5; //in minutes

    /**
     * Assigned when no ID is found for a record
     */
    String ZERO_REF_ID = "0000"; //Put in DB

    /**
     * Assigned as starting ID
     */
    String START_REF_ID = "0001"; //Put in DB


    /**
     * Case Reference Prefix
     */
    String CASE_REFERENCE_PREFIX = "URA/ENF/GEF/";


    /**---------------------------------------------------------------------------
     * DATE PROPERTIES
     * ---------------------------------------------------------------------------
     */

    /**
     * The DateTime format we are using in this application is in the format
     * "2016-07-25 08:55:09"
     */
    String DATE_TIME_DASH_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * DateTime format without seconds e.g. "2016-07-25 08:55"
     */
    String DATE_TIME_DASH_NO_SECONDS_FORMAT = "yyyy-MM-dd HH:mm";

    /**
     * The Date only format we are using in this application is in the format
     * "2016-07-25"
     */
    String DATE_DASH_FORMAT = "yyyy-MM-dd";

    /**
     * The time represented as Hour:Minute
     */
    String HOUR_MINUTE_FORMAT = "HH:mm";

    /**
     * The time represented as Hour:minute:second
     */
    String HOUR_MINUTE_SEC_FORMAT = "HH:mm:ss";


    /**---------------------------------------------------------------------------
     * DATABASE PROPERTY NAMES
     * ---------------------------------------------------------------------------
     */

    /**
     * A username that last modified a given auditable database entity
     */
    String PROPNAME_LAST_MODIFIED_BY = "lastModifiedBy";

    /**
     * A date when a given auditable database entity was modified
     */
    String PROPNAME_DATE_LAST_MODIFIED = "dateLastModified";

    /**
     * A delimited string with a trail of dates when an auditable database
     * entity has been modified
     */
    String PROPNAME_DATE_MODIFIED_HISTORY = "dateModifiedHistory";
    /**
     * A delimited string with a trail of usernames that have modified an
     * auditable database entity
     */
    String PROPNAME_MODIFIED_BY_HISTORY = "modifiedByHistory";

    /**
     * A username that first created a given auditable database entity
     */
    String PROPNAME_CREATED_BY = "createdBy";

    /**
     * A date when a given auditable database entity was first created
     */
    String PROPNAME_CREATED_ON = "createdOn";
    
    /**
     * All JSON request strings must have a root node named 'method' which
     * identifies the name of the API method being called
     */
    String JSON_METHOD_NODENAME = "method";
}
