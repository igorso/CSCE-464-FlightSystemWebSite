package ass1;
import beans.*;

import java.sql.*;

import java.util.ArrayList;
import java.util.Random;


public class FlightDetailSQL {
	public Connection conn;

	public FlightDetailSQL(String host, String db, String user, String password){
		this.conn = this.initiateConnection(host, db, user, password);
	}
	
	public static DetailedFlightBean getDetail(FlightSearchBean parameters, int id, int cost) throws SQLException{
		
		//We get the data from the bean parameter:
		FlightDetailSQL jdbc = new FlightDetailSQL("cse.unl.edu", "cse464", "sheili", "]34Dr3");
		String date=parameters.getDateOfTravel();
		String source=parameters.getSource();
		String destination=parameters.getDestination();
		String flightClass=parameters.getFlightClass();
		
		//Creation of the parameters for the query:
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(id);
		
		System.out.println("We are looking to flights number" +id);
		
		ResultSet rs1=null;
		
		rs1 = jdbc.queryDB("SELECT flights.source AS source, "
				+ "flights.destination AS destination,"
				+ "flights.id AS id, "
				+ "flights.operator AS operator, "
				+ "flights.departure As departureTime, "
				+ "flights.arrival As arrivalTime, "
				+ "flights.source As source, "
				+ "flights.destination As destination, "
				+ "flights.plane As pID "
				+ "FROM flights "
				+ "WHERE flights.id=?"
				, param);
	
		DetailedFlightBean result=null;
		if (rs1 != null){
			System.out.println("Printing results...");
			while (rs1.next()){
				result= new DetailedFlightBean();
				result.setId(rs1.getInt("id"));
				result.setPlane(rs1.getInt("pid"));
				result.setOperator(rs1.getString("operator"));
				result.setDeparture(rs1.getString("departureTime"));
				result.setArrival(rs1.getString("arrivalTime"));
				result.setFlightClass(flightClass);
				result.setSource(rs1.getString("source"));
				result.setDestination(rs1.getString("destination"));
				result.setCost(cost);
				System.out.print(rs1.getString("source")+"  ");
				System.out.print(rs1.getString("destination")+"  ");
				System.out.print(rs1.getTimestamp("departureTime")+"  ");
				System.out.print(rs1.getTimestamp("arrivalTime")+"  ");
				System.out.print("Flight ID"+rs1.getString("id")+"  ");
				System.out.print("Plane ID  "+rs1.getString("pID")+"  ");
				System.out.println();
				
				
			}
		}
		
		jdbc.conn.close();
		return(result);
		
	}
	
	
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
