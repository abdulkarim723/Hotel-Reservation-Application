package helperClasses;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Dates {
    public static Date getCurrentDate() {
        return new java.util.Date();
    }
    public static Date readDate(Scanner scanner, String terminalMessage) {
        System.out.println(terminalMessage);
        String userDate = scanner.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date formattedDate = null;
        try{
            formattedDate = df.parse(userDate);
        } catch (ParseException ex){
            System.out.println("Invalid Date format\n");
            return null;
        }
        return formattedDate;
    }
}
