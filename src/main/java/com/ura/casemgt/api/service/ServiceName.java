package com.ura.casemgt.api.service;

import com.ura.casemgt.domain.shared.Constant;
import com.ura.casemgt.domain.shared.ValueObject;

/**
 * @author smallGod
 */
public enum ServiceName implements ValueObject<ServiceName>, Constant {

    CREATE_USER_ACCOUNT("CREATE_USER_ACCOUNT"),
    AUTHENTICATE_USER("AUTHENTICATE_USER"),
    ACTIVATE_USER("ACTIVATE_USER"),
    SUSPEND_USER("SUSPEND_USER"),

    CREATE_CASE_FILE("CREATE_CASE_FILE"),
    UPDATE_CASE("UPDATE_CASE");

    private final String enumString;

    ServiceName(String value) {
        this.enumString = value;
    }

    public static ServiceName convertToEnum(String enumValue)
            throws EnumConstantNotPresentException {

        if (enumValue != null) {

            for (ServiceName value : ServiceName.values()) {

                if (enumValue.equalsIgnoreCase(value.getValue())) {
                    return value;
                }
            }
        }

        throw new EnumConstantNotPresentException(
                ServiceName.class,
                enumValue);
    }

    @Override
    public String getValue() {
        return this.enumString;
    }

    @Override
    public boolean isSameAs(ServiceName other) {
        return other != null && this == other;
    }
}