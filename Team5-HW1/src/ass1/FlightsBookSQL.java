package ass1;

import java.sql.*;
import java.util.ArrayList;
import beans.*;

import beans.FlightSearchBean;

/**
 * The Class FlightsBookSQL looks if there is enough seat left in the flight
 */
public class FlightsBookSQL {
	
	/** The conn. */
	public Connection conn;

	/**
	 * Instantiates a new flights book sql.
	 *
	 * @param host the host
	 * @param db the db
	 * @param user the user
	 * @param password the password
	 */
	public FlightsBookSQL(String host, String db, String user, String password){
		this.conn = this.initiateConnection(host, db, user, password);
	}
	
	/**
	 * Seats available.
	 *
	 * @param parameters the details of the flight
	 * @param numberSeats the number seats
	 * @return true, if there is enough seats
	 * @throws SQLException the SQL exception
	 */
	public static boolean SeatsAvailable(DetailedFlightBean parameters) throws SQLException{
		FlightsBookSQL jdbc = new FlightsBookSQL("cse.unl.edu", "cse464", "sheili", "]34Dr3");
		
		//This function looks if there is still seats available in the Plane:
		int capacity, reserved;
		//Creation of the parameters for the query:
			ArrayList<Object> param =  new ArrayList<Object>();
			int idPlane=parameters.getPlane();
			int idFlight=parameters.getId();
			String type=parameters.getFlightClass();
			int numberSeats=parameters.getNumberOfSeat();
			System.out.println(type);
			
			param.add(idPlane);
			param.add(idFlight);
			
			ResultSet rs1=null;
			//There is 3 different queries depending on the type of seats:
			if (type.equals("economy")) //economy class
			{	
				rs1 = jdbc.queryDB("SELECT  "
					+ "planes.economy_capacity AS capacity, "
					+ "flights.economy_reserved AS reserved "		
					+"FROM (flights JOIN planes ON (flights.plane=planes.id))"
					+ "WHERE flights.plane=? "
					+ "AND flights.id=?"
					, param);
			}
			if (type.equals("business")) //business class
			{	
				rs1 = jdbc.queryDB("SELECT  "
					+ "planes.business_capacity AS capacity, "
					+ "flights.business_reserved AS reserved "		
					+"FROM (flights JOIN planes ON (flights.plane=planes.id))"
					+ "WHERE flights.plane=? "
					+ "AND flights.id=?"
					, param);
			}
			if (type.equals("first")) //1st class
			{	
				rs1 = jdbc.queryDB("SELECT "
					+ "planes.first_class_capacity AS capacity, "
					+ "flights.first_class_reserved AS reserved "
					+"FROM (flights JOIN planes ON (flights.plane=planes.id))"
					+ "WHERE flights.plane=? "
					+ "AND flights.id=?"
					, param);
			}
			if (rs1 == null){
				System.out.println("Error: The request did not work");
				return(false);
			}
			else
			{
				if(rs1.next()){
					capacity=rs1.getInt("capacity");
					reserved=rs1.getInt("reserved");
					System.out.print ("Capacity= "+rs1.getString("capacity"));
					System.out.println(" Reserved= "+rs1.getString("reserved"));
					if(rs1.next()) {
						System.out.println("Error: two planes with the same number");
						return(false);
					}
					
					jdbc.conn.close();
					
					if(capacity-reserved>=numberSeats)
					{
						//System.out.println("There is enough seats left");
						jdbc.conn.close();
						return(true);	
					}else
					{
						System.out.println("Not enough seats available");
						jdbc.conn.close();
						return(false);	
					}
					
				}
				else
				{
					System.out.println("Error: The flight"+(idPlane)+" was not found");
					jdbc.conn.close();
					return(false);
				}

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
