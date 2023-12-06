package service.impl;

import data.GlobalData;
import data.HotelData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import helper.CustomerHelperService;
import helper.HelperService;
import helper.ReservationHelperService;
import model.Customer;
import model.Hotel;
import model.Reservation;
import model.Room;
import response.BaseResponse;
import service.CustomerService;
import util.InputUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public BaseResponse<Customer> register() {
        Customer customer = CustomerHelperService.getInstance().fillCustomer();
        if (customer != null) {
            GlobalData.customers.add(customer);
            return new BaseResponse<Customer>().of(200, "Success", customer);
        }
        throw new ApplicationException(ExceptionEnum.NULL_CUSTOMER_EXCEPTION);
    }

    @Override
    public BaseResponse<ArrayList<Reservation>> showReservation(Customer customer) {
        if(GlobalData.reservations.isEmpty()){
            throw new ApplicationException(ExceptionEnum.RESERVATION_NOT_FOUND);
        }
        boolean hasDoesnt = true;
        for (Reservation reservation : GlobalData.reservations) {
            if (reservation.getCustomerEmail().equals(customer.getEmail())) {
                System.out.println(reservation);
                hasDoesnt = false;
            }
        }
        if (!hasDoesnt) {
            return new BaseResponse<ArrayList<Reservation>>().of(200, "Success", GlobalData.reservations);
        }
        throw new ApplicationException(ExceptionEnum.RESERVATION_NOT_FOUND);
    }

    @Override
    public BaseResponse<Reservation> endDateUpdate(Customer customer, Room room) {
        if(GlobalData.reservations.isEmpty()){
            throw new ApplicationException(ExceptionEnum.RESERVATION_NOT_FOUND);
        }
        if (customer.getRoomNumber() == 0) {
            throw new ApplicationException(ExceptionEnum.RESERVATION_NOT_FOUND);
        }
        LocalDateTime endReservationDate = HelperService.getInstance().enterDate("Enter the reservation end date");
        double reservationMoney = ReservationHelperService.getInstance().calculateReservationMoney(endReservationDate, room);
        ReservationHelperService.getInstance().isHasCustomerMoney(customer, reservationMoney);
        ReservationHelperService.getInstance().setReservationProcessesForUpdateReservation(customer, room, reservationMoney, endReservationDate);
        Reservation reservation = new Reservation(++ReservationHelperService.reservationId, customer.getEmail(), room.getRoomNumber(), reservationMoney, HelperService.getInstance().now(), endReservationDate, true);
        GlobalData.reservations.add(reservation);
        return new BaseResponse<Reservation>().of(200, "sSuccess", reservation);
    }

    @Override
    public BaseResponse<Customer> increaseMoneyAccount(Customer customer) {
        int money = InputUtil.getInstance().inputInt("Enter the increase money: ");
        customer.setMoneyAccount(customer.getMoneyAccount() + money);
        return new BaseResponse<Customer>().of(200, "Success", customer);
    }

    @Override
    public BaseResponse<?> cancelToReservation(Customer customer) {
        if(GlobalData.reservations.isEmpty()){
            throw new ApplicationException(ExceptionEnum.RESERVATION_NOT_FOUND);
        }
        if (HelperService.getInstance().isNegative(HelperService.getInstance().now(), customer.getEndReservationDate())) {
            throw new ApplicationException(ExceptionEnum.IRREVOCABLE_EXCEPTION);
        }
        if (customer.getReservationDate() == null || customer.getEndReservationDate() == null) {
            throw new ApplicationException(ExceptionEnum.RESERVATION_NOT_FOUND);
        }
        for (Reservation reservation : GlobalData.reservations) {
            if (reservation.getCustomerEmail().equals(customer.getEmail()) && reservation.isContinue()) {
                reservation.setContinue(false);
                customer.setMoneyAccount(customer.getMoneyAccount() + reservation.getRoomPrice() * 0.5);
                HotelData.hotel.setBankAccount(HotelData.hotel.getBankAccount() - reservation.getRoomPrice() * 0.5);
                return new BaseResponse<Hotel>().of(200, "Success", HotelData.hotel);
            }
        }
        return new BaseResponse<>().of(403, "Invalid");
    }

    @Override
    public BaseResponse<Customer> showCustomer(Customer customer) {
        System.out.println(customer);
        return new BaseResponse<Customer>().of(200, "Success", customer);
    }
}
