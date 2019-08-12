/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and users are solely responsible
 * for its use and any consequences thereof.
 */
package com.ura.casemgt.infrastructure.interfaces.web.json.api;

import com.google.gson.annotations.SerializedName;
import com.ura.casemgt.domain.model.acase.CaseCategory;
import com.ura.casemgt.domain.shared.LocationType;

/**
 * @author smallGod
 */
public class CreateCaseFileRequest {

    /*
    {
        "method":"CREATE_CASE_FILE",
        "params":{
            "openning_date":"2019-07-13 19:21:03",
            "category":"DUMPING",
            "subject":"UGANDA VS Senkungu Ronald Harrison alias Ronnie, Oringo Alfred and others still at large."
            "summary":"Uncustomed goods ie 202 bags of Pakistan Rice from MUWONGE SIRAJI MITANGO",,
            "brief_facts":"blah blah...",
            "place_of_offence":{
                 "type":"STATION | BOND | FIELD",
                  "name":"UGMAL"
            }
        }
    }

    {
      "success": true,
      "data": {
          "description":"Case logged successfully!",
          "case_id":"908309",
          "case_gef": "URA-ENF-GEF-1949-2019"
      }
    }
    */
    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "credentials")
    private Credentials credentials;

    @SerializedName(value = "params")
    private Params params;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public class Params {

        @SerializedName(value = "id")
        private long id;

        @SerializedName(value = "openning_date")
        private String openningDate;

        @SerializedName(value = "category")
        private CaseCategory category;

        @SerializedName(value = "subject")
        private String subject;

        @SerializedName(value = "summary")
        private String summary;

        @SerializedName(value = "brief_facts")
        private String briefFacts;

        @SerializedName(value = "place_of_offence")
        private PlaceOfOffence placeOfOffence;

        public Params() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getOpenningDate() {
            return openningDate;
        }

        public void setOpenningDate(String openningDate) {
            this.openningDate = openningDate;
        }

        public CaseCategory getCategory() {
            return category;
        }

        public void setCategory(CaseCategory category) {
            this.category = category;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getBriefFacts() {
            return briefFacts;
        }

        public void setBriefFacts(String briefFacts) {
            this.briefFacts = briefFacts;
        }

        public PlaceOfOffence getPlaceOfOffence() {
            return placeOfOffence;
        }

        public void setPlaceOfOffence(PlaceOfOffence placeOfOffence) {
            this.placeOfOffence = placeOfOffence;
        }


        public class PlaceOfOffence {

            @SerializedName(value = "type")
            private LocationType type;

            @SerializedName(value = "name")
            private String name;

            public LocationType getType() {
                return type;
            }

            public void setType(LocationType type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}

