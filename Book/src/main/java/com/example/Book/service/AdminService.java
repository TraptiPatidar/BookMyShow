package com.example.Book.service;

import com.example.Book.entity.Admin;
import com.example.Book.entity.TheaterOwner;
import com.example.Book.repository.AdminRepo;
import com.example.Book.repository.TheaterOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    TheaterOwnerRepo theaterOwnerRepo;
    public String loginAdmin(String emailId,String password){
        Admin admin=adminRepo.findByEmailIdAndPassword(emailId, password);
        if(admin!=null){
            return "logged in";}
        else return "error";
    }

    public List<TheaterOwner> getAllRequests(){
        return theaterOwnerRepo.findByIsVerifiedFalse();
    }

    public String approveReq(int ownerId){
        theaterOwnerRepo.updateIsVerifiedTrue(ownerId);
        return "approved";
    }
}
