package az.DivAcademy.service;

import az.DivAcademy.model.Customer;
import az.DivAcademy.response.BaseResponse;

public interface LoginService {
    BaseResponse<Customer> signUp();
    void login();
}
