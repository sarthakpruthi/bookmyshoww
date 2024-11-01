package org.example.controller;

import org.example.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieController {
    Map<String, List<Movie>> cityMovieMap;
    List<Movie> allMovies;

    public MovieController(){
        cityMovieMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public List<Movie> getAllMovies(){
        return allMovies;
    }


    public List<Movie> getMovieByCity(String city){
        return cityMovieMap.getOrDefault(city, new ArrayList<>());
    }

    public void addMovie(Movie movie, String city) {
        List<Movie> movieByCity = getMovieByCity(city);
        movieByCity.add(movie);
        if(allMovies.stream()
                .noneMatch(m->m.getName().equals(movie.getName()))){
            allMovies.add(movie);
        }
        cityMovieMap.put(city, movieByCity);
    }
}
