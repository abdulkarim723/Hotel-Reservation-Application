package model;
import helperClasses.Dates;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

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
        return room.toString() + "\ncheck-in date: " + Dates.getFormattedDateAsString(checkInDate) + " at 15:00 pm"
                + "\ncheck-out date: " + Dates.getFormattedDateAsString(checkOutDate) + " at 12:00 pm";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Reservation reservation = (Reservation) o;
        return room.equals(reservation.getRoom())
            && customer.equals(reservation.getCustomer())
            && checkInDate.equals(reservation.getCheckInDate())
            && checkOutDate.equals(reservation.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room) * Objects.hash(customer) * Objects.hash(checkInDate) * Objects.hash(checkOutDate);
    }
}
