package org.example.entity;


import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    String id;
    List<Seat> seats;
    Show show;
}
