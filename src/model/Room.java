package model;

import java.util.Objects;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    RoomType enumeration;
    boolean isReserved = false;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
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
    public String toString() {
        return "Room Number: " + roomNumber + " , Price: " + price + " , Room is: " + enumeration;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public void setReservation() {
        isReserved = true;
    }

    @Override
    public void removeReservation() {
        isReserved = false;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber.equals(room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
