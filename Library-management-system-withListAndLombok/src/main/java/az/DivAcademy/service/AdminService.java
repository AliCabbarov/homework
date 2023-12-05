package az.DivAcademy.service;

import az.DivAcademy.model.*;
import az.DivAcademy.response.BaseResponse;

import java.util.List;

public interface AdminService {
    BaseResponse<Book> addBook();

    BaseResponse<Courier> addCourier();

    BaseResponse<List<Order>> trackOrders();

    BaseResponse<List<Book>> viewBooks();

    BaseResponse<List<Customer>> viewCustomers();

    BaseResponse<List<Courier>> viewCouriers();
    BaseResponse<Library> showLibrary();


}
