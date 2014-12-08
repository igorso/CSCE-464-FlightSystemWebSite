package ass1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DetailedFlightBean;
import beans.FlightSearchBean;

/**
 * The Class FlightResults.
 */
public class FlightResults extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor.
     *
     * @see HttpServlet#HttpServlet()
     */
    public FlightResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Nothing is done here.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Processing of the form DATA:
	 * 1) Query the database for the Flight Number that was given by the FlightResults.jsp
	 * 2) Put that information in a DetailedFlightBean
	 * 3) Forward to ViewAndBook.jsp
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flightNumber = 0;
		int cost=0;
		String sFlightNumber = Filter.cleanParameter(request.getParameter("flightNumber"));
		if((sFlightNumber != null) && (!sFlightNumber.trim().equals("")))
			flightNumber = Integer.parseInt(sFlightNumber);
		String costS = Filter.cleanParameter(request.getParameter("cost"));
		if((costS != null) && (!costS.trim().equals("")))
			cost = Integer.parseInt(costS);
		
		HttpSession session =request.getSession();
		FlightSearchBean parameters= (FlightSearchBean) session.getAttribute("flightBean");
		// Query the database to search for the selected flight
		
		DetailedFlightBean flight = null;
		try {
			flight = FlightDetailSQL.getDetail(parameters,flightNumber,cost);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Using scope="session" because the flight details will be used till confirmation of transaction
		session.setAttribute("selectedFlight", flight);

		//Dispatch results to view JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL("ViewAndBook.jsp"));
		dispatcher.forward(request, response);
	}

}
