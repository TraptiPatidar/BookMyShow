package com.example.Book.repository;

import com.example.Book.entity.Admin;
import com.example.Book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Admin findByEmailIdAndPassword(String emailId, String password);
}
