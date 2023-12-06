package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import helper.HelperService;
import helper.ReservationHelperService;
import model.Customer;
import model.Reservation;
import model.Room;
import response.BaseResponse;
import service.ReservationService;
import util.InputUtil;

import java.time.LocalDateTime;

public class ReservationServiceImpl implements ReservationService {

    @Override
    public BaseResponse<Reservation> reservation() {
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        boolean hasDoesntCustomer = false;
        for (Customer customer : GlobalData.customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                if (customer.getRoomNumber() != 0) {
                    hasDoesntCustomer = true;
                    String roomType = InputUtil.getInstance().inputString("Enter the room type(single,standard,duplex,suite): ");
                    ReservationHelperService.getInstance().showRoom(roomType);
                    int roomNumber = InputUtil.getInstance().inputInt("Enter the room number: ");
                    for (Room room : GlobalData.rooms) {
                        if (room.getRoomNumber() == roomNumber && !room.isSituationStatus()) {
                            LocalDateTime endReservationDate = HelperService.getInstance().enterDate("Enter the reservation date");
                            double reservationMoney = ReservationHelperService.getInstance().calculateReservationMoney(endReservationDate, room);
                            ReservationHelperService.getInstance().isHasCustomerMoney(customer, reservationMoney);
                            ReservationHelperService.getInstance().setReservationProcesses(customer, room, reservationMoney, endReservationDate);
                            Reservation reservation = new Reservation(++ReservationHelperService.reservationId, customer.getEmail(), room.getRoomNumber(), reservationMoney, HelperService.getInstance().now(), endReservationDate, true);
                            GlobalData.reservations.add(reservation);
                            return new BaseResponse<Reservation>().of(200, "sSuccess", reservation);
                        }

                    }
                }else {
                    throw new ApplicationException(ExceptionEnum.HAVE_RESERVATION_EXCEPTION);
                }
            }

        }
        if (!hasDoesntCustomer) {
            throw new ApplicationException(ExceptionEnum.CUSTOMER_NOT_FOUND_EXCEPTION);
        }
        throw new ApplicationException(ExceptionEnum.ROOM_NOT_FOUND);
    }
}
