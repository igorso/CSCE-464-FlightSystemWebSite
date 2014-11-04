package beans;

public class DetailedFlightBean {
	private int id; //id flight
	private int plane; //id plane
	private int cost; //cost of 1 flight
	private String operator;
	private String source;
	private String destination;
	private int firstClassReserved;
	private int businessReserved;
	private int economyReserved;
	private String departure;
	private String arrival;
	private String flightClass;
	private int numberOfSeat;
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlane() {
		return plane;
	}
	public void setPlane(int plane) {
		this.plane = plane;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		
		this.operator = operator;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
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
	public int getFirstClassReserved() {
		return firstClassReserved;
	}
	public void setFirstClassReserved(int firstClassReserved) {
		this.firstClassReserved = firstClassReserved;
	}
	public int getBusinessReserved() {
		return businessReserved;
	}
	public void setBusinessReserved(int businessReserved) {
		this.businessReserved = businessReserved;
	}
	public int getEconomyReserved() {
		return economyReserved;
	}
	public void setEconomyReserved(int economyReserved) {
		this.economyReserved = economyReserved;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public int getNumberOfSeat() {
		return numberOfSeat;
	}
	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}
	
}
