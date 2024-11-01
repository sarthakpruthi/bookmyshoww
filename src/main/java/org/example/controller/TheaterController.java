package org.example.controller;

import org.example.entity.Show;
import org.example.entity.Theater;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TheaterController {
    Map<String, List<Theater>> cityTheaterMap;
    List<Theater> allTheaters;

    public TheaterController(){
        cityTheaterMap = new HashMap<>();
        allTheaters = new ArrayList<>();
    }

    public List<Theater> getCityTheaters(String city){
        return cityTheaterMap.getOrDefault(city, new ArrayList<>());
    }

    public void setCityTheater(String city, Theater theater){
        allTheaters.add(theater);
        List<Theater> theaters = getCityTheaters(city);
        theaters.add(theater);
        cityTheaterMap.put(city, theaters);
    }

    public List<Show> getShowsByCityAndMovie(String city, String movie) {
        List<Theater> theaters = getCityTheaters(city);
        return theaters.stream()
                .flatMap(theater -> theater.getShows().stream())
                .filter(show -> show.getMovie().getName().equals(movie)).toList();
    }
}
