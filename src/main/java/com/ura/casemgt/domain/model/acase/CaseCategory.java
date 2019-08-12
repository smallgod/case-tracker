package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.Constant;
import com.ura.casemgt.domain.shared.ValueObject;

/**
 * @author smallGod
 **/
public enum CaseCategory
        implements ValueObject<CaseCategory>, Constant {

    DUMPING("Dumping"),
    SMUGGLING("Smuggling");

    private String enumString;

    CaseCategory(String value) {
        this.enumString = value;
    }

    public static CaseCategory convertToEnum(String enumValue) {

        if (enumValue != null) {

            for (CaseCategory value : CaseCategory.values()) {

                if (enumValue.equalsIgnoreCase(value.getValue())) {
                    return value;
                }
            }
        }
        
        throw new EnumConstantNotPresentException(
                CaseCategory.class,
                enumValue);
    }

    @Override
    public String getValue() {
        return this.enumString;
    }

    @Override
    public boolean isSameAs(CaseCategory other) {
        return other != null && this == other;
    }
}
