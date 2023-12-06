package model;

public class Room {
    private int id;
    private int roomNumber;
    private String roomType;
    private boolean situationStatus;
    private double price;

    public Room(int id, int roomNumber, String roomType, boolean situationStatus, double price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.situationStatus = situationStatus;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isSituationStatus() {
        return situationStatus;
    }

    public void setSituationStatus(boolean situationStatus) {
        this.situationStatus = situationStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", situationStatus=" + situationStatus +
                ", price=" + price +
                '}';
    }
    public String getInfo() {
        return "Room{" +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                '}';
    }
}
