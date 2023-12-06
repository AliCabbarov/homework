package service.impl;

import data.GlobalData;
import helper.HelperService;
import model.Customer;
import model.Room;
import response.BaseResponse;
import service.LoginManagementService;
import service.LoginService;
import util.InputUtil;

public class LoginServiceImpl implements LoginService{
    @Override
    public BaseResponse<?> login() {
        LoginManagementService loginManagementService = new LoginManagementServiceImpl();
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        for (Customer customer: GlobalData.customers) {
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password)){
                Room room = HelperService.getInstance().searchRoom(customer);
                loginManagementService.manage(customer,room);
            }
        }
        return null;
    }
}
