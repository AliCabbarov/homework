package az.DivAcademy.service.impl;

import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.service.LoginManagementService;
import az.DivAcademy.service.LoginService;
import az.DivAcademy.service.ManagementService;
import az.DivAcademy.util.MenuUtil;

public class LoginManagementServiceImpl implements LoginManagementService {
    @Override
    public void manage() {
        ManagementService managementService = new ManagementServiceImpl();
        LoginService loginService = new LoginServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().loginMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        loginService.login();
                        break;
                    case 2:
                        loginService.signUp();
                        break;
                    case 3:
                        managementService.manage();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);
                }
            } catch (ApplicationException e) {
                e.printStackTrace();
            }

        }
    }
}