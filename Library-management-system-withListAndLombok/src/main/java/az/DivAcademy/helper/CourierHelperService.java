package az.DivAcademy.helper;

import az.DivAcademy.model.Courier;
import az.DivAcademy.util.InputUtil;

public class CourierHelperService {
    private static long courierId = 0;
    public static Courier fillCourier(){
        try {
            String name = InputUtil.getInstance().inputString("Enter the name: ");
            long phoneNumber = InputUtil.getInstance().inputLong("Enter the number: ");
            String vehicleType = InputUtil.getInstance().inputString("Enter the vehicle type: ");
            String vehiclePlate = InputUtil.getInstance().inputString("Enter the vehicle Plate: ");
            return new Courier(++courierId,name,phoneNumber,vehicleType,vehiclePlate,0,0,false);
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
}
