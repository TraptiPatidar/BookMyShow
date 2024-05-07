package com.example.Book.repository;

import com.example.Book.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepo extends JpaRepository<Theater,Integer> {

}
