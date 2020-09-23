package com.example.library_management.Validator;

import com.example.library_management.DataAccessLayer.Book;

public class BookValidator {

    public static boolean isValid(Book book){

        if(book.book_name == null || book.book_name == ""){
            return false;
        }
        return true;
    }
}
