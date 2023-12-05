package az.DivAcademy.service.impl;

import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.helper.AdminHelperService;
import az.DivAcademy.service.LoginManagementService;
import az.DivAcademy.service.ManagementService;
import az.DivAcademy.util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void manage() {
        LoginManagementService loginManagementService = new LoginManagementServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 1:
                        System.exit(-1);
                    case 2:
                        AdminHelperService.adminLogin();
                        break;
                    case 3:
                        loginManagementService.manage();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);
                }
            }catch (ApplicationException e){
                e.printStackTrace();
            }
        }

    }
}
