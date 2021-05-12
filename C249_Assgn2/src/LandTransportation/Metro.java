/**
 * Name and ID: Anthony van Voorst - 40001890
 * COMP 249
 * Assignment 2
 * Due Date: February 24, 2019
 */

package LandTransportation;

public class Metro extends CityBus {
    private int maximumSpeed;
    private String cityName;

    /**
     * Default no-parameter constructor
     */
    public Metro(){
        super();
        maximumSpeed = 0;
        cityName = "No name yet";
    }

    /**
     * Constructor that takes in all available parameters.
     * @param ticketPrice Price of each ticket.
     * @param numberOfStops Number of stops on the route of this metro.
     * @param routeNumber The designated route number for the metro.
     * @param beginOperationYear The year that the metro began running.
     * @param lineName The designated route name for the metro.
     * @param driverName The driver assigned to this metro.
     * @param maximumSpeed The maximum speed of this metro.
     * @param cityName The city that this metro operates in.
     */
    public Metro(double ticketPrice, int numberOfStops, long routeNumber, int beginOperationYear, String lineName,
                 String driverName, int maximumSpeed, String cityName){
        super(ticketPrice, numberOfStops, routeNumber, beginOperationYear, lineName, driverName);
        this.maximumSpeed = maximumSpeed;
        this.cityName = cityName;
    }

    /**
     * Copy constructor
     * @param otherMetro The Metro object that is going to be copied.
     */
    public Metro(Metro otherMetro){
        super(otherMetro);
        this.maximumSpeed = otherMetro.maximumSpeed;
        this.cityName = otherMetro.cityName;
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
     * City name accessor
     * @return cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * City name mutator
     * @param cityName New city name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Equals method that returns true if the objects are the same class and they have equal characteristics.
     * Returns false otherwise.
     * @param otherMetro Object to compare to the calling object.
     * @return true if objects are the same class and have equal characteristics.
     * @return false otherwise
     */
    public boolean equals(Metro otherMetro){
        if(otherMetro.getClass() == null)
            return false;
        else if(getClass() != otherMetro.getClass())
            return false;
        else
            return super.equals(otherMetro) && maximumSpeed == otherMetro.maximumSpeed &&
                    cityName.equals(otherMetro.cityName);
    }
    /**
     * toString method to display all the characteristics of an object.
     * @return String Contains full description of the calling object.
     */
    public String toString() {
        return super.toString() + "It's maximum speed is " + maximumSpeed + " and it is from " + cityName + '.';
    }
}
