package by.it.podelstchikova.jd01_05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2{


    public static double printValue(double a, double b)
    {
        double y = (Math.pow((a + 1.15), 1 / 3) + Math.pow((a - b), 8) - (b / Math.asin(Math.pow(Math.abs(a), 2))));
        return y;
    }
    public static double scanValue() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        double rez = Double.parseDouble(bufferedReader.readLine());
//        bufferedReader.close();
        return rez;
    }

}
