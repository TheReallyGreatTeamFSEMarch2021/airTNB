package com.talentpath.airTNB.exceptions;

public class NullLocationException extends Exception{
    public NullLocationException(String message){super(message);}
    public NullLocationException(String message, Throwable innerException){super(message, innerException);}
}
