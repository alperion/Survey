package com.example.demo.dto.request.teacher;

import com.example.demo.entity.Student;

import java.util.List;

public class DeleteStudentFromSurveyRequest {
    private String token;
    private String surveyId;
    private List<Student> students;

    public DeleteStudentFromSurveyRequest(String token, String surveyId, List<Student> students) {
        this.token = token;
        this.surveyId = surveyId;
        this.students = students;
    }

    public DeleteStudentFromSurveyRequest() {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
