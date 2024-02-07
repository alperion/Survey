package com.example.demo.dto.request.teacher;

import com.example.demo.entity.Question;

import java.util.List;

public class AddQuestionToSurveyRequest {
    private String surveyId;
    private List<Question> questions;
    private String token;

    public AddQuestionToSurveyRequest(String surveyId, List<Question> questions, String token) {
        this.surveyId = surveyId;
        this.questions = questions;
        this.token = token;
    }

    public AddQuestionToSurveyRequest() {
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
