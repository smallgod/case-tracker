package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class FirstName implements ValueObject<FirstName> {

    private final String name;

    public FirstName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean isSameAs(FirstName other) {
        return other != null && this.getName().equals(other.getName());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof FirstName)) return false;
        return this.isSameAs((FirstName) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }
}
