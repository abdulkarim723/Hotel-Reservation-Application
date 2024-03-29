package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.List;
import java.util.Map;

public class AdminResource {
    private static AdminResource reference = new AdminResource();
    private AdminResource() {
        customerService = CustomerService.getInstance();
        reservationService = ReservationService.getInstance();
    }
    private static CustomerService customerService;
    private static ReservationService reservationService;
    public static AdminResource getInstance() {
        return reference;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {
        for(IRoom room : rooms) {
            reservationService.addRoom(room);
        }
    }

    public void addRoom(IRoom room) {
        reservationService.addRoom(room);
    }

    public boolean removeARoom(String roomNumber) {
        return reservationService.removeARoom(roomNumber);
    }

    public void removeRooms() {
        reservationService.removeAllRooms();
    }

    public Map<String, IRoom> getAllRooms() {
        return reservationService.getRooms();
    }

    public void displayAllRooms() {
        reservationService.displayAllRooms();
    }

    public void displayAllReservations() {
        reservationService.printAllReservations();
    }
    public void displayAllCustomers() { customerService.printAllCustomers(); }
}
