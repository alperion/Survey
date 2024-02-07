package com.example.demo.service;


import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getMyQuestions(String id){
            return questionRepository.findAllByTeacherId(id);
    }
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public boolean isExistById(String id){
            return questionRepository.existsById(id);
    }

    public void addQuestionToPool(Question question) {
        questionRepository.save(question);
    }

    public Question getQuestionById(String id){
        return questionRepository.findById(id).get();
    }


}
