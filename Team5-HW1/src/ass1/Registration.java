package ass1;

import java.io.IOException;
import java.sql.SQLException;








import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 * The Vue of this servlet is implemented in the JSP file: Registration.file
 * 
 */

 
public class Registration extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use constructor.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Nothing done here.
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
	 * 1) Get the parameters: Username and password
	 * 2) Ask User.java if the username already exists.
	 * 3) If not add the user to the database  and go to Login.jsp else stay on the page
	 * @see User.java
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get request parameters for userID and password
        String user = Filter.cleanParameter(request.getParameter("user"));
        String name = Filter.cleanParameter(request.getParameter("name"));
        String fullname = Filter.cleanParameter(request.getParameter("fullname"));
        System.out.println(name);
        if (name=="")
    	{
    		name="Name not provided";
    	}
        String adress = Filter.cleanParameter(request.getParameter("adress"));
        if (adress=="")
    	{
        	adress="Adress not provided";
    	}
        String pwd = Filter.cleanParameter(request.getParameter("pwd"));
        System.out.println("You try to register with username: "+user+" and psw: "+pwd);
        
        try {
			if (UserSQL.registration_successfull(user, pwd,fullname))
			{
				System.out.println("Registration successful");
				//We now can add a line in the organization table and the client table in the database:
				UserSQL.update_client_organization(name, adress, user);
				response.sendRedirect(response.encodeRedirectURL("Login.jsp"));
				
			}else{
				System.out.println("This username is already taken");
				response.sendRedirect(response.encodeRedirectURL("Registration.jsp"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
