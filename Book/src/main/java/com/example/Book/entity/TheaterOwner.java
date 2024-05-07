package com.example.Book.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="THEATEROWNER")
public class TheaterOwner {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ownerId;
    private String name;
    private String gstNumber;
    private boolean isVerified;
    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId;
    private String password;
}
