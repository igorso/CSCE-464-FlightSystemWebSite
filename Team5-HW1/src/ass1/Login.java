package ass1;

import java.io.IOException;
import java.sql.SQLException;








import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClientBean;
import beans.FlightSearchBean;
import beans.OrganizationBean;
import beans.UserBean;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Login
 * The view of this Servlet is implemented in Login.jsp
 * This class receives and processes form data in the doPost method
 */
public class Login extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	 * 1) Get the parameters: Username and password
	 * 2) Ask UserSQL.java if they correspond registered user.
	 * 3) If the login is successfull, go to LoginSuccess.jsp   else go to Register.jsp
	 * @see User.java
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.getSession().removeAttribute("userBean");
		
		//get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        
        UserBean userBean = new UserBean();
        userBean.setEmail(user);
        userBean.setPassword(pwd);
        
        ClientBean clientBean = new ClientBean();
        OrganizationBean orgBean=new OrganizationBean();
        
        System.out.println("You try to register with username: "+user+" and psw: "+pwd);
        
        try {
        	int userId=UserSQL.login_successfull(user, pwd); //return -1 if error, user_id if no error
			if (userId!=-1)
			{
				userBean.setId(userId);
				userBean.setFullName(UserSQL.get_user_fullname(user));
				HttpSession session = request.getSession(true);			
				//session.setAttribute("userBean", userBean);
				clientBean.setUser(userBean);
				
				orgBean=UserSQL.find_organization(user);
				clientBean.setOrganization(orgBean);
				System.out.println("Login successful");		
				session.setAttribute("clientBean", clientBean);
				response.sendRedirect(response.encodeRedirectURL("LoginSuccess.jsp"));
				
				
			}else{
				System.out.println("You are not registered yet");
				response.sendRedirect(response.encodeRedirectURL("Login.jsp"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
