package model;

public interface IRoom {
    public Double getRoomPrice();

    public String getRoomNumber();

    public RoomType getRoomType();

    public boolean isFree();
}
