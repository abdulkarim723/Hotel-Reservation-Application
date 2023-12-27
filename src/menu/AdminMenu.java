package menu;


import api.AdminResource;

public class AdminMenu {
    private static AdminMenu reference = new AdminMenu();
    private static AdminResource adminResource = AdminResource.getInstance();
    private AdminMenu() {}
    public static AdminMenu getInstance() {
        return reference;
    }

    private String adminMenu = "1. See all Customers\n" +
                               "2. See all Rooms\n" +
                               "3. See all Reservations\n" +
                               "4. Add a Room\n" +
                               "5. Back to Main Menu\n" +
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
}
