package ass1;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * RandomFlights generate random information for the number of flights required
 * by the FlightResults.jsp page. It is used only for this assignment. Next assignments it
 * will be replaced by some database functionality.
 *
 */
public class RandomFlights {
	
	/**
	 * Generate random values to fulfill FlightInfo objects present at RandomFlights
	 * @param nFlights - the number of flight results setted by the FlightResults.jsp
	 */
	public RandomFlights(int nFlights) {
		super();
		rn = new Random();
		flights = new ArrayList<FlightInfo>(nFlights);
		for(int i = 0; i < nFlights; ++i) {
			FlightInfo fInfo = new FlightInfo();
			fInfo.setArrivalTime(new Integer(Math.abs(rn.nextInt()%24)).toString() +
					"h" + new Integer(Math.abs(rn.nextInt()%60)).toString());
			fInfo.setDepartureTime(new Integer(Math.abs(rn.nextInt()%24)).toString() +
					"h" + new Integer(Math.abs(rn.nextInt()%60)).toString());
			fInfo.setnStops(Math.abs(rn.nextInt()%4));
			fInfo.setCost(rn.nextFloat()*300f + 40f);
			flights.add(fInfo);
		}
	}
	
	/**
	 * Function to get the FlightInfo object at index position.
	 * @param index - the index of the desired object
	 * @return - the FlightInfo object at index position
	 */
	public FlightInfo getFlight(int index) {
		return flights.get(index);
	}
	
	ArrayList<FlightInfo> flights;
	static Random rn; 
}
