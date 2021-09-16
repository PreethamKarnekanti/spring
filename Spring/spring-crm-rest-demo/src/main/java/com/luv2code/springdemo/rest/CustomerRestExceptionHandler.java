package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // add an exception for the customerNotFoundException

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception)
    {
        //create CustomerErrorResponse

        CustomerErrorResponse error =new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exception)
    {
        //create CustomerErrorResponse

        CustomerErrorResponse error =new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),"Invalid Customer ID",System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
