package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.List;
import java.awt.*;
import java.util.Collection;

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

    public Collection<IRoom> getAllRooms() {
        return reservationService.getRooms();
    }

    public void displayAllReservations() {
        reservationService.printAllReservations();
    }
    public void displayAllCustomers() { customerService.printAllCustomers(); }
}
