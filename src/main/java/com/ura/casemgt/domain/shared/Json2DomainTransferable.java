package com.ura.casemgt.domain.shared;

/**
 * Takes in a raw API request (JSON string)
 * and transfers/converts it to a domain entity/Object
 * <p>
 * Takes in a request object raw API request object e.q. A JSON CreateCaseFile Request
 * and returns a Domain entity/Object
 */
public interface Json2DomainTransferable<I, O> {

    /**
     * Takes in an object and transfers it to the required output object
     * @param objectToTransfer object to be transfered
     * @return the object that has been transfered
     */
    O transfer(I objectToTransfer);
}
