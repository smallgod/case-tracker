package com.ura.casemgt.domain.shared;

import com.ura.casemgt.core.specification.AbstractSpecification;
import com.ura.casemgt.core.Validate;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Email Address Specification.
 * Validates that a given email address is correct
 */
public class EmailAddressSpecification extends AbstractSpecification<EmailAddress> {

    private EmailAddress emailAddress;

    /**
     * @param emailAddress
     */
    public EmailAddressSpecification(EmailAddress emailAddress) {

        //Copied & pasted Apache's Validate class
        Validate.notNull(emailAddress, "Email address is required");
        Validate.notNull(emailAddress.getAddress(), "Email address is required");
        Validate.notEmpty(emailAddress.getAddress().trim(), "Email address cannot be empty");
        Validate.isTrue(emailAddress.getAddress().trim().length() > 100,
                "Email address must be 100 characters or less");

        this.emailAddress = emailAddress;
    }

    /**
     * @return Specified email Address
     */
    public EmailAddress emailAddress() {
        return emailAddress;
    }

    boolean isNameLengthOk(String firstName) throws IllegalArgumentException { //put proper exception

        if (firstName.length() < 1) { //2
            throw new IllegalArgumentException("Please provide first name");
        }
        return Boolean.TRUE;
    }


    @Override
    public boolean isSatisfiedBy(final EmailAddress emailAddress)
            throws IllegalArgumentException{

        String exceptionMessage;
        String emailRegex = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

        try {
            if(Pattern.matches(emailRegex, emailAddress.getAddress())){
                return true;
            }
            exceptionMessage = "Email address format is invalid.";
        } catch (PatternSyntaxException exc) {
            exceptionMessage = "Error with Email regex pattern syntax";
        }

        throw new IllegalArgumentException(exceptionMessage); //change to our custom exception
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
//                append(this.emailAddress, other.emailAddress).
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
//                append(this.emailAddress).toHashCode();
//    }