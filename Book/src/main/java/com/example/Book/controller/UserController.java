package com.example.Book.controller;

import com.example.Book.DTO.BookingDTO;
import com.example.Book.DTO.MovieShowDTO;
import com.example.Book.DTO.UserDTO;
import com.example.Book.entity.User;
import com.example.Book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bms/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody Map<String, String> requestBody){
        String emailId = requestBody.get("emailId");
        String password = requestBody.get("password");
        return userService.loginUser(emailId,password);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "User Registered";
    }

    @GetMapping("/showAllMovieShows")
    public List<MovieShowDTO> showAllMovieShows(@RequestParam int userId){

        return userService.getAllMovieShow();
    }

    @PostMapping("/booked")
    public BookingDTO bookMovieShow(@RequestBody MovieShowDTO movieShowDTO){
        return userService.bookShow(movieShowDTO);
    }

    @DeleteMapping("/deleteBooking")
    public String deleteBooking(@RequestParam int bookingId){
        return userService.deleteBooking(bookingId);
    }
}
