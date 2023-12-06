package com.company.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Flight {
    long id;
    String name;
    String source;
    String destination;
    LocalDate date;
    LocalTime startingTime;
    LocalTime reachingTime;
    boolean isContinue;
    double price;
}
