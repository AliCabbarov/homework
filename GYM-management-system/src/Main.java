import service.UserManagementService;
import service.impl.UserMManagementServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserManagementService userManagementService = new UserMManagementServiceImpl();
        userManagementService.manage();
    }
}