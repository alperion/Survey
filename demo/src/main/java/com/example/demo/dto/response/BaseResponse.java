package com.example.demo.dto.response;

public class BaseResponse {
    private String message;
    private int statusCode;

    public BaseResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
