package org.example.entity;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theater {
    String id;
    String city;
    List<Screen> screens;
    List<Show> shows;
}
