package com.example.Book.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MovieShowDTO {
    private int showId;
    private String theaterName;
    private String movieName;
    private int rating;
    private String startTime;
    private String endTime;
    private Date showDate;
    int amount;
    int availableSeats;
}
