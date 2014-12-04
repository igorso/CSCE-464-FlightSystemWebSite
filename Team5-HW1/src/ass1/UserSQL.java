package ass1;

import java.sql.*;
import java.util.ArrayList;

import beans.OrganizationBean;

// TODO: Auto-generated Javadoc
/**
 * The Class UserSQL.
 */
public class UserSQL {
	
	/** The conn. */
	public Connection conn;

	/**
	 * Instantiates a new user sql.
	 *
	 * @param host the host
	 * @param db the db
	 * @param user the user
	 * @param password the password
	 */
	public UserSQL(String host, String db, String user, String password){
		this.conn = this.initiateConnection(host, db, user, password);
	}
	
	/**
	 * This class loads the MySQL Driver and Connects to the entered database.
	 *
	 * @param email the email (this has to be unique in the database)
	 * @param password the password
	 * @param fullname 
	 * @return A live connection or null
	 * @throws SQLException the SQL exception
	 */
	
	
	public static boolean registration_successfull(String email, String password, String fullname) throws SQLException{
		int id=5;//What is this ID?
		if (user_exists(email))
		{
			System.out.println("The user "+email +" is already in the database, please enter an other email");
			return false;
		}
		else
		{
		UserSQL jdbc = new UserSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(id);
		param.add(email);
		param.add(password);
		
		param.add(Timestamp.valueOf("2014-09-30 11:41:00")); //date
		param.add(fullname);
		
		jdbc.updateDB("insert into users(id, email,password,date_of_birth,fullname) "
				+ "values(?,?,?,?,?);"  
            ,param); 
		
		System.out.println("The user "+email +" has been added in the database");
		return(true);
		}
	}
	
	public static String get_user_id(String email) throws SQLException{
		UserSQL jdbc = new UserSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(email);
		
		
		ResultSet rs1 = jdbc.queryDB("SELECT users.user_id AS id, users.email AS email "
				+ "FROM users "
				+ " WHERE users.email=?", param);
		if (rs1 != null){
			
			
			if(rs1.next()){
				
				System.out.print("User found  ");
				
				System.out.print ("User_ID="+rs1.getString("id"));
				System.out.println("  Email="+rs1.getString("email"));
				String S=rs1.getString("id");
				if(rs1.next()) {
					System.out.println("Error: There is at least 2 users with the same email");
					return("");
				}
				
				
				jdbc.conn.close();
				return(S);
				
			}
			
			System.out.println("User not found");
			jdbc.conn.close();
			return("");
		}else {
			System.out.println("A problem appeared in the database connection");
			jdbc.conn.close();
			return("");
		}

	}
	
	public static String get_user_fullname(String email) throws SQLException{
		UserSQL jdbc = new UserSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(email);
		
		
		ResultSet rs1 = jdbc.queryDB("SELECT users.fullname AS fullname, users.email AS email "
				+ "FROM users "
				+ " WHERE users.email=?", param);
		if (rs1 != null){
			
			
			if(rs1.next()){
				
				System.out.print("User found  ");
				
				System.out.print ("User_ID="+rs1.getString("fullname"));
				System.out.println("  Email="+rs1.getString("email"));
				String S=rs1.getString("fullname");
				if(rs1.next()) {
					System.out.println("Error: There is at least 2 users with the same email");
					return("");
				}
				
				
				jdbc.conn.close();
				return(S);
				
			}
			
			System.out.println("User not found");
			jdbc.conn.close();
			return("");
		}else {
			System.out.println("A problem appeared in the database connection");
			jdbc.conn.close();
			return("");
		}

	}
	
	public static String get_org_id() throws SQLException{
		UserSQL jdbc = new UserSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		
		
		ResultSet rs1 = jdbc.queryDB("SELECT MAX(organization_id) as ID from organization", param);
		if(rs1.next()){
			
			return(rs1.getString("ID"));
			
		}
		return("ERROR");
	}
	
