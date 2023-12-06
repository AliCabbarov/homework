package com.company.helper;

import com.company.data.AdminData;
import com.company.enums.ExceptionEnum;
import com.company.exception.ApplicationException;
import com.company.manage.AdminManagementService;
import com.company.manage.impl.AdminManagementServiceImpl;
import com.company.util.InputUtil;

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
