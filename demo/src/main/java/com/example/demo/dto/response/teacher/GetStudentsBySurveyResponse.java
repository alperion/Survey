package com.example.demo.dto.response.teacher;

import com.example.demo.entity.Consumer;

import java.util.List;

public class GetStudentsBySurveyResponse {
    private List<Consumer> students;

    public GetStudentsBySurveyResponse(List<Consumer> students) {
        this.students = students;
    }

    public GetStudentsBySurveyResponse() {
    }

    public List<Consumer> getStudents() {
        return students;
    }

    public void setStudents(List<Consumer> students) {
        this.students = students;
    }
}
