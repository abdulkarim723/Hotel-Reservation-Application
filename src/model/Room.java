package model;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    RoomType enumeration;
    public boolean isFree;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
        this.isFree = true;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + " , Price: " + price;
    }
}
