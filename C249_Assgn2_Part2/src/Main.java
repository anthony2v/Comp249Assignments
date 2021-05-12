/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP 249
 * Assignment 2 Part 2
 * Due Date: February 24, 2019
 * Every class attribute is now private because the accessors should be used to get object characteristics.
 * The copying did not work properly because every attribute of the array is treated as PublicTransportation
 * instead of their original types.
 */

import AirTransportation.AirCraft;
import WaterTransportation.Ferry;
import LandTransportation.*;
import Transportation.PublicTransportation;

public class Main {
    public static void main(String[] args) {
        PublicTransportation TransitDatabase[] = new PublicTransportation[12];
        TransitDatabase[0] = new PublicTransportation(4, 18);
        TransitDatabase[1] = new CityBus(3.25, 16, 101, 1994, "CoteVertu", "Jan");
        TransitDatabase[2] = new Tram(3.25, 16, 101, 1994, "CoteVertu", "Jan", 40);
        TransitDatabase[3] = new Metro(7, 10, 5, 2013, "DeuxMontagnes", "Bob", 30, "Montreal");
        TransitDatabase[4] = new PublicTransportation(4, 18);
        TransitDatabase[5] = new AirCraft(3.75, 3, AirCraft.ClassType.AIRLINE, AirCraft.MaintenanceType.MONTHLY);
        TransitDatabase[6] = new Ferry(1, 2, 2017, "SS Anne");
        for(int i = 7; i < TransitDatabase.length; i++)
            TransitDatabase[i] = new Ferry(Math.round(Math.random() * 15.0), (int)(Math.random() * 20), 2000 + i, "Boat" + i);
        PublicTransportation[] TransitDatabase2 = new PublicTransportation[12];
        System.out.println("Original array");
        for(int i = 0; i < TransitDatabase.length; i++){
            System.out.println(TransitDatabase[i]);
        }
        System.out.println("\nNew array");
        TransitDatabase2 = copyCityBuss(TransitDatabase);
        for(int i = 0; i < TransitDatabase2.length; i++){
            System.out.println(TransitDatabase2[i]);
        }
    }
    public static PublicTransportation[] copyCityBuss(PublicTransportation[] otherDatabase){
        PublicTransportation[] newDatabase = new PublicTransportation[otherDatabase.length];
        for(int i = 0; i < otherDatabase.length; i++){
            if(otherDatabase[i] instanceof CityBus) {
                newDatabase[i] = new CityBus((CityBus)otherDatabase[i]);
            }
        }
        return newDatabase;
    }
}