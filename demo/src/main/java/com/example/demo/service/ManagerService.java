package com.example.demo.service;

import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.request.manager.ChangeConsumerInfoRequest;
import com.example.demo.dto.request.manager.GetAnswersBySurveyAndQuestionRequest;
import com.example.demo.dto.request.manager.RegisterRequestWithToken;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.GetAllStudentResponse;
import com.example.demo.dto.response.manager.GetAllSurveyResponse;
import com.example.demo.dto.response.manager.GetAnswersBySurveyAndQuestionResponse;
import com.example.demo.dto.response.manager.GetSurveyByTeacherResponse;
import com.example.demo.entity.*;
import com.example.demo.entity.enums.Role;
import com.example.demo.exception.custom.*;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.utility.HashPassword;
import com.example.demo.utility.JwtManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final SurveyService surveyService;

    private final JwtManager jwtManager;
    private final ConsumerService consumerService;
    private  final SurveyQuestionService surveyQuestionService;
    private final QuestionService questionService;
    private final  AnswerService answerService;


    public ManagerService(ManagerRepository managerRepository, SurveyService surveyService, JwtManager jwtManager, ConsumerService consumerService, SurveyQuestionService surveyQuestionService, QuestionService questionService, AnswerService answerService) {
        this.managerRepository = managerRepository;
        this.surveyService = surveyService;
        this.jwtManager = jwtManager;
        this.consumerService = consumerService;
        this.surveyQuestionService = surveyQuestionService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public GetAllSurveyResponse getAllSurvey(String token) {
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }
        GetAllSurveyResponse getAllSurveyResponse=new GetAllSurveyResponse();
        getAllSurveyResponse.setSurveys(surveyService.getAllSurvey());
        return getAllSurveyResponse;
    }
    public GetAnswersBySurveyAndQuestionResponse getAnswersBySurveyAndQuestion(GetAnswersBySurveyAndQuestionRequest getAnswersBySurveyAndQuestionRequest) {

        Optional<String> id= jwtManager.getIdByToken(getAnswersBySurveyAndQuestionRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }
        List<SurveyQuestion> surveyQuestions=surveyQuestionService.getBySurveyId(getAnswersBySurveyAndQuestionRequest.getSurveyId());
        HashMap<String,List<Answer>> questionAndAnswers=new HashMap<>();
        for (SurveyQuestion surveyQuestion:surveyQuestions){
              Question question=questionService.getQuestionById(surveyQuestion.getQuestionId());

              List<Answer> answers=answerService.findAllAnswersByQuestionIdAndSurveyId(question.getId(),getAnswersBySurveyAndQuestionRequest.getSurveyId());
              questionAndAnswers.put(question.getQuestion(),answers);
        }

        GetAnswersBySurveyAndQuestionResponse response=new GetAnswersBySurveyAndQuestionResponse();
        response.setQuestionAndAnswers(questionAndAnswers);

        return response;
    }


    public BaseResponse addConsumer(RegisterRequestWithToken registerRequestWithToken) {
        Optional<String> id= jwtManager.getIdByToken(registerRequestWithToken.getToken());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumerService.findById(id.get()).get().getRole()!=Role.MANAGER){
            throw new InvalidRoleException();
        }
        Optional<Consumer> consumer=consumerService.findOptionalByEmail(registerRequestWithToken.getEmail());
        if(consumer.isPresent()){
            throw new EmailAlreadyExistsException();
        }
        if (!registerRequestWithToken.getEmail().contains("@")) {
            throw new EmailNotValidException();
        }

        Consumer consumer1=new Consumer();
        consumer1.setEmail(registerRequestWithToken.getEmail());
        consumer1.setName(registerRequestWithToken.getName());
        consumer1.setLastName(registerRequestWithToken.getLastName());
        consumer1.setPassword(HashPassword.encrypt(registerRequestWithToken.getPassword()));
        consumer1.setPhoneNumber(registerRequestWithToken.getPhoneNumber());
        consumer1.setPhoneNumber(registerRequestWithToken.getPhoneNumber());
        consumer1.setRole(registerRequestWithToken.getRole());

        consumerService.saveConsumer(consumer1);

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage("Kayıt Yapıldı");
        baseResponse.setStatusCode(200);

        return baseResponse;
    }

    public BaseResponse changeConsumerInfo(ChangeConsumerInfoRequest request) {

        Optional<String> id= jwtManager.getIdByToken(request.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());

        Consumer consumer1=consumerService.findById(request.getUserId()).get();


        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }
        if(consumerService.findOptionalByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException();//THIS_EMAIL_ALREADY_EXIST
        }
        if(request.getEmail().equals("string") || !request.getEmail().contains("@")){
            throw new InvalidFieldException(); // INVALID_FIELD
        }
        if(request.getPhoneNumber().equals("string") || request.getPhoneNumber().length()<2){
            throw new InvalidFieldException();
        }

        if(request.getName().equals("string")){
            throw new InvalidFieldException();
        }
        if(request.getLastName().equals("string")){
            throw new InvalidFieldException();
        }
        if(request.getTc().equals("string") || request.getPhoneNumber().length()<2){
            throw new InvalidFieldException();
        }
        if(request.getRole()!=Role.MANAGER && request.getRole()!=Role.STUDENT && request.getRole()!=Role.TEACHER){
            throw new InvalidFieldException();
        }
        if (request.getPassword().equals("string")){
            throw new InvalidFieldException();
        }

        consumer1.setTcNo(request.getTc());
        consumer1.setName(request.getName());
        consumer1.setLastName(request.getLastName());
        consumer1.setPhoneNumber(request.getPhoneNumber());
        consumer1.setEmail(request.getEmail());
        consumer1.setRole(request.getRole());
        consumer1.setPassword(HashPassword.encrypt(request.getPassword()));

        consumerService.changeConsumerInfo(consumer1);
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage("alanlar güncellendi");
        baseResponse.setStatusCode(200);

        return baseResponse;

    }

    public GetAllStudentResponse getAllStudent(String token) {
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());


        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }

        GetAllStudentResponse  getAllStudentResponse=new GetAllStudentResponse();
        getAllStudentResponse.setStudents(consumerService.getAllStudent());

        return getAllStudentResponse;

    }

    public GetAllStudentResponse getAllTeacher(String token) {
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());


        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }

        GetAllStudentResponse  getAllStudentResponse=new GetAllStudentResponse();
        getAllStudentResponse.setStudents(consumerService.getAllTeacher());

        return getAllStudentResponse;
    }

    public GetSurveyByTeacherResponse getSurveyByTeacher(String token) {

        Optional<String> id= jwtManager.getIdByToken(token);
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumerService.findById(id.get()).get().getRole()!=Role.MANAGER){
            throw new InvalidRoleException();
        }


        List<Survey> surveys=surveyService.getAllSurvey();
        HashMap<String ,Consumer> teacherHashMap=new HashMap<>();
        for (Survey survey:surveys){

            Consumer consumer=consumerService.findById(survey.getTeacherId()).get();
            teacherHashMap.put(survey.getSurveyName(),consumer);

        }
        GetSurveyByTeacherResponse getSurveyByTeacherResponse=new GetSurveyByTeacherResponse();
        getSurveyByTeacherResponse.setTeachers(teacherHashMap);
            return getSurveyByTeacherResponse;

    }
}
