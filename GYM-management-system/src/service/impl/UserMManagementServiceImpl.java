package service.impl;

import enums.Exception;
import exception.ApplicationException;
import service.UserManagementService;
import service.UserService;
import util.MenuUtil;

public class UserMManagementServiceImpl implements UserManagementService {
    @Override
    public void manage() {
        UserService userService = new UserServiceImpl();
        while (true) {
            try {

                byte option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        userService.register();
                        break;
                    case 2:
                        userService.Show();
                        break;
                    case 3:
                        userService.enterGym();
                        break;
                    case 4:
                        userService.UpdateDepartures();
                        break;
                    default:
                        throw new ApplicationException(Exception.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException exception){
                exception.printStackTrace();
            }
        }
    }
}
