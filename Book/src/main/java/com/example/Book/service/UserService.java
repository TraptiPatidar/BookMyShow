package com.example.Book.service;

import com.example.Book.DTO.BookingDTO;
import com.example.Book.DTO.MovieShowDTO;
import com.example.Book.DTO.UserDTO;
import com.example.Book.entity.Booking;
import com.example.Book.entity.MovieShow;
import com.example.Book.entity.User;
import com.example.Book.repository.BookingRepo;
import com.example.Book.repository.MovieShowRepo;
import com.example.Book.repository.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MovieShowRepo movieShowRepo;
    @Autowired
    private BookingRepo bookingRepo;
    public UserDTO loginUser(String emailId, String password){
        User user=userRepo.findByEmailIdAndPassword(emailId,password);
        if(user==null) return null;
        else{
            return UserDTO.builder()
                    .userId(user.getUserId())
                    .username(user.getUsername())
                    .build();
        }
    }
    public void registerUser(User user)
    {
        userRepo.save(user);
    }
    public List<MovieShowDTO> getAllMovieShow(){
        LocalDate currentDate = LocalDate.now();
        List<MovieShow> m=movieShowRepo.findMovieShowsAfterOrEqualDate(currentDate);
        List<MovieShowDTO> movieShowDTOArrayList = new ArrayList<>();
        for (MovieShow e : m) {
            movieShowDTOArrayList.add(MovieShowDTO.builder()
                            .showId(e.getShowId())
                            .theaterName(e.getTheater().getTheaterName())
                            .movieName(e.getMovie().getMovieName())
                            .rating(e.getMovie().getRating())
                            .startTime(e.getStartTime())
                            .endTime(e.getEndTime())
                            .showDate(e.getShowDate())
                            .amount(e.getPrice())
                            .availableSeats(e.getTheater().getTotalSeats()-e.getBookedSeats())
                    .build());
        }
        return movieShowDTOArrayList;
    }
    public BookingDTO bookShow(MovieShowDTO movieShowDTO){
        Optional<MovieShow> movieShowOptional=movieShowRepo.findById(movieShowDTO.getShowId());
        MovieShow movieShow = movieShowOptional.get();
        movieShow.setBookedSeats(movieShow.getTheater().getTotalSeats()-movieShowDTO.getAvailableSeats()+1);
        Booking savedBooking = bookingRepo.save(Booking.builder()
                        .bookingTime(movieShowDTO.getStartTime())
                        .bookingAmount(movieShowDTO.getAmount())
                        .movieShow(movieShow)
                .build());

        return BookingDTO.builder()
                .bookingId(savedBooking.getBookingId())
                .theaterName(movieShow.getTheater().getTheaterName())
                .price(savedBooking.getBookingAmount())
                .startTime(movieShow.getStartTime())
                .theaterAddress(movieShow.getTheater().getAddress())
                .movieName(movieShow.getMovie().getMovieName())
                .showDate(movieShow.getShowDate())
                .build();
    }
    public String deleteBooking(int bookingId){
        bookingRepo.deleteById(bookingId);
        return "deleted";
    }
}
