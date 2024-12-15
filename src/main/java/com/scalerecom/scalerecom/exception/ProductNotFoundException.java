package com.scalerecom.scalerecom.exception;

public class ProductNotFoundException extends Exception{

    // create an object of ProductNotFoundException class
    // and set the error message
    public ProductNotFoundException(String message) {
        super(message);
    }
}
