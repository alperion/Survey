package com.example.demo.exception.custom;

public class QuestionNotExistException extends RuntimeException{
    public QuestionNotExistException(String message){
        super(message);
    }

    public QuestionNotExistException(){super();}
}
