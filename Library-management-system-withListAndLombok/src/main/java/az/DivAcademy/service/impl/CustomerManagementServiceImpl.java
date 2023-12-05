package az.DivAcademy.service.impl;

import az.DivAcademy.enums.ExceptionEnum;
import az.DivAcademy.exception.ApplicationException;
import az.DivAcademy.helper.CustomerHelperService;
import az.DivAcademy.model.Customer;
import az.DivAcademy.service.CustomerManagementService;
import az.DivAcademy.service.CustomerService;
import az.DivAcademy.service.LoginManagementService;
import az.DivAcademy.util.MenuUtil;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Override
    public void manage(Customer customer) {
        CustomerService customerService = new CustomerServiceImpl();
        LoginManagementService loginManagementService = new LoginManagementServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().customerMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        loginManagementService.manage();
                        break;
                    case 2:
                        CustomerHelperService.checkStatusCourier();
                        customerService.placeOrder(customer);
                        break;
                    case 3:
                        customerService.addComment(customer);
                        break;
                    case 4:
                        customerService.likeOrDislike(customer);
                        break;
                    case 5:
                        customerService.viewBook(customer);
                        break;
                    case 6:
                        customerService.searchBook(customer);
                        break;
                    case 7:
                        customerService.trackOrders(customer);
                        break;
                    case 8:
                        customerService.cancelOrder(customer);
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);
                }
            } catch (ApplicationException e) {
                e.printStackTrace();
            }

        }
    }
}
