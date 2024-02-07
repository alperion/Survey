package com.example.demo.dto.request.teacher;

import com.example.demo.entity.Student;

import java.util.List;

public class AddStudentToSurveyRequest {

    private List<Student> students;
    private String token;
    private String surveyId;

    public AddStudentToSurveyRequest(List<Student> students, String token, String surveyId) {
        this.students = students;
        this.token = token;
        this.surveyId = surveyId;
    }

    public AddStudentToSurveyRequest() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
}
