package by.it.Baranova.JD01.JD01_13_Exception.B;

/**
 * Created by Ekaterina on 2/29/16.
 */
public class NegativeNumberException extends Exception{
    public NegativeNumberException() {
    }
    public NegativeNumberException(String message, Throwable exception) {
        super(message, exception);
    }
    public NegativeNumberException(String message) {
        System.out.println("Ошибка:"+message);
    }
    public NegativeNumberException(Throwable exception) {
        super(exception);
    }
}
