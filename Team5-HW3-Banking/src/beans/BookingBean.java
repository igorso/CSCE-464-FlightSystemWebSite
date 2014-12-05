package beans;

/**
 * The Class BookingBean.
 */
public class BookingBean {
	
	/** The id. */
	private int id; //id booking


	/** The date of booking. */
	private String dateOfBooking;	
	
	/** The flight ids. */
	private int flightIds; //id plane
	
	/** The number of seats. */
	private int numberOfSeats;
	
	/** The account id. */
	private int accountId;
	
	/** The user id. */
	private int userId;
	
	/** The total cost. */
	private int totalCost;
	
	/**
	 * Instantiates a new booking bean.
	 */
	public BookingBean() {
		this.id=0; //id booking
		this.dateOfBooking="DEFAULT";	
		this.flightIds=0; //id plane
		this.numberOfSeats=0;
		this.accountId=0;
		this.userId=0;
		this.totalCost=0;
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
	 * Gets the date of booking.
	 *
	 * @return the date of booking
	 */
	public String getDateOfBooking() {
		return dateOfBooking;
	}

	/**
	 * Sets the date of booking.
	 *
	 * @param dateOfBooking the new date of booking
	 */
	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	/**
	 * Gets the flight ids.
	 *
	 * @return the flight ids
	 */
	public int getFlightIds() {
		return flightIds;
	}

	/**
	 * Sets the flight ids.
	 *
	 * @param flightIds the new flight ids
	 */
	public void setFlightIds(int flightIds) {
		this.flightIds = flightIds;
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
	 * Gets the account id.
	 *
	 * @return the account id
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * Sets the account id.
	 *
	 * @param accountId the new account id
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the total cost.
	 *
	 * @return the total cost
	 */
	public int getTotalCost() {
		return totalCost;
	}

	/**
	 * Sets the total cost.
	 *
	 * @param totalCost the new total cost
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
}
