package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class KeepAnonymous implements ValueObject<KeepAnonymous> {

    private final boolean isKeyAnonymous;

    public KeepAnonymous(boolean isKeyAnonymous) {
        this.isKeyAnonymous = isKeyAnonymous;
    }

    public boolean getIsKeyAnonymous() {
        return this.isKeyAnonymous;
    }

    @Override
    public boolean isSameAs(KeepAnonymous other) {
        return other != null && this.getIsKeyAnonymous() == (other.getIsKeyAnonymous());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof KeepAnonymous)) return false;
        return this.isSameAs((KeepAnonymous) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getIsKeyAnonymous());
    }
}
