/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP249
 * Assignment #3
 * Due Date: March 21, 2019
 * This is a child class of StringTokenizer. It is an improved version with methods to keep track of the tokens that
 * are passed. It has methods to return a token count and previously passed tokens.
 */

import java.util.StringTokenizer;

public class EnhancedStringTokenizer extends StringTokenizer{
    private String[] a;
    private int count;
    public EnhancedStringTokenizer(String arg0) {
        super(arg0);
        a = new String[countTokens()]; //The method countTokens is inherited and is not overridden.
        count = 0;
    }
    public EnhancedStringTokenizer(String arg0, String delimiters) {
        super(arg0, delimiters);
        a = new String[countTokens()];
        count = 0;
    }
    public EnhancedStringTokenizer(String arg0, String delimiters, boolean returnDelimiters) {
        super(arg0, delimiters, returnDelimiters);
        a = new String[countTokens()];
        count = 0;
    }
    /**
     * Returns the same value as the same method in the StringTokenizer class, but it also stores data for the
     * method tokensSoFar to use.
     * @return The next token in the string to be processed.
     */
    public String nextToken() { //This method nextToken has its definition overridden.
        String token = super.nextToken(); //super.nextToken is a version of nextToken defined in the base class StringTokenizer.
        a[count] = token;
        count++;
        return token;
    }
    /**
     * Returns the same value as the same method in the StringTokenizer class, and changes the delimiter set in the same
     * way as does the same method in the StringTokenizer class, but it also stores data for the method tokensSoFar to use.
     * @param delimiters Characters that are meant to be stopping points in the string.
     * @return The next token in the array.
     */
    public String nextToken(String delimiters) { //This method nextToken also has its definition overridden.
        String token = super.nextToken(delimiters); //super.nextToken is the version of nextToken defined in the base class
        a[count] = token;
        count++;
        return token;
    }
    /**
     * Returns an array of all tokens produced so far. Array returned has length equal to the number of tokens
     * produced so far.
     * @return The list of tokens that have been processed already.
     */
    public String[] tokensSoFar() { //tokensSoFar is a new method.
        String[] arrayToReturn = new String[count];
        for(int i = 0; i < count; i++) arrayToReturn[i] = a[i];
        return arrayToReturn;
    }
}