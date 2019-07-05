package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class IdentificationNumber implements ValueObject<IdentificationNumber> {

    private final String number;

    public IdentificationNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public boolean isSameAs(IdentificationNumber other) {
        return other != null && this.getNumber().equals(other.getNumber());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof IdentificationNumber)) return false;
        return this.isSameAs((IdentificationNumber) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNumber());
    }
}
