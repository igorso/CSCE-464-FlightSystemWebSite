package beans;

public class BookingBean {
	private int id; //id booking


	private String dateOfBooking;	
	private int flightIds; //id plane
	private int numberOfSeats;
	private int accountId;
	private int userId;
	private int totalCost;
	
	public BookingBean() {
		this.id=0; //id booking
		this.dateOfBooking="DEFAULT";	
		this.flightIds=0; //id plane
		this.numberOfSeats=0;
		this.accountId=0;
		this.userId=0;
		this.totalCost=0;
		}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public int getFlightIds() {
		return flightIds;
	}

	public void setFlightIds(int flightIds) {
		this.flightIds = flightIds;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
}
