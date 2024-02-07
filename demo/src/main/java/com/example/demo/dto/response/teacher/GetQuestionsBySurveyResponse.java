package com.example.demo.dto.response.teacher;

import com.example.demo.entity.Question;
import com.example.demo.entity.SurveyQuestion;

import java.util.List;

public class GetQuestionsBySurveyResponse {

    private List<SurveyQuestion> questions;

    public GetQuestionsBySurveyResponse(List<SurveyQuestion> questions) {
        this.questions = questions;
    }

    public GetQuestionsBySurveyResponse() {
    }

    public List<SurveyQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<SurveyQuestion> questions) {
        this.questions = questions;
    }
}
