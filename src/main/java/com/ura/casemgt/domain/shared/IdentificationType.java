package com.ura.casemgt.domain.shared;

import javax.transaction.NotSupportedException;

/**
 * @author smallGod
 **/
public enum IdentificationType implements ValueObject<IdentificationType>, Constant {

    //@SerializedName(value = "NATIONAL_ID")
    NATIONAL_ID("National ID"),
    PASSPORT_NUMBER("Passport number"),
    STAFF_NUMBER("URA Staff number"), //I think we should have separate idtype enum for staff to separate concerns
    POLICE_NUMBER("Police number"); //I think we should have separate idtype enum for police

    private String enumString;

    IdentificationType(String value) {
        this.enumString = value;
    }

    public static IdentificationType convertToEnum(String enumValue)
            throws NotSupportedException {

        if (enumValue != null) {

            for (IdentificationType value : IdentificationType.values()) {

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
    public boolean isSameAs(IdentificationType other) {
        return other != null && this.getValue().equals(other.getValue());
    }
}
