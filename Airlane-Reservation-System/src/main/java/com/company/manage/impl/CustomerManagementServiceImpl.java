package com.company.manage.impl;

import com.company.enums.ExceptionEnum;
import com.company.exception.ApplicationException;
import com.company.helper.HelperService;
import com.company.manage.CustomerManagementService;
import com.company.manage.ManagementService;
import com.company.service.CustomerService;
import com.company.service.impl.CustomerServiceImpl;
import com.company.util.MenuUtil;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Override
    public void manage() {
        while (true) {
            try {
                ManagementService managementService = new ManagementServiceImpl();
                CustomerService customerService = new CustomerServiceImpl();
                byte option = MenuUtil.getInstance().customerMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        managementService.manage();
                        break;
                    case 2:
                        customerService.viewFlights();
                        break;
                    case 3:
                        customerService.OrderTicket();
                        HelperService.checkFlights();
                        break;
                    case 4:
                        customerService.cancelTickets();
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
