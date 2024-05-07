package com.example.Book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name="MovieSHOW")
public class MovieShow {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int showId;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @Temporal(TemporalType.DATE)
    private Date showDate;
    private String startTime;
    private String endTime;
    private int price;
    private int bookedSeats;
}
