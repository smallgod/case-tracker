package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.Constant;
import com.ura.casemgt.domain.shared.ValueObject;

import javax.transaction.NotSupportedException;

/**
 * @author smallGod
 **/
public enum Status implements ValueObject<Status>, Constant {

    NEW("New"),
    PENDING("Pending"),
    IN_COURT("In Court"),
    CLOSED("Closed");

    private String enumString;

    Status(String value) {
        this.enumString = value;
    }

    public static Status convertToEnum(String enumValue)
            throws NotSupportedException {

        if (enumValue != null) {

            for (Status value : Status.values()) {

                if (enumValue.equalsIgnoreCase(value.getValue())) {
                    return value;
                }
            }
        }
        throw new NotSupportedException("Enum value not supported!");
    }

    @Override
    public String getValue() {
        return this.enumString;
    }

    @Override
    public boolean isSameAs(Status other) {
        return other != null && this == other;
    }
}
