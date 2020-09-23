package com.example.library_management.Controller;

import com.example.library_management.DataAccessLayer.Book;
import com.example.library_management.DataAccessLayer.BookRepo;
import com.example.library_management.DataAccessLayer.LibraryUsers;
import com.example.library_management.DataAccessLayer.UserRepo;
import com.example.library_management.Exception.NoUserFoundException;
import com.example.library_management.Exception.UserNotFoundException;
import com.example.library_management.Validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController

public class UserRegistered {

    @Autowired
    UserRepo userrepo;

    @Autowired
    BookRepo bookRepo;

    @PostMapping("/newuser")
    public boolean addUser(@RequestBody LibraryUsers libraryUsers){

        if(UserValidator.isValid(libraryUsers)){
            userrepo.saveAll(Collections.singletonList(libraryUsers));
            return  true;
        }
        return  false;
    }

    @GetMapping("/user/{id}")
    LibraryUsers getUser(@PathVariable int id){
        //Integer checkid = Integer.parseInt(id);
        return userrepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }


    @PutMapping("/issuebook")
    boolean issueBook(@RequestBody LibraryUsers user) throws SQLException {
        //List<LibraryUsers> list = new ArrayList<>();
        //list = userrepo.findAll();
        //String id  = JOptionPane.showInputDialog(null, "Enter your id", "id input");
        //int Id1 = Integer.parseInt(id);
                //String name = JOptionPane.showInputDialog(null, "Enter book name from available books", "book input");
                //String name = "rd.sharma";


                List<Book> list = new ArrayList<>();
                list = bookRepo.findAll();

                for(Book bk : list){
                    if(bk.getBook_name().equals(user.getBookies())){
                        int checkid = bk.getBook_id();
                        bookRepo.deleteById(checkid);
                        DbOperations.updateIssuedBooks(user.getUser_id(),user.getUsername(),user.getBookies());
                        userrepo.saveAndFlush(user);
                        return true;
                    }
                }
                return false;
    }

    @PostMapping("/allusers")
    List getAllUsers(){

        List<LibraryUsers> list = new ArrayList<>();
        list = userrepo.findAll();
        if(list.size()==0){
            throw new NoUserFoundException();
        }
        return list;
    }





}
