package com.example.loginregisterwithphp;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;

    public RegisterResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
