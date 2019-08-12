package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.ValueObject;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class GEFReference
        implements ValueObject<GEFReference> {

    private final String reference;

    public GEFReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return this.reference;
    }

    @Override
    public boolean isSameAs(GEFReference other) {
        return other != null && this.getReference().equals(other.getReference());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof GEFReference)) return false;
        return this.isSameAs((GEFReference) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getReference());
    }
}
