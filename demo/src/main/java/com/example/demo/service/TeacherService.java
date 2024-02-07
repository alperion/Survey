package com.example.demo.service;


import com.example.demo.dto.request.teacher.*;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.GetAllStudentResponse;
import com.example.demo.dto.response.teacher.*;
import com.example.demo.entity.*;
import com.example.demo.entity.enums.Role;
import com.example.demo.exception.custom.InvalidRoleException;
import com.example.demo.exception.custom.TokenNotEmptyException;
import com.example.demo.repository.ConsumerRepository;
import com.example.demo.utility.JwtManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {


    private  final JwtManager jwtManager;
    private final ConsumerService consumerService;
    private final  SurveyService surveyService;
    private final  QuestionService questionService;
    private final SurveyQuestionService surveyQuestionService;
    private  final SurveyStudentService surveyStudentService;
    private final StudentService studentService;
    private final AnswerService answerService;

    public TeacherService(JwtManager jwtManager, ConsumerRepository consumerRepository, ConsumerService consumerService, SurveyService surveyService, QuestionService questionService, SurveyQuestionService surveyQuestionService, SurveyStudentService surveyStudentService, StudentService studentService, AnswerService answerService) {

        this.jwtManager = jwtManager;
        this.consumerService = consumerService;
        this.surveyService = surveyService;
        this.questionService = questionService;
        this.surveyQuestionService = surveyQuestionService;
        this.surveyStudentService = surveyStudentService;
        this.studentService = studentService;
        this.answerService = answerService;
    }

    public BaseResponse addSurvey(AddSurveyRequest addSurveyRequest) {

        Optional<String> id= jwtManager.getIdByToken(addSurveyRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
                throw new InvalidRoleException();
        }

        Survey survey=new Survey();
        survey.setSurveyName(addSurveyRequest.getSurveyName());
        survey.setTeacherId(id.get());

        surveyService.save(survey);

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("Anket açıldı");

        return baseResponse;

    }
    public GetMyQuestionResponse getMyQuestions(String token) {

        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        GetMyQuestionResponse getMyQuestionResponse=new GetMyQuestionResponse();
        getMyQuestionResponse.setQuestions(questionService.getMyQuestions(id.get()));

        return getMyQuestionResponse;

    }

    public GetAllQuestionFromPoolResponse getAllQuestions(String token){
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        GetAllQuestionFromPoolResponse getAllQuestionFromPoolResponse=new GetAllQuestionFromPoolResponse();
        getAllQuestionFromPoolResponse.setQuestions(questionService.getAllQuestions());

        return getAllQuestionFromPoolResponse;

    }

    public BaseResponse addQuestionToSurvey(AddQuestionToSurveyRequest addQuestionToSurveyRequest) {


        Optional<String> id= jwtManager.getIdByToken(addQuestionToSurveyRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        surveyQuestionService.save(addQuestionToSurveyRequest.getQuestions(),addQuestionToSurveyRequest.getSurveyId());

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage("sorular ankete eklendi");
        baseResponse.setStatusCode(200);

        return  baseResponse;

    }

    public BaseResponse addStudentToSurvey(AddStudentToSurveyRequest addStudentToSurveyRequest) {

        Optional<String> id= jwtManager.getIdByToken(addStudentToSurveyRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        surveyStudentService.addStudentToSurvey(addStudentToSurveyRequest.getStudents(),addStudentToSurveyRequest.getSurveyId());

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("öğrenciler eklendi ");

            return baseResponse;
    }

    public GetAllStudentResponse getAllStudents(String token) {
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        GetAllStudentResponse getAllStudentResponse=new GetAllStudentResponse();
        getAllStudentResponse.setStudents(consumerService.getAllStudent());

        return getAllStudentResponse;
    }


    public GetAnswerBySurveyAndQuestionResponse getAnswersBySurveyAndQuestion(AnswerBySurveyAndQuestionRequest answerRequest){
        Optional<String> id= jwtManager.getIdByToken(answerRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        List<SurveyQuestion> surveyQuestions=surveyQuestionService.getBySurveyId(answerRequest.getSurveyId());
        HashMap<String,List<Answer>> questionAnswers=new HashMap<>();

        for (SurveyQuestion surveyQuestion:surveyQuestions){
            Question question=questionService.getQuestionById(surveyQuestion.getQuestionId());
            List<Answer> answers=answerService.findAllAnswersByQuestionIdAndSurveyId(surveyQuestion.getQuestionId(),surveyQuestion.getSurveyId());

            questionAnswers.put(question.getQuestion(),answers);

        }

        GetAnswerBySurveyAndQuestionResponse getAnswerBySurveyAndQuestionResponse=new GetAnswerBySurveyAndQuestionResponse();
        getAnswerBySurveyAndQuestionResponse.setQuestionAnswer(questionAnswers);
        return getAnswerBySurveyAndQuestionResponse;

    }
    public GetMySurveysResponse getMySurveys(String token) {
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        GetMySurveysResponse getMySurveysResponse=new GetMySurveysResponse();
        getMySurveysResponse.setSurveys(surveyService.getMySurveys(id.get()));
        return getMySurveysResponse;

    }
    public BaseResponse addQuestionToPool(AddQuestionToPoolRequest addQuestionToPoolRequest) {
        Optional<String> id= jwtManager.getIdByToken(addQuestionToPoolRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }
        Question question=new Question();
        question.setTeacherId(id.get());
        question.setQuestion(addQuestionToPoolRequest.getQuestion());

        questionService.addQuestionToPool(question);

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage("Soru havuza eklendi ");
        baseResponse.setStatusCode(200);

        return baseResponse;
    }

    public BaseResponse deleteSurvey(DeleteSurveyRequest deleteSurveyRequest) {
        Optional<String> id= jwtManager.getIdByToken(deleteSurveyRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        surveyService.deleteSurvey(deleteSurveyRequest.getSurveyId());
        surveyQuestionService.deleteQuestionsBySurveyId(deleteSurveyRequest.getSurveyId());
        surveyStudentService.deleteStudentBySurveyId(deleteSurveyRequest.getSurveyId());
        answerService.deleteBySurveyId(deleteSurveyRequest.getSurveyId());



        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("Survey silindi");

        return baseResponse;
    }





    public BaseResponse deleteQuestionBySurveyId(DeleteQuestionRequest deleteQuestionRequest){

        Optional<String> id= jwtManager.getIdByToken(deleteQuestionRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        for (Question question:deleteQuestionRequest.getQuestions()) {
                    Question question1=questionService.getQuestionById(question.getId());
                    surveyQuestionService.deleteQuestion(question1.getId(),deleteQuestionRequest.getSurveyId());
                    answerService.deleteByQuestionIdAndSurveyId(question1.getId(),deleteQuestionRequest.getSurveyId());

        }

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage("soru ve cevaplar silindi");
        baseResponse.setStatusCode(200);

            return baseResponse;

    }


    public GetQuestionsBySurveyResponse getQuestionsBySurvey(GetQuestionBySurvey getQuestionBySurvey) {

        Optional<String> id= jwtManager.getIdByToken(getQuestionBySurvey.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        GetQuestionsBySurveyResponse getQuestionsBySurveyResponse=new GetQuestionsBySurveyResponse();
        getQuestionsBySurveyResponse.setQuestions(surveyQuestionService.getQuestionsBySurvey(getQuestionBySurvey.getSurveyId()));

            return getQuestionsBySurveyResponse;
    }

    public BaseResponse deleteStudentBySurvey(DeleteStudentFromSurveyRequest deleteStudentFromSurveyRequest) {

        Optional<String> id= jwtManager.getIdByToken(deleteStudentFromSurveyRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        for (Student student:deleteStudentFromSurveyRequest.getStudents()) {
                surveyStudentService.deleteStudent(student);
        }
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage("Öğrenciler silindi");

        return baseResponse;

    }

    public GetStudentsBySurveyResponse getStudentsBySurvey(String token,String surveyId){
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.TEACHER){
            throw new InvalidRoleException();
        }

        List<SurveyStudent> surveyStudents=surveyStudentService.findSurveyStudentBySurveyId(surveyId);
        List<Consumer> students=new ArrayList<>();
        for (SurveyStudent surveyStudent:surveyStudents){
            Consumer consumer1=consumerService.findById(surveyStudent.getStudentId()).get();
            students.add(consumer1);
        }
        GetStudentsBySurveyResponse response=new GetStudentsBySurveyResponse();
        response.setStudents(students);
        return response;
    }
}
