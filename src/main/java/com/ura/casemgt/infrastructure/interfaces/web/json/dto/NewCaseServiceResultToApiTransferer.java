package com.ura.casemgt.infrastructure.interfaces.web.json.dto;

import com.ura.casemgt.domain.service.dto.NewCaseServiceResult;
import com.ura.casemgt.domain.shared.ServiceResultToApiTransferable;
import com.ura.casemgt.infrastructure.interfaces.web.json.api.CreateCaseFileResponse;
import com.ura.casemgt.infrastructure.interfaces.web.json.utils.JsonConverter;

/**
 * @author smallGod
 */
public class NewCaseServiceResultToApiTransferer
        implements ServiceResultToApiTransferable<NewCaseServiceResult, String> {


    @Override
    public String transfer(NewCaseServiceResult serviceResult) {

        CreateCaseFileResponse response = new CreateCaseFileResponse();
        CreateCaseFileResponse.Data data = response.new Data();

        response.setSuccess(Boolean.TRUE);
        response.setData(data);

        data.setId(serviceResult.getCaseFileId());
        data.setDescription(serviceResult.getDescription());
        data.setGefReference(serviceResult.getGeneratedReference());

        String jsonResponse = JsonConverter
                .convertToJson(response, CreateCaseFileResponse.class);

        return jsonResponse;
    }
}
