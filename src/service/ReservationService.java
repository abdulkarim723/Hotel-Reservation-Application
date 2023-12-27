package service;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java.util.Date;
import java.util.Iterator;

import model.Customer;
import model.IRoom;
import model.Reservation;


public class ReservationService {

    private static ReservationService reference = new ReservationService();
    private ReservationService() {}
    public static ReservationService getInstance() {
        return reference;
    }

    private final Queue<Reservation> reservations = new LinkedList<Reservation>();
    private Set<IRoom> foundRooms = new HashSet<IRoom>();

    public Queue<Reservation> getCustomerReservation(Customer customer) {
        Queue<Reservation> foundReservations = new LinkedList<Reservation>();
        for(Reservation reservation : reservations) {
            if(reservation.getCustomer() == customer) {
                foundReservations.add(reservation);
            }
        }
        return foundReservations;
    }
    private final Set<IRoom> rooms = new HashSet<IRoom>();
    public void addRoom(IRoom room) {
        rooms.add(room);
    }

    public Set<IRoom> getRooms() {
        return rooms;
    }

    public IRoom getARoom(String roomId) {
        for(IRoom room : rooms) {
            if(Objects.equals(room.getRoomNumber(), roomId)) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Set<IRoom> rooms = findRooms(checkInDate, checkOutDate);
        for(IRoom oneRoom : rooms) {
            if(oneRoom == room) {
                Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
                reservations.add(reservation);
                return reservation;
            }
        }
        return null;
    }

    // find available rooms
    public Set<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        for(Reservation reservation : reservations) {
            if(checkInDate.after(reservation.getCheckInDate()) && checkInDate.before(reservation.getCheckOutDate())) {
                continue;
            }
            if(checkOutDate.before(checkInDate)) {
                throw new IllegalArgumentException("check-out date should be after check-in date");
            }
            foundRooms.add(reservation.getRoom());
        }
        return foundRooms;
    }

    public void printAllReservations(){
        for(Reservation reservation : reservations)
            System.out.println(reservation);
    }
}