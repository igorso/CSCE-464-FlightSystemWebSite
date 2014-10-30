package beans;

public class DetailedFlightBean {
	private int id;
	private int plane;
	private String operator;
	private String source;
	private String destination;
	private int firstClassReserved;
	private int businessReserved;
	private int economyReserved;
	private String departure;
	private String arrival;
	
	public DetailedFlightBean(int id) {
		this.id = id;
		this.plane = 42;
		this.operator = "Operator";
		this.source = "Source";
		this.destination = "Destination";
		this.firstClassReserved = 10;
		this.businessReserved = 12;
		this.economyReserved = 18;
		this.departure = "10/27/2014";
		this.arrival = "10/28/2014";
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
	
}
