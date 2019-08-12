package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class WitnessNumber implements ValueObject<WitnessNumber> {

    private final String number;

    public WitnessNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public boolean isSameAs(WitnessNumber other) {
        return other != null && this.getNumber().equals(other.getNumber());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof WitnessNumber)) return false;
        return this.isSameAs((WitnessNumber) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNumber());
    }
}
