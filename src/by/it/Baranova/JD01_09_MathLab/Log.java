package by.it.Baranova.JD01_09_MathLab;

import java.io.*;
import java.util.Date;

public class Log {

    private static volatile Log instance;
    private Log(){
    }

    public static Log getInstance(){
        Log localInstanse=instance;
        if (localInstanse==null){
            synchronized (Log.class){
                localInstanse=instance;
                if (localInstanse==null){
                    instance=localInstanse=new Log();
                }
            }
        }
        return localInstanse;
    }

    public void saveLog(String error) {

        String src = System.getProperty("user.dir") + "/src/by/it/Baranova/";
        String filename = src + "JD01_09_MathLab/Log.txt";
        File f = new File(filename);PrintWriter pw = null;
        Date today = new Date(System.currentTimeMillis());
        synchronized (Log.class) {
            try {
                pw = new PrintWriter(new FileWriter(f, true));
                pw.println(error + "  " + today);

            } catch (IOException e) {
                System.out.println("Ошибка файла");
            } finally {
                if (pw != null) {
                    pw.close();
                }

            }

        }
    }


}
