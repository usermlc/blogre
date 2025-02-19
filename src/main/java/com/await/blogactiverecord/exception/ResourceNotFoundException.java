package com.await.blogactiverecord.exception;

// Exception thrown when a requested resource is not found
public class ResourceNotFoundException extends RuntimeException {

    // Constructor to initialize the exception with a custom message
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
