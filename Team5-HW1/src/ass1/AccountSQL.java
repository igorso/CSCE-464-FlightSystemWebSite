package ass1;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class AccountSQL {
	public Connection conn;

	public AccountSQL(String host, String db, String user, String password){
		this.conn = this.initiateConnection(host, db, user, password);
	}
	
	/**
	 * This class loads the MySQL Driver and Connects to the entered database.
	 * @param host Host computer ("cse.unl.edu")
	 * @param db
	 * @param user
	 * @param password 
	 * @return A live connection or null
	 */
	
	
	public static boolean transaction_successfull(
		DetailedFlightBean parameters, 
		int account_id, 
		int holder_id, 
		int routing_number, 
		int user_id, //Hard to get...
		int totalCost, 
		int numberOfSeats) throws SQLException{
		int flightId =parameters.getId();
	
		
		
		
		if (Payement(account_id,holder_id, routing_number,totalCost))
		{
		System.out.println("Congrats! We are now uptdating the flights!");
			
		
		AccountSQL jdbc = new AccountSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		
		//Insert a line in booking:
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(flightId);//What does it mean exactly????
		param.add(numberOfSeats);
		param.add(account_id);
		param.add(user_id);
		param.add(totalCost);
		
		param.add(Timestamp.valueOf("2014-09-30 11:41:00")); //date

		
		jdbc.updateDB("insert into bookings(date_of_booking,flight_ids,number_of_seats, accounts_id, user_id,total_cost) "
				+ "values(NOW() ,? ,? ,?,?,? );"  
            ,param); 
		param.clear();
		System.out.println("The booking table has been updated ");
		
		//Insert a line in booking flights:
		param.add(45);//change it later/have to do a request to get the ID,
		param.add(flightId);
		jdbc.updateDB("insert into bookings_flights (booking_id, flights_id) "
				+ "values(?,?);"  
            ,param); 		
		System.out.println("The booking_flights table has been updated ");
		
		return (true);
		}
		else
		{
			System.out.println("Sorry it did not work... You are too poor!");
		return(false);
		}
	}
	public static boolean Payement(int account_id, int holder_id, int routing_number, int cost) throws SQLException
	{
		AccountSQL jdbc = new AccountSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(account_id);
		param.add(holder_id);
		param.add(routing_number);
		param.add(cost);
		
		
		ResultSet rs1 = jdbc.queryDB("SELECT balance, id "
				+ "FROM accounts "
				+ " WHERE account_id=?"
				+ "AND holder_id=?"
				+ "AND routing_number=?"
				, param);
		param.clear();
		if (rs1 != null){
			
			
			if(rs1.next()){
				
				System.out.print("We found the account, there is "+rs1.getString("balance")+ " $ on the account");
				if (rs1.getInt("balance")>cost)
				{
					System.out.println("That is enough. We proceed to the payement");
					
					param.add(rs1.getInt("balance")-cost);
					jdbc.updateDB("UPDATE accounts "
							+ "Set balance=? "
							+ "Where accounts."
 
		            ,param); 
					
					jdbc.conn.close();
					return(true);
					
				}
				else
				{
					System.out.println("Not enough money");					
					jdbc.conn.close();
					return(false);
				}
				
			}
			
			System.out.println("Account not found");
			jdbc.conn.close();
			return(false);
		}else {
			System.out.println("A problem appeared");
			jdbc.conn.close();
			return(true);
		}
		
		
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
