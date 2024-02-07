package com.example.demo.dto.response.student;

import com.example.demo.entity.Survey;
import com.example.demo.entity.SurveyStudent;

import java.util.List;

public class GetStudentSurveyResponse {

   private  List<Survey> surveyStudents;

    public GetStudentSurveyResponse(List<Survey> surveys) {
        this.surveyStudents = surveys;
    }

    public GetStudentSurveyResponse() {
    }

    public List<Survey> getSurveys() {
        return surveyStudents;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveyStudents = surveys;
    }
}
