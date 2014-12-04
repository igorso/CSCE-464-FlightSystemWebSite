package beans;

/**
 * The Class OrganizationBean.
 */
public class OrganizationBean {
	
	/** The name. */
	private String name;
	
	/** The adress. */
	private String adress;
	
	/**
	 * Instantiates a new organization bean.
	 */
	public OrganizationBean() {
		this.name = "DEFAULT NAME";
		this.adress = "DEFAULT ADRESS";
		}
	
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the adress.
	 *
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Sets the adress.
	 *
	 * @param adress the new adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	
}
