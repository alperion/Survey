package com.example.demo.dto.request.manager;

public class GetAnswersBySurveyAndQuestionRequest {

    private String token;
    private String surveyId;

    public GetAnswersBySurveyAndQuestionRequest(String token, String surveyId) {
        this.token = token;
        this.surveyId = surveyId;
    }

    public GetAnswersBySurveyAndQuestionRequest() {
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
