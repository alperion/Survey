package com.example.demo.dto.response.manager;

import com.example.demo.entity.Consumer;
import com.example.demo.entity.Teacher;

import java.util.HashMap;

public class GetSurveyByTeacherResponse {


    HashMap<String, Consumer> teachers;

    public GetSurveyByTeacherResponse( HashMap<String, Consumer> teachers) {

        this.teachers = teachers;
    }

    public GetSurveyByTeacherResponse() {
    }

    public HashMap<String, Consumer> getTeachers() {
        return teachers;
    }

    public void setTeachers(HashMap<String, Consumer> teachers) {
        this.teachers = teachers;
    }


}
