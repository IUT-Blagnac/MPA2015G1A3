package Models;

public class Project {
	private String id;
	private String group;
	private String subject;
	private String customer;
	private String supervisor;
	
	/**
	 * Constructor of the class Project
	 * @param pId the ID of the project
	 * @param pGroup the group linked to the project
	 * @param pSubject the name of the subject
	 * @param pCustomer the customer of the project
	 * @param pSupervisor the supervisor of the project
	 */
	public Project(String pId,String pGroup,String pSubject, String pCustomer, String pSupervisor){
		this.id = pId;
		this.group = pGroup;
		this.subject = pSubject;
		this.customer = pCustomer;
		this.supervisor = pSupervisor;
	}
	
	/**
	 * Get the id of a project
	 * @return the id of the project
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * Set the id of a project
	 * @param pId the id of the project
	 */
	public void setId(String pId){
		this.id = pId;
	}
	
	/**
	 * Get the group assigned to the project
	 * @return the id of the group assigned to the project
	 */
	public String getGroup(){
		return this.group;
	}
	
	/**
	 * Set the group assigned to the project
	 * @param pGroup the id of the group
	 */
	public void setGroup(String pGroup){
		this.group = pGroup;
	}
	
	/**
	 * Get the subject of the project
	 * @return the subject of the project
	 */
	public String getSubject(){
		return this.subject;
	}
	
	/**
	 * Set the subject of a project
	 * @param pSubject the new name of the subject
	 */
	public void setSubject(String pSubject){
		this.subject=pSubject;
	}
	
	/**
	 * Get the customer of a project
	 * @return the customer of the project
	 */
	public String getCustomer(){
		return this.customer;
	}
	
	/**
	 * Set the customer of a project
	 * @param pCustomer the customer of the project
	 */
	public void setCustomer(String pCustomer){
		this.customer=pCustomer;
	}
	
	/**
	 * Get the supervisor of a project
	 * @return the supervisor of the project
	 */
	public String getSupervisor(){
		return this.supervisor;
	}
	
	/**
	 * Set the supervisor of a project
	 * @param pSupervisor the supervisor of the project
	 */
	public void setSupervisor(String pSupervisor){
		this.supervisor=pSupervisor;
	}
}
