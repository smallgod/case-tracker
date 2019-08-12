/*
 * Copyright (c) 2018. SmallGod. This code is provided as is and users are solely responsible for its use and any consequences thereof.
 */

package com.ura.casemgt.infrastructure.exception;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ura.casemgt.core.exception.ErrorCode;

/*
    {
        "success":false,
        "data":{
            "error_code":"CLIENT_ERROR",
            "display_message":"User ID was inactivated due to pending OTP verification",
            "additional_details":"additional details to error"
         }
     }
 */

/**
 * @author smallGod
 */
public class ExceptionResponse {

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    public ExceptionResponse() {
        this(Boolean.FALSE);
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

    private ExceptionResponse(boolean success) {
        this.success = success;
    }

    public class Data {

        @SerializedName("error_code")
        @Expose
        private ErrorCode errorCode;

        @SerializedName("display_message")
        @Expose
        private String displayMessage;

        @SerializedName("additional_details")
        @Expose
        private String additionalDetails;

        public ErrorCode getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(ErrorCode errorCode) {
            this.errorCode = errorCode;
        }

        public String getDisplayMessage() {
            return displayMessage;
        }

        public void setDisplayMessage(String displayMessage) {
            this.displayMessage = displayMessage;
        }

        public String getAdditionalDetails() {
            return additionalDetails;
        }

        public void setAdditionalDetails(String additionalDetails) {
            this.additionalDetails = additionalDetails;
        }
    }
}
