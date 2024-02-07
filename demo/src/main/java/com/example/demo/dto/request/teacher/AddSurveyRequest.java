package com.example.demo.dto.request.teacher;

public class AddSurveyRequest {
    private String surveyName;
    private String token;

    public AddSurveyRequest( String surveyName, String token) {

        this.surveyName = surveyName;
        this.token = token;
    }

    public AddSurveyRequest() {
    }



    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
