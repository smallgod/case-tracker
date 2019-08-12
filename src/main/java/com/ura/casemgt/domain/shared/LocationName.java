package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class LocationName implements ValueObject<LocationName> {

    private final String name;

    public LocationName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean isSameAs(LocationName other) {
        return other != null && this.getName().equals(other.getName());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof LocationName)) return false;
        return this.isSameAs((LocationName) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }
}
