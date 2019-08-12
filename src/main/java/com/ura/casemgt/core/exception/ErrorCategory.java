package com.ura.casemgt.core.exception;

import com.ura.casemgt.domain.shared.Constant;

/**
 * @author smallGod
 */
public enum ErrorCategory implements Constant {

    SYSTEM_ERROR("SYSTEM_ERROR"),
    CLIENT_ERROR("CLIENT_ERROR"),
    DEVELOPER_ERROR("DEVELOPER_ERROR");

    private final String errorCategoryValue;

    ErrorCategory(String errorCategoryValue) {
        this.errorCategoryValue = errorCategoryValue;
    }

    @Override
    public String getValue() {
        return this.errorCategoryValue;
    }
}
