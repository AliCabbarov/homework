package com.company.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passenger {
    long id;
    String name;
    String surname;
    int age;
    LocalDate birthdate;
    String phoneNumber;
    String email;
    String passportNumber;
    String gender;
    double balance;
    long ticketId;
    long seatNumber;
}
