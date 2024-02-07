package com.example.demo.dto.response.manager;

import com.example.demo.entity.Survey;

import java.util.List;

public class GetAllSurveyResponse {

    List<Survey> surveys;

    public GetAllSurveyResponse(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public GetAllSurveyResponse() {
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }
}
