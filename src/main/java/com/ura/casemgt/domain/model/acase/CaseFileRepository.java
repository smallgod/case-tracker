package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.core.exception.DatabaseException;
import com.ura.casemgt.core.exception.DuplicateTransactionException;

/**
 * One repository per Aggregate Root
 *
 * @author smallGod
 **/
public interface CaseFileRepository {

    /**
     * Save a case file
     *
     * @param caseFile
     * @return
     * @throws DuplicateTransactionException
     * @throws DatabaseException
     * @throws NumberFormatException
     */
    Number persistCaseFile(CaseFile caseFile)

            throws DuplicateTransactionException,
            DatabaseException,
            NumberFormatException;

    /**
     * Add an offence to a case
     *
     * @throws NullPointerException
     */
    void addOffence() throws NullPointerException;

    /**
     * Get the most current GEF reference
     *
     * @return
     */
    GEFReference getCurrentReference()
            throws DatabaseException;
}
