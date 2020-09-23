package com.example.library_management.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer id) {
        super("User with id "+id+" not found");
    }
}
