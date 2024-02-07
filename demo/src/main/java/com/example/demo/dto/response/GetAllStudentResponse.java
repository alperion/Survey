package com.example.demo.dto.response;

import com.example.demo.entity.Consumer;
import com.example.demo.entity.Student;

import java.util.List;

public class GetAllStudentResponse {
    List<Consumer> students;

    public GetAllStudentResponse(List<Consumer> students) {
        this.students = students;
    }

    public GetAllStudentResponse() {
    }

    public List<Consumer> getStudents() {
        return students;
    }

    public void setStudents(List<Consumer> students) {
        this.students = students;
    }
}
