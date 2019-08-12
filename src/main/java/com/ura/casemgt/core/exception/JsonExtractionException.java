package com.ura.casemgt.core.exception;

import com.ura.casemgt.core.DisplayMsg;

/**
 * @author smallGod
 */
public final class JsonExtractionException
        extends DisplayMsgException {

    private static final long serialVersionUID
            = 3599015809889620757L;

    private final String displayMsg;

    /**
     * Required JSON tag or its value is Null
     *
     */
    public JsonExtractionException(Throwable throwable) {
        super(DisplayMsg.CONTACT_ADMIN, throwable);
        this.displayMsg = DisplayMsg.CONTACT_ADMIN;
    }

    @Override
    public String getDisplayMsg() {
        return displayMsg;
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.APPLICATION_ERR;
    }
}
