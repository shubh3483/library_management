package com.example.library_management.DataAccessLayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Booksissued {


    private int book_id;
    private String book_name;
    private String username;


    public Booksissued(int book_id, String book_name, String username) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.username = username;
    }

    public Booksissued() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
