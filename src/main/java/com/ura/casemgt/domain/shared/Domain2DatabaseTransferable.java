package com.ura.casemgt.domain.shared;

/**
 * Takes in a Domain object (Entity/Value object)
 * and transfers/converts it to a database/Hibernate object
 *
 * @author smallGod
 */
public interface Domain2DatabaseTransferable<I, O> {

    /**
     * Takes in a domain object and transfers it a requried database object
     * @param objectToTransfer object to be transfered
     * @return the object that has been transfered
     */
    O transfer(I objectToTransfer);
}
