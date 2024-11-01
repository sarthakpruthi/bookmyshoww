package org.example.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    String id;
    String name;
    String email;
    String phoneNumber;
    int age;
}
