package com.example.demo.Exeption;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException{
    private final String message;
    private final HttpStatus httpstatus;
    private final ZonedDateTime timestamp;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp){
        this.message = message;
        this.httpstatus = httpStatus;
        this.timestamp = timestamp; 
    }
    //getters
    public String getMessage(){return this.message;}
    public HttpStatus getHttpStatus(){return this.httpstatus;}
    public ZonedDateTime getTimestamp(){return this.timestamp;}


}