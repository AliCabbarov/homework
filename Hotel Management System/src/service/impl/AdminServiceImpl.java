package service.impl;

import data.GlobalData;
import data.HotelData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import helper.RoomHelperService;
import model.Customer;
import model.Hotel;
import model.Reservation;
import model.Room;
import response.BaseResponse;
import service.AdminService;
import util.InputUtil;

import java.util.ArrayList;

public class AdminServiceImpl implements AdminService {
    @Override
    public BaseResponse<Room> registerRoom() {
        Room room = RoomHelperService.getInstance().fillRoom();
        if (room != null) {
            GlobalData.rooms.add(room);
            return new BaseResponse<Room>().of(200, "Success", room);
        } else throw new ApplicationException(ExceptionEnum.NULL_VALUE_EXCEPTION);
    }

    @Override
    public BaseResponse<ArrayList<Customer>> showCustomer() {
        if (GlobalData.customers.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.CUSTOMER_NOT_FOUND_EXCEPTION);
        }
        for (Customer customer : GlobalData.customers) {
            System.out.println(customer.toString());
        }
        return new BaseResponse<ArrayList<Customer>>().of(200,"Success",GlobalData.customers);
    }

    @Override
    public BaseResponse<ArrayList<Room>> showRoom() {
        for (Room room: GlobalData.rooms){
            System.out.println(room.toString());
        }
        return new BaseResponse<ArrayList<Room>>().of(200,"Success",GlobalData.rooms);
    }

    @Override
    public BaseResponse<ArrayList<Reservation>> showReservation() {
        if(GlobalData.reservations.isEmpty()){
            throw new ApplicationException(ExceptionEnum.RESERVATION_NOT_FOUND);
        }
        for (Reservation reservation:GlobalData.reservations) {
            System.out.println(reservation.toString());
        }
        return new BaseResponse<ArrayList<Reservation>>().of(200,"Success",GlobalData.reservations);
    }

    @Override
    public BaseResponse<Hotel> showHotelInfo() {
        System.out.println(HotelData.hotel.toString());
        return new BaseResponse<Hotel>().of(200,"Success",HotelData.hotel);
    }

    @Override
    public BaseResponse<Customer> searchCustomer() {
        String email = InputUtil.getInstance().inputString("Enter the search email: ");
        for (Customer customer: GlobalData.customers) {
            if(customer.getEmail().equals(email)){
                System.out.println(customer);
                return new BaseResponse<Customer>().of(200,"Success",customer);
            }
        }
        throw new ApplicationException(ExceptionEnum.CUSTOMER_NOT_FOUND_EXCEPTION);
    }

    @Override
    public BaseResponse<Room> updateRoomPrice() {
       return new RoomServiceImpl().updateRoomPrice();
    }
}
