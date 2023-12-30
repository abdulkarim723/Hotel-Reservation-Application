package helperClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {
    private static void checkRegexPattern(String regexPattern, String string, String errorMessage) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(string);
        if(!matcher.matches())
            throw new IllegalArgumentException(errorMessage);
    }
    public static void checkEmailRegexPattern(String string) {
        String emailRegex = "^(.+)@(.+).(.+)$";
        String errorMessage = "Email format is not supported!";
        checkRegexPattern(emailRegex, string, errorMessage);
    }

    public static void checkNameRegexPattern(String string) {
        String nameRegex = "[a-zA-Z 0-9]+";
        String errorMessage = "Name format is not supported!";
        checkRegexPattern(nameRegex, string, errorMessage);
    }
}