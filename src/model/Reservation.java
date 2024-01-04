package model;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }
    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
    @Override
    public String toString() {
        return customer.toString() + '\n' + room.toString() + "\ncheck-in date: " + checkInDate
                + "\ncheck-out date: " + checkOutDate;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Reservation reservation = (Reservation) o;
        return room.equals(reservation.getRoom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(room);
    }
}
