package by.it.novik.JD02_05;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DateWriter {
    public static void main(String[] args) {

        System.out.printf("%s%s%s", "Выберите язык\n", "Choose language\n", "Абярыце мову\n");
        System.out.println("RU (Русский)/ EN (English)/ BY (Беларуская) >");



        Locale rus = Locale.getDefault();
        Locale bel = new Locale("be", "BY");
        Locale eng = new Locale("en", "US");
        Locale cur = Locale.getDefault();

        String language = "";
        boolean ok = false;
        while (!ok) {
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNext()) {
                language = scanner.nextLine();
            }
            switch (language) {
                case "RU":
                    cur = rus;ok=true;
                    break;
                case "ru":
                    cur = rus;ok=true;
                    break;
                case "EN":
                    cur = eng;ok=true;
                    break;
                case "en":
                    cur = eng;ok=true;
                    break;
                case "BY":
                    cur = bel;ok=true;
                    break;
                case "by":
                    cur = bel;ok=true;
                    break;
                default:
                    System.out.println("You were asked to enter a language");
                    ok = false;

            }
        }


        if (ok) {
            ResourceBundle rb = ResourceBundle.getBundle("by.it.novik.JD02_05.text", cur);

            String greeting = rb.getString("key");

            System.out.println(greeting);

            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, eng);

            Date date = null;
            String todayDate = "March 18, 2016";
            try {
                date = df.parse(todayDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            df = DateFormat.getDateInstance(DateFormat.LONG,cur);
            String day = df.format(date);
            System.out.println(day);
        }
    }
}
