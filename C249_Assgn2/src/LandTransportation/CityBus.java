/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP 249
 * Assignment 2
 * Due Date: February 24, 2019
 */

package LandTransportation;
import Transportation.PublicTransportation;

public class CityBus extends PublicTransportation {
    protected long routeNumber;
    protected int beginOperationYear;
    protected String lineName;
    protected String driverName;

    /**
     * Default no-parameter constructor
     */
    public CityBus(){
        super();
        routeNumber = 0;
        beginOperationYear = 0;
        lineName = "No name yet";
        driverName = "No name yet";
    }

    /**
     * Constructor that takes in all available parameters.
     * @param ticketPrice Price of each ticket.
     * @param numberOfStops Number of stops on the route of this city bus.
     * @param routeNumber The designated route number for the city bus.
     * @param beginOperationYear The year that the bus began running.
     * @param lineName The designated route name for the city bus.
     * @param driverName The driver assigned to this city bus.
     */
    public CityBus(double ticketPrice, int numberOfStops, long routeNumber, int beginOperationYear, String lineName, String driverName){
        super(ticketPrice, numberOfStops);
        this.routeNumber = routeNumber;
        this.beginOperationYear = beginOperationYear;
        this.lineName = lineName;
        this.driverName = driverName;
    }

    /**
     * Copy Constructor
     * @param otherCityBus The CityBus object that is going to be copied.
     */
    public CityBus(CityBus otherCityBus){
        this(otherCityBus.getTicketPrice(), otherCityBus.getNumberOfStops(), otherCityBus.routeNumber,
                otherCityBus.beginOperationYear, otherCityBus.lineName, otherCityBus.driverName);
    }

    /**
     * Route number accessor
     * @return routeNumber
     */
    public long getRouteNumber() {
        return routeNumber;
    }
    /**
     * Route number mutator
     * @param routeNumber New route number.
     */
    public void setRouteNumber(long routeNumber) {
        this.routeNumber = routeNumber;
    }

    /**
     * Begin operation year accessor
     * @return beginOperationYear
     */
    public int getBeginOperationYear() {
        return beginOperationYear;
    }

    /**
     * Begin operation year mutator
     * @param beginOperationYear The new beginning operation year
     */
    public void setBeginOperationYear(int beginOperationYear) {
        this.beginOperationYear = beginOperationYear;
    }

    /**
     * Line name accessor
     * @return lineName
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * Line name mutator
     * @param lineName The new line name.
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     * Drive name accessor
     * @return driverName
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Driver name mutator
     * @param driverName New driver name.
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * Equals method that returns true if both objects are the same class and they have equal characteristics.
     * Returns false otherwise.
     * @param otherCityBus Object to compare to the calling object.
     * @return true if objects are the same class and have equal characteristics.
     * @return false otherwise
     */
    public boolean equals(CityBus otherCityBus){
        if(otherCityBus.getClass() == null)
            return false;
        else if(getClass() != otherCityBus.getClass())
            return false;
        else
            return super.equals(otherCityBus) && this.routeNumber == otherCityBus.routeNumber &&
                    this.beginOperationYear == otherCityBus.beginOperationYear &&
                    this.lineName.equals(otherCityBus.lineName) && this.driverName.equals(otherCityBus.driverName);
    }
    /**
     * toString method to display all the characteristics of an object.
     * @return String Contains full description of the calling object.
     */
    public String toString() {
        return super.toString() + "It's route number is " + routeNumber +
                " and it began operation in " + beginOperationYear +
                ". The name of its line is " + lineName +
                " and it's driven by " + driverName + ". ";
    }
}
