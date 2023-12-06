package com.company.manage.impl;

import com.company.enums.ExceptionEnum;
import com.company.exception.ApplicationException;
import com.company.manage.AdminManagementService;
import com.company.manage.ManagementService;
import com.company.service.AdminService;
import com.company.service.impl.AdminServiceImpl;
import com.company.util.MenuUtil;

public class AdminManagementServiceImpl implements AdminManagementService {
    @Override
    public void manage() {
        while (true) {
            try {
                AdminService adminService = new AdminServiceImpl();
                ManagementService managementService = new ManagementServiceImpl();
                byte option = MenuUtil.getInstance().adminMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        managementService.manage();
                        break;
                    case 2:
                        adminService.addFlight();
                        break;
                    case 3:
                        adminService.viewTickets();
                        break;
                    case 4:
                        adminService.viewPassenger();
                        break;
                    case 5:
                        adminService.viewNoticeBoard();
                        break;
                    case 6:
                        adminService.viewFlight();
                        break;
                    case 7:
                        adminService.searchAll();
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
