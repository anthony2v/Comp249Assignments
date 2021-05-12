/**
 * Anthony van Voorst - 40001890
 * COMP 249
 * Assignment #4 Part 2
 * April 10, 2019
 * This driver demos the CellPhone, CellList, and NoSuchElementException classes. It opens the Cell_Info.txt file and
 * process the records that are saved in it.
 */

import java.util.Scanner;
import java.io.FileInputStream;

public class CellListUtilization {

    public static void main(String[] args) {
        long serialNumber;
        CellList PhoneList1 = new CellList();
        CellList PhoneList2;
        Scanner inputFile = null, keyboard = new Scanner(System.in);
        System.out.println("Welcome to my Cell Phone processor!\n===================================");
        try {
            inputFile = new Scanner(new FileInputStream("Cell_Info.txt"));
            System.out.println("The first part will process the text file, which contains info on all available phones. Duplicates won't be included.");
            while(inputFile.hasNext()){
                serialNumber = inputFile.nextLong();
                if(!PhoneList1.contains(serialNumber))
                    PhoneList1.addToStart(new CellPhone(serialNumber, inputFile.next(), inputFile.nextDouble(),
                            inputFile.nextInt()));
                else{
                    inputFile.next();
                    inputFile.nextDouble();
                    inputFile.nextInt();
                }
            }
            System.out.println("===================================\nNext the contents of the list will be displayed. The size will also be displayed at the end.");
            PhoneList1.showContents();
            System.out.print(PhoneList1.getSize());
            System.out.println("\n===================================\nFor this next part, you will be asked to enter serial numbers to find in the list.");
            for(int i = 0; i < 3; i++) {
                System.out.print("Please enter a serial number to search: ");
                serialNumber = keyboard.nextLong();
                System.out.println("Your serial number being in the list is " + PhoneList1.contains(serialNumber));
            }
            System.out.println("===================================\nThis part will replace index 3 in the list with an iPhone SE.");
            CellPhone iPhoneSE = new CellPhone(80808080, "Apple", 400, 2016);
            PhoneList1.replaceAtIndex(iPhoneSE, 3);
            PhoneList1.showContents();
            System.out.println("\n===================================\nNow we will insert the iPhone SE into the 5th index.");
            PhoneList1.insertAtIndex(iPhoneSE, 5);
            PhoneList1.showContents();
            System.out.println("===================================\nWe will clone the CellList and delete a few nodes.");
            PhoneList2 = new CellList(PhoneList1);
            System.out.println("The lists being equal is " + PhoneList1.equals(PhoneList2));
            PhoneList2.deleteFromStart();
            PhoneList2.deleteFromIndex(8);
            PhoneList2.deleteFromIndex(16);
            PhoneList2.showContents();
            System.out.println("The lists being equal is " + PhoneList1.equals(PhoneList2));
            System.out.println("===================================\nThis part tests the getters, setters, toString(), and clone() of CellPhone.");
            iPhoneSE.setBrand("Samsung");
            iPhoneSE.setPrice(999.99);
            iPhoneSE.setSerialNum(1234567890);
            iPhoneSE.setYear(2025);
            System.out.println("New Serial Number:\tNew Brand:\tNew Price:\tNew Year:");
            System.out.println(iPhoneSE.getSerialNum() + "\t" + iPhoneSE.getBrand() + "\t" + iPhoneSE.getPrice() + "\t" + iPhoneSE.getYear());
            CellPhone otherPhone = iPhoneSE.clone(iPhoneSE, 323545634);
            System.out.println(otherPhone);
            System.out.println("Thank you for using my Cell Phone processor. Good-bye!");
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("Generic Error. Program will exit after closing files.");
        }
        finally{
            inputFile.close();
            keyboard.close();
        }
    }
}
