package ass1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.FlightResultBean;
import beans.FlightSearchBean;
/**
 * The Class FlightSearch.
 */
public class FlightSearch extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor.
     *
     * @see HttpServlet#HttpServlet()
     */
    public FlightSearch() {
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
	 * 1) Fill the FlightSearchBean to maintain initial flight query through session
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String source= request.getParameter("source");
		String destination =request.getParameter("destination");
		String date =request.getParameter("date");
		String nSeats =request.getParameter("nSeats");
		String flightClass =request.getParameter("flightClass");
		
		
		
		FlightSearchBean flightBean;
		if(session.getAttribute("flightBean") == null) {
			System.out.println("We have to create a new search flight");
			flightBean = new FlightSearchBean();
		}
		else {
			System.out.println("We are taking it in the session");
			flightBean = (FlightSearchBean) session.getAttribute("flightBean");
			System.out.println("Source="+flightBean.getSource());
		}
		
		flightBean.setSource(source);
		flightBean.setDateOfTravel(date);
		flightBean.setDestination(destination);
		flightBean.setFlightClass(flightClass);
		flightBean.setNumberOfSeats(Integer.parseInt(nSeats));
		// Query the database to search for matching flight results
		ArrayList<FlightResultBean> dbResults=null;
		try {
			
			dbResults = FlightsSearchSQL.lookFlights(flightBean);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Using scope="request" because the specific results just interest
		// the FlightResults.jsp page
		request.setAttribute("numberOfResults", dbResults.size());
		request.setAttribute("dbResults", dbResults);
		
		//Dispatch results to view JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("FlightResults.jsp");
		dispatcher.forward(request, response);
	}
}
