package com.ura.casemgt.infrastructure.interfaces.web.json.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author smallgod
 */
public class CreateCaseFileResponse {

    /*
    {
      "success": true,
      "data": {
          "id":"908309",
          "gef_reference": "URA-ENF-GEF-1949-2019",
          "description":"Case logged successfully!"
      }
    }
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    private CreateCaseFileResponse(boolean success) {
        this.success = success;
    }

    public CreateCaseFileResponse() {
        this(Boolean.TRUE);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("id")
        @Expose
        private long id;

        @SerializedName(value = "gef_reference")
        private String gefReference;

        @SerializedName("description")
        @Expose
        private String description;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getGefReference() {
            return gefReference;
        }

        public void setGefReference(String gefReference) {
            this.gefReference = gefReference;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}

