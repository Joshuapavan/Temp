package com.GRANDEUR.GrandeurBackend.exceptions;

public class UserNotFoundException extends  RuntimeException{

    // User not found exception //
    public UserNotFoundException(String message) {
        super(message);
    }
}
