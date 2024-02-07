package com.example.demo.dto.response.student;

import com.example.demo.entity.Question;
import com.example.demo.entity.SurveyQuestion;

import java.util.List;

public class GetQuestionsBySurveyIdResponse {

    List<Question> questions;

    public GetQuestionsBySurveyIdResponse(List<Question> questions) {
        this.questions = questions;
    }

    public GetQuestionsBySurveyIdResponse() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
