package model;

import java.time.LocalDateTime;

public class Reservation {
    private final int id;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customerEmail='" + customerEmail + '\'' +
                ", roomNumber=" + roomNumber +
                ", roomPrice=" + roomPrice +
                ", reservationDate=" + reservationDate +
                ", endReservationDate=" + endReservationDate +
                ", isContinue=" + isContinue +
                '}';
    }

    private final String customerEmail;
    private final int roomNumber;
    private final double roomPrice;
    private final LocalDateTime reservationDate;
    private final LocalDateTime endReservationDate;
    private boolean isContinue;

    public Reservation(int id, String customerEmail, int roomNumber, double roomPrice, LocalDateTime reservationDate, LocalDateTime endReservationDate,boolean isContinue) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.reservationDate = reservationDate;
        this.endReservationDate = endReservationDate;
        this.isContinue = isContinue;
    }

    public int getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public LocalDateTime getEndReservationDate() {
        return endReservationDate;
    }

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

}
