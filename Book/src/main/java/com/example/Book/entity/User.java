package com.example.Book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="USER")
public class User
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String phoneNumber;
    @Column(name = "email_id", unique = true)
    private String emailId;
    private String password;
}
