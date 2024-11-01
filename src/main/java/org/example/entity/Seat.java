package org.example.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seat {
    String id;
    int price;
    int seatNumber;
}
