package org.example.entity;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    String id;
    String name;
    String description;
    List<String> cast;
    Double rating;
    int reviewCount;
    List<String> genre;
    Double duration;
    Date releaseDate;
}
