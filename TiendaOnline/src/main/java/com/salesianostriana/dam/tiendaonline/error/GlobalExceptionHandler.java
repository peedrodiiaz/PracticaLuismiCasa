package com.salesianostriana.dam.tiendaonline.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (IllegalArgumentException.class)
    public ProblemDetail handlerIllegalArgumentException (IllegalArgumentException ex){
        ProblemDetail problemDetail =  ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setTitle("Illegal argument");

        return problemDetail;

    }
}
