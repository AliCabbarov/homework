package az.DivAcademy.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Courier {
    long id;
    String name;
    long phoneNumber;
    String vehicleType;
    String vehiclePlate;
    long customerId;
    long orderId;
    boolean status;
}
