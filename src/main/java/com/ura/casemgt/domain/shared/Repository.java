package com.ura.casemgt.domain.shared;

public interface Repository<T> {

    /**
     * Retrieve an entity by it's ID
     *
     * @param id
     * @return
     */
    T findById(long id);
}
