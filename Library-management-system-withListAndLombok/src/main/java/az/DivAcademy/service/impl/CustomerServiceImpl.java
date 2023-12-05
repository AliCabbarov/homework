package az.DivAcademy.service.impl;

import az.DivAcademy.data.GlobalData;
import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.helper.BookHelperService;
import az.DivAcademy.helper.CustomerHelperService;
import az.DivAcademy.model.Book;
import az.DivAcademy.model.Customer;
import az.DivAcademy.model.Order;
import az.DivAcademy.response.BaseResponse;
import az.DivAcademy.service.CustomerService;
import az.DivAcademy.util.InputUtil;
import az.DivAcademy.util.MenuUtil;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public BaseResponse<Order> placeOrder(Customer customer) {
        CustomerHelperService.showBook();
        Book book = CustomerHelperService.chooseBook();
        CustomerHelperService.hasMoney(book, customer);
        Order order = CustomerHelperService.finisOrder(book, customer);
        CustomerHelperService.printReceipt(order);
        return new BaseResponse<Order>().of(200, "Success", order);
    }

    @Override
    public BaseResponse<String> addComment(Customer customer) {
        BookHelperService.showBook(customer);
        Book book = BookHelperService.chooseBook(customer);
        String comment = InputUtil.getInstance().inputString("Input the comment: ");
        book.addComments(comment);
        return new BaseResponse<String>().of(200, "Success", comment);
    }

    @Override
    public BaseResponse<Integer> likeOrDislike(Customer customer) {
        if (customer.getOrders().isEmpty()) {
            throw new ApplicationException(ExceptionEnum.YOU_HAVE_NOT_BOOK_EXCEPTION);
        }
        customer.getOrders().forEach(System.out::println);
        Book book = BookHelperService.chooseBook(customer);
        byte option = MenuUtil.getInstance().likeOrDislike();

        if (option == 1) {
            book.incrementLikes();
        } else {
            book.incrementDisLikes();
        }

        return new BaseResponse<Integer>().of(200,"Success", (int) option);

    }

    @Override
    public BaseResponse<List<Book>> viewBook(Customer customer) {
        if (customer.getOrders().isEmpty()) {
            throw new ApplicationException(ExceptionEnum.YOU_HAVE_NOT_BOOK_EXCEPTION);
        }
        List<Book> bookList = customer.getOrders()
                .stream().peek(Order::getBook)
                .map(Order::getBook)
                .collect(Collectors.toList());


        return new BaseResponse<List<Book>>().of(200,"Success",bookList);
    }

    @Override
    public BaseResponse<Book> searchBook(Customer customer) {
        if (customer.getOrders().isEmpty()) {
            throw new ApplicationException(ExceptionEnum.YOU_HAVE_NOT_BOOK_EXCEPTION);
        }

        Book book = BookHelperService.chooseBook(customer);
        System.out.println(book);
        return new BaseResponse<Book>().of(200,"Success",book);
    }

    @Override
    public BaseResponse<List<Order>> trackOrders(Customer customer) {
        if (customer.getOrders().isEmpty()) {
            throw new ApplicationException(ExceptionEnum.YOU_HAVE_NOT_ORDER_EXCEPTION);
        }

        System.out.println(customer.getOrders());
        return new BaseResponse<List<Order>>().of(200,"Success",customer.getOrders());
    }

    @Override
    public BaseResponse<Order> cancelOrder(Customer customer) {
        Order order = CustomerHelperService.isBeCancel(customer);
        order.setDeliveryStatus(true);
        customer.incrementAccount(order.getPaymentAmount());
        GlobalData.library.decrementMoneyAccount(order.getPaymentAmount());
        order.getCourier().setStatus(false);
        System.err.println("ORDER CANCELED!!!");
        return new BaseResponse<Order>().of(200,"Success",order);
    }
}
