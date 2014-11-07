package beans;

/**
 * The Class UserBean.
 */
public class UserBean {
	
	/** The id. */
	private int id; //id of the user (field user_id of the database)	
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/**
	 * Instantiates a new user bean.
	 */
	public UserBean() {
		this.id = 0;
		this.email = "stanislas.heili@gmail.com";
		this.password = "1";
		}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		
		this.password = password;
	}
}
