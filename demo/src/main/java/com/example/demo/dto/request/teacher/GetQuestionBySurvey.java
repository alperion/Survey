package com.example.demo.dto.request.teacher;

public class GetQuestionBySurvey {
    private String token;
    private String surveyId;

    public GetQuestionBySurvey(String token, String surveyId) {
        this.token = token;
        this.surveyId = surveyId;
    }

    public GetQuestionBySurvey() {
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
