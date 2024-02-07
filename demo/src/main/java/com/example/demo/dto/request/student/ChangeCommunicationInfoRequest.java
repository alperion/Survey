package com.example.demo.dto.request.student;

public class ChangeCommunicationInfoRequest {


    private String email;
    private String phoneNumber;
    private String token;

    public ChangeCommunicationInfoRequest(String email, String phoneNumber, String token) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.token = token;
    }

    public ChangeCommunicationInfoRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
