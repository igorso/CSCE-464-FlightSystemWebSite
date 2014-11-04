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
	
	
	public static int transaction_successfull(
		DetailedFlightBean parameters, 
		int account_id, 
		int holder_id, 
		int routing_number, 
		int user_id
		) 
				throws SQLException{
		int flightId =parameters.getId();
		int numberOfSeats=parameters.getNumberOfSeat(); 
		int totalCost=parameters.getCost()*numberOfSeats;
		
		int payementError= Payement(account_id,holder_id, routing_number,totalCost);
		
		if (payementError==0)
		{
			System.out.println("Payement Successful! We are now uptdating our database!");
				
			
			AccountSQL jdbc = new AccountSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
			
			//Insert a line in booking:
			ArrayList<Object> param =  new ArrayList<Object>();
			param.add(flightId);//What does it mean exactly????
			param.add(numberOfSeats);
			param.add(account_id);
			param.add(user_id);
			param.add(totalCost);
			//param.add(Timestamp.valueOf("2014-09-30 11:41:00")); the date is now added automatically
			jdbc.updateDB("insert into bookings(date_of_booking,flight_ids,number_of_seats, account_id, user_id,total_cost) "
					+ "values(NOW(),? ,? ,? ,? ,? );"  
	            ,param); 
			param.clear();
			
			//Get the last ID of booking:
			PreparedStatement ps = jdbc.conn.prepareStatement("SELECT id As LastID FROM bookings ORDER BY id DESC LIMIT 1;");
			ResultSet rs2 = ps.executeQuery();
			int lastID=0;
			
			if (rs2 != null){
				if(rs2.next()){
					lastID=rs2.getInt("LastID");
					}
				else
				{
					System.out.println("Last ID not found in the database");
					return(3);
				}
			}else {
				System.out.println("A problem appeared in the database connection");	
				return(3);
			}
			
			//Insert a line in booking flights:
			param.add(lastID);
			param.add(flightId);
			jdbc.updateDB("insert into booking_flights (booking_id, flight_id) "
				+ "values(?,?);"  
				,param); 		
			
			System.out.println("Update of the database finished");
			
			return (0);
		}
		else
		{
			System.out.println("Sorry the payement operation did not work, there is the error : " + payementError);
			return(payementError);
		}
	}
	public static int Payement(int id, int holder_id, int routing_number, int cost) throws SQLException
	{
		//Return 0 if everything was OK
		//Return 1 if the account was not found
		//Return 2 if there is not enough money
		//Return 3 if there is a database problem
		AccountSQL jdbc = new AccountSQL("cse.unl.edu", "sheili", "sheili", "]34Dr3");
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(id);
		param.add(holder_id);
		param.add(routing_number);
		//param.add(cost);
		
		
		ResultSet rs1 = jdbc.queryDB("SELECT balance, id "
				+ "FROM accounts "
				+ " WHERE id=? "
				+ "AND holder_id=? "
				+ "AND routing_number=?"
				, param);
		param.clear();
		if (rs1 != null){
			
			
			if(rs1.next()){
				
				System.out.print("We found the account, there is "+rs1.getString("balance")+ "$ on the account");
				if (rs1.getInt("balance")>cost)
				{
					System.out.println("It is enough to pay "+String.valueOf(cost)+"$. We proceed to the payement");
					param.clear();

					param.add(rs1.getInt("balance")-cost);
					param.add(id);

					jdbc.updateDB("UPDATE accounts "
							+ "Set balance=? "
							+ "Where accounts.id=?"
 
		            ,param); 
					
					jdbc.conn.close();
					return(0);
				}
				else
				{
					System.out.println("Not enough money");					
					jdbc.conn.close();
					return(2);
				}
				
			}
			
			System.out.println("Account not found");
			jdbc.conn.close();
			return(1);
		}else {
			System.out.println("A problem appeared in the connection to the database");
			jdbc.conn.close();
			return(3);
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
