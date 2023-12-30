import menu.AdminMenu;
import menu.MainMenu;

import java.util.Scanner;

public class Main {
    private static void print(String str) {
        System.out.print(str);
    }

    private static void processAdminMenu() {
        while (true) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1": adminMenu.seeAllCustomers(); break;
                case "2": adminMenu.displayAllRooms(); break;
                case "3": break;
                case "4": adminMenu.addARoom(scanner); break;
                case "5": return;
            }
            adminMenu.printAdminMenu();
        }

    }
    private static Scanner scanner = new Scanner(System.in);
    private static AdminMenu adminMenu = AdminMenu.getInstance();
    private static MainMenu mainMenu = MainMenu.getInstance();
    public static void main(String[] args) {
        String userInput;
        try {
            //noinspection InfiniteLoopStatement
            while (true) {
                mainMenu.printMainMenu();
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "1": break;
                    case "2": break;
                    case "3":
                        try {
                            mainMenu.createACustomer(scanner); break;
                        } catch (IllegalArgumentException ex) {
                            print(ex.getLocalizedMessage() + '\n');
                            break;
                        }
                    case "4":
                        adminMenu.printAdminMenu();
                        processAdminMenu();
                        break;
                    case "5": print("Exit the program!\n"); return;
                    default:
                        print("Please enter only a valid number\n");
                }
            }
        } catch (Exception ex) {
            ex.getLocalizedMessage();
        } finally {
            scanner.close();
        }
    }
}
