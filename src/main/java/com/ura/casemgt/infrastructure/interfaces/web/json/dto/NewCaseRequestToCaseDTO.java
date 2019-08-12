package com.ura.casemgt.infrastructure.interfaces.web.json.dto;

import com.ura.casemgt.core.utilities.DateUtils;
import com.ura.casemgt.domain.model.acase.*;
import com.ura.casemgt.domain.shared.Json2DomainTransferable;
import com.ura.casemgt.domain.shared.LocationName;
import com.ura.casemgt.domain.shared.LocationType;
import com.ura.casemgt.infrastructure.interfaces.web.json.api.CreateCaseFileRequest;
import com.ura.casemgt.infrastructure.interfaces.web.json.utils.JsonConverter;

import java.time.LocalDateTime;

/**
 * Transfer/Convert JSON string to Domain object
 *
 * @author smallGod
 */
public class NewCaseRequestToCaseDTO
        implements Json2DomainTransferable<String, Case> {

    @Override
    public Case transfer(String jsonRequest) {

        CreateCaseFileRequest request = JsonConverter
                .convertFromJson(jsonRequest, CreateCaseFileRequest.class);

        CreateCaseFileRequest.Params params = request.getParams();

        BriefFacts briefFacts = new BriefFacts(params.getBriefFacts());
        CaseCategory category = params.getCategory();
        LocalDateTime openningDate = DateUtils
                .convertToLocalDateTime(params.getOpenningDate());
        Subject subject = new Subject(params.getSubject());
        CaseSummary summary = new CaseSummary(params.getSummary());
        LocationName locationName = new LocationName(params.getPlaceOfOffence().getName());
        LocationType locationType = params.getPlaceOfOffence().getType();

        PlaceOfOffence placeOfOffence
                = new PlaceOfOffence(locationType, locationName);

        Case aCase = new Case(openningDate,
                category,
                subject,
                summary,
                briefFacts,
                placeOfOffence);

        return aCase;
    }
}
