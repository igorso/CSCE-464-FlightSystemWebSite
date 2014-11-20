package ass1;
import beans.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;


// TODO: Auto-generated Javadoc
/**
 * The Class BookingSearchSQL. search for the previous booking of a user
 */
public class BookingSearchSQL {
	
	/** The conn. */
	public Connection conn;

	/**
	 * Instantiates a new booking search sql.
	 *
	 * @param host the host
	 * @param db the db
	 * @param user the user
	 * @param password the password
	 */
	public BookingSearchSQL(String host, String db, String user, String password){
		this.conn = this.initiateConnection(host, db, user, password);
	}
	
	/**
	 * Look the bookings of a specific user.
	 *
	 * @param userData the user data
	 * @return a list of booking in an array list
	 * @throws SQLException the SQL exception
	 */
	public static ArrayList<BookingBean> lookBooking(UserBean userData) throws SQLException{
		
		//We get the data from the bean parameter:
		BookingSearchSQL jdbc = new BookingSearchSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		
		//Format the date in a good way:
		int userId=userData.getId();
		
		
		//Creation of the parameters for the query:
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(userId);
	
		
		System.out.println("We are looking to for the booking of " +userId);
		
		ResultSet rs1=null;
		
		rs1 = jdbc.queryDB("SELECT *"
				+ "FROM bookings "
				+ "WHERE user_id=? "
				, param);
	
		BookingBean result;
		ArrayList<BookingBean> listBooking =  new ArrayList<BookingBean>();
		if (rs1 != null){
			System.out.println("Printing results...");
			while (rs1.next()){
				result= new BookingBean();
				result.setId(rs1.getInt("id")); 
				result.setDateOfBooking(rs1.getString("date_of_booking")); 
				result.setFlightIds(rs1.getInt("flight_ids"));
				result.setNumberOfSeats(rs1.getInt("number_of_seats"));
				result.setAccountId(rs1.getInt("account_id"));
				result.setUserId(userId);
				result.setTotalCost(rs1.getInt("total_cost"));	
				listBooking.add(result);
			}
		}
		
		jdbc.conn.close();
		return(listBooking);
		
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
			return null;
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
