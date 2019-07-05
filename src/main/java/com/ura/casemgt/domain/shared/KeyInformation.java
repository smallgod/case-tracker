package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class KeyInformation implements ValueObject<KeyInformation> {

    private final String information;

    public KeyInformation(String information) {
        this.information = information;
    }

    public String getInformation() {
        return this.information;
    }

    @Override
    public boolean isSameAs(KeyInformation other) {
        return other != null && this.getInformation().equals(other.getInformation());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof KeyInformation)) return false;
        return this.isSameAs((KeyInformation) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getInformation());
    }
}
