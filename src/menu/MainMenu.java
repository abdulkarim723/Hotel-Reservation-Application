package menu;

import api.HotelResource;
import helperClasses.CheckRegex;
import helperClasses.Dates;
import model.Reservation;

import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private static MainMenu reference = new MainMenu();
    private MainMenu() {}
    public static MainMenu getInstance() {
        return reference;
    }

    private static final HotelResource hotelResource = HotelResource.getInstance();
    private final String mainMenu = "1- Find and reserve a room\n" +
                                    "2- See my reservations\n" +
                                    "3- Create an account\n" +
                                    "4- Admin\n" +
                                    "5- Exit\n" +
                                    "User input: ";
    private static void print(String str) {
        System.out.print(str);
    }

    public void printMainMenu() {
        print(mainMenu);
    }

    public void createACustomer(Scanner scanner) {
        print("Enter your first name please: ");
        String firstName = scanner.nextLine();
        print("Enter your last name please: ");
        String lastName = scanner.nextLine();
        print("Enter your Email please: ");
        String email = scanner.nextLine();
        hotelResource.createACustomer(email, firstName, lastName);
    }

    public void bookARoom(Scanner scanner) {
        print("Enter your Customer Email please: ");
        String email = scanner.nextLine();
        try {
            CheckRegex.checkEmailRegexPattern(email);
        } catch (IllegalArgumentException ex) {
            print(ex.getLocalizedMessage() + '\n');
            return;
        }
        if(!hotelResource.isCustomerValid(email)) {
            print("Please enter a valid Email\n");
            return;
        }
        print("Please choose a Room you want to book\n");
        hotelResource.displayAvailableRooms();
        print("Please insert the Room ID you want to book: ");
        String roomID = scanner.nextLine();
        try {
            CheckRegex.checkRoomNumberRegexPattern(roomID);
        } catch (IllegalArgumentException ex) {
            print("Please enter a valid Room ID\n");
            return;
        }
        if(!hotelResource.isRoomValid(roomID)) {
            print("Invalid Room ID!");
            return;
        }

        Date checkInDate = Dates.readDate(scanner, "Enter Check-In date please, Format: dd/mm/yyyy , Example: 31/01/2024\n" +
                "User Input: ");
        if(checkInDate == null) return;
        Date checkOutDate = Dates.readDate(scanner, "Enter Check-In date please, Format: dd/mm/yyyy , Example: 31/01/2024\n" +
                "User Input: ");
        if(checkOutDate == null) return;

        hotelResource.bookARoom(email, hotelResource.getRoom(roomID), checkInDate, checkOutDate);

    }
}
