package service;

import model.Customer;
import model.Room;
import response.BaseResponse;

public interface CustomerService {
    BaseResponse<?> register();
    BaseResponse<?> showReservation(Customer customer);
    BaseResponse<?> endDateUpdate(Customer customer, Room room);
    BaseResponse<?> increaseMoneyAccount(Customer customer);
    BaseResponse<?> cancelToReservation(Customer customer);

    BaseResponse<Customer> showCustomer(Customer customer);
}
