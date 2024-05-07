package com.example.Book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int movieId;
    private String movieName;
    private int rating;
    private String actor;
    private String actress;
    private String director;
    private Date releaseDate;

}
