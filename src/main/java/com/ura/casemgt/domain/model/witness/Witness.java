package com.ura.casemgt.domain.model.witness;

import com.ura.casemgt.core.PhoneNumber;
import com.ura.casemgt.core.specification.Specification;
import com.ura.casemgt.domain.shared.*;

/**
 * Let's keep Getters as much as possible out of this domain object and encapsulate it's business Logic inside
 * @author smallGod
 **/
public abstract class Witness implements Entity<Witness> {

    //Domain objects should have behaviour - A bounded context is built around an Aggregate.
    //An aggregate is everything that should be processed in one transaction

    private  long id;
    private WitnessNumber witnessNumber;
    private WitnessIdentity witnessIdentity;
    private PhoneNumber phoneNumber;
    private EmailAddress emailAddress;
    private KeepAnonymous isKeepAnonymous;
    private KeyInformation keyInformation;

    /**
     * Witness details that link him/her back to their identity
     * should be stored encrypted in the database, especially if they have isKeepAnonymous == True.
     * Witnesses can only be unmasked by a restricted special operation
     *
     * @param witnessIdentity
     */
    void maskWitnessIdentity(WitnessIdentity witnessIdentity) {}

    void unMaskWitnessIdentity(){}

    void changeWitnessIdentity(){}

    void maskWitnessContacts(PhoneNumber phoneNumber, EmailAddress emailAddress) {}

    @Override
    public boolean sameIdentityAs(Witness other) {
        return other != null && this.witnessNumber().sameValueAs(other.witnessNumber());
    }


//    public Witness() {}
//
//    public FirstName getFirstName() {
//        return firstName;
//    }
//
//
//    public void setFirstName(FirstName firstName) {
//        this.firstName = firstName;
//    }
//
//    public LastName getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(LastName lastName) {
//        this.lastName = lastName;
//    }
//
//    public OtherNames getOtherNames() {
//        return otherNames;
//    }
//
//    public void setOtherNames(OtherNames otherNames) {
//        this.otherNames = otherNames;
//    }
//
//    public IdentificationType getIdentificationType() {
//        return identificationType;
//    }
//
//    public void setIdentificationType(IdentificationType identificationType) {
//        this.identificationType = identificationType;
//    }
//
//    public IdentificationNumber getIdenticationNumber() {
//        return identicationNumber;
//    }
//
//    public void setIdenticationNumber(IdentificationNumber identicationNumber) {
//        this.identicationNumber = identicationNumber;
//    }
//
//    public PhoneNumber getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(PhoneNumber phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public EmailAddress getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(EmailAddress emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    public KeepAnonymous getIsKeepAnonymous() {
//        return isKeepAnonymous;
//    }
//
//    public void setIsKeepAnonymous(KeepAnonymous isKeepAnonymous) {
//        this.isKeepAnonymous = isKeepAnonymous;
//    }
//
//    public KeyInformation getKeyInformation() {
//        return keyInformation;
//    }
//
//    public void setKeyInformation(KeyInformation keyInformation) {
//        this.keyInformation = keyInformation;
//    }
}
