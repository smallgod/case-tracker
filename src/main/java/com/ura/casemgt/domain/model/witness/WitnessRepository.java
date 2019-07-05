package com.ura.casemgt.domain.model.witness;

import com.ura.casemgt.domain.shared.Repository;

/**
 * One repository per Aggregate Root
 *
 * @author smallGod
 **/
public interface WitnessRepository extends Repository<Witness>{

    /**
     * Finds a witness by their Identity
     *
     * @param witnessIdentity witness Identity
     * @return The Witness, or null if not found.
     */
    Witness findWitness(WitnessIdentity witnessIdentity);
}
