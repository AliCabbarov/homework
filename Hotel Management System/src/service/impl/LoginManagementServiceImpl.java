package service.impl;

import enums.ExceptionEnum;
import exception.ApplicationException;
import model.Customer;
import model.Room;
import service.CustomerManagementService;
import service.CustomerService;
import service.LoginManagementService;
import util.MenuUtil;

public class LoginManagementServiceImpl implements LoginManagementService {
    @Override
    public void manage(Customer customer, Room room) {
        CustomerService customerService = new CustomerServiceImpl();
        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
        while (true) {
            try {
                int option = MenuUtil.getInstance().LoginMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        customerManagementService.manage();
                        break;
                    case 2:
                        customerService.showReservation(customer);
                        break;
                    case 3:
                        customerService.endDateUpdate(customer, room);
                        break;
                    case 4:
                        customerService.increaseMoneyAccount(customer);
                        break;
                    case 5:
                        customerService.cancelToReservation(customer);
                        break;
                    case 6:
                        customerService.showCustomer(customer);
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
