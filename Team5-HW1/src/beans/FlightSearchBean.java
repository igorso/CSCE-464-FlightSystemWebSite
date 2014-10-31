package beans;

public class FlightSearchBean {
	private String source;
	private String destination;
	private String dateOfTravel;
	private int numberOfSeats;
	private String flightClass;
	
	public FlightSearchBean() {
		this.source = "MIA";
		this.destination = "ORD";
		this.dateOfTravel = "2014-09-30 11:41:00";
		this.numberOfSeats = 1;
		this.flightClass = "business";
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(String dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	
	
}
