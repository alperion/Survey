package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.entity.SurveyQuestion;
import com.example.demo.exception.custom.QuestionNotExistException;
import com.example.demo.repository.SurveyQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyQuestionService {

    private final SurveyQuestionRepository surveyQuestionRepository;
    private final  QuestionService questionService;

    public SurveyQuestionService(SurveyQuestionRepository surveyQuestionRepository, QuestionService questionService) {
        this.surveyQuestionRepository = surveyQuestionRepository;
        this.questionService = questionService;
    }

    public void save(List<Question> questions, String surveyId){

        for (Question question:questions){
                if(!questionService.isExistById(question.getId())){
                    throw new QuestionNotExistException();
                }
        }

        for (Question question:questions){
            SurveyQuestion surveyQuestion=new SurveyQuestion();
            surveyQuestion.setSurveyId(surveyId);
            surveyQuestion.setQuestionId(question.getId());
            surveyQuestionRepository.save(surveyQuestion);
        }
    }

    public List<SurveyQuestion> getBySurveyId(String surveyId) {
        return surveyQuestionRepository.findAllBySurveyId(surveyId);
    }

    public void deleteQuestionsBySurveyId(String surveyId) {

        surveyQuestionRepository.deleteBySurveyId(surveyId);

    }

    public List<SurveyQuestion> getQuestionsBySurvey(String surveyId) {

        return surveyQuestionRepository.findAllBySurveyId(surveyId);


    }

    public void deleteQuestion(String questionId,String surveyId) {
                surveyQuestionRepository.deleteByQuestionIdAndSurveyId(questionId,surveyId);


    }
}
