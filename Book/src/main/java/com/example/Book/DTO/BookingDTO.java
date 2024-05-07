package com.example.Book.DTO;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class BookingDTO {
    int bookingId;
    String startTime;
    String movieName;
    String theaterName;
    String theaterAddress;
    Date showDate;
    int price;

}
