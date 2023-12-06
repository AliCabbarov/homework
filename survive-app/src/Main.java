import service.ManagementService;
import service.impl.ManagementServiceImpl;

public class Main {
    public static void main(String[] args) {
        /*
        Thread
        Runnable
        run and start
         */
        ManagementService managementService = new ManagementServiceImpl();
        managementService.management();
    }
}