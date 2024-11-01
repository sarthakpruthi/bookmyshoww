package org.example;

import org.example.controller.MovieController;
import org.example.controller.TheaterController;
import org.example.entity.*;

import java.util.*;
import java.util.stream.Collectors;

public class BookMyShow {
    static MovieController movieController;
    static TheaterController theaterController;

    BookMyShow(){
        movieController = new MovieController();
        theaterController = new TheaterController();
    }


    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        createBooking("Bangalore","Bahubali");
        createBooking("Bangalore","Bahubali");
    }

    private static void createBooking(String city, String movie) {
        List<Movie> movies = movieController.getMovieByCity(city);
        Optional<Movie> interestedMovie = movies.stream().filter(m -> m.getName().equals(movie)).findFirst();
        if(interestedMovie.isPresent()) {
            List<Show> shows = theaterController.getShowsByCityAndMovie(city, movie);
            Show interestedShow = shows.get(0);
            List<Integer> bookedSeats = interestedShow.getBookedSeatNumbers();
            int seatNumber=1;
            if(!bookedSeats.contains(seatNumber)){
                bookedSeats.add(seatNumber);
                Seat seat = interestedShow.getScreen().getSeats()
                        .stream()
                        .filter(s -> s.getSeatNumber() == seatNumber).findFirst().get();

                Booking booking = Booking.builder()
                        .id(UUID.randomUUID().toString())
                        .show(interestedShow)
                        .seats(List.of(seat))
                        .build();

                System.out.println("booking successful");
            }
            else{
                System.out.println("This seat is booked");
            }
        }
        else{
            System.out.println("No such movie in your city!");
        }
    }

    private void initialize() {
        createTheater(createMovies());
    }

    private void createTheater(List<Movie> movies) {
        List<Screen> screens = createScreen();
        Show s1 = createShow(screens.get(0),movies.get(0),0);
        Show s2 = createShow(screens.get(0),movies.get(1),16);
        Theater t1 = Theater.builder()
                .id(UUID.randomUUID().toString())
                .screens(screens)
                .city("Bangalore")
                .shows(List.of(s1,s2)).build();

        Theater t2 = Theater.builder()
                .id(UUID.randomUUID().toString())
                .screens(screens)
                .city("Delhi")
                .shows(List.of(s1,s2))
                .build();


        theaterController.setCityTheater("Bangalore", t1);
        theaterController.setCityTheater("Delhi", t2);
    }

    private Show createShow(Screen screen, Movie movie, int startTime) {
        return Show.builder()
                .id(UUID.randomUUID().toString())
                .movie(movie)
                .screen(screen)
                .startTime(startTime)
                .bookedSeatNumbers(new ArrayList<>()).build();
    }

    private List<Screen> createScreen() {
        Seat seat = Seat.builder()
                .id(UUID.randomUUID().toString())
                .seatNumber(1)
                .price(200)
                .build();
        Screen screen = Screen.builder()
                .id(UUID.randomUUID().toString())
                .seats(List.of(seat))
                .build();
        return List.of(screen);
    }

    private List<Movie> createMovies() {
        Movie avengers = Movie.builder()
                .id(UUID.randomUUID().toString())
                .name("Avengers")
                .duration(120.0)
                .build();
        Movie bahubali = Movie.builder()
                .id(UUID.randomUUID().toString())
                .name("Bahubali")
                .duration(128.0)
                .build();

        movieController.addMovie(avengers,"Bangalore");
        movieController.addMovie(avengers,"Delhi");
        movieController.addMovie(bahubali,"Bangalore");
        movieController.addMovie(bahubali,"Delhi");
        return List.of(avengers,bahubali);
    }

    private static void bookMovie(String id) {

    }
}