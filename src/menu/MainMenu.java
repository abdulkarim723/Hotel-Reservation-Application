package menu;

import api.HotelResource;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
