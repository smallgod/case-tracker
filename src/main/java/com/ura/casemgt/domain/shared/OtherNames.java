package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class OtherNames implements ValueObject<OtherNames> {

    private final String names;

    public OtherNames(String names) {
        this.names = names;
    }

    public String getNames() {
        return names;
    }

    @Override
    public boolean isSameAs(OtherNames other) {
        return other != null && this.getNames().equals(other.getNames());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof FirstName)) return false;
        return this.isSameAs((OtherNames) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNames());
    }
}
