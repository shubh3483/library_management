package com.example.library_management.Exception;

public class NoUserFoundException extends RuntimeException{

    public NoUserFoundException() {

        super("No user found");
    }
}
