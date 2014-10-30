package ass1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DetailedFlightBean;

public class FlightResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor
     * @see HttpServlet#HttpServlet()
     */
    public FlightResults() {
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
	 * 1) Query the database for the Flight Number that was given by the FlightResults.jsp
	 * 2) Put that information in a DetailedFlightBean
	 * 3) Forward to ViewAndBook.jsp
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flightNumber = 0;
		String sFlightNumber = request.getParameter("flightNumber");
		if((sFlightNumber != null) && (!sFlightNumber.trim().equals("")))
			flightNumber = Integer.parseInt(sFlightNumber);
				
		// Query the database to search for the selected flight
		DetailedFlightBean flight = queryDataBase(flightNumber);
		// Using scope="session" because the flight details will be used till confirmation of transaction
		HttpSession session = request.getSession();
		session.setAttribute("selectedFlight", flight);

		//Dispatch results to view JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAndBook.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void populateDetailedFlightBean(HttpServletRequest request) {
	}
	
	protected DetailedFlightBean queryDataBase(int flightNumber) {
		return new DetailedFlightBean(flightNumber);
	}
}
