package com.ura.casemgt.domain.service.dto;

import com.ura.casemgt.domain.shared.ServiceResult;


public class NewCaseServiceResult {

    private long caseFileId;
    private String description;
    private String generatedReference;

    private NewCaseServiceResult() {}

    public long getCaseFileId() {
        return caseFileId;
    }

    public String getDescription() {
        return description;
    }

    public String getGeneratedReference() {
        return generatedReference;
    }

    public static class Builder {

        private final String generatedReference;
        private long caseFileId;
        private String description;

        public Builder(String generatedReference) {
            this.generatedReference = generatedReference;
        }

        public Builder withId(long caseFileId) {
            this.caseFileId = caseFileId;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public NewCaseServiceResult build() {

            NewCaseServiceResult serviceDTO = new NewCaseServiceResult();
            serviceDTO.caseFileId = this.caseFileId;
            serviceDTO.description = this.description;
            serviceDTO.generatedReference = this.generatedReference;

            return serviceDTO;
        }
    }
}
