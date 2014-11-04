package beans;

public class FlightResultBean {
	private int numberOfFlight;
	private String date;
	private String departureTime;
	private String arrivalTime;
	private int numberOfStops;
	private int cost;
	
	public int getNumberOfFlight() {
		return numberOfFlight;
	}
	public void setNumberOfFlight(int numberOfFlight) {
		this.numberOfFlight = numberOfFlight;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getNumberOfStops() {
		return numberOfStops;
	}
	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
