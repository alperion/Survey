package com.example.demo.controller;




import com.example.demo.dto.request.student.AnswerQuestionRequest;
import com.example.demo.dto.request.student.ChangeCommunicationInfoRequest;
import com.example.demo.dto.request.student.GetQuestionsBySurveyIdRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.student.GetQuestionsBySurveyIdResponse;
import com.example.demo.dto.response.student.GetStudentSurveyResponse;
import com.example.demo.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    @GetMapping("/get_student_survey")
    public ResponseEntity<GetStudentSurveyResponse> getStudentSurvey(@RequestParam String token){
        return ResponseEntity.ok(studentService.getStudentSurvey(token));
    }

    @PostMapping("/get_questions_by_survey")
    public ResponseEntity<GetQuestionsBySurveyIdResponse> getQuestionsBySurveyId(@RequestBody GetQuestionsBySurveyIdRequest request){
        return ResponseEntity.ok(studentService.getQuesstionsBySurveyId(request));
    }

    @PostMapping("/answer_question")
    public ResponseEntity<BaseResponse> answerQuestion(@RequestBody AnswerQuestionRequest request){
        return ResponseEntity.ok(studentService.answerQuesiton(request));
    }



    @PutMapping("/change_comms")
    public ResponseEntity<BaseResponse> changeCommunicationInfo(@RequestBody ChangeCommunicationInfoRequest request){
        return ResponseEntity.ok(studentService.changeStudentInfo(request));
    }







}
