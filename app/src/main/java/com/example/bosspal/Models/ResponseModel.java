package com.example.bosspal.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseModel {
    @SerializedName("code")
    @Expose
    String code;
    @SerializedName("message")
    @Expose
    String message;
    public String getMessage() {
        return message;
    }
    public String getCode() {
        return code;
    }
}
