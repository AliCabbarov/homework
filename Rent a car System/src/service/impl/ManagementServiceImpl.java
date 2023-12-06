package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import service.CarService;
import service.ManagementService;
import service.OperationService;
import util.MenuUtil;


public class ManagementServiceImpl implements ManagementService {
    @Override
    public void manage() {
        CarService carService = new CarServiceImpl();
        OperationService operationService = new OperationServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        carService.rent();
                        break;
                    case 2:
                        operationService.show();
                        break;
                    case 3:
                        carService.register();
                        break;
                    case 4:
                        carService.returnRent();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
