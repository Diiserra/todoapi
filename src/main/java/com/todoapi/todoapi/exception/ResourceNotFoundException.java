package com.todoapi.todoapi.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object email) {
        super("Resource not found. " + email + " not exist.");
    }
}
