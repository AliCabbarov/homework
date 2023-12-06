package service;

import response.BaseResponse;

public interface AdminService {
    BaseResponse<?> registerRoom();
    BaseResponse<?> showCustomer();
    BaseResponse<?> showRoom();
    BaseResponse<?> showReservation();
    BaseResponse<?> showHotelInfo();
    BaseResponse<?> searchCustomer();
    BaseResponse<?> updateRoomPrice();
}
