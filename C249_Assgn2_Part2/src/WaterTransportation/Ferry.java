/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP 249
 * Assignment 2
 * Due Date: February 24, 2019
 */

package WaterTransportation;
import Transportation.PublicTransportation;

public class Ferry extends PublicTransportation {
    private int buildYear;
    private String shipName;

    /**
     * Default no-parameter constructor
     */
    public Ferry(){
        super();
        buildYear = 0;
        shipName = "No name yet";
    }

    /**
     * Constructor that takes in all available parameters.
     * @param ticketPrice Price of each ticket.
     * @param numberOfStops Number of stops on the route of this ferry.
     * @param buildYear The year that the ferry was built.
     * @param shipName The name of the ferry.
     */
    public Ferry(double ticketPrice, int numberOfStops, int buildYear, String shipName){
        super(ticketPrice, numberOfStops);
        this.buildYear = buildYear;
        this.shipName = shipName;
    }

    /**
     * Copy constructor
     * @param otherFerry The ferry object that is going to be copied.
     */
    public Ferry(Ferry otherFerry){
        this(otherFerry.getTicketPrice(), otherFerry.getNumberOfStops(), otherFerry.buildYear, otherFerry.shipName);
    }

    /**
     * Build year accessor
     * @return buildYear
     */
    public int getBuildYear() {
        return buildYear;
    }

    /**
     * Build year mutator
     * @param buildYear
     */
    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    /**
     * Ship name accessor
     * @return shipName
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * Ship name mutator
     * @param shipName New ship name
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    /**
     * Equals method that returns true if the objects are the same class and they have equal characteristics.
     * Returns false otherwise.
     * @param otherFerry Object to compare to the calling object.
     * @return true if objects are the same class and have equal characteristics.
     * @return false otherwise
     */
    public boolean equals(Ferry otherFerry){
        if(otherFerry.getClass() == null)
            return false;
        else if(getClass() != otherFerry.getClass())
            return false;
        else
            return super.equals(otherFerry) && this.buildYear == otherFerry.buildYear &&
                    this.shipName.equals(otherFerry.shipName);
    }
    /**
     * toString method to display all the characteristics of an object.
     * @return String Contains full description of the calling object.
     */
    public String toString() {
        return super.toString() + "Its build year is " + buildYear + " and it is called " + shipName + '.';
    }
}
