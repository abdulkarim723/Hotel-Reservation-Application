package menu;

import api.HotelResource;
import helperClasses.CheckRegex;
import helperClasses.Dates;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class MainMenu {
    private static final MainMenu reference = new MainMenu();
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
        if(!hotelResource.createACustomer(email, firstName, lastName)) {
            print("This customer is already inserted!\n" +
                    "It is not allowed to have more than one account for the same Email\n");
            return;
        }
        print("Account successfully created ..\n" + hotelResource.getCustomer(email).toString() + '\n');
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

        Date checkInDate = Dates.readDate(scanner, "Enter Check-In date please, Format: dd/mm/yyyy , Example: 31/01/2024\n" +
                "User Input: ");
        if(checkInDate == null) return;
        Date checkOutDate = Dates.readDate(scanner, "Enter Check-Out date please, Format: dd/mm/yyyy , Example: 31/01/2024\n" +
                "User Input: ");
        if(checkOutDate == null) return;

        Map<String, IRoom> rooms = hotelResource.getAvailableRooms(checkInDate, checkOutDate);
        if(rooms.isEmpty()) {
            print("For the given Check-In and Check-Out dates there are no available Rooms unfortunately\n" +
                  "Search recommended Rooms for the Range of one month after your desired Reservation in a 10 days steps? yes/no\n" +
                  "User Input: ");
            String userInput = scanner.nextLine();
            if(!CheckRegex.checkYesOrNo(userInput)) {
                print("Invalid Answer!\n");
                return;
            } else {
                if (userInput.equalsIgnoreCase("no")) {
                    return;
                }
            }
            for(int count=10; count<=30; count += 10) {
                checkInDate = Dates.getDateAfterNDays(checkInDate, count);
                checkOutDate = Dates.getDateAfterNDays(checkOutDate, count);
                rooms = hotelResource.getAvailableRooms(checkInDate, checkOutDate);
                if(!rooms.isEmpty()) break;
            }
        }
        print("Available Rooms for these dates are:\n" +
              "Check-In Date: " + Dates.getFormattedDateAsString(checkInDate) + " , CheckOut-Date: " + Dates.getFormattedDateAsString(checkOutDate) + '\n');
        for(Map.Entry<String, IRoom> availableRoom : rooms.entrySet()) System.out.println(availableRoom.getValue().toString());
        print("Please insert the Room ID you want to book: ");
        String roomID = scanner.nextLine();
        try {
            CheckRegex.checkRoomNumberRegexPattern(roomID);
        } catch (IllegalArgumentException ex) {
            print("Please enter a valid Room ID\n");
            return;
        }

        Reservation reservation = hotelResource.bookARoom(email, hotelResource.getRoom(roomID), checkInDate, checkOutDate);
        if(reservation != null) {
            print("Successfully created the following Reservation:\n" + reservation + '\n');
        }
    }

    public void seeMyReservations(Scanner scanner) {
        print("Enter your Email please: ");
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

        Collection<Reservation> foundReservations = hotelResource.getCustomerReservations(email);
        print(hotelResource.getCustomer(email).toString() + '\n');
        for(Reservation reservation : foundReservations) print(reservation.toString() + '\n');
    }
}
