package com.example.demo.dto.request.student;

public class GetQuestionsBySurveyIdRequest {


    private String token ;
    private String surveyId;

    public GetQuestionsBySurveyIdRequest(String token, String surveyId) {
        this.token = token;
        this.surveyId = surveyId;
    }

    public GetQuestionsBySurveyIdRequest() {
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
