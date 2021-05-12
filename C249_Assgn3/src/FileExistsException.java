/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP249
 * Assignment #3
 * Due Date: March 21, 2019
 * This class inherits from the Exception class. That is, it will be able to use the methods and constructors
 * from that class unless they are overridden below. It will be thrown if the main class tries to create a file
 * that already exists in the same directory.
 */

public class FileExistsException extends Exception implements ExceptionConstraints {
    // This is the default message.
    private String message = "Exception: There is already an existing file for that author. File will\n" +
            "be renamed as BU, and older BU files will be deleted!";
    private int fileIndex = 0;
    // This is the default constructor if no custom message is given as an argument.
    public FileExistsException(){
    }

    /** This is the constructor that will overwrite the default message if a new one is given as an argument.
     * @param newMessage The new message to overwrite the old one.
     */
    public FileExistsException(String newMessage){
        message = newMessage;
    }

    /** This is the constructor that will overwrite the default message if a new one is given as an argument.
     * It also includes the index of the file that already exists.
     * @param newMessage The new message to overwrite the old one.
     * @param fileIndex the file that needs to be dealt with.
     */
    public FileExistsException(String newMessage, int fileIndex){
        message = newMessage;
        this.fileIndex = fileIndex;
    }

    /** A getter method to give the exception message.
     * @return The message that the called exception contains.
     */
    public String getMessage(){
        return message;
    }

    /** A getter method to give the index number of the problem file.
     * @return The index number of the files that must be dealt with.
     */
    public int getFileIndex(){
        return fileIndex;
    }
}
