package exceptions;

/**
 * Created by ahenry on 11/17/16.
 */
public class ArraysConsumedException extends Exception {
    public ArraysConsumedException() {
        super("All of the given arrays are empty!");
    }
}
