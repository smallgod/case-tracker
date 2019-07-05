package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class LastName implements ValueObject<LastName> {

    private final String name;

    public LastName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isSameAs(LastName other) {
        return other != null && this.getName().equals(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof FirstName)) return false;
        return this.isSameAs((LastName) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }
}
