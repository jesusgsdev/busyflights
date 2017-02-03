package com.jesusgsdev.exceptions;

/**
 * Created by jesgarsal on 29/01/17.
 */
public class ValidationException extends RuntimeException {

    public ValidationException(){
        super();
    }

    public ValidationException(String message){
        super(message);
    }

}
