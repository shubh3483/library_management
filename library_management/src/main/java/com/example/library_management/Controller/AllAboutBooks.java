package com.example.library_management.Controller;


import com.example.library_management.DataAccessLayer.Book;
import com.example.library_management.DataAccessLayer.BookRepo;
import com.example.library_management.Exception.BookNotFoundException;
import com.example.library_management.Validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class AllAboutBooks {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            @Autowired
    BookRepo bookRepo;

    @GetMapping("/books")
    List<Book> findAll() {
        LOGGER.info("findAll called");
        List<Book> list = new ArrayList<Book>();
        //list = repository.findAll();
        try {
            list = bookRepo.findAll();
            if (list.size() == 0) {
                LOGGER.severe("No book found");
                throw new BookNotFoundException(5);
            }
        }
        catch(BookNotFoundException exc)
        {
            LOGGER.severe(exc.toString());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Book Found", exc);
        }
        return list;
    }

    @PostMapping("/newbook")
    boolean newBook(Book book){

        if(BookValidator.isValid(book)){
            bookRepo.saveAll(Collections.singletonList(book));
            return true;
        }
        return  false;
    }

    @PostMapping("/issuedbooks")
    List issuedBooks() throws SQLException {
        return DbOperations.allIssuedBooks();
    }

}
