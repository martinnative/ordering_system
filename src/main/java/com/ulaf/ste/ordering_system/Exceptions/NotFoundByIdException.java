package com.ulaf.ste.ordering_system.Exceptions;

public class NotFoundByIdException extends Exception{
    public NotFoundByIdException(String errorMessage) {
        super(errorMessage);
    }
}
