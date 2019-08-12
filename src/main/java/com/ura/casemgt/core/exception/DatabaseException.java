package com.ura.casemgt.core.exception;

import com.ura.casemgt.core.DisplayMsg;

/**
 * @author smallGod
 */
public final class DatabaseException
        extends DisplayMsgException {

    private static final long serialVersionUID
            = 3599015809889620758L;

    private final String displayMsg;

    /**
     * Any exception thrown in the database..
     *
     */
    public DatabaseException(Throwable throwable) {
        super(DisplayMsg.TRY_AGAIN, throwable);
        this.displayMsg = DisplayMsg.TRY_AGAIN;
    }

    @Override
    public String getDisplayMsg() {
        return displayMsg;
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.DATABASE_ERR;
    }
}
