package helperClasses;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        if(formattedDate.before(Dates.getCurrentDate())) {
            System.out.println("The given date is not allowed as it is a date in the past!");
            return null;
        }

        return formattedDate;
    }

    public static Date getDateAfterNDays(Date date, int numberOfShiftedDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, numberOfShiftedDays);
        return c.getTime();
    }

    public static String getFormattedDateAsString(Date date) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormatter.format(date);
    }
}
