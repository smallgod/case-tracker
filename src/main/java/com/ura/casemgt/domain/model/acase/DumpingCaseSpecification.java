package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.core.specification.AbstractSpecification;

/**
 * Check if this case is a DUMPING case.
 * We need to alert management about all DUMPING cases
 *
 * @author smallGod
 */
public class DumpingCaseSpecification
        extends AbstractSpecification<CaseCategory> {
    /**
     * {@inheritDoc}
     *
     * @param caseCategory
     */
    @Override
    public boolean isSatisfiedBy(CaseCategory caseCategory) {

        return caseCategory == CaseCategory.DUMPING ? true: false;
    }
}
