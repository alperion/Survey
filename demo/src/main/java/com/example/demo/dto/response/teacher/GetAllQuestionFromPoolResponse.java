package com.example.demo.dto.response.teacher;

import com.example.demo.entity.Question;

import java.util.List;

public class GetAllQuestionFromPoolResponse {
        List<Question> questions;

    public GetAllQuestionFromPoolResponse(List<Question> questions) {
        this.questions = questions;
    }

    public GetAllQuestionFromPoolResponse() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
