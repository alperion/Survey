package com.example.demo.service;

import com.example.demo.dto.request.student.AnswerQuestionRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.entity.SurveyQuestion;
import com.example.demo.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer getById(String questionId, String surveyId) {

        Optional<Answer> answer=answerRepository.findOptionalByQuestionIdAndSurveyId(questionId,surveyId);
        if (answer.isPresent()){
            return answer.get();
        }
        System.err.println("alperen müko");
        return null;
    }

    public void deleteBySurveyId(String surveyId) {

        answerRepository.deleteBySurveyId(surveyId);
    }

    public void deleteByQuestionId(Question question) {
            answerRepository.deleteByQuestionId(question.getId());
    }

    public List<Answer> findAllAnswersByQuestionIdAndSurveyId(String id, String surveyId) {

        return answerRepository.findAllByQuestionIdAndSurveyId(id,surveyId);


    }

    public BaseResponse answerQuestion(AnswerQuestionRequest request, String studentId){

        Answer answer=new Answer();
        answer.setQuestionId(request.getQuestionId());
        answer.setAnswer(request.getAnswer());
        answer.setStudentId(studentId);
        answer.setSurveyId(request.getSurveyId());
        answerRepository.save(answer);

        BaseResponse response=new BaseResponse();
        response.setMessage("sorular kayıt");
        response.setStatusCode(200);
        return response;

    }

    public void deleteByQuestionIdAndSurveyId(String questionId,String surveyId) {
        System.err.println("hata3");
        answerRepository.deleteByQuestionIdAndSurveyId(questionId,surveyId);
    }
}
