package ass1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * The Class ClearShoppingCart is a servlet that erases the shopping cart after check out.
 */
public class ClearShoppingCart extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor.
     *
     * @see HttpServlet#HttpServlet()
     */
    public ClearShoppingCart() {
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
	 * Do post. Erase the session's shopping cart attribute. 
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Just put a null value to the shopping cart and redirect to FlightSearch
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		session.setAttribute("shoppingCart", null);

		//Dispatch results to view JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("FlightSearch.jsp");
		dispatcher.forward(request, response);
	}
}