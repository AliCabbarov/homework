package service.impl;

import enums.ExceptionEnum;
import exception.ApplicationException;
import service.AdminManagementService;
import service.AdminService;
import service.ManagementService;
import util.MenuUtil;
public class AdminManagementServiceImpl implements AdminManagementService {
    @Override
    public void manage() {
        AdminService adminService = new AdminServiceImpl();
        ManagementService managementService = new ManagementServiceImpl();
        while (true) {
            try {
                int option = MenuUtil.getInstance().adminMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        managementService.manage();
                        break;
                    case 2:
                        adminService.registerRoom();
                        break;
                    case 3:
                        adminService.showCustomer();
                        break;
                    case 4:
                        adminService.showRoom();
                        break;
                    case 5:
                        adminService.showReservation();
                        break;
                    case 6:
                        adminService.showHotelInfo();
                        break;
                    case 7:
                        adminService.searchCustomer();
                        break;
                    case 8:
                        adminService.updateRoomPrice();
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

