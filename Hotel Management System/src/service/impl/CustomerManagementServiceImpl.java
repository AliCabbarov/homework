package service.impl;

import enums.ExceptionEnum;
import exception.ApplicationException;
import service.CustomerManagementService;
import service.CustomerService;
import service.LoginService;
import service.ManagementService;
import util.MenuUtil;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Override
    public void manage() {
        CustomerService customerService = new CustomerServiceImpl();
        LoginService loginService = new LoginServiceImpl();
        ManagementService managementService = new ManagementServiceImpl();
        while (true) {
            try {
                int option = MenuUtil.getInstance().customerMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        managementService.manage();
                        break;
                    case 2:
                        customerService.register();
                        break;
                    case 3:
                        loginService.login();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);
                }

            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
