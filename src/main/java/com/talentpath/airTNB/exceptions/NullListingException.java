package com.talentpath.airTNB.exceptions;

public class NullListingException extends Exception{

    public NullListingException(String message){
        super(message);
    }

    public NullListingException(String message, Throwable innerException){
        super(message, innerException);
    }
}
