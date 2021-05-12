/**
 * Anthony van Voorst - 40001890
 * COMP 249
 * Assignment #4 Part 2
 * April 10, 2019
 * This CellPhone class contains 4 attributes, including a serial number, brand, year, and price. No 2 cell phones in a
 * list should have the same serial number. Methods included are getters and setters, clone, equals, and toString.
 */
public class CellPhone {
	private long serialNum;
	private String brand;
	private int year;
	private double price;

	/**
	 * The parameterized constructor for the CellPhone.
	 * @param serialNum The unique serial number.
	 * @param brand The manufacturer of the cell phone.
	 * @param price The cell phone's price.
	 * @param year The year the cell phone was manufactured.
	 */
	public CellPhone(long serialNum, String brand, double price, int year){
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	/**
	 * The copy constructor for this CellPhone class.
	 * @param otherCellPhone The CellPhone to be copied.
	 * @param serialNum The new CellPhone's serial number.
	 */
	public CellPhone(CellPhone otherCellPhone, long serialNum){
		this(serialNum, otherCellPhone.brand, otherCellPhone.price, otherCellPhone.year);
	}

	/**
	 * Getter for the serial number.
	 * @return The calling CellPhone's serial number.
	 */
	public long getSerialNum() {
		return serialNum;
	}

	/**
	 * Setter for the serial number.
	 * @param serialNum The calling CellPhone's serial number.
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * Getter for the brand.
	 * @return The calling CellPhone's brand.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter for the brand.
	 * @param brand The calling CellPhone's brand.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Getter for the year.
	 * @return The calling CellPhone's year.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Setter for the year.
	 * @param year The calling CellPhone's year.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Getter for the price.
	 * @return The calling CellPhone's price.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for the price.
	 * @param price The calling CellPhone's price.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Returns a deep copy of a CellPhone object. The new phone will have its own unique serial number.
	 * @param otherCellPhone The CellPhone to be copied.
	 * @param serialNum The new phone's unique serial number.
	 * @return The new CellPhone object.
	 */
	public CellPhone clone(CellPhone otherCellPhone, long serialNum){
		return new CellPhone(otherCellPhone, serialNum);
	}

	/**
	 * Compares 2 CellPhone objects to determine whether they are equal. Serial numbers are not compared as they are
	 * assumed to be unique for each CellPhone.
	 * @param otherObject The CellPhone to compare to the calling CellPhone.
	 * @return True if the brand, year, and price are equal, false otherwise.
	 */
	public boolean equals(Object otherObject){
		if(otherObject == null)
			return false;
		else if(this.getClass() != otherObject.getClass())
			return false;
		else{
		    CellPhone otherCellPhone = (CellPhone)otherObject;
			return this.brand.equals(otherCellPhone.brand) && this.year == otherCellPhone.year && this.price == otherCellPhone.price;
		}
	}

	/**
	 * This will return a string with all the information of the calling CellPhone object.
	 * @return The variables of the calling CellPhone object.
	 */
	public String toString(){
		return "[" + serialNum + ": " + brand + " " + price + "$ " + year + "]";
	}
}
