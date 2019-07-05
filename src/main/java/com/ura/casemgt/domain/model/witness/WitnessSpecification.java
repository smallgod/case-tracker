package com.ura.casemgt.domain.model.witness;

import com.ura.casemgt.core.specification.AbstractSpecification;
import com.ura.casemgt.core.specification.Validate;
import com.ura.casemgt.domain.shared.FirstName;

/**
 * Route specification. Describes where a cargo origin and destination is,
 * and the arrival deadline.
 */
public class WitnessSpecification extends AbstractSpecification<FirstName> {

    private FirstName firstName;

    /**
     * @param firstName
     */
    public WitnessSpecification(FirstName firstName) {

        //Copied & pasted Apache's Validate class
        Validate.notNull(firstName, "First name is required");
        Validate.notNull(firstName.getName(), "First name is required");
        Validate.notEmpty(firstName.getName().trim(), "First name cannot be empty");

        this.firstName = firstName;
    }

    /**
     * @return Specified first name.
     */
    public FirstName firstName() {
        return firstName;
    }

    boolean isNameLengthOk(String firstName) throws IllegalArgumentException { //put proper exception

        if (firstName.length() < 1) { //2
            throw new IllegalArgumentException("Please provide first name");
        }
        return Boolean.TRUE;
    }


    @Override
    public boolean isSatisfiedBy(final FirstName firstName) {
        return isNameLengthOk(firstName.getName());
    }
}




///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////



//    @Override
//    public boolean isSameAs(final FirstNameSpecification other) {
//        return other != null && new EqualsBuilder().
//                append(this.firstName, other.firstName).
//                isEquals();
//    }
//
//    @Override
//    public boolean equals(final Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        return isSameAs((FirstNameSpecification) o);
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().
//                append(this.firstName).toHashCode();
//    }