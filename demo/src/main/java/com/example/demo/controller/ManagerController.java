package com.example.demo.controller;


import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.request.manager.ChangeConsumerInfoRequest;
import com.example.demo.dto.request.manager.GetAnswersBySurveyAndQuestionRequest;
import com.example.demo.dto.request.manager.RegisterRequestWithToken;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.GetAllStudentResponse;
import com.example.demo.dto.response.manager.GetAllSurveyResponse;
import com.example.demo.dto.response.manager.GetAnswersBySurveyAndQuestionResponse;
import com.example.demo.dto.response.manager.GetSurveyByTeacherResponse;
import com.example.demo.dto.response.teacher.GetAnswerBySurveyAndQuestionResponse;
import com.example.demo.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }


    @GetMapping("/get_all_survey")
    public ResponseEntity<GetAllSurveyResponse> getAllSurvey(@RequestParam String token){
        return ResponseEntity.ok(managerService.getAllSurvey(token));
    }

    @PostMapping("/get_Answers_By_Survey_And_Question")
    public ResponseEntity<GetAnswersBySurveyAndQuestionResponse> getAnswers(@RequestBody GetAnswersBySurveyAndQuestionRequest getAnswersBySurveyAndQuestionRequest){
        return ResponseEntity.ok(managerService.getAnswersBySurveyAndQuestion(getAnswersBySurveyAndQuestionRequest));
    }

    @PostMapping("/add_student")
    public ResponseEntity<BaseResponse> addStudent(@RequestBody RegisterRequestWithToken registerRequestWithToken){
            return ResponseEntity.ok(managerService.addConsumer(registerRequestWithToken));
    }
    @PostMapping("/add_teacher")
    public ResponseEntity<BaseResponse> addTeacher(@RequestBody RegisterRequestWithToken registerRequestWithToken){
        return ResponseEntity.ok(managerService.addConsumer(registerRequestWithToken));
    }
    @PostMapping("/add_manager")
    public ResponseEntity<BaseResponse> addManager(@RequestBody RegisterRequestWithToken registerRequestWithToken){
        return ResponseEntity.ok(managerService.addConsumer(registerRequestWithToken));
    }

    @PutMapping("/change_student_info")
    public ResponseEntity<BaseResponse> changeStudentInfo(@RequestBody ChangeConsumerInfoRequest changeConsumerInfoRequest){
        return ResponseEntity.ok(managerService.changeConsumerInfo(changeConsumerInfoRequest));
    }

    @PutMapping("/change_teacher_info")
    public ResponseEntity<BaseResponse> changeTeacherInfo(@RequestBody ChangeConsumerInfoRequest changeConsumerInfoRequest){
        return ResponseEntity.ok(managerService.changeConsumerInfo(changeConsumerInfoRequest));
    }

    @GetMapping("/get_all_students")
    public ResponseEntity<GetAllStudentResponse> getAllStudent(@RequestParam String token){
        return ResponseEntity.ok(managerService.getAllStudent(token));
    }

    @GetMapping("/get_all_teacher")
    public ResponseEntity<GetAllStudentResponse> getAllTeacher(@RequestParam String token){
        return ResponseEntity.ok(managerService.getAllTeacher(token));
    }

    @GetMapping("/find_surveys_by_teacher")
    public ResponseEntity<GetSurveyByTeacherResponse> getSurveysByTeacherResponse(@RequestParam String token){
        return ResponseEntity.ok(managerService.getSurveyByTeacher(token));
    }




}
