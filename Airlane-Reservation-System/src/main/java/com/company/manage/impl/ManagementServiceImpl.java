package com.company.manage.impl;

import com.company.enums.ExceptionEnum;
import com.company.exception.ApplicationException;
import com.company.helper.AdminHelperService;
import com.company.manage.CustomerManagementService;
import com.company.manage.ManagementService;
import com.company.util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void manage() {
        while (true) {
            try {
                CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
                byte option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 1:
                        System.exit(-1);
                    case 2:
                        AdminHelperService.adminLogin();
                        break;
                    case 3:
                        customerManagementService.manage();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }

    }
}
