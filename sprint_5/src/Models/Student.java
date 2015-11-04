package Models;

public class Student {
	
	private String firstName;
	private String lastName;
	private String id;
	private String group;
	
	/**
	 * Constructor of the class Student
	 * @param pGroup The group of the student
	 * @param pId The id of the student
	 * @param pFirstName The first name of the student
	 * @param pLastName The last name of the student
	 */
	public Student(String pGroup,String pId,String pFirstName, String pLastName){
		this.firstName = pFirstName;
		this.lastName = pLastName;
		this.id = pId;
		this.group = pGroup;
	}
	
	/**
	 * Get the first name of a student
	 * @return the first name of the student
	 */
	public String getFirstName(){
		return this.firstName;
	}
	
	/**
	 * Set the first name of a student
	 * @param name the first name of the student
	 */
	public void setFirstName(String name){
		this.firstName = name;
	}
	
	/**
	 * Get the last name of a student
	 * @return the last name of the student
	 */
	public String getLastName(){
		return this.lastName;
	}
	
	/**
	 * Set the last name of a student
	 * @param name the last name of the student
	 */
	public void setLastName(String name){
		this.lastName = name;
	}
	
	/**
	 * Get the group of a student
	 * @return the group of the student
	 */
	public String getGroup(){
		return this.group;
	}
	
	/**
	 * Set the group of a student
	 * @param group the group of the student
	 */
	public void setGroup(String group){
		this.group = group;
	}
	
	/**
	 * Get the id of a student
	 * @return the id of the student
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * Set the id of a student
	 * @param pId the id of the student
	 */
	public void setId(String pId){
		this.id=pId;
	}
	
	
	public String print(){
		return "Groupe : "+this.group+"\nId :"+this.id+"\nFirst Name : "+this.firstName+"\nLast Name :"+this.lastName;
	}

	@Override
	public String toString() {
		return this.print();
	}
	
	
}
