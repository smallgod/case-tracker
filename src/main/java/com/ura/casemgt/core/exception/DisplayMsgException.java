package com.ura.casemgt.core.exception;

import com.ura.casemgt.core.DisplayMsg;

/**
 * @author smallGod
 */
public abstract class DisplayMsgException extends RuntimeException implements DisplayMsg {

    public DisplayMsgException(String message, Throwable cause) {
        super(message, cause);
    }

    public DisplayMsgException(Throwable cause) {
        super(cause);
    }

    /**
     * Message to display to a user
     *
     * @return user display message
     */
    public abstract String getDisplayMsg();

    /**
     * Get this exceptions' custom error code
     *
     * @return
     */
    public abstract ErrorCode getErrorCode();
}
