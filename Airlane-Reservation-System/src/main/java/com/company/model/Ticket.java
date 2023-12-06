package com.company.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
    long id;
    long ticketNumber;
    String source;
    String destination;
    double price;
    long flightId;
}
