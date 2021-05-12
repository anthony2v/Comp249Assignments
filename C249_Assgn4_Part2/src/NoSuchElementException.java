/**
 * Anthony van Voorst - 40001890
 * COMP 249
 * Assignment #4 Part 2
 * April 10, 2019
 * This exception class is for a linked list method that tries to process an index that is out of bounds of the present
 * linked list. The following action should be to exit the program.
 */

public class NoSuchElementException extends Exception {
    String message;

    /**
     * The default constructor for this exception class.
     */
    public NoSuchElementException(){
        message = "Invalid index. Program will exit.";
    }

    /**
     * For when the exception message needs to be printed.
     * @return Exception message.
     */
    public String toString(){
        return message;
    }
}
