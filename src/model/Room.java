package model;

public class Room implements IRoom {
    public String roomNumber;
    public Double price;
    public RoomType roomType;
    public Boolean isfree;

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setIsfree(Boolean isfree) {
        this.isfree = isfree;
    }

    public Room(String roomNumber, Double price, RoomType roomType, Boolean isFree) {
        super();
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        this.isfree = isFree;
    }

    @Override
    public Double getRoomPrice() {
        return null;
    }

    @Override
    public String getRoomNumber() {
        return null;
    }

    @Override
    public RoomType getRoomType() {
        return null;
    }

    @Override
    public boolean isFree() {
        return false;
    }


    public String toString() {
        return "Room Number : " + getRoomNumber() + "\nRoom Price: " + getRoomPrice() + "\nRoomType : " + getRoomType();
    }
}
