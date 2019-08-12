package com.ura.casemgt.domain.service;

import com.ura.casemgt.core.exception.DatabaseException;
import com.ura.casemgt.domain.model.acase.CaseFileRepository;
import com.ura.casemgt.domain.model.acase.GEFReference;

public interface GEFReferenceGeneratorService {

    /**
     * Generate a Reference number for a new case file
     *
     * @param repository
     * @return
     * @throws DatabaseException
     */
    GEFReference generateRefNumber(CaseFileRepository repository)
            throws DatabaseException;
}