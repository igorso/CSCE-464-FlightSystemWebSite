package ass1;

import java.util.ArrayList;
import java.util.Random;

import beans.FlightResultBean;
import beans.FlightSearchBean;

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
	public RandomFlights(FlightSearchBean flightBean, int nFlights) {
		super();
		rn = new Random();
		flights = new ArrayList<FlightResultBean>(nFlights);
		for(int i = 0; i < nFlights; ++i) {
			FlightResultBean fInfo = new FlightResultBean();
			fInfo.setNumberOfFlight(i);
			fInfo.setDate(flightBean.getDateOfTravel());
			fInfo.setArrivalTime(new Integer(Math.abs(rn.nextInt()%24)).toString() +
					"h" + new Integer(Math.abs(rn.nextInt()%60)).toString());
			fInfo.setDepartureTime(new Integer(Math.abs(rn.nextInt()%24)).toString() +
					"h" + new Integer(Math.abs(rn.nextInt()%60)).toString());
			fInfo.setNumberOfStops(Math.abs(rn.nextInt()%4));
			fInfo.setCost(rn.nextFloat()*300f + 40f);
			flights.add(fInfo);
		}
	}
	
	/**
	 * Function to get the FlightInfo object at index position.
	 * @param index - the index of the desired object
	 * @return - the FlightInfo object at index position
	 */
	public FlightResultBean getFlight(int index) {
		return flights.get(index);
	}

	public ArrayList<FlightResultBean> getFlights() {
		return flights;
	}
	
	private ArrayList<FlightResultBean> flights;
	private static Random rn; 
}
