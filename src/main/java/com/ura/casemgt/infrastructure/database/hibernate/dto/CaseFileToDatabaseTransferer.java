package com.ura.casemgt.infrastructure.database.hibernate.dto;

import com.ura.casemgt.domain.model.acase.*;
import com.ura.casemgt.domain.shared.*;

/**
 * Transfer/Convert Case file domain object
 * to it's database/Hibernate object
 *
 * @author smallGod
 */
public class CaseFileToDatabaseTransferer
        implements Domain2DatabaseTransferable<CaseFile, CaseFileDTO> {

    @Override
    public CaseFileDTO transfer(CaseFile caseFile) {

        Case aCase = caseFile.getaCase();

        GEFReference refNumber = caseFile.getGEFReference();

        PlaceOfOffence offencePlace = aCase.getPlaceOfOffence();
        PlaceOfOffenceEmbeddable place = new PlaceOfOffenceEmbeddable(
                offencePlace.getLocationType(),
                offencePlace.getLocationName().getName()
        );

        CaseFileDTO caseFileDTO = new CaseFileDTO();
        caseFileDTO.setGefReferenceNumber(refNumber.getReference());
        caseFileDTO.setBriefFacts(aCase.getBriefFacts().getFacts());
        caseFileDTO.setPlaceOfOffence(place);
        caseFileDTO.setLocationOfFile(LocationOfFile.UNSANCTIONED);
        caseFileDTO.setOpenningDate(aCase.getOpenningDate());
        caseFileDTO.setCategory(aCase.getCaseCategory());
        caseFileDTO.setStatus(Status.NEW);
        caseFileDTO.setSubject(aCase.getSubject().getText());
        caseFileDTO.setSummary(aCase.getCaseSummary().getText());

        return caseFileDTO;
    }
}
