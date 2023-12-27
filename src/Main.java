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
                case "2": break;
                case "3": break;
                case "4": break;
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
                if (userInput.equals("1")) {

                } else if (userInput.equals("2")) {

                } else if (userInput.equals("3")) {
                    mainMenu.createACustomer(scanner);
                } else if (userInput.equals("4")) {
                    adminMenu.printAdminMenu();
                    processAdminMenu();
                } else if (userInput.equals("5")) {
                    print("Exit the program!\n");
                    break;
                } else {
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
