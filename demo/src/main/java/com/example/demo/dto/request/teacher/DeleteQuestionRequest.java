package com.example.demo.dto.request.teacher;

import com.example.demo.entity.Question;

import java.util.List;

public class DeleteQuestionRequest {
    private String token;
    private String surveyId;
    private List<Question> questions;

    public DeleteQuestionRequest(String token, String surveyId, List<Question> questions) {
        this.token = token;
        this.surveyId = surveyId;
        this.questions = questions;
    }

    public DeleteQuestionRequest() {
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
