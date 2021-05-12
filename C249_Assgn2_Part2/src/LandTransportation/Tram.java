/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP 249
 * Assignment 2
 * Due Date: February 24, 2019
 */

package LandTransportation;

public class Tram extends CityBus {
    private int maximumSpeed;
    /**
     * Default no-parameter constructor
     */
    public Tram(){
        super();
        maximumSpeed = 0;
    }
    /**
     * Constructor that takes in all available parameters.
     * @param ticketPrice Price of each ticket.
     * @param numberOfStops Number of stops on the route of this tram.
     * @param routeNumber The designated route number for the tram.
     * @param beginOperationYear The year that the tram began running.
     * @param lineName The designated route name for the tram.
     * @param driverName The driver assigned to this tram.
     * @param maximumSpeed The maximum speed of this tram.
     */
    public Tram(double ticketPrice, int numberOfStops, long routeNumber, int beginOperationYear, String lineName,
                String driverName, int maximumSpeed){
        super(ticketPrice, numberOfStops, routeNumber, beginOperationYear, lineName, driverName);
        this.maximumSpeed = maximumSpeed;
    }
    /**
     * Copy constructor
     * @param otherTram The tram object that is going to be copied.
     */
    public Tram(Tram otherTram){
        this(otherTram.getTicketPrice(), otherTram.getNumberOfStops(), otherTram.getRouteNumber(), otherTram.getBeginOperationYear(),
                otherTram.getLineName(), otherTram.getDriverName(), otherTram.maximumSpeed);
    }
    /**
     * Maximum speed accessor
     * @return maximumSpeed
     */
    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    /**
     * Maximum speed mutator
     * @param maximumSpeed New maximum speed
     */
    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }
    /**
     * Equals method that returns true if the objects are the same class and they have equal characteristics.
     * Returns false otherwise.
     * @param otherTram Object to compare to the calling object.
     * @return true if objects are the same class and have equal characteristics.
     * @return false otherwise
     */
    public boolean equals(Tram otherTram){
        if(otherTram.getClass() == null)
            return false;
        else if(getClass() != otherTram.getClass())
            return false;
        else
            return super.equals(otherTram) && maximumSpeed == otherTram.maximumSpeed;
    }
    /**
     * toString method to display all the characteristics of an object.
     * @return String Contains full description of the calling object.
     */
    public String toString() {
        return super.toString() + "It's maximum speed is " + maximumSpeed + '.';
    }
}
