package com.example.Book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int bookingId;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private MovieShow movieShow;

    private String bookingTime;
    private int bookingAmount;
}
