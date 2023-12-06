package service;

import response.BaseResponse;

public interface RoomService {
    BaseResponse<?> updateRoomPrice();
    BaseResponse<?> checkReservationRoom(); // her 3 servicde cagrilacaq
}
