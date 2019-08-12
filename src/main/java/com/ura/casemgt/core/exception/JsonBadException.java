package com.ura.casemgt.core.exception;

import com.ura.casemgt.core.DisplayMsg;

/**
 * @author smallGod
 */
public final class JsonBadException
        extends DisplayMsgException {

    private static final long serialVersionUID
            = 3599015809889620759L;

    private final String displayMsg;

    /**
     * Required JSON tag or its value is Null
     *
     */
    public JsonBadException(Throwable throwable) {
        super(DisplayMsg.BAD_JSON, throwable);
        this.displayMsg = DisplayMsg.BAD_JSON;
    }

    @Override
    public String getDisplayMsg() {
        return displayMsg;
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.BAD_REQUEST_ERR;
    }
}
