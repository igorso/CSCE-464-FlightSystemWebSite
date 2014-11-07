package ass1;
import beans.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;


/**
 * The Class FlightsSearchSQL. Search for flights in the database
 */
public class FlightsSearchSQL {
	
	/** The conn. */
	public Connection conn;

	/**
	 * Instantiates a new flights search sql.
	 *
	 * @param host the host
	 * @param db the db
	 * @param user the user
	 * @param password the password
	 */
	public FlightsSearchSQL(String host, String db, String user, String password){
		this.conn = this.initiateConnection(host, db, user, password);
	}
	
	/**
	 * Look flights.
	 *This function looks for flights corresponding to the parameters in the database.
	 *It looks only for flights without stop.
	 * @param parameters the parameters given by the user and stored in the bean
	 * @return the array list
	 * @throws SQLException the SQL exception
	 */
	public static ArrayList<FlightResultBean> lookFlights(FlightSearchBean parameters) throws SQLException{
		
		//We get the data from the bean parameter:
		FlightsSearchSQL jdbc = new FlightsSearchSQL("cse.unl.edu", "cse464", "sheili", "]34Dr3");
		
		//Format the date in a good way:
		String Sdate=parameters.getDateOfTravel();
		java.util.Date Ddate = null;
		try {
			Ddate = new SimpleDateFormat("MM/dd/yyyy").parse(Sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date=df.format(Ddate) +" 00:00:00.0";;//"2015-01-01 10:28:00.0";
		//System.out.println("The date is "+ date);
		
		//Get the other parameters:
		String source=parameters.getSource();
		String destination=parameters.getDestination();
		String flightClass=parameters.getFlightClass();
		
		//Creation of the parameters for the query:
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(source);
		param.add(destination);
		
		param.add(Timestamp.valueOf(date));
		Timestamp oneDayAfter=Timestamp.valueOf(date);
		oneDayAfter.setTime(oneDayAfter.getTime()+24*3600*1000);
		param.add((oneDayAfter));
		
		/*
		ArrayList<Object> param2 =  new ArrayList<Object>();		
		param2.add(source);
		param2.add(destination);
		param2.add(Timestamp.valueOf(date));		
		Timestamp oneDayAfter2=Timestamp.valueOf(date);
		oneDayAfter2.setTime(oneDayAfter2.getTime()+24*3600*1000);
		param2.add((oneDayAfter2));
		*/
		
		System.out.println("We are looking to flights from "+source+" to "+destination+" between "+date +" and " +oneDayAfter);
		
		ResultSet rs1=null;
		
		rs1 = jdbc.queryDB("SELECT flights.source AS source, "
				+ "flights.destination AS destination,"
				+ "flights.id AS id,"
				+ "flights.departure As departureTime, "
				+ "flights.arrival As arrivalTime, "
				+ "flights.plane As pID "
				+ "FROM flights "
				+ "WHERE flights.source=? "
				+ "AND flights.destination=?"
				+ "AND	flights.departure>? "
				+ "AND flights.departure<? "
				, param);
	
		FlightResultBean result;
		ArrayList<FlightResultBean> listFlight =  new ArrayList<FlightResultBean>();
		if (rs1 != null){
			System.out.println("Printing results...");
			while (rs1.next()){
				result= new FlightResultBean();
				result.setNumberOfFlight(rs1.getInt("id"));
				result.setDepartureTime(rs1.getString("departureTime"));
				result.setArrivalTime(rs1.getString("arrivalTime"));
				Date dateFlight=rs1.getDate("arrivalTime");
				result.setDate(dateFlight.toString());
				result.setNumberOfStops(0);
				
				Random generator = new Random();
				int randomNumber = 50+generator.nextInt(50);
				result.setCost(randomNumber);
				
				
				System.out.print(rs1.getString("source")+"  ");
				System.out.print(rs1.getString("destination")+"  ");
				System.out.print(rs1.getTimestamp("departureTime")+"  ");
				System.out.print(rs1.getTimestamp("arrivalTime")+"  ");
				System.out.print("Flight ID"+rs1.getString("id")+"  ");
				System.out.print("Plane ID  "+rs1.getString("pID")+"  ");
				System.out.println();
				
				listFlight.add(result);
			}
		}
		/*
		System.out.println("One step flights:");
		ResultSet rs2=null;
		if (type==0) //economy class
		{
			rs2 = jdbc.queryDB(
					"SELECT "
						+ "f1.source AS source, "
						+ "f1.destination AS stop, "
						+ "f2.destination AS end, "								
						+ "f1.departure As f1depart, "
						+ "f1.arrival As f1arrival, "
						+ "f2.departure As f2depart, "
						+ "f2.arrival As f2arrival, "
						+ "f2.plane As f2ID, "
						+ "f1.plane As f1ID "
						+ "FROM ((flights AS f1 JOIN flights AS f2 ON f1.destination=f2.source)) "
					+ "WHERE f1.source=? "
						+ "AND f2.destination=? "
						+ "AND	f1.departure>? "
						+ "AND f1.departure<? "
						+ "AND TIMEDIFF(f2.departure, f1.arrival)>6000 " //Minimum time of a stop is 1hour
						+ "AND TIMEDIFF(f2.departure, f1.arrival)<60000 "//The unit is minute/100 =>10hours=10*60*100=60000
						
					, param2);
		}
		if (rs2 != null){
			System.out.println("Printing results...");
			while (rs2.next()){
				System.out.print("From " + rs2.getString("source")+"  ");
				System.out.print("Stop in " +rs2.getString("stop")+"  ");
				System.out.print("End "+rs2.getString("end")+"  ");
				System.out.print("1st Flight " +rs2.getString("f1ID")+ " from "+ rs2.getTimestamp("f1depart")+"  ");
				System.out.print("to "+ rs2.getTimestamp("f1arrival")+"  ");
				System.out.println("2nd Flight " +rs2.getString("f2ID")+ " from "+ rs2.getTimestamp("f2depart")+"  ");
				System.out.println("to "+ rs2.getTimestamp("f2arrival")+"  ");
				//System.out.print(rs2.getString("id")+"  ");
				//System.out.println(rs2.getString("seats"));				
			}
		}
		*/
		jdbc.conn.close();
		return(listFlight);
		
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
