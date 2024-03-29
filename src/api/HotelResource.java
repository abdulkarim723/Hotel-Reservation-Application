package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;
import java.util.Date;
import java.util.Collection;
import java.util.Map;

public class HotelResource {
    private static final HotelResource reference = new HotelResource();
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

    public boolean createACustomer(String email, String firstName, String lastName) {
        return customerService.addCustomer(email, firstName, lastName);
    }

    public boolean isCustomerValid(String email) {
        return customerService.isCustomerValid(email);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public boolean isRoomValid(String roomId) {
        return reservationService.isRoomValid(roomId);
    }

    public Map<String, IRoom> getAvailableRooms(Date checkInDate, Date checkOutDate) {
        return reservationService.getAvailableRooms(checkInDate, checkOutDate);
    }

    public void displayRooms() {
        reservationService.displayAllRooms();
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return reservationService.reserveARoom(customerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail) {
        return reservationService.getCustomerReservations(customerService.getCustomer(customerEmail));
    }
}
