package com.example.Book.repository;


import com.example.Book.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieShowRepo extends JpaRepository<MovieShow,Integer> {
    @Query("SELECT ms FROM MovieShow ms WHERE ms.showDate >= :currentDate AND ms.bookedSeats < ms.theater.totalSeats")
    List<MovieShow> findMovieShowsAfterOrEqualDate(@Param("currentDate") LocalDate currentDate);

}