	public static OrganizationBean find_organization(String email) throws SQLException
	{
		String userID=get_user_id(email);
		UserSQL jdbc = new UserSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(userID);
		OrganizationBean orgBean=new OrganizationBean();
		
		ResultSet rs1 = jdbc.queryDB("SELECT organization.name AS name, organization.adress AS adress "
				+ "FROM organization,client "
				+ " WHERE client.user_id=? AND"
				+ " client.organization_id=organization.organization_id", param);
		if (rs1 != null){
			
			
			if(rs1.next()){
				
				System.out.print("Org founded");
				
				System.out.print ("Org name="+rs1.getString("name"));
				System.out.println("Org adress="+rs1.getString("adress"));
				orgBean.setAdress(rs1.getString("name"));
				orgBean.setName(rs1.getString("adress"));
				
				jdbc.conn.close();
				return(orgBean);
				
			}
			
			System.out.println("Org not found");
			jdbc.conn.close();
			return(orgBean);
		}
		return null;
		
	}
	public static boolean update_client_organization(String name, String adress, String email) throws SQLException{
		
		//We add the new line in the organization:
		UserSQL jdbc = new UserSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(name);
		param.add(adress);
		jdbc.updateDB("insert into organization(name,adress) "
				+ "values(?,?);"  
            ,param); 
		
		System.out.println("The organization "+name +" has been added in the database");
		//Get the id of the user:
				String user_id=get_user_id(email);
				System.out.println("User id (in the update function)"+user_id);
				
		//Get the last id of the organization:
				String org_id=get_org_id();
				System.out.println("Org id (in the update function)"+org_id);
				
		//Insert a line in the client table:
				param =  new ArrayList<Object>();
				param.add(user_id);
				param.add(org_id);
				jdbc.updateDB("insert into client(user_id,organization_id) "
						+ "values(?,?);"  
		            ,param); 
				
				System.out.println("The client: User id: "+user_id +" Org id:"+org_id +" has been added in the database");		
				
				

		return(true);
		
	}
	
	
	/**
	 * User_exists.
	 *
	 * @param email the email
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public static boolean user_exists(String email) throws SQLException
	{
		UserSQL jdbc = new UserSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(email);
		
		
		ResultSet rs1 = jdbc.queryDB("SELECT users.user_id AS id, users.email AS email "
				+ "FROM users "
				+ " WHERE users.email=?", param);
		if (rs1 != null){
			
			
			if(rs1.next()){
				
				System.out.print("User found  ");
				
				System.out.print ("User_ID="+rs1.getString("id"));
				System.out.println("  Email="+rs1.getString("email"));
				
				if(rs1.next()) {
					System.out.println("Error: There is at least 2 users with the same email");
					return(true);
				}
				
				jdbc.conn.close();
				return(true);
				
			}
			
			System.out.println("User not found");
			jdbc.conn.close();
			return(false);
		}else {
			System.out.println("A problem appeared in the database connection");
			jdbc.conn.close();
			return(true);
		}
		
		
	}
	
	/**
	 * Login_successfull.
	 *
	 * @param email the email
	 * @param password the password
	 * @return 1 if the login is successfull, 0 else 
	 * @throws SQLException the SQL exception
	 */
	public static int login_successfull(String email, String password) throws SQLException
	{
		//Test login
		//return 1 if the login is successfull, 0 else
		UserSQL jdbc = new UserSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(email);
		param.add(password);
		
		
		ResultSet rs1 = jdbc.queryDB("SELECT users.user_id AS id, users.email AS email, users.password AS pass "
				+ "FROM users "
				+ " WHERE users.email=?"
				+ "AND users.password=?", param);
		if (rs1 != null){
			
			
			while (rs1.next()){
				System.out.println("Login Successful");
				
				System.out.print ("User ID="+rs1.getString("id"));
				System.out.print("  Email="+rs1.getString("email"));
				System.out.println("  Pass="+rs1.getString("pass"));
				int id=rs1.getInt("id");
				
				jdbc.conn.close();
				return(id);
			}
			System.out.println("Login not Successful, please register");
			jdbc.conn.close();
			return(-1);
		}else {
			System.out.println("A problem appeared");
			jdbc.conn.close();
			return(-1);
		}
	}
	
	/**
	 * Query db.
	 *
	 * @param <T> the generic type
	 * @param query the query
	 * @param sqlParam the sql param
	 * @return the result set
	 */
	public <T> ResultSet queryDB(String query, ArrayList<T> sqlParam){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);

			int i = 1;
			for (T a : sqlParam){
				//System.out.println(a.getClass());
				if (a.getClass() == String.class){
					ps.setString(i, (String)a);
					//System.out.println(String.format("I'm a String!  %d - %s", i, (String) a));
				}else if(a.getClass() == Integer.class){
					ps.setInt(i, (Integer)a);
					//System.out.println(String.format("I'm an Integer!  %d - %d", i, (Integer) a));
				}else if(a.getClass() == Double.class){
					ps.setDouble(i, (Double)a);
					//System.out.println(String.format("I'm a Double!  %d - %f", i, (Double) a));
				}else if (a.getClass() == Timestamp.class){
					ps.setTimestamp(i, (Timestamp)a);
					//System.out.println(String.format("I'm a DateTime!  %d - %s", i, a.toString()));
				}
				i++;
			}
			rs = ps.executeQuery();
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	/**
	 * Update db.
	 *
	 * @param <T> the generic type
	 * @param query the query
	 * @param sqlParam the sql param
	 * @return the int
	 */
	public <T> int updateDB(String query, ArrayList<T> sqlParam){
		PreparedStatement ps = null;
		int rs = 0;
		try{
			ps = conn.prepareStatement(query);

			int i = 1;
			for (T a : sqlParam){
				//System.out.println(a.getClass());
				if (a.getClass() == String.class){
					ps.setString(i, (String)a);
					//System.out.println(String.format("I'm a String!  %d - %s", i, (String) a));
				}else if(a.getClass() == Integer.class){
					ps.setInt(i, (Integer)a);
					//System.out.println(String.format("I'm an Integer!  %d - %d", i, (Integer) a));
				}else if(a.getClass() == Double.class){
					ps.setDouble(i, (Double)a);
					//System.out.println(String.format("I'm a Double!  %d - %f", i, (Double) a));
				}else if (a.getClass() == Timestamp.class){
					ps.setTimestamp(i, (Timestamp)a);
					//System.out.println(String.format("I'm a DateTime!  %d - %s", i, a.toString()));
				}
				i++;
			}
			rs = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
			return 0;
		}
		return rs;
	}
	
	/**
	 * Initiate connection.
	 *
	 * @param host the host
	 * @param db the db
	 * @param user the user
	 * @param password the password
	 * @return the connection
	 */
	public Connection initiateConnection(String host, String db, String user, String password){

		Connection dbConnection = null;

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//System.out.println("Driver Loaded");
		}catch(Exception x){
			System.out.println("Unable to load the driver class");
		}


		try{
			String connString = String.format("jdbc:mysql://%s:3306/%s?user=%s&password=%s", host, db, user, password);
			dbConnection = DriverManager.getConnection(connString);
			//System.out.println("Connected to Database");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Couldn't get Connection");
			return null;
		}
		return dbConnection;
	}
}
