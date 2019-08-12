package com.ura.casemgt.core.exception;

import com.ura.casemgt.domain.shared.Constant;
import com.ura.casemgt.domain.shared.ValueObject;

/**
 * @author smallGod
 */
public enum ErrorCode implements ValueObject<ErrorCode>, Constant {

    INVALID_USER_INPUT,
    FILE_NOT_FOUND_ERR,
    BAD_STATE_ERR,
    BAD_REQUEST_ERR,
    BAD_RESPONSE_ERR,
    PROCESSING_ERR,
    FORMAT_ERR,
    INTERNAL_ERR,
    ARITHMETIC_ERR,
    UNAUTHORISED_CLIENT_ERR,
    INVALID_CREDENTIALS_ERR,
    PASSWORDS_DONT_MATCH_ERR,
    USER_NOT_EXIST_ERR,
    HANDSHAKE_ERR,
    LOGIN_ERR,
    NO_SESSION_ERR,
    COMMUNICATION_ERR,
    READ_TIMEOUT_ERR,
    CONNECTION_TIMEOUT_ERR,
    TIMEOUT_ERR,
    NOT_SUPPORTED_ERR,
    INVALID_REQUEST_ERR,
    NOT_CONFIGURED_ERR,
    BENEFICIARY_ACCOUNT_NOT_FOUND_ERR,
    INVALID_ACCOUNT_DETAILS_ERR,
    THIRDPARTY_SYSTEM_ERR,
    BAD_LOGIN_TOKEN_ERR,
    TERMS_AND_CONDITIONS_ERR,
    ACCOUNT_VERIFICATION_ERR,
    SECURITY_ERR,
    FILE_UPLOAD_ERR,
    DATABASE_ERR,
    APPLICATION_ERR,
    NOT_ENOUGH_FUNDS,
    GENERAL_ERR,
    UNKNOWN_ERR,
    JSON_TAG_OR_VALUE_NULL,
    DUPLICATE_TRANSACTION;

    ErrorCode() {}

    @Override
    public String getValue() {
        return this.name();
    }

    @Override
    public boolean isSameAs(ErrorCode other) {
        return other != null && this == other;
    }
}