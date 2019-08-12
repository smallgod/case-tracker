package com.ura.casemgt.core;

/**
 * @author smallGod
 */
public interface DisplayMsg {


    String OOPS_NOT_YOUR_FAULT = "Ooops! Not your fault, something bad happened, try again later";

    String NOT_FOUND = "Requested for resource doesn't exist";

    String NOT_ENOUGH_FUNDS = "You do not have enough funds";

    String CONTACT_ADMIN = "Request failed, contact System admin";

    String NO_SUCH_SERVICE = "Service not available, contact admin";

    String DUPLICATE = "Duplicate entry, not allowed";

    String TRY_AGAIN = "Request failed, please try again later";

    String BAD_JSON = "Badly formatted request, contact system admin";
}
