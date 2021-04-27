package com.talentpath.airTNB.exceptions;

public class NoSuchHostException extends Exception{
    public NoSuchHostException(String message) {
        super(message);
    }
    public NoSuchHostException(String message,Throwable cause) {
        super(message,cause);
    }
}
