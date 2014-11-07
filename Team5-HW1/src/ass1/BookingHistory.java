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

import beans.BookingBean;
import beans.UserBean;

/**
 * The Class BookingHistory is a servlet getting the booking history of a user.
 */
public class BookingHistory extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor.
     *
     * @see HttpServlet#HttpServlet()
     */
    public BookingHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * doGet call doPost.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
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
			
		HttpSession session =request.getSession();
		UserBean parameters= (UserBean) session.getAttribute("userBean");
		// Query the database to search for the selected flight
		ArrayList<BookingBean> listBooking =  null;
		
		try {
			listBooking = BookingSearchSQL.lookBooking(parameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Using scope="session" because the flight details will be used till confirmation of transaction
		request.setAttribute("bookingSearch", listBooking);

		//Dispatch results to view JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookingHistory.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
