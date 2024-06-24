package com.example.handlers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception ex) {

        ProblemDetail problemDetail = null;

        if (ex instanceof BadCredentialsException) {
            problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), ex.getMessage());
            problemDetail.setProperty("access_denied_reason", "Authentication Failure");
        }

        return problemDetail;

    }

}