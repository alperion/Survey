package com.example.demo.dto.request.teacher;

import com.example.demo.entity.Question;

public class AddQuestionToPoolRequest {
    private String token;
    private String question;

    public AddQuestionToPoolRequest(String token, String question) {
        this.token = token;
        this.question = question;
    }

    public AddQuestionToPoolRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
