package com.example.demo.dto.request;

public class BaseRequest {
    private String token;

    public BaseRequest(String token) {
        this.token = token;
    }

    public BaseRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
