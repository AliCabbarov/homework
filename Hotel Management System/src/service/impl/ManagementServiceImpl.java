package service.impl;

import enums.ExceptionEnum;
import exception.ApplicationException;
import helper.AdminHelperService;
import service.*;
import util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {

    @Override
    public void manage() {
        AdminManagementService adminManagementService = new AdminManagementServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl();
        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
        RoomService roomService = new RoomServiceImpl();
        while (true) {
            try {
                int option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        AdminHelperService.adminLogin();
                        break;
                    case 2:
                        roomService.checkReservationRoom();
                        reservationService.reservation();
                        break;
                    case 3:
                        customerManagementService.manage();
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
