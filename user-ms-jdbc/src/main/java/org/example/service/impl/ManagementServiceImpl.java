package org.example.service.impl;

import org.example.model.enums.ExceptionEnums;
import org.example.model.exception.ApplicationException;
import org.example.service.ManagementService;
import org.example.service.UserService;
import org.example.util.MenuUtil;

import java.io.IOException;
import java.sql.SQLException;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void manage() {
        UserService userService = new UserServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        userService.findByUserName();
                        break;
                    case 2:
                        userService.findAll();
                        break;
                    case 3:
                        userService.findById();
                        break;
                    case 4:
                        userService.insertUser();
                        break;
                    case 5:
                        userService.updateUserById();
                        break;
                    case 6:
                        userService.deleteUserById();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
