package helper;

import data.AdminData;
import service.AdminManagementService;
import service.impl.AdminManagementServiceImpl;
import util.InputUtil;

public class AdminHelperService {
    public static void adminLogin() {
        AdminManagementService adminManagementService = new AdminManagementServiceImpl();
        String username = InputUtil.getInstance().inputString("Enter the username: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        if(username.equals(AdminData.username) && password.equals(AdminData.password)){
            adminManagementService.manage();
        }
    }
}
