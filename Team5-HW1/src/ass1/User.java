package ass1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
/**
 * User class managing the users of the website
 * This class can both get new informations about users or set new users in the system
 */

public class User {
	/**
	 * login_successfull looks in the property file if the user exists
	 *  @param  usrname  the username of the person trying to login
	 * @param  password the password of the person trying to login
	 * @return     true if the login is successful, false else
	 */
	public static boolean login_successfull(String usrname, String password) throws FileNotFoundException {
		Hashtable<String, String> users = get_infos();
		System.out.println(users.get(usrname)+" "+password);
		if (user_exists(usrname)==false){
			return false;
		}
		if (users.get(usrname).equals(password)) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * get_infos() get all the users in the property file
	 * @param  there is not parameters needed
	 * @return     return a Hashtable<String, String> of the users in the file
	 */
	public static Hashtable<String, String> get_infos() throws FileNotFoundException{
		
		Scanner s = new Scanner(new File("C:\\Users\\Igor\\Desktop\\UNL\\CSCE 464 - InternetSys&Programm\\FlightSystem\\Team5-HW1\\users.properties"));
		//To do use a relative path
		String read_password=new String();
		String read_usrname=new String();
		Hashtable<String, String> ht = new Hashtable<String,String>();
	  	while (s.hasNext()){
			read_usrname=s.next();
			if (s.hasNext()) {
				read_password=s.next();
			}else{
				read_password="";
				System.out.println("Problem in the property file");
			}
			
			ht.put(read_usrname, read_password);
		}
		System.out.println(ht);
		s.close();
		return ht;
	}
	
	
	/**
	 * user_exists check if a username already exists in the database
	 * @param  usrname  : the username of the person trying to login
	 *  @return true if the user exists, false else
	 */
	public static boolean user_exists(String usrname) throws FileNotFoundException {
		Hashtable<String, String> users = get_infos();
		if (users.get(usrname)==null) {
				return false;
			}else{
				return true;
			}
	
	}
	/**
	 * registration_successfull add a user in the database.
	 *  @param  usrname  the username of the person trying to register
	 * @param  password the password of the person trying to register
	 * @return     true if the registration is successful, false else

	 */
	public static boolean registration_successfull(String usrname, String password) throws IOException{
		if (user_exists(usrname)==true) {
			//this username is already taken, please choose an other
			return false;
		} else {
			FileWriter writer = new FileWriter("C:\\Users\\Igor\\Desktop\\UNL\\CSCE 464 - InternetSys&Programm\\FlightSystem\\Team5-HW1\\users.properties",true);
		    writer.write(usrname+" "+password+"\n");
	    	writer.close();
			return true;
		}
	}
}
