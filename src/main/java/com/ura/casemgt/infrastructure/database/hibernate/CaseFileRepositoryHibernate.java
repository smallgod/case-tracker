package com.ura.casemgt.infrastructure.database.hibernate;

import com.ura.casemgt.core.Validate;
import com.ura.casemgt.core.exception.DatabaseException;
import com.ura.casemgt.core.exception.DuplicateTransactionException;
import com.ura.casemgt.domain.model.acase.*;
import com.ura.casemgt.domain.shared.Domain2DatabaseTransferable;
import com.ura.casemgt.infrastructure.database.hibernate.dto.CaseFileDTO;
import com.ura.casemgt.infrastructure.database.hibernate.dto.CaseFileToDatabaseTransferer;

/**
 * @author smallGod
 */
public class CaseFileRepositoryHibernate
        extends HibernateRepository<CaseFileDTO> implements CaseFileRepository {

    @Override
    public Number persistCaseFile(CaseFile caseFile)
            throws NumberFormatException,
            DuplicateTransactionException,
            DatabaseException {

        Domain2DatabaseTransferable<CaseFile, CaseFileDTO> dto
                = new CaseFileToDatabaseTransferer();

        CaseFileDTO caseFileDTO = dto.transfer(caseFile);

        return super.save(caseFileDTO);
    }


    @Override
    public void addOffence() {
    }

    /**
     * Get the most current case file reference number
     *
     * @return
     * @throws DatabaseException
     * @inherit
     */
    @Override
    public GEFReference getCurrentReference()
            throws DatabaseException {

        CaseFileDTO caseFile = (CaseFileDTO) super
                .getMostRecentRecord(CaseFileDTO.class, "id");

        return Validate.isNull(caseFile) ? null :
                new GEFReference(caseFile.getGefReferenceNumber());
    }
}