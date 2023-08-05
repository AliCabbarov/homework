import service.ManagementService;
import service.impl.ManagementServiceImpl;
public class Main {
    public static void main(String[] args) throws Exception{
        ManagementService managementService = new ManagementServiceImpl();
        managementService.manage();
    }
}