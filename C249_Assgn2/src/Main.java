/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP 249
 * Assignment 2 Part 1
 * Due Date: February 24, 2019
 */

import AirTransportation.AirCraft;
import WaterTransportation.Ferry;
import LandTransportation.*;
import Transportation.PublicTransportation;

public class Main {
    public static void main(String[] args) {
        PublicTransportation TransitDatabase[] = new PublicTransportation[15];
        TransitDatabase[0] = new PublicTransportation(4, 18);
        TransitDatabase[1] = new CityBus(3.25, 16, 101, 1994, "CoteVertu", "Jan");
        TransitDatabase[2] = new Tram(3.25, 16, 101, 1994, "CoteVertu", "Jan", 40);
        TransitDatabase[3] = new Metro(7, 10, 5, 2013, "DeuxMontagnes", "Bob", 30, "Montreal");
        TransitDatabase[4] = new PublicTransportation(4, 18);
        TransitDatabase[5] = new AirCraft(3.75, 3, AirCraft.ClassType.AIRLINE, AirCraft.MaintenanceType.MONTHLY);
        TransitDatabase[6] = new Ferry(1, 2, 2017, "SS Anne");
        for(int i = 7; i < TransitDatabase.length; i++)
            TransitDatabase[i] = new Ferry(Math.round(Math.random() * 15.0), (int)(Math.random() * 20), 2000 + i, "Boat" + i);
        int leastExpensiveService = 0, mostExpensiveService = 0;
        for(int i = 0; i < TransitDatabase.length; i++){
            System.out.println(TransitDatabase[i]);
            if(TransitDatabase[i].getTicketPrice() < TransitDatabase[leastExpensiveService].getTicketPrice())
                leastExpensiveService = i;
            if(TransitDatabase[i].getTicketPrice() > TransitDatabase[mostExpensiveService].getTicketPrice())
                mostExpensiveService = i;
        }
        System.out.println("\nBoat13 is equal to Boat14 is " + TransitDatabase[13].equals(TransitDatabase[14]) + '.');
        System.out.println("Public Transit Index 4 is equal to Public Transit Index 0 is " + TransitDatabase[4].equals(TransitDatabase[0]) + '.');
        System.out.println("Boat8 is equal to CityBus CoteVertu is " + TransitDatabase[8].equals(TransitDatabase[1]) + '.');
        System.out.println("\nLeast expensive service (index #" + leastExpensiveService + "):");
        System.out.println(TransitDatabase[leastExpensiveService]);
        System.out.println("\nMost expensive service (index #" + mostExpensiveService + "):");
        System.out.println(TransitDatabase[mostExpensiveService]);
    }
}