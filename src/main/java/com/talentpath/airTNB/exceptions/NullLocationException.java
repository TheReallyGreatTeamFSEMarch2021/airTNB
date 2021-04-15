package com.talentpath.airTNB.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class NullLocationException extends Exception {
    public NullLocationException(String message){
        super(message);
    }

    public NullLocationException(String message, Throwable innerException){
        super(message, innerException);
    }
}
