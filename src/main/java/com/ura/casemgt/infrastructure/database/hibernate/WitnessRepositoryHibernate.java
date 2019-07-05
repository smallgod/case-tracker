package com.ura.casemgt.infrastructure.database.hibernate;

import com.ura.casemgt.domain.model.witness.WitnessIdentity;
import com.ura.casemgt.domain.model.witness.WitnessRepository;

public class WitnessRepositoryHibernate
        extends HibernateRepository implements WitnessRepository {

    @Override
    public Witness findWitness(final WitnessIdentity witnessIdentity) {

        //Returning a Hibernate Witness

        Witness witness = (Witness) getSession().
                createQuery("from witness where witnessIdentity = :wi").
                setParameter("wi", witnessIdentity).
                uniqueResult();;

        return witness;
    }
}
