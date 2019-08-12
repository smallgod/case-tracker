package com.ura.casemgt.domain.shared;

public interface ServiceResultToApiTransferable<I, O> {

    /**
     * Takes in a domain / Service result and converts/transfers it to a raw API object response
     * @param serviceResult a result from a service e.g. {id, case-ref, description}
     * @return an API response
     */
    O transfer(I serviceResult) ;
}
