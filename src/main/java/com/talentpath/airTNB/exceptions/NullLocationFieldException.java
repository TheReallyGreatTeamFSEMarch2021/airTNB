package com.talentpath.airTNB.exceptions;

import javax.validation.constraints.Null;

public class NullLocationFieldException extends Exception {
    public NullLocationFieldException(String message){
        super(message);
    }
    public NullLocationFieldException(String message, Throwable innerException){
        super(message, innerException);
    }

}
