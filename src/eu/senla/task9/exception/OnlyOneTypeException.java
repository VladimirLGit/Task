package eu.senla.task9.exception;

public class OnlyOneTypeException extends Exception{
    public OnlyOneTypeException(String message) {
        System.out.println(message);
    }
}
