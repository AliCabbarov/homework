package helper;

import data.GlobalData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import model.Customer;
import util.InputUtil;

import java.time.LocalDate;

public class CustomerHelperService {
    private static int customerId;
    private static CustomerHelperService instance;
    private CustomerHelperService(){}

    public static CustomerHelperService getInstance() {
        return instance == null ? instance = new CustomerHelperService() : instance;
    }

    public Customer fillCustomer(){
        try {
            String name = InputUtil.getInstance().inputString("Enter the name: ");
            String surname = InputUtil.getInstance().inputString("Enter the surname: ");
            LocalDate birthday = HelperService.getInstance().birthday("Enter the birthday");
            lowAgeException(birthday);
            String phone = InputUtil.getInstance().inputString("Enter the phone number: ");
            String email = InputUtil.getInstance().inputString("Enter the email: ");
            sameEmailException(email);
            String password = InputUtil.getInstance().inputString("Enter the password: ");
            return new Customer(++customerId,name,surname,birthday,phone,email,password,0,null,null,HelperService.getInstance().now(),null ,0);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void lowAgeException(LocalDate birthday) {
        if(birthday.getYear() < 18){
            throw new ApplicationException(ExceptionEnum.LOW_AGE_EXCEPTION);
        }
    }

    private void sameEmailException(String email) {
        for (Customer customer: GlobalData.customers){
            if(customer.getEmail().equals(email)){
                throw new ApplicationException(ExceptionEnum.SAME_EMAIL_EXCEPTION);
            }
        }
    }
}
