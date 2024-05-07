package com.example.Book.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="ADMIN")
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int adminId;
    private String name;
    private String emailId;
    private String password;
}
