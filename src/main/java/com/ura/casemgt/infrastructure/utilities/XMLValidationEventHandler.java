package com.ura.casemgt.infrastructure.utilities;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;

/**
 * @author smallGod
 */
public class XMLValidationEventHandler implements ValidationEventHandler {

    public XMLValidationEventHandler() {}

    @Override
    public boolean handleEvent(ValidationEvent event) throws RuntimeException {

        if (event == null) {
            throw new NullPointerException("Null ValidationEvent");
        }

        int evenSeverity = event.getSeverity();
        ValidationEventLocator vel = event.getLocator();

        System.out.println("EVENT             :" + event.getClass());
        System.out.println("SEVERITY          :" + evenSeverity);
        System.out.println("MESSAGE           :" + event.getMessage());
        System.out.println("LINKED EXCEPTION  :" + event.getLinkedException());
        System.out.println("LOCATOR");
        System.out.println("   -LINE NUMBER   :" + vel.getLineNumber());
        System.out.println("   -COLUMN NUMBER :" + vel.getColumnNumber());
        System.out.println("   -OFFSET        :" + vel.getOffset());
        System.out.println("   -OBJECT        :" + vel.getObject());
        System.out.println("   -NODE          :" + vel.getNode());
        System.out.println("   -URL           :" + vel.getURL());

        if (evenSeverity == ValidationEvent.ERROR || evenSeverity == ValidationEvent.FATAL_ERROR) {
            String error = "Validation error:  " + event.getMessage() + " at row: " + vel.getLineNumber() + " and column: " + vel.getColumnNumber();
            System.err.println(error);
            return false;
        } else {
            return true;
        }
    }
}
