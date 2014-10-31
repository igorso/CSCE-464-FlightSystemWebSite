package ass1;

import java.io.IOException;

import ass1.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 * The view of this Servlet is implemented in Login.jsp
 * This class receives and processes form data in the doPost method
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	 * 1) Get the parameters: Username and password
	 * 2) Ask User.java if they correspond registered user.
	 * 3) If the login is successfull, go to LoginSuccess.jsp   else go to Register.jsp
	 * @see User.java
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        System.out.println("You try to register with username: "+user+" and psw: "+pwd);
        
        if (User.login_successfull(user, pwd)==true)
        {
    		HttpSession session = request.getSession(true);
    		session.setAttribute("session_username", user);
        	
        	System.out.println("Login successful");
    		response.sendRedirect("LoginSuccess.jsp");
        	
        }else{
       		System.out.println("You are not registered yet");
       		response.sendRedirect("Login.jsp");
        }
	}

}
