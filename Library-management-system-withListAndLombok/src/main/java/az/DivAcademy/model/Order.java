package az.DivAcademy.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    long id;
    Book book;
    Customer customer;
    Courier courier;
    boolean deliveryStatus;
    LocalDateTime orderDate;
    LocalDateTime deliveryTime;
    double paymentAmount;
}
