package com.ura.casemgt.domain.model.witness;

import com.ura.casemgt.core.PhoneNumber;
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


}
