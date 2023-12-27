package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;
import java.util.Date;
import java.util.Collection;

public class HotelResource {
    private static HotelResource reference = new HotelResource();
    private static CustomerService customerService;
    private static ReservationService reservationService;
    public static HotelResource getInstance() {
        return reference;
    }

    private HotelResource() {
        customerService = CustomerService.getInstance();
        reservationService = ReservationService.getInstance();
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return reservationService.reserveARoom(customerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail) {
        return reservationService.getCustomerReservation(customerService.getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        return reservationService.findRooms(checkInDate, checkOutDate);
    }
}
