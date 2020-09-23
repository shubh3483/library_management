package com.example.library_management.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<LibraryUsers,Integer> {

}
