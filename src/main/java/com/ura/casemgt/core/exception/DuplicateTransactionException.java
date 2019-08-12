package com.ura.casemgt.core.exception;

import com.ura.casemgt.core.DisplayMsg;

/**
 * @author smallGod
 */
public final class DuplicateTransactionException
        extends DisplayMsgException {

    private static final long serialVersionUID
            = 3599015809889620758L;

    private final String displayMsg;

    /**
     * Any exception thrown in the database..
     *
     */
    public DuplicateTransactionException(Throwable throwable) {
        super(DisplayMsg.DUPLICATE, throwable);
        this.displayMsg = DisplayMsg.DUPLICATE;

    }

    @Override
    public String getDisplayMsg() {
        return displayMsg;
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.DUPLICATE_TRANSACTION;
    }
}
