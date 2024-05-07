package com.example.Book.controller;

import com.example.Book.entity.Theater;
import com.example.Book.entity.TheaterOwner;
import com.example.Book.service.TheaterOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bms/theaterOwner")
public class TheaterOwnerController {
    @Autowired
    TheaterOwnerService theaterService;
    @PostMapping("/login")
    public String loginTheaterOwner(@RequestBody Map<String, String> requestBody){
        String emailId=requestBody.get("emailId");
        String password=requestBody.get("password");
        return theaterService.loginTheaterOwner(emailId,password);
    }
    @PostMapping("/register")
    public String registerTheaterOwner(@RequestBody TheaterOwner theaterOwner){
        return theaterService.registerTheaterOwner(theaterOwner);
    }

    @PostMapping("/addTheater")
    public int addTheater(@RequestParam int ownerId, @RequestBody Theater theater){
        return theaterService.addTheater(ownerId,theater);
    }
}
