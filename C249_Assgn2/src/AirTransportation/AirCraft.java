/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP 249
 * Assignment 2
 * Due Date: February 24, 2019
 */

package AirTransportation;
import Transportation.PublicTransportation;

public class AirCraft extends PublicTransportation {
    public enum ClassType{HELICOPTER, AIRLINE, GLIDER, BALLOON}
    public enum MaintenanceType{WEEKLY, MONTHLY, ANNUALLY}
    private ClassType classType;
    private MaintenanceType maintenanceType;

    /**
     * Default no-parameter constructor
     */
    public AirCraft(){
        super();
        classType = null;
        maintenanceType = null;
    }

    /**
     * Constructor that takes in all available parameters.
     * @param ticketPrice Price of each ticket.
     * @param numberOfStops Number of stops on the route of this aircraft.
     * @param classType The class of aircraft (helicopter, airline, glider, balloon).
     * @param maintenanceType The aircraft's maintenance type (weekly, monthly, annually).
     */
    public AirCraft(double ticketPrice, int numberOfStops, ClassType classType, MaintenanceType maintenanceType){
        super(ticketPrice, numberOfStops);
        this.classType = classType;
        this.maintenanceType = maintenanceType;
    }

    /**
     * Copy constructor
     * @param otherAirCraft The aircraft object that is going to be copied.
     */
    public AirCraft(AirCraft otherAirCraft){
        this(otherAirCraft.getTicketPrice(), otherAirCraft.getNumberOfStops(), otherAirCraft.classType,
                otherAirCraft.maintenanceType);
    }

    /**
     * Class type accessor
     * @return classType
     */
    public ClassType getClassType() {
        return classType;
    }

    /**
     * Class type mutator
     * @param classType New class type
     */
    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    /**
     * Maintenance type accessor
     * @return maintenanceType
     */
    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    /**
     * Maintenance type mutator
     * @param maintenanceType New maintenance type
     */
    public void setMaintenanceType(MaintenanceType maintenanceType) {
        this.maintenanceType = maintenanceType;
    }
    /**
     * Equals method that returns true if the objects are the same class and they have equal characteristics.
     * Returns false otherwise.
     * @param otherAirCraft Object to compare to the calling object.
     * @return true if objects are the same class and have equal characteristics.
     * @return false otherwise
     */
    public boolean equals(AirCraft otherAirCraft){
        if(otherAirCraft.getClass() == null)
            return false;
        else if(getClass() != otherAirCraft.getClass())
            return false;
        else
            return super.equals(otherAirCraft) && this.getClassType() == otherAirCraft.getClassType() &&
                    this.getMaintenanceType() == otherAirCraft.getMaintenanceType();
    }
    /**
     * toString method to display all the characteristics of an object.
     * @return String Contains full description of the calling object.
     */
    public String toString(){
        return super.toString() + "It undergoes maintenance " + maintenanceType + '.';
    }
}
