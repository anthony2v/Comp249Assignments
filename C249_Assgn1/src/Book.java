/**
 * Anthony van Voorst - 40001890
 * Assignment 1 - Part 1
 * COMP 249
 * Due February 1, 2019
 * Description: This class contains a book object with the following attributes:  a title (String),
 * an author (String), an ISBN (long), and a price (double). It contains constructors for book objects
 * which are allowed to have missing attributes (either price, price and ISBN, price, ISBN and author
 * or all 4). Each attribute has accessor and mutator methods. It contains a toString() method as well
 * to display the information of a book. It keeps track of the number of book objects that have been
 * created and can display the number with the method findNumberOfCreatedBooks(). An equals() method
 * is included to compare the attributes between 2 books.
 */

/**
 * @author A_VANVO
 * @version 1
 */
public class Book {
    private String title;
    private String author;
    private long ISBN;
    private double price;
    public static int numberOfBooks = 0;
    public Book() {
        title = "No title";
        author = "No author";
        ISBN = 0;
        price = 0;
        numberOfBooks++;
    }
    public Book(String newTitle) {
        title = newTitle;
        author = "No author";
        ISBN = 0;
        price = 0;
        numberOfBooks++;
    }
    public Book(String newTitle, String newAuthor) {
        title = newTitle;
        author = newAuthor;
        ISBN = 0;
        price = 0;
        numberOfBooks++;
    }
    public Book(String newTitle, String newAuthor, long newISBN) {
        title = newTitle;
        author = newAuthor;
        ISBN = newISBN;
        price = 0;
        numberOfBooks++;
    }
    public Book(String newTitle, String newAuthor, long newISBN, double newPrice) {
        if(!validPrice(newPrice)) {
            System.out.println("Fatal Error: negative pricing.");
            System.exit(0);
        }
        else {
            title = newTitle;
            author = newAuthor;
            ISBN = newISBN;
            price = newPrice;
            numberOfBooks++;
        }
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public long getISBN() {
        return ISBN;
    }
    public double getPrice() {
        return price;
    }
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }
    public void setISBN(long newISBN) {
        ISBN = newISBN;
    }
    /**
     * Updates the price of an object of type Book.
     * @param newPrice Replaces the current price. It must be nonnegative.
     */
    public void setPrice(double newPrice) {
        if(!validPrice(newPrice)) {
            System.out.println("Error: negative pricing.");
            System.out.println("Price not updated.");
        }
        else
            price = newPrice;
    }
    /**
     * Returns the details of a book object in a single String.
     * @return String to be used in a print method.
     */
    public String toString() {
        return("Author: " + author
                + "\nTitle: " + title
                + "\nISBN: " + ISBN
                + "\nPrice: $" + price);
    }
    /**
     * @return The number of book objects that have been created up until the point of calling this method.
     */
    public int findNumberOfCreatedBooks() {
        return numberOfBooks;
    }
    /**
     * Tests for equality between 2 objects of type Book. To be equal, the 2 objects must have the same title, author, ISBN,
     * and price. It downcasts otherObject to a Book variable before checking.
     * @param otherObject The object that will be checked to make sure that it's not null and that it is actually of type Book.
     * @return Returns true if the calling object equals otherBook.
     */
    public boolean equals(Object otherObject) {
        if(otherObject == null) return false;
        else if(getClass() != otherObject.getClass()) return false;
        else {
            Book otherBook = (Book)otherObject;
            return (author.equals(otherBook.getAuthor())
                    && title.equals(otherBook.getTitle())
                    && ISBN == otherBook.ISBN
                    && price == otherBook.price);
        }
    }
    /**
     * Tests if a book's price is negative.
     * @param priceCheck The price of the calling Book object.
     * @return Returns true if the price is positive. Returns false otherwise.
     */
    public static boolean validPrice(double priceCheck) {
        if(priceCheck < 0) return false;
        else return true;
    }
}