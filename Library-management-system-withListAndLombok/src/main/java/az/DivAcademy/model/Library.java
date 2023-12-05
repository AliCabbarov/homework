package az.DivAcademy.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
@Getter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Library {
    @Setter
    String name;
    @Setter
    String address;
    @Setter
    long phoneNumber;
    BigDecimal moneyAccount;
    @ToString.Exclude
    List<Book> books;
    @ToString.Exclude
    List<Order> orders;
    public void addBooks(Book book) {
        this.books.add(book);
    }

    public void addOrders(Order order) {
        this.orders.add(order);
    }
    public void incrementMoneyAccount(double money){
        moneyAccount = BigDecimal.valueOf(moneyAccount.doubleValue() + money);
    }
    public void decrementMoneyAccount(double money){
        moneyAccount = BigDecimal.valueOf(moneyAccount.doubleValue() - money);
    }

}
