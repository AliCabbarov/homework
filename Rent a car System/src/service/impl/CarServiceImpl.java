package service.impl;
import data.GlobalData;
import enums.ExceptionEnums;
import enums.StatusEnums;
import exception.ApplicationException;
import helperService.HelperService;
import model.Car;
import model.Operations;
import response.Response;
import service.CarService;
import util.InputUtil;
import java.util.ArrayList;
public class CarServiceImpl implements CarService {
    @Override
    public Response<?> register() {
        byte count = InputUtil.getInstance().inputByte("How many register: ");
        boolean isAdd = false;
        for (int i = 0; i < count; i++) {
            Car car = HelperService.getInstance().fillCar();
            if (car != null) {
                GlobalData.cars.add(car);
                isAdd = true;
            }
        }
        if (isAdd) {
            System.out.println(StatusEnums.SUCCESS.getMessage());
            return new Response<ArrayList<Car>>().of(StatusEnums.SUCCESS.getMessage(), 200, GlobalData.cars);
        } else return new Response<Boolean>().of(StatusEnums.MISTAKE.getMessage(), 403);
    }
    @Override
    public Response<?> rent() {
        if (GlobalData.cars.isEmpty()) {
            throw new ApplicationException(ExceptionEnums.CAR_NOT_FOUND_EXCEPTION);
        }
        HelperService.getInstance().hasCarForRent();
        try {
            HelperService.getInstance().showCarForRent();
            boolean isBe = false;
            long carId = InputUtil.getInstance().inputLong("Enter the rent Car id: ");
            for (Car car : GlobalData.cars) {
                if (car.getId() == carId && !car.isRent()) {
                    Operations operations = HelperService.getInstance().fillForm(carId);
                    if (operations != null) {
                        GlobalData.operations.add(operations);
                        HelperService.getInstance().Rented(car);
                        System.out.println(StatusEnums.SUCCESS.getMessage());
                        return new Response<Operations>().of(StatusEnums.SUCCESS.getMessage(), 200, operations);
                    }
                }
            }
            if (!isBe) {
                throw new ApplicationException(ExceptionEnums.CAR_NOT_FOUND_EXCEPTION);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return new Response<>().of(StatusEnums.MISTAKE.getMessage(), 403);
    }
    @Override
    public Response<?> returnRent() {
        if (GlobalData.cars.isEmpty()) {
            throw new ApplicationException(ExceptionEnums.CAR_NOT_FOUND_EXCEPTION);
        }
        try {
            HelperService.getInstance().hasCarForReturn();
            HelperService.getInstance().showCarForReturn();
            long carId = InputUtil.getInstance().inputLong("Enter the return Car id: ");
            boolean isBe = false;
            for (Car car : GlobalData.cars) {
                if (car.getId() == carId && car.isRent()) {
                    car.setRent(false);
                    System.out.println(StatusEnums.SUCCESS.getMessage());
                    return new Response<Car>().of(StatusEnums.SUCCESS.getMessage(), 200, car);
                }
            }
            if (!isBe) {
                throw new ApplicationException(ExceptionEnums.CAR_NOT_FOUND_EXCEPTION);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return new Response<>().of(StatusEnums.INVALID.getMessage(), 403);
    }
}