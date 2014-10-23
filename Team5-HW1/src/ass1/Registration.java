package ass1;

import java.io.IOException;
import ass1.User;

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
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use constructor
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Nothing done here
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
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
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        System.out.println("You try to register with username: "+user+" and psw: "+pwd);
        
        if (User.registration_successfull(user, pwd)==true)
        {
    		System.out.println("Registration successful");
    		response.sendRedirect("Login.jsp");
        	
        }else{
       		System.out.println("This username is already taken");
       		response.sendRedirect("Registration.jsp");
        }

	}

}
