package model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
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
        return customer.toString() + '\n' + room.toString() + "\ncheck-in date: " + dateFormatter.format(checkInDate) + " at 15:00 pm"
                + "\ncheck-out date: " + dateFormatter.format(checkOutDate) + " at 12:00 pm";
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
