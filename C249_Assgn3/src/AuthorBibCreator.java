/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP249
 * Assignment #3
 * Due Date: March 21, 2019
 * This program is a bibliography creator for the following formats: ACM, IEEE, and NJ. It will open all JSON format
 * input files in the folder "in" and open 3 output files for each bibliography. The user will be prompted for the last
 * name of the author they wish to cite and scan the files for that name. Once the scan is complete, the sources will be
 * printed to the output files. If no sources have been found that contain the author name, then the output files will
 * be deleted and a message will be displayed notifying the user.
 */

import java.io.*;
import java.util.Scanner;

public class AuthorBibCreator {
    static String authorName = null, completeAuthorName = "";

    /**
     * The main method of the BibCreator.
     * @param args
     * @throws FileNotFoundException If the input files are not found or there is a problem with one them, then this
     * exception is thrown.
     * @throws Exception If there is a problem with either the input files or the output files, then this exception is
     * thrown.
     */
    public static void main(String[] args) {
        // Prompts the user for the author that they need for their bibliography.
        String fileName = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Welcome to BibCreator!\n\nPlease enter the last name of the author that you would like to search for: ");
        authorName = keyboard.nextLine();
        System.out.println();
        // Prepares the files for reading and writing.
        Scanner[] inputStream = null;
        PrintWriter[] outputStream = new PrintWriter[3];
        File[] bibliographies = null, directoryFiles = null;
        try {
            // Searches for input files and opens them.
            File targetDirectory = new File("./in");
            directoryFiles = targetDirectory.listFiles();
            inputStream = new Scanner[targetDirectory.listFiles().length];
            int fileCounter = 0;
            for (File singleFile: directoryFiles)
                inputStream[fileCounter++] = new Scanner(new FileInputStream(singleFile));
            // If all input files are opened successfully, then the program will open the output files.
            bibliographies = checkFileExistence(authorName);
            for(int i = 0; i < bibliographies.length; i++) {
                fileName = bibliographies[i].getName();
                outputStream[i] = new PrintWriter(new FileOutputStream(bibliographies[i]));
            }
        }
        // Exceptions that must be handled.
        catch(FileNotFoundException e){
            System.out.println("Error opening the file " + fileName + ", file not found.\n" +
                    "Program will terminate after closing any opened files.");
            // Part 4: if there was a problem opening any of the output files, then they will all be deleted.
            EnhancedStringTokenizer fileType = new EnhancedStringTokenizer(fileName, "-");
            while(!fileType.hasMoreTokens()){
                String tempToken = fileType.nextToken();
                if(bibliographies != null && tempToken.equals("IEEE") || tempToken.equals("ACM") || tempToken.equals("NJ")){
                    bibliographies[0].delete();
                    bibliographies[1].delete();
                    bibliographies[2].delete();
                }
            }
        }
        catch(Exception e){
            System.out.println("Could not open input file " + fileName + " for reading/writing.\n" +
                    "Please check if file exists! Program will terminate after closing any opened files.");
        }
        // Once the files have been opened successfully, they will be processed.
        finally{
            if(processBibFiles(inputStream, outputStream)){
                System.out.println("Files " + bibliographies[0].getName() + ", " + bibliographies[1].getName() + ", and " +
                        bibliographies[2].getName() + " have been created successfully!");
            }
            // In case no references are found.
            else{
                bibliographies[0].delete();
                bibliographies[1].delete();
                bibliographies[2].delete();
                System.out.println("No files have been created!");
            }
            for (int i = 0; i < inputStream.length; i++) {
                inputStream[i].close();
            }
            for (int i = 0; i < outputStream.length; i++) {
                outputStream[i].close();
            }
            System.out.println("\nGoodbye! I hope you enjoyed creating bibliographies using BibCreator!");
            System.exit(0);
        }
    }

    /**
     * Verifies that bibliography files don't already exist for the specified user. If they do, then the offending files
     * will be renamed as BU and older BU files will be deleted.
     * @param authorName The name that the user is searching for.
     * @return The bibliography files that will be processed.
     */
    public static File[] checkFileExistence(String authorName) {
        File[] bibliographies = new File[3], bibliographiesBU = new File[3];
        bibliographies[0] = new File(authorName + "-IEEE.json");
        bibliographies[1] = new File(authorName + "-ACM.json");
        bibliographies[2] = new File(authorName + "-NJ.json");
        bibliographiesBU[0] = new File(authorName + "-IEEE-BU.json");
        bibliographiesBU[1] = new File(authorName + "-ACM-BU.json");
        bibliographiesBU[2] = new File(authorName + "-NJ-BU.json");
        try {
            // If any of the files already exist, they will be renamed.
            for (int i = 0; i < bibliographies.length; i++) {
                if (bibliographies[i].exists())
                    throw new FileExistsException(bibliographies[i] + " could not be opened. It already exists\n" +
                            "for that author. It will be renamed as BU, and older BU files will be deleted!\n", i);
            }
        }
        // If BU files already exist, then they will be deleted before renaming the more recent bibliography files.
        catch(FileExistsException e){
            System.out.println(e.getMessage());
            if(bibliographiesBU[e.getFileIndex()].exists()){
                if(bibliographiesBU[e.getFileIndex()].delete()) {
                    //System.out.println("Delete successful.");
                }
            }
            if (bibliographies[e.getFileIndex()].renameTo(bibliographiesBU[e.getFileIndex()]))
                //System.out.println("Rename successful.");
            // Now that the problem is fixed, the method will run again.
            bibliographies = checkFileExistence(authorName);
        }
        return bibliographies;
    }

