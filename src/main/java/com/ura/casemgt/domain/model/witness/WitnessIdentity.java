package com.ura.casemgt.domain.model.witness;

import com.ura.casemgt.domain.shared.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author smallGod
 **/
public final class WitnessIdentity implements ValueObject<WitnessIdentity> {

    private FirstName firstName;
    private LastName lastName;
    private OtherNames otherNames;
    private IdentificationType identificationType;
    private IdentificationNumber identicationNumber;

    //Hibernate's
    public WitnessIdentity() {
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public OtherNames getOtherNames() {
        return otherNames;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public IdentificationNumber getIdenticationNumber() {
        return identicationNumber;
    }

    @Override
    public boolean isSameAs(WitnessIdentity other) {

        return other != null && new EqualsBuilder().
                append(this.firstName, other.firstName).
                append(this.lastName, other.lastName).
                append(this.otherNames, other.otherNames).
                append(this.identificationType, other.identificationType).
                append(this.identicationNumber, other.identicationNumber).
                isEquals();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof WitnessIdentity)) return false;
        return this.isSameAs((WitnessIdentity) o);
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().
                append(this.firstName).
                append(this.lastName).
                append(this.otherNames).
                append(this.identificationType).
                append(this.identicationNumber).
                toHashCode();
    }

    @Override
    public String toString() {
        return "WitnessIdentity{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", otherNames=" + otherNames +
                ", identificationType=" + identificationType +
                ", identicationNumber=" + identicationNumber +
                '}';
    }
}
