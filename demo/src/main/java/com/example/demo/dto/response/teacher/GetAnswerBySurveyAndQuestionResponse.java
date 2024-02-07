package com.example.demo.dto.response.teacher;

import com.example.demo.entity.Answer;

import java.util.HashMap;
import java.util.List;

public class GetAnswerBySurveyAndQuestionResponse {

   private HashMap<String,List<Answer>> questionAnswer;

    public GetAnswerBySurveyAndQuestionResponse(HashMap<String, List<Answer>> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public GetAnswerBySurveyAndQuestionResponse() {
    }

    public HashMap<String, List<Answer>> getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(HashMap<String, List<Answer>> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
