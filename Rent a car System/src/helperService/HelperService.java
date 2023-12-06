package helperService;

import data.GlobalData;
import enums.ExceptionEnums;
import exception.ApplicationException;
import model.Car;
import model.Operations;
import util.InputUtil;

import java.time.LocalDate;

public class HelperService {
    private static HelperService instance;
    private static long carId;
    private static long operationId;

    private HelperService() {

    }

    public static HelperService getInstance() {
        return instance == null ? instance = new HelperService() : instance;
    }

    public Car fillCar() {
        try {
            String brand = InputUtil.getInstance().inputString("Enter the brand: ");
            String model = InputUtil.getInstance().inputString("Enter the model: ");
            double engine = InputUtil.getInstance().inputDouble("Enter the engine: ");
            int production = InputUtil.getInstance().inputInt("Enter the production: ");
            String bodyType = InputUtil.getInstance().inputString("Enter the body type: ");
            byte seats = InputUtil.getInstance().inputByte("Enter the seats: ");
            byte doors = InputUtil.getInstance().inputByte("Enter the doors: ");
            int speed = InputUtil.getInstance().inputInt("Enter the speed: ");
            double amount = InputUtil.getInstance().inputDouble("Enter the amount: ");
            return new Car(++carId, brand, model, engine, production, bodyType, seats, doors, speed, amount, false);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void showCarForRent() {
        for (Car car : GlobalData.cars) {
            if (!car.isRent()) {
                System.out.println(car);
            }
        }
    }
    public void showCarForReturn() {
        for (Car car : GlobalData.cars) {
            if (car.isRent()) {
                System.out.println(car);
            }
        }
    }
    public Operations fillForm(long CarId) {
        try {
            String name = InputUtil.getInstance().inputString("Enter the name: ");
            String surname = InputUtil.getInstance().inputString("Enter the surname: ");
            LocalDate birthday = birthdayFormat();
            String fin = InputUtil.getInstance().inputString("Enter the fin: ");
            String passport = InputUtil.getInstance().inputString("Enter the passport: ");
            return new Operations(++operationId,CarId,name,surname,birthday,fin,passport,true);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private LocalDate birthdayFormat() {
        try {
            String stringBirthday = InputUtil.getInstance().inputString("Enter the birthday(dd/MM/YYYY): ");
            String[] splitBirthday = stringBirthday.split("/");
            byte day = (byte) Integer.parseInt(splitBirthday[0]);
            byte month = (byte) Integer.parseInt(splitBirthday[1]);
            int years = Integer.parseInt(splitBirthday[2]);
            return LocalDate.of(years,month,day);
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    public void Rented(Car car){
        car.setRent(true);
    }

    public void hasCarForRent(){
        boolean isTrue = false;
        for (int i = 0; i < GlobalData.cars.size(); i++) {
            if(!GlobalData.cars.get(i).isRent()){
                isTrue = true;
            }
        }
        if(!isTrue){
            throw new ApplicationException(ExceptionEnums.CAR_NOT_FOUND_EXCEPTION);
        }
    }
    public void hasCarForReturn(){
        boolean isTrue = false;
        for (int i = 0; i < GlobalData.cars.size(); i++) {
            if(GlobalData.cars.get(i).isRent()){
                isTrue = true;
            }
        }
        if(!isTrue){
            throw new ApplicationException(ExceptionEnums.CAR_NOT_FOUND_EXCEPTION);
        }
    }
}
