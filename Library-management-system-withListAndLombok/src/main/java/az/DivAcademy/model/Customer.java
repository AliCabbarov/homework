package az.DivAcademy.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Setter
    long id;
    @Setter
    String name;
    @Setter
    String surname;
    @Setter
    String email;
    @Setter
    long phoneNumber;
    double account;
    @Setter
    String password;
    List<Order> orders;

    public void incrementAccount(double money) {
        account = account + money;
    }

    public void decrementMoney(double money) {
        account = account - money;
    }
    public void orderAddList(Order order){
        orders.add(order);
    }
}

