package com.ura.casemgt.core.exception;

import com.ura.casemgt.core.DisplayMsg;

/**
 * @author smallGod
 */
public final class NoServiceException
        extends DisplayMsgException {

    private static final long serialVersionUID
            = 3599015809889620756L;

    private final String displayMsg;

    /**
     * If no service is found/configured
     * to handle this request
     *
     */
    public NoServiceException() {
        super(new Throwable(DisplayMsg.NO_SUCH_SERVICE));
        this.displayMsg = DisplayMsg.NO_SUCH_SERVICE;
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
