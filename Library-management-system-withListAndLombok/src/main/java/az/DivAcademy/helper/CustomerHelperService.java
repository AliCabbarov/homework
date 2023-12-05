package az.DivAcademy.helper;

import az.DivAcademy.data.GlobalData;
import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.model.Book;
import az.DivAcademy.model.Courier;
import az.DivAcademy.model.Customer;
import az.DivAcademy.model.Order;
import az.DivAcademy.util.InputUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Consumer;

import static java.time.LocalDateTime.now;

public class CustomerHelperService {
    private static long orderId = 0;
    private static long customerId = 0;

    public static Customer fillCustomer() {
        try {
            String name = InputUtil.getInstance().inputString("Enter the name: ");
            String surname = InputUtil.getInstance().inputString("Enter the surname: ");
            String email = InputUtil.getInstance().inputString("Enter the email: ");
            alreadyExistEmail(email);
            long phoneNumber = InputUtil.getInstance().inputLong("Enter the number: ");
            String password = InputUtil.getInstance().inputString("Enter the password: ");
            return new Customer(++customerId, name, surname, email, phoneNumber, 1000, password, new ArrayList<>());
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static void alreadyExistEmail(String email) {
        if (!GlobalData.customers.isEmpty()) {
            boolean isHas = GlobalData.customers.stream()
                    .anyMatch(customer -> customer.getEmail().equals(email));
            if (isHas) {
                throw new ApplicationException(ExceptionEnum.ALREADY_EXIST_EXCEPTION);
            }
        }
    }

    public static void alreadyExistCustomer(Customer fillCustomer) {
        boolean hasCustomer = GlobalData.customers.stream()
                .anyMatch(customer -> customer.equals(fillCustomer));
        if (hasCustomer) {
            throw new ApplicationException(ExceptionEnum.ALREADY_EXIST_EXCEPTION);
        }
    }

    public static void showBook() {
        if (GlobalData.library.getBooks().isEmpty()) {
            throw new ApplicationException(ExceptionEnum.BOOK_NOT_FOUND_EXCEPTION);
        }
        GlobalData.library.getBooks().stream()
                .filter(book -> book.getCopiesCount() > 0)
                .forEach(System.out::println);
    }

    public static Book chooseBook() {
        long bookId = InputUtil.getInstance().inputLong("Enter the book id: ");
        return GlobalData.library.getBooks().stream()
                .filter(book -> book.getId() == bookId)
                .filter(book -> book.getCopiesCount() > 0)
                .findFirst()
                .orElseThrow(
                        () -> new ApplicationException(ExceptionEnum.BOOK_NOT_FOUND_EXCEPTION));


    }

    public static void hasMoney(Book book, Customer customer) {
        if (book.getPrice() > customer.getAccount()) {
            throw new ApplicationException(ExceptionEnum.LOW_MONEY_EXCEPTION);
        } else System.out.println("Order successfully");
    }

    public static Order finisOrder(Book book, Customer customer) {
        Order order = createorder(book, customer);
        customer.decrementMoney(order.getPaymentAmount());
        GlobalData.library.incrementMoneyAccount(order.getPaymentAmount());
        GlobalData.library.addOrders(order);
        customer.orderAddList(order);
        return order;
    }

    private static Courier findCourier() {
        return GlobalData.couriers.stream()
                .filter(courier -> !courier.isStatus())
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ExceptionEnum.COURIER_NOT_FOUND_EXCEPTION));
    }

    private static Order createorder(Book book, Customer customer) {
        book.decrementCopiesCount();
        Courier courier = findCourier();
        courier.setStatus(true);
        return new Order(++orderId, book, customer, courier, false, now(), now().plusHours(1), book.getPrice());
    }

    public static void printReceipt(Order order) {
        System.out.println("------ Cash Receipt ------" +
                "\nStart Date: " + order.getOrderDate() +
                "\nEnd Date  : " + order.getDeliveryTime() +
                "\n\nEmail   : " + order.getCustomer().getEmail() +
                "\nBook Name : " + order.getBook().getTitle() +
                "\nBook Author :" + order.getBook().getAuthor() +
                "\nCourier Name: " + order.getCourier().getName() +
                "\nCourier phone Number: " + order.getCourier().getPhoneNumber() +
                "\nCourier vehicle Type: " + order.getCourier().getVehicleType() +
                "\nCourier vehicle Plate:" + order.getCourier().getVehiclePlate() +
                "\nCash: " + order.getPaymentAmount() + " azn");


    }

    public static Order isBeCancel(Customer customer) {
        return customer.getOrders().stream()
                .filter(order -> !order.isDeliveryStatus())
                .filter(order -> {
                    Duration duration = Duration.between(LocalDateTime.now(), order.getDeliveryTime().minusMinutes(30));
                    return duration.isNegative();
                })
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ExceptionEnum.IRREVOCABLE_EXCEPTION));
    }

    public static void checkStatusCourier(){
        GlobalData.library.getOrders().stream()
                .filter(order -> order.getCourier().isStatus())
                .filter(order -> order.getDeliveryTime().getNano() < LocalDateTime.now().getNano())
                .findFirst()
                .ifPresent(order -> order.getCourier().setStatus(true));
    }
}

