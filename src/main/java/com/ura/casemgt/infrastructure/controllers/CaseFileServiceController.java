package com.ura.casemgt.infrastructure.controllers;

import com.ura.casemgt.api.implementation.NewCaseServiceImpl;
import com.ura.casemgt.api.service.ServiceName;
import com.ura.casemgt.domain.model.acase.Case;
import com.ura.casemgt.domain.service.dto.NewCaseServiceResult;
import com.ura.casemgt.domain.shared.Json2DomainTransferable;
import com.ura.casemgt.domain.shared.ServiceResultToApiTransferable;
import com.ura.casemgt.infrastructure.database.hibernate.CaseFileRepositoryHibernate;
import com.ura.casemgt.infrastructure.interfaces.web.json.dto.NewCaseRequestToCaseDTO;
import com.ura.casemgt.infrastructure.interfaces.web.json.dto.NewCaseServiceResultToApiTransferer;

/**
 * @author smallGod
 */
public class CaseFileServiceController
        extends ChainProcessorBase {

    private final CaseFileRepositoryHibernate repository
            = new CaseFileRepositoryHibernate();

    public CaseFileServiceController() {
        super();
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     * If a null result is returned, another processor will be called
     * to try and handle this request via the Chain of Responsibility Pattern
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception{

//        switch (super.serviceName){
//
//            case CREATE_CASE_FILE:
//                break;
//
//            case UPDATE_CASE:
//                break;
//
//                default:
//
//        }

        if (super.serviceName.isSameAs(
                ServiceName.CREATE_CASE_FILE)) {

            //request - input
            Json2DomainTransferable<String, Case> apiRequest
                    = new NewCaseRequestToCaseDTO();
            Case aCase = apiRequest.transfer(super.request);

            //service
            NewCaseServiceImpl service = new NewCaseServiceImpl();
            NewCaseServiceResult result = service.provideService(aCase, repository);

            //response - output
            ServiceResultToApiTransferable<NewCaseServiceResult, String> apiResponse
                    = new NewCaseServiceResultToApiTransferer();
            String response = apiResponse.transfer(result);

            return response;

        } else {
            return super.moveToNextInChain(
                    super.currentProcessorId,
                    super.request,
                    super.serviceName);
        }
    }
}
