package beans;

/**
 * The Class Client Bean.
 */
public class ClientBean {
	private UserBean user;
	private OrganizationBean organization;
	
	//Getters and Setters:
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public OrganizationBean getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationBean organization) {
		this.organization = organization;
	}

}
