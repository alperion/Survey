package com.example.demo.exception.custom;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String message){
        super(message);
    }

    public EmailAlreadyExistsException(){super();}


}
