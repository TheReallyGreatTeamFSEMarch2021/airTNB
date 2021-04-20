package com.talentpath.airTNB.exceptions;

public class NullActivityException extends Exception{

    public NullActivityException(String message){
        super(message);
    }

    public NullActivityException(String message, Throwable innerException){
        super(message, innerException);
    }
}
