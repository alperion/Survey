package com.example.demo.dto.response;

import com.example.demo.entity.Consumer;

import java.util.List;

public class GetAllTeacherResponse {
    List<Consumer> teachers;

    public GetAllTeacherResponse(List<Consumer> teachers) {
        this.teachers = teachers;
    }

    public GetAllTeacherResponse() {
    }

    public List<Consumer> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Consumer> teachers) {
        this.teachers = teachers;
    }
}
