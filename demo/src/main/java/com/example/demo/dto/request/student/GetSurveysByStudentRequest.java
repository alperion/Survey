package com.example.demo.dto.request.student;

public class GetSurveysByStudentRequest {

    private String token;
    private  String surveyId;

    public GetSurveysByStudentRequest(String token, String surveyId) {
        this.token = token;
        this.surveyId = surveyId;
    }

    public GetSurveysByStudentRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }
}
