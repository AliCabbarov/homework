package helper;

import data.GlobalData;
import data.HotelData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import model.Customer;
import model.Room;

import java.time.LocalDateTime;

public class ReservationHelperService {
    public static int reservationId;
    private static ReservationHelperService instance;

    private ReservationHelperService() {
    }

    public static ReservationHelperService getInstance() {
        return instance == null ? instance = new ReservationHelperService() : instance;
    }

    public void showRoom(String roomType) {
        boolean hasNext = false;
        for (Room room : GlobalData.rooms) {
            if (room.getRoomType().equals(roomType) && !room.isSituationStatus()) {
                hasNext = true;
                System.out.println(room);
            }
        }
        if (!hasNext) {
            throw new ApplicationException(ExceptionEnum.ROOM_NOT_FOUND);
        }
    }

    public void setReservationProcesses(Customer customer, Room room, double reservationMoney, LocalDateTime endReservationDate) {
        customer.setMoneyAccount(customer.getMoneyAccount() - reservationMoney);
        room.setSituationStatus(true);
        customer.setReservationDate(HelperService.getInstance().now());
        customer.setEndReservationDate(endReservationDate);
        customer.setRoomNumber(room.getRoomNumber());
        HotelData.hotel.setBankAccount(HotelData.hotel.getBankAccount() + reservationMoney);
    }

    public void setReservationProcessesForUpdateReservation(Customer customer, Room room, double reservationMoney, LocalDateTime endReservationDate) {
        customer.setMoneyAccount(customer.getMoneyAccount() - reservationMoney);
        customer.setReservationDate(HelperService.getInstance().now());
        customer.setEndReservationDate(endReservationDate);
        HotelData.hotel.setBankAccount(HotelData.hotel.getBankAccount() + room.getPrice());
    }

    public void isHasCustomerMoney(Customer customer, double reservationMoney) {
        if (reservationMoney > customer.getMoneyAccount()) {
            throw new ApplicationException(ExceptionEnum.LOW_MONEY_EXCEPTION);
        }
    }

    public double calculateReservationMoney(LocalDateTime endReservationDate, Room room) {
        long day = HelperService.getInstance().duration(endReservationDate).toDays();
        return (double) (day + 1) * room.getPrice();
    }

}
