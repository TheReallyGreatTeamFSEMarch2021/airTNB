package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value = InvalidIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String errorMessageOnInvalidIdException(InvalidIdException ex, WebRequest request) {
        return request.toString() + "an error occurred: " + ex.getMessage();
    }
}
