package Models;

/**
 * Class Participant
 * @author Group 1A3
 *
 */
public class Participant {
	
	private String firstName;
	private String lastName;
	private String id;

	/**
	 * Main constructor of the class Participant
	 * @param pId the ID of the Participant
	 * @param pFirstName the first name of the Participant
	 * @param pLastName the last name of the Participant
	 */
	
	public Participant(String pId,String pFirstName, String pLastName){
		this.firstName = pFirstName;
		this.lastName = pLastName;
		this.id = pId;
	}
	
	/**
	 * get the first name of a Participant
	 * @return the first name of the Participant
	 */
	public String getFirstName(){
		return this.firstName;
	}
	
	/**
	 * Set the first name of a Participant
	 * @param name first name of a Participant
	 */
	public void setFirstName(String name){
		this.firstName = name;
	}
	
	/**
	 * Get the last name of a participant
	 * @return the last name of the Participant
	 */
	public String getLastName(){
		return this.lastName;
	}
	
	/**
	 * Set the last name of a participant
	 * @param name  Last name of the participant
	 */
	public void setLastName(String name){
		this.lastName = name;
	}
	
	/**
	 * Get the id of a Participant
	 * @return the id of the Participant
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * Set the ID of a Participant
	 * @param pId the id of the Participant
	 */
	public void setId(String pId){
		this.id=pId;
	}

}
