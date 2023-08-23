package com.casestudy.happy_paws.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController  {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoFoundException(Exception e){
        return "/customers/404";
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public String serviceError(Exception e){

        return "/customers/500";
    }
    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public String forbiddenError(Exception e){

        return "/customers/403";
    }
}
