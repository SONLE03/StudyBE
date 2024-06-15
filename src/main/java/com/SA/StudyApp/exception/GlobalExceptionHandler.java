package com.SA.StudyApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    // Global
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex) {
        logger.info("Exception: " + ex.getMessage());
        return "Unknow";
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException businessException){
        return ResponseEntity.status(businessException.getApiStatus().getStatus()).body(businessException.getApiStatus().getMessage());
    }
}