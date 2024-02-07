package com.example.demo.dto.request.teacher;

public class DeleteSurveyRequest {
    private String surveyId;
    private String token;

    public DeleteSurveyRequest(String surveyId, String token) {
        this.surveyId = surveyId;
        this.token = token;
    }

    public DeleteSurveyRequest() {
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
