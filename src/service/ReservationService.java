package service;
import java.util.*;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;


public class ReservationService {

    private static final ReservationService reference = new ReservationService();
    private ReservationService() {}
    public static ReservationService getInstance() {
        return reference;
    }

    private final Set<Reservation> reservations = new HashSet<>();

    public Set<Reservation> getCustomerReservations(Customer customer) {
        Set<Reservation> foundReservations = new HashSet<>();
        for(Reservation reservation : reservations) {
            if(reservation.getCustomer() == customer) {
                foundReservations.add(reservation);
            }
        }
        return foundReservations;
    }
    private final Map<String, IRoom> rooms = new HashMap<>();

    public void addRoom(IRoom room) {
        if(rooms.containsKey(room.getRoomNumber())) {
            System.out.println("Redundant Rooms are not allowed!");
        }
        rooms.put(room.getRoomNumber(), room);
    }

    public boolean removeARoom(String roomNumber) {
        Room room = (Room) getARoom(roomNumber);
        if(room != null) {
            rooms.remove(room.getRoomNumber());
            return true;
        }
        return false;
    }

    public void removeAllRooms() {
        rooms.clear();
    }

    public Map<String, IRoom> getRooms() {
        return rooms;
    }

    public void displayAllRooms() {
        for(Map.Entry<String, IRoom> room : rooms.entrySet()) {
                System.out.println(room.getValue().toString());
        }
    }

    public void displayAvailableRooms() {
        for(Map.Entry<String, IRoom> room : rooms.entrySet()) {
            if(!room.getValue().isReserved()) {
                System.out.println(room.getValue().toString());
            }
        }
    }

    public IRoom getARoom(String roomId) {
        if(rooms.containsKey(roomId)) return rooms.get(roomId);
        return null;
    }

    public boolean isRoomValid(String roomId) {
        return rooms.containsKey(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        if(checkInDate.equals(checkOutDate) || checkInDate.after(checkOutDate)) {
            System.out.println("Please check the Dates you inserted, invalid Input!");
            return null;
        }
        IRoom item = rooms.get(room.getRoomNumber());
        if(!item.isReserved()) {
            return createRoomReservation(customer, room, checkInDate, checkOutDate);
        } else {
            for (Reservation reservation : reservations) {
                if(reservation.getRoom().equals(room)) {
                    if (checkInDate.after(reservation.getCheckInDate()) &&
                        checkInDate.before(reservation.getCheckOutDate()) ||
                        checkOutDate.after(reservation.getCheckInDate()) &&
                        checkOutDate.before(reservation.getCheckOutDate()) ||
                        checkInDate.before(reservation.getCheckInDate()) &&
                        checkOutDate.after(reservation.getCheckOutDate()))
                    {
                        System.out.println("The Room with ID Number " + room.getRoomNumber() +
                                " can not be booked at the given time zone!");
                        return null;
                    }
                    return createRoomReservation(customer, room, checkInDate, checkOutDate);
                }
            }
        }
        return null;
    }

    private Reservation createRoomReservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        room.setReservation();
        reservations.add(reservation);
        return reservation;
    }

    public void printAllReservations(){
        for(Reservation reservation : reservations)
            System.out.println(reservation);
    }
}
