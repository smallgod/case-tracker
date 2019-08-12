package com.ura.casemgt.api.implementation;

import com.ura.casemgt.api.service.NewCaseService;
import com.ura.casemgt.core.ReferenceGenerator;
import com.ura.casemgt.core.Validate;
import com.ura.casemgt.core.exception.DatabaseException;
import com.ura.casemgt.core.exception.DuplicateTransactionException;
import com.ura.casemgt.core.utilities.ProcessingMutex;
import com.ura.casemgt.domain.model.acase.*;
import com.ura.casemgt.domain.service.GEFReferenceGeneratorService;
import com.ura.casemgt.domain.service.dto.NewCaseServiceResult;
import com.ura.casemgt.core.utilities.NamedConstants;

import java.util.Calendar;

/**
 * @author smallGod
 */
public class NewCaseServiceImpl implements
        NewCaseService, GEFReferenceGeneratorService {

    @Override
    public NewCaseServiceResult provideService(Case input,
                                        CaseFileRepository repository)
            throws DuplicateTransactionException,
            DatabaseException,
            NumberFormatException {

        /**
         * Generation of a case reference and persistence
         * of a case need to happen together
         */
        synchronized (ProcessingMutex.CREATE_CASE) {

            GEFReference generatedRef =
                    this.generateRefNumber(repository);

            CaseFile caseFile = new CaseFile(input, generatedRef);

            long caseFileId = (long) repository
                    .persistCaseFile(caseFile);

            NewCaseServiceResult result = new NewCaseServiceResult
                    .Builder(generatedRef.getReference())
                    .withId(caseFileId)
                    .withDescription("Success, case file generated")
                    .build();

            return result;
        }
    }

    //--> URA/ENF/GEF/0001/2019 <--
    @Override
    public GEFReference generateRefNumber(CaseFileRepository repository)
            throws DatabaseException {

        GEFReference mostCurrentRef = getMostRecentReferenceHelper(repository);

        String[] tokens = mostCurrentRef.getReference().split("/");
        int tokenLen = tokens.length;

        String number = tokens[tokenLen - 2].trim();
        int currentRefyear = Integer.valueOf(tokens[tokenLen - 1].trim());

        int currentYear = Calendar.getInstance()
                .get(Calendar.YEAR);

        StringBuilder refBuilder = new StringBuilder();
        refBuilder.append(NamedConstants.CASE_REFERENCE_PREFIX);

        System.out.println("Current yr: " + currentYear + " > Year: " + currentRefyear + ": " + (currentYear>currentRefyear));

        if (currentYear > currentRefyear) {
            refBuilder
                    .append(NamedConstants.START_REF_ID)
                    .append("/")
                    .append(currentYear);
        } else {
            refBuilder
                    .append(ReferenceGenerator.getNextRef(number))
                    .append("/")
                    .append(currentRefyear);
        }
        return new GEFReference(refBuilder.toString());
    }

    /**
     * Helper method to get recent reference
     *
     * @param repository
     * @return
     */
    private GEFReference getMostRecentReferenceHelper(CaseFileRepository repository) {

        GEFReference reference = repository.getCurrentReference();

        if (Validate.isNotNull(reference)){
        System.out.println("retrieved current ref: " + reference.getReference());}

        if (Validate.isNull(reference)
                || Validate.isNull(reference.getReference())
                || reference.getReference().trim().isEmpty()) {

            StringBuilder startRef = new StringBuilder();
            startRef.append(NamedConstants.CASE_REFERENCE_PREFIX)
                    .append(NamedConstants.ZERO_REF_ID)
                    .append("/")
                    .append(Calendar.getInstance().get(Calendar.YEAR));

            reference = new GEFReference(startRef.toString());
        }

        System.out.println("most current ref: " + reference.getReference());
        return reference;
    }
}
