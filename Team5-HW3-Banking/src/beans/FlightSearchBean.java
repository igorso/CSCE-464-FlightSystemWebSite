package beans;

/**
 * The Class FlightSearchBean.
 */
public class FlightSearchBean {
	
	/** The source. */
	private String source;
	
	/** The destination. */
	private String destination;
	
	/** The date of travel. */
	private String dateOfTravel;
	
	/** The number of seats. */
	private int numberOfSeats;
	
	/** The flight class. */
	private String flightClass;
	
	/**
	 * Instantiates a new flight search bean.
	 */
	public FlightSearchBean() {
		this.source = "MIA";
		this.destination = "ORD";
		this.dateOfTravel = "01/01/2015";
		this.numberOfSeats = 1;
		this.flightClass = "business";
	}
	
	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * Sets the destination.
	 *
	 * @param destination the new destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	 * Gets the date of travel.
	 *
	 * @return the date of travel
	 */
	public String getDateOfTravel() {
		return dateOfTravel;
	}
	
	/**
	 * Sets the date of travel.
	 *
	 * @param dateOfTravel the new date of travel
	 */
	public void setDateOfTravel(String dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	
	/**
	 * Gets the number of seats.
	 *
	 * @return the number of seats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	/**
	 * Sets the number of seats.
	 *
	 * @param numberOfSeats the new number of seats
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	/**
	 * Gets the flight class.
	 *
	 * @return the flight class
	 */
	public String getFlightClass() {
		return flightClass;
	}
	
	/**
	 * Sets the flight class.
	 *
	 * @param flightClass the new flight class
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	
	
}
