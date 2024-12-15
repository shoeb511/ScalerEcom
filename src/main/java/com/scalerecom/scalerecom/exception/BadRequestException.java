package com.scalerecom.scalerecom.exception;

public class BadRequestException extends Exception {

    //create a BadRequestException object and set the error message
    public BadRequestException(String message) {
        super(message);
    }
}
