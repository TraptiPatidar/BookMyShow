package com.example.Book.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="THEATER")
public class Theater {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int theaterId;
    String theaterName;
    private int totalSeats;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private TheaterOwner theaterOwner;
    private String address;
}
