package az.DivAcademy.service.impl;

import az.DivAcademy.data.GlobalData;
import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.model.*;
import az.DivAcademy.response.BaseResponse;
import az.DivAcademy.service.AdminService;

import java.util.List;
import java.util.stream.Collectors;

import static az.DivAcademy.helper.BookHelperService.fillBook;
import static az.DivAcademy.helper.CourierHelperService.fillCourier;

public class AdminServiceImpl implements AdminService {
    @Override
    public BaseResponse<Book> addBook() {
        Book book = fillBook();
        if(book != null){
            GlobalData.library.addBooks(book);
            return new BaseResponse<Book>().of(200,"Success",book);
        }
        return new BaseResponse<Book>().of(400,"Invalid");
    }

    @Override
    public BaseResponse<Courier> addCourier() {
        Courier courier = fillCourier();
        if(courier != null){
            GlobalData.couriers.add(courier);
            return new BaseResponse<Courier>().of(200,"Success",courier);
        }
        return new BaseResponse<Courier>().of(400,"Invalid");
    }

    @Override
    public BaseResponse<List<Order>> trackOrders() {
        if (GlobalData.library.getOrders().isEmpty()){
            throw new ApplicationException(ExceptionEnum.ORDER_NOT_FOUND_EXCEPTION);
        }
        List<Order> orderList = GlobalData.library.getOrders().stream()
                .peek(System.out::println)
                .collect(Collectors.toList());

        return new BaseResponse<List<Order>>().of(200,"Success",orderList);
    }

    @Override
    public BaseResponse<List<Book>> viewBooks() {
        if (GlobalData.library.getBooks().isEmpty()){
            throw new ApplicationException(ExceptionEnum.BOOK_NOT_FOUND_EXCEPTION);
        }
        List<Book> bookList = GlobalData.library.getBooks().stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
        return new BaseResponse<List<Book>>().of(200,"Success",bookList);
    }

    @Override
    public BaseResponse<List<Customer>> viewCustomers() {
        if (GlobalData.customers.isEmpty()){
            throw new ApplicationException(ExceptionEnum.CUSTOMER_NOT_FOUND_EXCEPTION);
        }
        List<Customer> customerList = GlobalData.customers.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
        return new BaseResponse<List<Customer>>().of(200,"Success",customerList);
    }

    @Override
    public BaseResponse<List<Courier>> viewCouriers() {
        if (GlobalData.couriers.isEmpty()){
            throw new ApplicationException(ExceptionEnum.COURIER_NOT_FOUND_EXCEPTION);
        }
        List<Courier> courierList = GlobalData.couriers.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
        return new BaseResponse<List<Courier>>().of(2000,"Success",courierList);
    }

    @Override
    public BaseResponse<Library> showLibrary() {
        System.out.println(GlobalData.library);
        return new BaseResponse<Library>().of(200,"Success",GlobalData.library);
    }
}
