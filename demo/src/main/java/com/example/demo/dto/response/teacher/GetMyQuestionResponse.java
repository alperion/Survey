package com.example.demo.dto.response.teacher;

import com.example.demo.entity.Question;

import java.util.List;

public class GetMyQuestionResponse {

    List<Question> questions;

    public GetMyQuestionResponse(List<Question> questions) {
        this.questions = questions;
    }

    public GetMyQuestionResponse() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
