package com.example.demo.dto.response.teacher;

import com.example.demo.entity.Survey;

import java.util.List;

public class GetMySurveysResponse {
    private List<Survey> surveys;

    public GetMySurveysResponse(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public GetMySurveysResponse() {
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }
}
