package az.DivAcademy.service.impl;

import az.DivAcademy.data.GlobalData;
import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.model.Customer;
import az.DivAcademy.response.BaseResponse;
import az.DivAcademy.service.CustomerManagementService;
import az.DivAcademy.service.LoginService;
import az.DivAcademy.util.InputUtil;

import static az.DivAcademy.helper.CustomerHelperService.alreadyExistCustomer;
import static az.DivAcademy.helper.CustomerHelperService.fillCustomer;

public class LoginServiceImpl implements LoginService {
    @Override
    public BaseResponse<Customer> signUp() {
        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
        System.out.println("-------------| Welcome to Sign Up Menu |--------------");
        Customer customer = fillCustomer();
        if (customer == null){
            throw new NullPointerException("Null customer!!!");
        }
         alreadyExistCustomer(customer);

        GlobalData.customers.add(customer);
        customerManagementService.manage(customer);
        return new BaseResponse<Customer>().of(200,"Success",customer);

    }



    @Override
    public void login() {
        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
        System.out.println("-------------| Welcome to Login Menu |--------------");
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");

        GlobalData.customers.stream()
                .filter(hasCustomer -> hasCustomer.getEmail().equals(email) && hasCustomer.getPassword().equals(password))
                .findFirst()
                .ifPresentOrElse(customerManagementService::manage,
                        () -> {
                            throw new ApplicationException(ExceptionEnum.CUSTOMER_NOT_FOUND_EXCEPTION);
                        });

    }
}
