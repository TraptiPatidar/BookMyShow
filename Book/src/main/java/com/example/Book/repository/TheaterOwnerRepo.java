package com.example.Book.repository;

import com.example.Book.entity.TheaterOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TheaterOwnerRepo extends JpaRepository<TheaterOwner,Integer> {

    @Query("SELECT to.name FROM TheaterOwner to WHERE to.emailId = :emailId AND to.password = :password AND to.isVerified = true")
    String findUsernameByEmailIdAndPasswordAndIsVerifiedTrue(
            @Param("emailId") String emailId, @Param("password") String password);
    List<TheaterOwner> findByIsVerifiedFalse();
    @Transactional
    @Modifying
    @Query("UPDATE TheaterOwner to SET to.isVerified = true WHERE to.ownerId = :ownerId")
    void updateIsVerifiedTrue(@Param("ownerId") int ownerId);
}
