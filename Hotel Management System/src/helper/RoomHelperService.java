package helper;

import data.GlobalData;
import model.Customer;
import model.Reservation;
import model.Room;
import util.InputUtil;

public class RoomHelperService {
    private static int roomId = 100;
    private static int roomNumber = 100;
    private static RoomHelperService instance;

    private RoomHelperService() {
    }

    public static RoomHelperService getInstance() {
        return instance == null ? instance = new RoomHelperService() : instance;
    }

    public boolean isNegative(Reservation reservations) {
        return HelperService.getInstance().isNegative(HelperService.getInstance().now(), reservations.getEndReservationDate());
    }

    public void setCustomerRoomNumber(Reservation reservations) {
        for (Customer customer : GlobalData.customers) {
            if (customer.getRoomNumber() == reservations.getRoomNumber()) {
                customer.setRoomNumber(0);
            }
        }
    }

    public void setSituationStatus(Reservation reservations) {
        for (Room room : GlobalData.rooms) {
            if (room.getRoomNumber() == reservations.getRoomNumber()) {
                room.setSituationStatus(false);
            }
        }
    }

    public boolean priceIsTrue(int price) {
        return price > 50;
    }

    public Room fillRoom() {
        try {
            String roomType = InputUtil.getInstance().inputString("Enter the room type: ");
            double price = InputUtil.getInstance().inputInt("Enter the room price: ");
            return new Room(++roomId, ++roomNumber, roomType, false, price);
        }catch (RuntimeException e){
            e.getMessage();
            return null;
        }
    }
}
