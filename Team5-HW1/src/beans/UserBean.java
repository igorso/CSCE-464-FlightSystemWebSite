package beans;

public class UserBean {
	private int id; //id of the user (field user_id of the database)	
	private String email;
	private String password;
	
	public UserBean() {
		this.id = 0;
		this.email = "stanislas.heili@gmail.com";
		this.password = "1";
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
		this.password = password;
	}
}
