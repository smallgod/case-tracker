package com.ura.casemgt.api.service;

import com.ura.casemgt.domain.model.acase.Case;
import com.ura.casemgt.domain.model.acase.CaseFileRepository;
import com.ura.casemgt.domain.service.dto.NewCaseServiceResult;

/**
 * @author smallGod
 */
public interface NewCaseService
        extends Service<Case, CaseFileRepository, NewCaseServiceResult> {
}
