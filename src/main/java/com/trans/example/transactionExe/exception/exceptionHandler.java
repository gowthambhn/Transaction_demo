package com.trans.example.transactionExe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionHandler {


    @ExceptionHandler
    public ResponseEntity<exceptionPojo> Exception (Exception ex) {
        exceptionPojo eObject = new exceptionPojo(500,"Enter the Data Properly" , System.currentTimeMillis());
        return new ResponseEntity<exceptionPojo>(eObject, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
