package ass1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.FlightResultBean;
import beans.FlightSearchBean;

public class FlightSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor
     * @see HttpServlet#HttpServlet()
     */
    public FlightSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Nothing is done here
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Processing of the form DATA:
	 * 1) Fill the FlightSearchBean to maintain initial flight query through session
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		populateFlightBean(request);
		
		// Query the database to search for matching flight results
		ArrayList<FlightResultBean> dbResults = queryDataBase();
		
		// Using scope="request" because the specific results just interest
		// the FlightResults.jsp page
		request.setAttribute("numberOfResults", dbResults.size());
		request.setAttribute("dbResults", dbResults);
		
		//Dispatch results to view JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("FlightResults.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void populateFlightBean(HttpServletRequest request) {
		HttpSession session = request.getSession();
		FlightSearchBean flightBean = new FlightSearchBean();
		session.setAttribute("flightBean", flightBean);
		
		String source = (String) request.getAttribute("source");
		if((source != null) && (!source.trim().equals("")))
			flightBean.setSource(source);
		
		String destination = (String) request.getAttribute("destination");
		if((destination != null) && (!destination.trim().equals("")))
			flightBean.setDestination(destination);
		
		String dateOfTravel = (String) request.getAttribute("date");
		if((dateOfTravel != null) && (!dateOfTravel.trim().equals("")))
			flightBean.setDateOfTravel(dateOfTravel);
		
		String numberOfSeats = (String) request.getAttribute("nSeats");
		if((numberOfSeats != null) && (!numberOfSeats.trim().equals("")))
			flightBean.setNumberOfSeats(Integer.parseInt(numberOfSeats));
		
		String flightClass = (String) request.getAttribute("flightClass");
		if((flightClass != null) && (!flightClass.trim().equals("")))
			flightBean.setFlightClass(flightClass);
	}
	
	protected ArrayList<FlightResultBean> queryDataBase() {
		RandomFlights flightGenerator = new RandomFlights(7);
		return flightGenerator.getFlights();
	}
}
