package az.DivAcademy.service;

import az.DivAcademy.model.Book;
import az.DivAcademy.model.Customer;
import az.DivAcademy.model.Order;
import az.DivAcademy.response.BaseResponse;

import java.util.List;

public interface CustomerService {
    BaseResponse<Order> placeOrder(Customer customer);
    BaseResponse<String> addComment(Customer customer);
    BaseResponse<Integer> likeOrDislike(Customer customer);
    BaseResponse<List<Book>> viewBook(Customer customer);
    BaseResponse<Book> searchBook(Customer customer);
    BaseResponse<List<Order>> trackOrders(Customer customer);
    BaseResponse<Order> cancelOrder(Customer customer);
}
