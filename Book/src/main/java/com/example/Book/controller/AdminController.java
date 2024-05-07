package com.example.Book.controller;

import com.example.Book.entity.TheaterOwner;
import com.example.Book.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bms/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/login")
    public String loginAdmin(@RequestBody Map<String, String> requestBody){
        String emailId=requestBody.get("emailId");
        String password=requestBody.get("password");
        return adminService.loginAdmin(emailId,password);
    }

    @GetMapping("/requests")
    public List<TheaterOwner> getAllRequests(){
        return adminService.getAllRequests();
    }

    @PostMapping("/approveRequest")
    public String approveReq(@RequestParam int ownerId){
        System.out.println("hii");
        return adminService.approveReq(ownerId);
    }
}
