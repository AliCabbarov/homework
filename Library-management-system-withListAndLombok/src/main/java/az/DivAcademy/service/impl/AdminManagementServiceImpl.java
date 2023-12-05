package az.DivAcademy.service.impl;

import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.service.AdminManagementService;
import az.DivAcademy.service.AdminService;
import az.DivAcademy.service.ManagementService;
import az.DivAcademy.util.MenuUtil;

public class AdminManagementServiceImpl implements AdminManagementService {
    @Override
    public void manage() {
        ManagementService managementService = new ManagementServiceImpl();
        AdminService adminService = new AdminServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().adminMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        managementService.manage();
                        break;
                    case 2:
                        adminService.addBook();
                        break;
                    case 3:
                        adminService.addCourier();
                        break;
                    case 4:
                        adminService.trackOrders();
                        break;
                    case 5:
                        adminService.viewBooks();
                        break;
                    case 6:
                        adminService.viewCustomers();
                        break;
                    case 7:
                        adminService.viewCouriers();
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
