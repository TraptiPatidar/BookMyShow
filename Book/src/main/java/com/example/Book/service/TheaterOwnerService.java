package com.example.Book.service;


import com.example.Book.entity.Theater;
import com.example.Book.entity.TheaterOwner;
import com.example.Book.repository.TheaterOwnerRepo;
import com.example.Book.repository.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterOwnerService {
    @Autowired
    TheaterOwnerRepo theaterOwnerRepo;
    @Autowired
    TheaterRepo theaterRepo;
    public String loginTheaterOwner(String emailId, String password){
        String s=theaterOwnerRepo.findUsernameByEmailIdAndPasswordAndIsVerifiedTrue(emailId,password);
        return "welcome"+s;

    }
    public String registerTheaterOwner(TheaterOwner theaterOwner){
        theaterOwnerRepo.save(theaterOwner);
        return "registered..wait for admin approval";
    }

    public int addTheater(int ownerId,Theater theater){
        theater.setTheaterOwner(theaterOwnerRepo.getById(ownerId));
        Theater savedTheater = theaterRepo.save(theater);
        return savedTheater.getTheaterId();
    }
}
