package com.example.demo.controller;

import com.example.demo.dto.request.teacher.*;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.GetAllStudentResponse;
import com.example.demo.dto.response.teacher.*;
import com.example.demo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping("/add_survey")
    public ResponseEntity<BaseResponse> addSurvey(@RequestBody AddSurveyRequest addSurveyRequest){
        return  ResponseEntity.ok(teacherService.addSurvey(addSurveyRequest));
    }

    @GetMapping("/get_my_questions")
    public ResponseEntity<GetMyQuestionResponse> getMyQuestions(@RequestParam  String token){
            return ResponseEntity.ok(teacherService.getMyQuestions(token));
    }

    @GetMapping("/get_all_questions")
    public ResponseEntity<GetAllQuestionFromPoolResponse> getAllQuestions(@RequestParam String token){
        return ResponseEntity.ok(teacherService.getAllQuestions(token));
    }

    @PostMapping("/add_question_to_survey")
    public ResponseEntity<BaseResponse> addQuestionToSurvey(@RequestBody AddQuestionToSurveyRequest addQuestionToSurveyRequest){
            return ResponseEntity.ok(teacherService.addQuestionToSurvey(addQuestionToSurveyRequest));
    }

    @GetMapping("/get_all_student")
    public  ResponseEntity<GetAllStudentResponse> getAllStudents(@RequestParam String token){
            return ResponseEntity.ok(teacherService.getAllStudents(token));
    }


    @PostMapping("/add_student_to_survey")
    public ResponseEntity<BaseResponse> addStudentToSurvey(@RequestBody AddStudentToSurveyRequest addStudentToSurveyRequest){
        return ResponseEntity.ok(teacherService.addStudentToSurvey(addStudentToSurveyRequest));
    }


    @PostMapping("/get_answer_by_survey_and_question")
    public ResponseEntity<GetAnswerBySurveyAndQuestionResponse> getAnswersBySurvey(@RequestBody AnswerBySurveyAndQuestionRequest answerRequest){
            return ResponseEntity.ok(teacherService.getAnswersBySurveyAndQuestion(answerRequest));
    }

    @GetMapping("/get_my_survey")
    public ResponseEntity<GetMySurveysResponse> getMySurvey(@RequestParam String token){
            return ResponseEntity.ok(teacherService.getMySurveys(token));
    }
    @GetMapping("/get_student_by_survey")
    public ResponseEntity<GetStudentsBySurveyResponse> getStudentBySurvey(@RequestParam String token, @RequestParam String surveyId){
        return ResponseEntity.ok(teacherService.getStudentsBySurvey(token,surveyId));
    }



    @PostMapping("/add_question_to_pool")
    public ResponseEntity<BaseResponse> addQuestionToPool(@RequestBody AddQuestionToPoolRequest addQuestionToPoolRequest){
            return ResponseEntity.ok(teacherService.addQuestionToPool(addQuestionToPoolRequest));
    }


    @DeleteMapping("/delete_survey")
    public ResponseEntity<BaseResponse> deleteSurvey(@RequestBody DeleteSurveyRequest deleteSurveyRequest){
            return ResponseEntity.ok(teacherService.deleteSurvey(deleteSurveyRequest));
    }

    @DeleteMapping("/delete_question")
    public ResponseEntity<BaseResponse> deleteQuestion(@RequestBody DeleteQuestionRequest deleteQuestionRequest){
        return ResponseEntity.ok(teacherService.deleteQuestionBySurveyId(deleteQuestionRequest));
    }

    @PostMapping("/get_questions_by_survey")
    public ResponseEntity<GetQuestionsBySurveyResponse> getQuestionsBySurvey(@RequestBody GetQuestionBySurvey getQuestionBySurvey){
            return ResponseEntity.ok(teacherService.getQuestionsBySurvey(getQuestionBySurvey));
    }

    @DeleteMapping("/delete_student")
    public ResponseEntity<BaseResponse> deleteStudentBySurvey(@RequestBody DeleteStudentFromSurveyRequest deleteStudentFromSurveyRequest){
            return ResponseEntity.ok(teacherService.deleteStudentBySurvey(deleteStudentFromSurveyRequest));
    }



}
