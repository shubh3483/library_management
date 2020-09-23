package com.example.library_management.DataAccessLayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LibraryUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    public String username;
    private String bookies;
    public String mobile_no;


    public LibraryUsers(String username, String bookies, String mobile_no) {
        this.username = username;
        this.bookies = bookies;
        this.mobile_no = mobile_no;
    }

    public LibraryUsers() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookies() {
        return bookies;
    }

    public void setBookies(String bookies) {
        this.bookies = bookies;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}
