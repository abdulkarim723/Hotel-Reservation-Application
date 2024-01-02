package model;

public interface IRoom {
    enum RoomType{
        SINGLE,
        DOUBLE,
    }

    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isReserved();
    public void setReservation();
    public void removeReservation();
}
