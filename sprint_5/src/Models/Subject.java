package Models;

public class Subject {
	
	private String name;
	private String title;
	private String id;
	
	public Subject(String pId,String pName, String pTitle){
		this.name = pName;
		this.title = pTitle;
		this.id = pId;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String pName){
		this.name = pName;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String pTitle){
		this.title = pTitle;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String pId){
		this.id=pId;
	}

}
