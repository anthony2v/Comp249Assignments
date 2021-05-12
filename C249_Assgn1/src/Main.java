/**
 * Anthony van Voorst - 40001890
 * Assignment 1 - Part 2
 * COMP 249
 * Due February 1, 2019
 * Description: This program helps bookstore owners to keep track of the books in their store. It displays a welcome message and offers 5 options
 * to choose from. The five options are: enter new books, change information of a book, display all books by a specific author, display all books
 * under a certain price, or quit the program. Each option is explained in the comments below. The program also uses Book and Password objects.
 */

import java.util.Scanner;

public class Main {
    static String inputPassword;
    static String masterPassword = "password";
    static int passwordAttempts = 0, failedPasswordChecks = 0;
    static Scanner stringKeyboard = new Scanner(System.in);
    static Scanner intKeyboard = new Scanner(System.in);
    public static void main(String[] args) {
        int maximumBooks, currentNumberOfBooks = 0, numberOfAdditionalBooks = 0, userChoice, bookChangeOption = 0,
                bookNumber = -15, userPrice = 0, bookCounter = 0;
        String authorName = "";
        Book[] inventory;
        System.out.println("---------Welcome to my bookstore catalogue program!---------\n"
                + "---------------Written by Anthony van Voorst----------------\n");
        System.out.print("Please input the maximum number of books available (You cannot change this later): ");
        maximumBooks = intKeyboard.nextInt();
        inventory = new Book[maximumBooks];
        System.out.println();
        while(true) {
            passwordAttempts = 0;
            userChoice = 0;
            System.out.print("What do you want to do?"
                    + "\n\t1. Enter new books (password required)"
                    + "\n\t2. Change information of a book (password required)"
                    + "\n\t3. Display all books by a specific author"
                    + "\n\t4. Display all books under a certain a price."
                    + "\n\t5. Quit"
                    + "\nPlease enter your choice: ");
            userChoice = intKeyboard.nextInt();
            switch(userChoice) {
                case 1:
                    //Checks to see if the right password is entered.
                    passwordInput(userChoice);
                    //Returns to main menu if the incorrect password is entered 3 times.
                    if(passwordAttempts == 3) {
                        break;
                    }
                    //Checks to make sure that the inventory isn't full.
                    else if ((numberOfAdditionalBooks + currentNumberOfBooks) == maximumBooks){
                        System.out.println("Error: inventory has reached maximum capacity.");
                    }
                    else {
                        System.out.print("Please enter the number of books you would like to add: ");
                        numberOfAdditionalBooks = intKeyboard.nextInt();
                        while((numberOfAdditionalBooks + currentNumberOfBooks) > maximumBooks) {
                            System.out.println("Error: adding that number of books exceeds the maximum number of books. There are "
                                    + (maximumBooks - currentNumberOfBooks) + " spaces remaining.");
                            System.out.print("Please enter the number of books you would like to add: ");
                            numberOfAdditionalBooks = intKeyboard.nextInt();
                        }
                        for(int i = currentNumberOfBooks; i < currentNumberOfBooks + numberOfAdditionalBooks; i++) {
                            System.out.println("Book #" + (i+1));
                            inventory[i] = new Book();
                            modifyTitle(inventory[i]);
                            modifyAuthor(inventory[i]);
                            modifyISBN(inventory[i]);
                            modifyPrice(inventory[i]);
                        }
                        currentNumberOfBooks += numberOfAdditionalBooks;
                    }
                    break;
                case 2:
                    //Checks to see if the right password is entered.
                    passwordInput(userChoice);
                    //Returns to main menu if the incorrect password is entered 3 times.
                    if(passwordAttempts == 3) {
                        break;
                    }
                    System.out.print("Please specify the book number that you wish to update (-1 to exit): ");
                    bookNumber = intKeyboard.nextInt();
                    //Loops until the user enters a valid book number, or the exit code (-1).
                    while(bookNumber < 0 || bookNumber > maximumBooks || inventory[bookNumber-1] == null) {
                        if (bookNumber == -1)
                            break;
                        else {
                            System.out.print("Error: user input out of range or no info available. Enter a new number or -1 to go back to the main menu: ");
                            bookNumber = intKeyboard.nextInt();
                        }
                    }
                    if(bookNumber == -1) break;
                    //Loops until the user enters a valid option.
                    while(bookChangeOption != 5) {
                        System.out.println("Book #" + bookNumber + "\n" + inventory[bookNumber-1]);
                        System.out.print("What information would you like to change?" +
                                "\n\t1. author" +
                                "\n\t2. title" +
                                "\n\t3. ISBN" +
                                "\n\t4. price" +
                                "\n\t5. Quit" +
                                "\nEnter your choice: ");
                        bookChangeOption = intKeyboard.nextInt();
                        switch(bookChangeOption) {
                            case 1:
                                modifyAuthor(inventory[bookNumber-1]);
                                break;
                            case 2:
                                modifyTitle(inventory[bookNumber-1]);
                                break;
                            case 3:
                                modifyISBN(inventory[bookNumber-1]);
                                break;
                            case 4:
                                modifyPrice(inventory[bookNumber-1]);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Error: invalid choice. Displaying options again.");
                        }
                    }
                    break;
                case 3:
                    //Searches for books that include a specific author's name.
                    System.out.print("Please enter the author name you would like to search for: ");
                    authorName = stringKeyboard.nextLine();
                    for (int i = 0; i < inventory.length; i++){
                        if(inventory[i] == null) break;
                        if(inventory[i].getAuthor().equalsIgnoreCase(authorName)) {
                            System.out.println("Book #" + (i+1) + "\n" + inventory[i]);
                            bookCounter++;
                        }
                    }
                    if(bookCounter == 0) System.out.println("Error: there are no books in the inventory by that author.");
                    else bookCounter = 0;
                    break;
                case 4:
                    //Searches for books that are equal to or less than a specific price.
                    System.out.print("Please enter the maximum price you would like to search for: ");
                    userPrice = intKeyboard.nextInt();
                    for (int i = 0; i < inventory.length; i++){
                        if(inventory[i] == null) break;
                        if(inventory[i].getPrice() <= userPrice) {
                            System.out.println("Book #" + (i+1) + "\n" + inventory[i]);
                            bookCounter++;
                        }
                    }
                    if(bookCounter == 0) System.out.println("Error: there are no books that are below that price.");
                    else bookCounter = 0;
                    break;
                case 5:
                    //Displays a closing message, closes the Scanner objects and terminates the program.
                    System.out.print("\n-------Thank you for using my catalogue program, bye!-------");
                    intKeyboard.close();
                    stringKeyboard.close();
                    System.exit(0);
                default:
                    System.out.println("Error: invalid choice. Displaying options again.");
            }
            System.out.println();
        }
    }
    /**
     * Checks to see if the correct password is entered.
     * @param menuOption Variable used to determine whether to keep track of failed password checks.
     */
    static void passwordInput(int menuOption) {
        System.out.print("Please enter your password: ");
        inputPassword = stringKeyboard.nextLine();
        while(!masterPassword.equals(inputPassword)) {
            passwordAttempts++;
            if(menuOption == 1) {
                //Terminates the program if the wrong password has been entered 12 times.
                failedPasswordChecks++;
                if(failedPasswordChecks == 12) {
                    System.out.println("Program detected suspicious activities and will terminate immediately!");
                    System.exit(0);
                }
            }
            if(passwordAttempts == 3) {
                break;
            }
            System.out.print("Error: wrong password."
                    + "\nPlease enter your password: ");
            inputPassword = stringKeyboard.nextLine();
        }
    }
    //Updates the title of a book.
    static void modifyTitle(Book otherBook) {
        System.out.print("Enter new title: ");
        otherBook.setTitle(stringKeyboard.nextLine());
    }
    //Updates the author of a book.
    static void modifyAuthor(Book otherBook) {
        System.out.print("Enter new author: ");
        otherBook.setAuthor(stringKeyboard.nextLine());
    }
    //Updates the ISBN of a book.
    static void modifyISBN(Book otherBook) {
        System.out.print("Enter new ISBN: ");
        otherBook.setISBN(intKeyboard.nextLong());
    }
    //Updates the price of a book.
    static void modifyPrice(Book otherBook) {
        System.out.print("Enter new price: ");
        otherBook.setPrice(intKeyboard.nextDouble());
    }
}