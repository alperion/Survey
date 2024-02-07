package com.example.demo.service;


import com.example.demo.dto.request.student.AnswerQuestionRequest;
import com.example.demo.dto.request.student.ChangeCommunicationInfoRequest;
import com.example.demo.dto.request.student.GetQuestionsBySurveyIdRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.student.GetQuestionsBySurveyIdResponse;
import com.example.demo.dto.response.student.GetStudentSurveyResponse;
import com.example.demo.entity.*;
import com.example.demo.entity.enums.Role;
import com.example.demo.exception.custom.EmailAlreadyExistsException;
import com.example.demo.exception.custom.InvalidFieldException;
import com.example.demo.exception.custom.InvalidRoleException;
import com.example.demo.exception.custom.TokenNotEmptyException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.utility.HashPassword;
import com.example.demo.utility.JwtManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private  final JwtManager jwtManager;
    private final ConsumerService consumerService;
    private SurveyQuestionService surveyQuestionService;
    private  final SurveyStudentService surveyStudentService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public StudentService(StudentRepository studentRepository, JwtManager jwtManager, ConsumerService consumerService, SurveyQuestionService surveyQuestionService, @Lazy SurveyStudentService surveyStudentService, QuestionService questionService, AnswerService answerService) {
        this.studentRepository = studentRepository;
        this.jwtManager = jwtManager;
        this.consumerService = consumerService;
        this.surveyQuestionService = surveyQuestionService;
        this.surveyStudentService = surveyStudentService;
        this.questionService = questionService;
        this.answerService = answerService;
    }


    public boolean isExistById(String id){
        return studentRepository.existsById(id);
    }


    public GetStudentSurveyResponse getStudentSurvey(String token) {

        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.STUDENT){
            throw new InvalidRoleException();
        }

        List<Survey> surveys=surveyStudentService.getSurveyStudentByStudentId(id.get());
        GetStudentSurveyResponse response=new GetStudentSurveyResponse();
        response.setSurveys(surveys);
        return response;

    }

    public GetQuestionsBySurveyIdResponse getQuesstionsBySurveyId(GetQuestionsBySurveyIdRequest request) {

        Optional<String> id= jwtManager.getIdByToken(request.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.STUDENT){
            throw new InvalidRoleException();
        }

        List<SurveyQuestion> surveyQuestions=surveyQuestionService.getBySurveyId(request.getSurveyId());
        List<Question> questions=new ArrayList<>();


        for (SurveyQuestion surveyQuestion:surveyQuestions){

            Question question=questionService.getQuestionById(surveyQuestion.getQuestionId());
            questions.add(question);
        }

        GetQuestionsBySurveyIdResponse getQuestionsBySurveyResponse=new GetQuestionsBySurveyIdResponse();
        getQuestionsBySurveyResponse.setQuestions(questions);


        return getQuestionsBySurveyResponse;


    }

    public BaseResponse answerQuesiton(AnswerQuestionRequest request) {
        Optional<String> id= jwtManager.getIdByToken(request.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.STUDENT){
            throw new InvalidRoleException();
        }

        return  answerService.answerQuestion(request,id.get());
    }


    public BaseResponse changeStudentInfo(ChangeCommunicationInfoRequest request) {

        Optional<String> id= jwtManager.getIdByToken(request.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        Consumer consumer1=consumer.get();
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumer.get().getRole()!= Role.STUDENT){
            throw new InvalidRoleException();
        }
        if(consumerService.findOptionalByEmail(request.getEmail()).isPresent()){
           throw new EmailAlreadyExistsException();
        }


        if(request.getEmail().equals("string") || !request.getEmail().contains("@")){
            throw new InvalidFieldException();
        }

        if(request.getPhoneNumber().equals("string") || request.getPhoneNumber().length()<2){
            throw new InvalidFieldException();
        }

        consumer1.setEmail(request.getEmail());
        consumer1.setPhoneNumber(request.getPhoneNumber());
        consumerService.changeConsumerInfo(consumer1);


        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("Güncellendi");


            return baseResponse;

    }
}
