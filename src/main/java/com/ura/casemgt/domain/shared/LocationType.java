package com.ura.casemgt.domain.shared;

import javax.transaction.NotSupportedException;

/**
 * @author smallGod
 **/
public enum LocationType implements ValueObject<LocationType>, Constant {

    BOND("Bond"),
    STATION("Station"),
    FIELD("Field");

    private String enumString;

    LocationType(String value) {
        this.enumString = value;
    }

    public static LocationType convertToEnum(String enumValue)
            throws NotSupportedException {

        if (enumValue != null) {

            for (LocationType value : LocationType.values()) {

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
    public boolean isSameAs(LocationType other) {
        return other != null && this.getValue().equals(other.getValue());
    }
}
