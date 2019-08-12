package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.Constant;
import com.ura.casemgt.domain.shared.ValueObject;

import javax.transaction.NotSupportedException;

/**
 * @author smallGod
 **/
public enum LocationOfFile
        implements ValueObject<LocationOfFile>, Constant {

    INTELLIGENCE("Intelligence"),
    OMD("OMD"),
    LITIGATION("Litigation"),
    EXECUTIVE("Executive - CCD"),
    ARCHIVE("Archive"),
    UNSANCTIONED("Un-sanctioned");

    private String enumString;

    LocationOfFile(String value) {
        this.enumString = value;
    }

    public static LocationOfFile convertToEnum(String enumValue)
            throws NotSupportedException {

        if (enumValue != null) {

            for (LocationOfFile value : LocationOfFile.values()) {

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
    public boolean isSameAs(LocationOfFile other) {
        return other != null && this == other;
    }
}