    /**
     * The method that will process all files. No IO exceptions should be thrown in this method.
     * @param inputFiles All input files in JSON format that need to be processed.
     * @param outputFiles The 3 bibliography files where the matching references will go.
     * @return The success or failure of processing all the files.
     */
    public static boolean processBibFiles(Scanner[] inputFiles, PrintWriter[] outputFiles) {
        int referenceCounter = 0;
        String tempString = null, tempAuthor = null, tempJournal = null, tempTitle = null, tempVolume = null,
                tempNumber = null, tempPages = null, tempMonth = null, tempYear = null, tempDOI = null;
        EnhancedStringTokenizer tempLine = null;
        for (int i = 0; i < inputFiles.length; i++) {
            // goForward is used as a flag to determine whether the source should be processed.
            boolean goForward = false;
            // Testing for the end of the file.
            while (inputFiles[i].hasNext()) {
                tempLine = new EnhancedStringTokenizer(inputFiles[i].nextLine(), "={}");
                // Testing for the end of the line.
                while (tempLine.hasMoreTokens()) {
                    tempString = tempLine.nextToken();
                    if (tempString.equals("author")) {
                        tempAuthor = tempLine.nextToken();
                        // To create author name with initials for ACM.
                        processCompleteAuthorName(tempAuthor);
                        // If the current authors include the one the user is looking for, then the rest of the source
                        // will be processed.
                        goForward = includesAuthor(authorName, tempAuthor);
                    }
                    if (goForward) {
                        if (tempString.equals("journal"))
                            tempJournal = tempLine.nextToken();
                        else if (tempString.equals("title"))
                            tempTitle = tempLine.nextToken();
                        else if (tempString.equals("volume"))
                            tempVolume = tempLine.nextToken();
                        else if (tempString.equals("number"))
                            tempNumber = tempLine.nextToken();
                        else if (tempString.equals("pages"))
                            tempPages = tempLine.nextToken();
                        else if (tempString.equals("doi"))
                            tempDOI = tempLine.nextToken();
                        else if (tempString.equals("year"))
                            tempYear = tempLine.nextToken();
                        else if (tempString.equals("month")) {
                            tempMonth = tempLine.nextToken();
                            // IEEE format
                            outputFiles[0].println(tempAuthor + ". \"" + tempTitle + "\", " + tempJournal + ", vol. " + tempVolume +
                                    ", no. " + tempNumber + ", p. " + tempPages + ", " + tempMonth + " " + tempYear + ".\n");
                            // ACM format
                            outputFiles[1].println("[" + ++referenceCounter + "]" + "\t" + completeAuthorName + tempYear +
                                    ". " + tempTitle + ". " + tempVolume + ", " + tempNumber + "(" + tempYear + "), " + tempPages +
                                    ". DOI:" + tempDOI + ".\n");
                            // NJ format
                            outputFiles[2].println(tempAuthor + ". " + tempTitle + ". " + tempJournal + ". " + tempVolume + ", " + tempPages + "(" + tempYear + ")\n");
                            // This gets reset for the next author name, there could varying initials.
                            completeAuthorName = "";
                        }
                        else {}
                    }
                }
            }
        }
        // If at least one reference was found, return true.
        if (referenceCounter > 0) {
            System.out.println("A total of " + referenceCounter + " records found for author(s) with the name " + authorName);
            return true;
        } else {
            System.out.println("No records were found for author(s) with the name " + authorName);
            return false;
        }
    }

    /**
     * Checks if otherAuthorName is the same as the author specified by the user.
     * @param authorName The user-specified author name.
     * @param otherAuthorName The string that is currently being scanned.
     * @return true if the names match, false otherwise.
     */
    public static boolean includesAuthor(String authorName, String otherAuthorName){
        EnhancedStringTokenizer author = new EnhancedStringTokenizer(otherAuthorName);
        while (author.hasMoreTokens()){
            if(author.nextToken().equals(authorName)){
                return true;
            }
        }
        return false;
    }

    /**
     * This method is for adding the author's initials to their last name as well as "et al." at the end. This is for
     * ACM format bibliography.
     * @param authorReference The complete list of authors from the reference.
     */
    public static void processCompleteAuthorName(String authorReference){
        String temp = null;
        EnhancedStringTokenizer wordFactory = new EnhancedStringTokenizer(authorReference);
        while(wordFactory.hasMoreTokens()){
            temp = wordFactory.nextToken();
            completeAuthorName = completeAuthorName.concat(" " + temp);
            if(temp.equals(authorName)) {
                completeAuthorName = completeAuthorName.concat(" et al. ");
                break;
            }
            // If true, then that means the author referenced before "and" is not the right author, and completeAuthorName
            // should be reset for the next name.
            else if(temp.equals("and"))
                completeAuthorName = "";
            else{}
        }
    }
}
