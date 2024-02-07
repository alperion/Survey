package com.example.demo.dto.response;

public class BaseTokenResponse {
    private String token;
    private int statusCode;
    private String message;

    public BaseTokenResponse(String token, int statusCode, String message) {
        this.token = token;
        this.statusCode = statusCode;
        this.message = message;
    }

    public BaseTokenResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
