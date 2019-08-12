package com.ura.casemgt.api.service;

import com.ura.casemgt.core.exception.DatabaseException;

/**
 * @author smallGod
 *
 * Provide a service and return result
 *
 * @param <I> input
 * @param <S> repository/storage
 * @param <O> -output / result of service
 */
public interface Service<I, S, O> {

    /**
     * Provides a service
     *
     * @param input
     * @param storage
     * @return -ouput  of service
     * @throws DatabaseException
     */
    O provideService(I input, S storage)
            throws DatabaseException;
}
