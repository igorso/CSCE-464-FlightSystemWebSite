package beans;

/**
 * The Class DetailedFlightBean.
 */
public class DetailedFlightBean {
	
	/** The id. */
	private int id; //id flight
	
	/** The plane. */
	private int plane; //id plane
	
	/** The cost. */
	private int cost; //cost of 1 flight
	
	/** The operator. */
	private String operator;
	
	/** The source. */
	private String source;
	
	/** The destination. */
	private String destination;
	
	/** The first class reserved. */
	private int firstClassReserved;
	
	/** The business reserved. */
	private int businessReserved;
	
	/** The economy reserved. */
	private int economyReserved;
	
	/** The departure. */
	private String departure;
	
	/** The arrival. */
	private String arrival;
	
	/** The flight class. */
	private String flightClass;
	
	/** The number of seat. */
	private int numberOfSeat;
	
	/**
	 * Instantiates a new detailed flight bean.
	 */
	public DetailedFlightBean() {
		this.id = 0;
		this.plane = 0;
		this.operator = "DEFAULT";
		this.source = "DEFAULT";
		this.destination = "DEFAULT";
		this.firstClassReserved = 0;
		this.businessReserved = 0;
		this.economyReserved = 0;
		this.departure = "DEFAULT";
		this.arrival = "DEFAULT";
		this.numberOfSeat=0;
		}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the plane.
	 *
	 * @return the plane
	 */
	public int getPlane() {
		return plane;
	}
	
	/**
	 * Sets the plane.
	 *
	 * @param plane the new plane
	 */
	public void setPlane(int plane) {
		this.plane = plane;
	}
	
	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * Sets the operator.
	 *
	 * @param operator the new operator
	 */
	public void setOperator(String operator) {
		
		this.operator = operator;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
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
	 * Gets the first class reserved.
	 *
	 * @return the first class reserved
	 */
	public int getFirstClassReserved() {
		return firstClassReserved;
	}
	
	/**
	 * Sets the first class reserved.
	 *
	 * @param firstClassReserved the new first class reserved
	 */
	public void setFirstClassReserved(int firstClassReserved) {
		this.firstClassReserved = firstClassReserved;
	}
	
	/**
	 * Gets the business reserved.
	 *
	 * @return the business reserved
	 */
	public int getBusinessReserved() {
		return businessReserved;
	}
	
	/**
	 * Sets the business reserved.
	 *
	 * @param businessReserved the new business reserved
	 */
	public void setBusinessReserved(int businessReserved) {
		this.businessReserved = businessReserved;
	}
	
	/**
	 * Gets the economy reserved.
	 *
	 * @return the economy reserved
	 */
	public int getEconomyReserved() {
		return economyReserved;
	}
	
	/**
	 * Sets the economy reserved.
	 *
	 * @param economyReserved the new economy reserved
	 */
	public void setEconomyReserved(int economyReserved) {
		this.economyReserved = economyReserved;
	}
	
	/**
	 * Gets the departure.
	 *
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}
	
	/**
	 * Sets the departure.
	 *
	 * @param departure the new departure
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	/**
	 * Gets the arrival.
	 *
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}
	
	/**
	 * Sets the arrival.
	 *
	 * @param arrival the new arrival
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
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
	
	/**
	 * Gets the number of seat.
	 *
	 * @return the number of seat
	 */
	public int getNumberOfSeat() {
		return numberOfSeat;
	}
	
	/**
	 * Sets the number of seat.
	 *
	 * @param numberOfSeat the new number of seat
	 */
	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}
	
}
