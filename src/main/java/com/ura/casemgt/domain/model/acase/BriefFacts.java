package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.ValueObject;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class BriefFacts implements ValueObject<BriefFacts> {

    private final String facts;

    public BriefFacts(String facts) {
        this.facts = facts;
    }

    public String getFacts() {
        return this.facts;
    }

    @Override
    public boolean isSameAs(BriefFacts other) {
        return other != null && this.getFacts().equals(other.getFacts());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof BriefFacts)) return false;
        return this.isSameAs((BriefFacts) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFacts());
    }
}
