package com.ura.casemgt.infrastructure.database.hibernate;

import com.ura.casemgt.core.PhoneNumber;
import com.ura.casemgt.domain.shared.*;

/**
 * @author smallGod
 */
public class Witness
        extends com.ura.casemgt.domain.model.witness.Witness {

    private FirstName firstName;
    private LastName lastName;
    private OtherNames otherNames;
    private IdentificationType identificationType;
    private IdentificationNumber identicationNumber;
    private PhoneNumber phoneNumber;
    private EmailAddress emailAddress;
    private KeepAnonymous isKeepAnonymous;
    private KeyInformation keyInformation;

    public Witness() {
    }

   // @Override
    public FirstName getFirstName() {
        return firstName;
    }

    //@Override
    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    public OtherNames getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(OtherNames otherNames) {
        this.otherNames = otherNames;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public IdentificationNumber getIdenticationNumber() {
        return identicationNumber;
    }

    public void setIdenticationNumber(IdentificationNumber identicationNumber) {
        this.identicationNumber = identicationNumber;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public KeepAnonymous getIsKeepAnonymous() {
        return isKeepAnonymous;
    }

    public void setIsKeepAnonymous(KeepAnonymous isKeepAnonymous) {
        this.isKeepAnonymous = isKeepAnonymous;
    }

    public KeyInformation getKeyInformation() {
        return keyInformation;
    }

    public void setKeyInformation(KeyInformation keyInformation) {
        this.keyInformation = keyInformation;
    }

    /**
     * Entities compare by identity, not by attributes.
     *
     * @param other The other entity.
     * @return true if the identities are the same, regardless of other attributes.
     */
    @Override
    public boolean sameIdentityAs(com.ura.casemgt.domain.model.witness.Witness other) {
        return false;
    }
}
