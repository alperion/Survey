package com.example.demo.dto.response.manager;

import com.example.demo.entity.Answer;

import java.util.HashMap;
import java.util.List;

public class GetAnswersBySurveyAndQuestionResponse {

    private HashMap<String,List<Answer>> questionAndAnswers;

    public GetAnswersBySurveyAndQuestionResponse(HashMap<String, List<Answer>> questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;
    }

    public GetAnswersBySurveyAndQuestionResponse() {
    }

    public HashMap<String, List<Answer>> getQuestionAndAnswers() {
        return questionAndAnswers;
    }

    public void setQuestionAndAnswers(HashMap<String, List<Answer>> questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;
    }
}
