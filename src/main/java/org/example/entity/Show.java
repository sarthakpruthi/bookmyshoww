package org.example.entity;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
    String id;
    Movie movie;
    Screen screen;
    int startTime;
    List<Integer> bookedSeatNumbers;
}
