package com.example.demo.service;


import com.example.demo.entity.Student;
import com.example.demo.entity.Survey;
import com.example.demo.entity.SurveyStudent;
import com.example.demo.exception.custom.OwnerNotFoundException;
import com.example.demo.repository.SurveyStudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyStudentService {

    private final SurveyStudentRepository surveyStudentRepository;
    private final ConsumerService consumerService;

    private  final  StudentService studentService;
    private final SurveyService surveyService;


    public SurveyStudentService(SurveyStudentRepository surveyStudentRepository, ConsumerService consumerService, StudentService studentService, SurveyService surveyService) {
        this.surveyStudentRepository = surveyStudentRepository;
        this.consumerService = consumerService;
        this.studentService = studentService;
        this.surveyService = surveyService;
    }
    public void addStudentToSurvey(List<Student> students,String surveyId){

        for (Student student:students) {
                if(!consumerService.isExistById(student.getId())){
                    throw new OwnerNotFoundException();
                }
        }
        for (Student student:students) {
            SurveyStudent surveyStudent=new SurveyStudent();
            surveyStudent.setStudentId(student.getId());
            surveyStudent.setSurveyId(surveyId);
            surveyStudentRepository.save(surveyStudent);
        }
    }


    public void deleteStudentBySurveyId(String surveyId) {
            surveyStudentRepository.deleteBySurveyId(surveyId);
    }
    public void deleteStudent(Student student){
            surveyStudentRepository.deleteByStudentId(student.getId());
    }


    public List<Survey> getSurveyStudentByStudentId(String studentId) {
        List<Survey> surveys=new ArrayList<>();
        for (SurveyStudent surveyStudent: surveyStudentRepository.findAllByStudentId(studentId)) {
            Survey survey=new Survey();
            survey.setId(surveyStudent.getSurveyId());
            String surveyName=surveyService.findSurveysById(surveyStudent.getSurveyId()).getSurveyName();
            survey.setSurveyName(surveyName);
            surveys.add(survey);
        }

        return surveys;
    }


    public List<SurveyStudent> findSurveyStudentBySurveyId(String surveyId) {
        return surveyStudentRepository.findAllBySurveyId(surveyId);
    }
}
