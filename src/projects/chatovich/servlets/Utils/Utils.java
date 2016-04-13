package projects.chatovich.servlets.Utils;

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
}
