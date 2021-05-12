/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP 249
 * Assignment 2
 * Due Date: February 24, 2019
 */

package Transportation;

public class PublicTransportation {
    private double ticketPrice;
    private int numberOfStops;

    /**
     * Default no-parameter constructor
     */
    public PublicTransportation(){
        ticketPrice = 0;
        numberOfStops = 0;
    }

    /**
     * Constructor with 2 parameters
     * @param ticketPrice Price of each ticket.
     * @param numberOfStops Number of stops on the route of the public transportation.
     */
    public PublicTransportation(double ticketPrice, int numberOfStops){
        this.ticketPrice = ticketPrice;
        this.numberOfStops = numberOfStops;
    }

    /**
     * Copy Constructor
     * @param otherPublicTransportation Object to copy.
     */
    public PublicTransportation(PublicTransportation otherPublicTransportation){
        this(otherPublicTransportation.ticketPrice, otherPublicTransportation.numberOfStops);
    }

    /**
     * Ticket price accessor
     * @return ticketPrice
     */
    public double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * Ticket price mutator
     * @param ticketPrice New ticket price.
     */
    public void setTicketPrice(double ticketPrice){
        this.ticketPrice = ticketPrice;
    }

    /**
     * Number of stops accessor
     * @return numberOfStops
     */
    public int getNumberOfStops() {
        return numberOfStops;
    }

    /**
     * Number of stops mutator
     * @param numberOfStops New number of stops.
     */
    public void setNumberOfStops(int numberOfStops){
        this.numberOfStops = numberOfStops;
    }

    /**
     * Equals method that returns true if the objects are the same class and they have equal characteristics.
     * Returns false otherwise.
     * @param otherPublicTransportation Object to compare to the calling object.
     * @return true if objects are the same class and have equal characteristics.
     * @return false otherwise
     */
    public boolean equals(PublicTransportation otherPublicTransportation){
        if(otherPublicTransportation.getClass() == null)
            return false;
        else if(getClass() != otherPublicTransportation.getClass())
            return false;
        else
            return this.numberOfStops == otherPublicTransportation.numberOfStops
                    && this.ticketPrice == otherPublicTransportation.ticketPrice;
    }

    /**
     * toString method to display all the characteristics of an object.
     * @return String Contains full description of the calling object.
     */
    public String toString() {
        return "This " + getClass().getSimpleName() + " costs $" + ticketPrice
                + " and has " + numberOfStops + " stops. ";
    }
}
