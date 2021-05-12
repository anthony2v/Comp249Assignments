/**
 * Anthony van Voorst - 40001890
 * COMP249
 * Assignment #4 Part 1
 * Due Date: Monday April 10, 2019
 * This program prompts the user for a text file to process (including its extension) and turns it into a dictionary.
 * The new file is call "SubDictionary.txt" and will hold every unique word from the input file, excluding special
 * characters, numbers, and single letter words excluding 'A' and 'I'.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        int wordCounter = 0;
        char titleCharacter = 'u';
        String temp = "Nothing yet";
        ArrayList<String> subDictionary = new ArrayList<String>();
        Scanner keyboard = new Scanner(System.in), inputFile = null;
        PrintWriter outputFile = null;
        System.out.print("Welcome to my dictionary creator!\nPlease enter the name of the file you would like to process: ");
        temp = keyboard.nextLine();
        try{
            inputFile = new Scanner(new FileInputStream(temp));
            outputFile = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
            while(inputFile.hasNext()) {
                temp = fileFactory(inputFile);
                if(temp != null && !alreadyInDictionary(temp, subDictionary)){
                    subDictionary.add(temp);
                    wordCounter++;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found. Program will exit now.");
            System.exit(0);
        }
        sort(subDictionary, subDictionary.size());
        outputFile.println("The document produced this sub-dictionary, which includes " + wordCounter + " entries.");
        for(String word: subDictionary){
            if(word.charAt(0) != titleCharacter){
                titleCharacter = word.charAt(0);
                outputFile.println("\n" + titleCharacter + "\n==");
                outputFile.println(word);
            }
            else
                outputFile.println(word);
        }
        System.out.println("\nThe document produced a sub-dictionary which includes " + wordCounter + " entries." +
                "\n\nThank you for using my dictionary program. Have a nice day!");
        inputFile.close();
        outputFile.close();
    }

    /**
     * Processes a given Scanner object to remove special characters, numbers, and single letter words excluding 'A' and
     * 'I'.
     * @param fileToProcess The Scanner object, which could either be userInput or a FileOutputStream.
     * @return The processed word.
     */
    public static String fileFactory(Scanner fileToProcess){
        String word = fileToProcess.next().toUpperCase();
        if(word.length() == 1 && !word.equalsIgnoreCase("a") && !word.equalsIgnoreCase("i") ||
                word.contains("0") || word.contains("1") || word.contains("2") || word.contains("3") || word.contains("4") ||
                word.contains("5") || word.contains("6") || word.contains("7") || word.contains("8") || word.contains("9"))
            return null;
        else if(word.endsWith(",") || word.endsWith("?") || word.endsWith(":") ||
                word.endsWith(";") || word.endsWith("!") || word.endsWith("."))
            return word.substring(0, word.length() - 1);
        else if(word.contains("'"))
            return word.substring(0, word.length() - 2);
        else if(word.length() == 1 && word.equalsIgnoreCase("e")) {
            fileToProcess.next();
            return fileToProcess.next();
        }
        else
            return word;
    }

    /**
     * Checks if a word is already in a given array list.
     * @param testWord The word to check for.
     * @param testDictionary The given array list.
     * @return True if the word is already in the arraylist, false otherwise.
     */
    public static boolean alreadyInDictionary(String testWord, ArrayList<String> testDictionary){
        for(String word: testDictionary)
            if(testWord.equalsIgnoreCase(word))
                return true;
        return false;
    }
    /**
     * Precondition: numberUsed <= a.length;
     *              The first numberUsed variables indexed have values.
     * Action: Sorts a so that a[0], a[1], ... , a[numberUsed - 1] are in increasing order
     * by the compareTo method.
     * @param a The corresponding list that will be sorted.
     * @param numberUsed The number of indexes in the list.
     */
    public static void sort(ArrayList<String> a, int numberUsed){
        int index, indexOfNextSmallest;
        for(index = 0; index < numberUsed - 1; index++){
            // Place the correct value in a[index]:
            indexOfNextSmallest = indexOfSmallest(index, a, numberUsed);
            interchange(index, indexOfNextSmallest, a);
            // a[0], a[1], ... , a[index] are correctly ordered and these are
            // the smallest of the original array elements. The remaining positions
            // contain the rest of the original array elements.
        }
    }

    /**
     * Returns the index of the smallest value among a[startIndex], a[startIndex + 1], ... a[numberUsed - 1]
     */
    private static int indexOfSmallest(int startIndex, ArrayList<String> a, int numberUsed){
        String min = a.get(startIndex);
        int indexOfMin = startIndex;
        int index;
        for(index = startIndex + 1; index < numberUsed; index++){
            if(a.get(index).compareTo(min) < 0) { // if a[index] is less than min
                min = a.get(index);
                indexOfMin = index;
                // min is smallest of a[startIndex] through a[index]
            }
        }
        return indexOfMin;
    }
    /**
     * Precondition: i and j are legal indices for the array a.
     * Postcondition: Values of a[i] and a[j] have been interchanged.
     */
    private static void interchange(int i, int j, ArrayList<String> a){
        String temp;
        temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp); // Original value of a[i]
    }
}
