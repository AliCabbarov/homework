package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import helper.RoomHelperService;
import model.Reservation;
import model.Room;
import response.BaseResponse;
import service.RoomService;
import util.InputUtil;

public class RoomServiceImpl implements RoomService {
    @Override
    public BaseResponse<Room> updateRoomPrice() {
        int roomId = InputUtil.getInstance().inputInt("Enter the update room id: ");
        for (Room room : GlobalData.rooms) {
            if (room.getId() == roomId) {
                int price = InputUtil.getInstance().inputInt("Enter the update price: ");
                if (RoomHelperService.getInstance().priceIsTrue(price)) {
                    room.setPrice(price);
                    return new BaseResponse<Room>().of(200,"Success",room);
                }else throw new ApplicationException(ExceptionEnum.LOW_PRICE_EXCEPTION);
            }
        }
        throw new ApplicationException(ExceptionEnum.ROOM_NOT_FOUND);
    }

    @Override
    public BaseResponse<?> checkReservationRoom() {
        for (Reservation reservations : GlobalData.reservations) {
            if (reservations.isContinue()) {
                if (RoomHelperService.getInstance().isNegative(reservations)) {
                    reservations.setContinue(false);
                    RoomHelperService.getInstance().setSituationStatus(reservations);
                    RoomHelperService.getInstance().setCustomerRoomNumber(reservations);
                    return new BaseResponse<Boolean>().of(200, "success", true);
                }
            }
        }
        return new BaseResponse<Boolean>().of(403, "Invalid", false);
    }


}
