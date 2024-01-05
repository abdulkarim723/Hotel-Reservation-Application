package menu;


import api.AdminResource;
import helperClasses.CheckRegex;
import model.IRoom;
import model.Room;

import javax.swing.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AdminMenu {
    private static final AdminMenu reference = new AdminMenu();
    private static final AdminResource adminResource = AdminResource.getInstance();
    private AdminMenu() {}
    public static AdminMenu getInstance() {
        return reference;
    }

    private final String adminMenu = "1. See all Customers\n" +
                               "2. See all Rooms\n" +
                               "3. See all Reservations\n" +
                               "4. Add a Room\n" +
                               "5. Remove a Room\n" +
                               "6. Remove all Rooms\n" +
                               "7. Back to Main Menu\n" +
                               "User Input: ";

    private static void print(String str) {
        System.out.print(str);
    }

    public void printAdminMenu() {
        print(adminMenu);
    }

    public void seeAllCustomers(){
        adminResource.displayAllCustomers();
    }

    public void addARoom(Scanner scanner){
        IRoom.RoomType rType = IRoom.RoomType.SINGLE;
        Double price = 0.0;
        print("Enter Room Number please: ");
        String roomNumber = scanner.nextLine();
        if(!CheckRegex.checkRoomNumberRegexPattern(roomNumber)) {
            print("Invalid Room Number!\n");
            return;
        }
        print("Enter the price for this room please: ");
        try {
            price = scanner.nextDouble();
            if(price<=0) {
                print("Invalid Price!\n");
                return;
            }
        }
        catch(InputMismatchException e){
            print("Invalid Price!");
            return;
        }
        scanner.nextLine();
        print("Enter Room Type please, Single or Double: ");
        String roomType = scanner.nextLine();
        if(!CheckRegex.checkRoomTypeRegexPattern(roomType)) {
            print("Invalid Room Type!\n");
            return;
        }
        if(roomType.equalsIgnoreCase("single")) {
            rType = IRoom.RoomType.SINGLE;
        } else if (roomType.equalsIgnoreCase("double")) {
            rType = IRoom.RoomType.DOUBLE;
        }
        Room room = new Room(roomNumber, price, rType);
        adminResource.addRoom(room);
    }

    public void removeARoom(Scanner scanner) {
        print("Enter Room Number you wish to remove: ");
        String roomNumber = scanner.nextLine();
        if(!CheckRegex.checkRoomNumberRegexPattern(roomNumber)) {
            print("Invalid Room Number!\n");
            return;
        }

        if(adminResource.removeARoom(roomNumber)) {
            print("Room with ID Number " + roomNumber + " is removed successfully!\n");
            return;
        }

        print("Error by removing the room with ID Number " + roomNumber + '\n');
    }

    public void removeAllRooms(Scanner scanner) {
        print("This may be dangerous, are you sure you want to delete all Rooms? ");
        String userInput = scanner.nextLine();
        if(CheckRegex.checkYesOrNo(userInput)) {
            if (userInput.equalsIgnoreCase("yes")) {
                adminResource.removeRooms();
                print("All Rooms are removed successfully!\n");
            }
        }

    }

    public void displayAllRooms() {
        adminResource.displayAllRooms();
    }

    public void seeAllReservations() {
        adminResource.displayAllReservations();
    }
}
