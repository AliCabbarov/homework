package az.DivAcademy.helper;

import az.DivAcademy.data.AdminData;
import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.service.AdminManagementService;
import az.DivAcademy.service.impl.AdminManagementServiceImpl;
import az.DivAcademy.util.InputUtil;

public class AdminHelperService {
    public static void adminLogin() {
        AdminManagementService adminManagementService = new AdminManagementServiceImpl();
        String username = InputUtil.getInstance().inputString("Enter the username: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        if(username.equals(AdminData.username) && password.equals(AdminData.password)){
            adminManagementService.manage();
        }else {
            throw new ApplicationException(ExceptionEnum.WRONG_USERNAME_OR_PASSWORD_EXCEPTION);
        }
    }
}
