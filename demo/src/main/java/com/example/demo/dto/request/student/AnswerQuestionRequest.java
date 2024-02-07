package com.example.demo.dto.request.student;

public class AnswerQuestionRequest{

    private String questionId;
    private String surveyId;
    private String token;
    private String answer;

    public AnswerQuestionRequest(String questionId, String surveyId,String token,String answer) {
        this.questionId = questionId;
        this.surveyId = surveyId;
        this.token=token;
        this.answer=answer;
    }

    public AnswerQuestionRequest() {
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



}
