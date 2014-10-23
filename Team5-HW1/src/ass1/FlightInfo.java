package ass1;

/**
 * 
 * FlightInfo is just a data container for flight information besides what is
 * already present at the HTTP request. 
 * 
 * So, it contains arrival and departure time, number of stops and cost of the flight.
 * To accomplish its tasks, it has just getters and setters methods.
 * 
 */
public class FlightInfo {
	
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getnStops() {
		return nStops;
	}
	public void setnStops(int nStops) {
		this.nStops = nStops;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	private String arrivalTime;
	private String departureTime;
	private int nStops;
	private float cost;
}