package com.example.library_management.Validator;

import com.example.library_management.DataAccessLayer.LibraryUsers;

public class UserValidator {

    public static boolean isValid(LibraryUsers libraryUsers){
        if(libraryUsers.username == null || libraryUsers.username == ""){
            return false;
        }
        return  true;
    }
}
