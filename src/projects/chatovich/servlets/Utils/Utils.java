package projects.chatovich.servlets.Utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utils
 */
public class Utils {

    public static boolean checkRegex (String line){

        Pattern pat = Pattern.compile("[a-zA-Zа-яА-ЯёЁ]+");
        Matcher mat = pat.matcher(line);
        return mat.matches();
    }

    public static int getUserAge (Timestamp birthdate){

        Calendar today = Calendar.getInstance();
        Calendar birthday = Calendar.getInstance();
        birthday.setTime(birthdate);
        return today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
    }
}
