package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.*;

/**
 * @author smallGod
 **/
public class CaseFile implements Entity<CaseFile> {

    private final Case aCase;
    private final GEFReference aGEFReference;

    public CaseFile(Case aCase, GEFReference aGEFReference) {
        this.aCase = aCase;
        this.aGEFReference = aGEFReference;
    }

    public GEFReference getGEFReference() {
        return aGEFReference;
    }

    public Case getaCase() {
        return aCase;
    }

    @Override
    public boolean sameIdentityAs(final CaseFile other) {
        return other != null &&
                this.aGEFReference.isSameAs(other.aGEFReference);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof CaseFile)) return false;
        return this.sameIdentityAs((CaseFile) o);
    }

    @Override
    public int hashCode() {
        return aGEFReference.hashCode();
    }

    @Override
    public String toString() {
        return aGEFReference.toString();
    }
}