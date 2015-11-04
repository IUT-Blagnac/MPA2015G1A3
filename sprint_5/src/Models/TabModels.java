package Models;

public class TabModels {
	
	private  Student[] tabStu;
	private  Subject[] tabSub;
	private  Participant[] tabPar;
	private Project[] tabPro;
	 
	public TabModels(String pathStu,String pathSub,String pathPar,String pathPro){
		
		this.tabStu = createTabStudent(pathStu);
		this.tabSub = createTabSubjects(pathSub);
		this.tabPar = createTabParticipant(pathPar);
		this.tabPro = createTabProject(pathPro);		
	
	}
	public  Student[] createTabStudent(String path){
		
		CSVReader read = new CSVReader(path);
		String[][] tabTemp = read.getLines();
		Student[] pTabStu;
		pTabStu = new Student[tabTemp.length-1];
		for(int i=0;i<tabTemp.length-1;i++){
			pTabStu[i] = new Student(tabTemp[i+1][0],tabTemp[i+1][1],tabTemp[i+1][2],tabTemp[i+1][3]);
		}
		
		return pTabStu;
	}
	public  Subject[] createTabSubjects(String path){
		
		CSVReader read = new CSVReader(path);
		String[][] tabTemp = read.getLines();
		Subject[] pTabSub;
		pTabSub = new Subject[tabTemp.length-1];
		for(int i=0;i<tabTemp.length-1;i++){
			pTabSub[i] = new Subject(tabTemp[i+1][0],tabTemp[i+1][1],tabTemp[i+1][2]);
		}
		
		return pTabSub;
	}
	public Participant[] createTabParticipant(String path){
		
		CSVReader read = new CSVReader(path);
		String[][] tabTemp = read.getLines();
		Participant[] pTabPar;
		pTabPar = new Participant[tabTemp.length-1];
		for(int i=0;i<tabTemp.length-1;i++){
			pTabPar[i] = new Participant(tabTemp[i+1][0],tabTemp[i+1][1],tabTemp[i+1][2]);
		}
		
		return pTabPar;
		
	}
	public Project[] createTabProject(String path){
		
		CSVReader read = new CSVReader(path);
		String[][] tabTemp = read.getLines();
		Project[] pTabPro;
		pTabPro = new Project[tabTemp.length-1];
		for(int i=0;i<tabTemp.length-1;i++){
			pTabPro[i] = new Project(tabTemp[i+1][0],tabTemp[i+1][1],tabTemp[i+1][2],tabTemp[i+1][3],tabTemp[i+1][4]);
		}
		
		return pTabPro;
		
	}
	
	public Student[] getStudent(){	
		return this.tabStu;
	}
	public Project[] getProject(){	
		return this.tabPro;
	}
	public Subject[] getSubject(){	
		return this.tabSub;
	}
	public Participant[] getParticipant(){
		return this.tabPar;
	}
	
	public Subject getSubject(int index){
		return this.tabSub[index];
	}
	public Student getStudent(int index){
		return this.tabStu[index];
	}
	public Participant getParticipant(int index){
		return this.tabPar[index];
	}
	public Project getProject(int index){
		return this.tabPro[index];
	}
	
	
	public Student getStudent(String id){
		Student stu = new Student("Undefined","Undefined","Undefined","Undefined");
		for(int i=0;i<this.getStudent().length;i++){
			if(this.getStudent()[i].getId().equals(id)){
				stu = this.getStudent()[i];
			}
		}
		return stu;
	}
	public Subject getSubject(String id){
		Subject sub = new Subject("Undefined","Undefined","Undefined");
		for(int i=0;i<this.getSubject().length;i++){
			if(this.getSubject()[i].getId().equals(id)){
				sub = this.getSubject()[i];
			}
		}
		return sub;
	}
	public Participant getParticipant(String id){
		Participant par = new Participant("Undefined","Undefined","Undefined");
		for(int i=0;i<this.getParticipant().length;i++){
			if(this.getParticipant()[i].getId().equals(id)){
				par = this.getParticipant()[i];
			}
		}
		return par;
	}
	public Project getProject(String id){
		Project pro = new Project("Undefined","Undefined","Undefined","Undefined","Undefined");
		for(int i=0;i<this.getProject().length;i++){
			if(this.getProject()[i].getId().equals(id)){
				pro = this.getProject()[i];
			}
		}
		return pro;
	}
	
	public void removeSubject(int index){
		Subject[] tabTemp = new Subject[this.tabSub.length-1];
		for(int i=0;i<index;i++){
			tabTemp[i]=this.tabSub[i];
		}
		for(int i=index;i<tabTemp.length;i++){
			tabTemp[i]=this.tabSub[i+1];
		}
		this.tabSub = tabTemp;
	}
	public void removeStudent(int index){
		Student[] tabTemp = new Student[this.tabStu.length-1];
		for(int i=0;i<index;i++){
			tabTemp[i]=this.tabStu[i];
		}
		for(int i=index;i<tabTemp.length;i++){
			tabTemp[i]=this.tabStu[i+1];
		}
		this.tabStu = tabTemp;
	}
	public void removeParticipant(int index){
		Participant[] tabTemp = new Participant[this.tabPar.length-1];
		for(int i=0;i<index;i++){
			tabTemp[i]=this.tabPar[i];
		}
		for(int i=index;i<tabTemp.length;i++){
			tabTemp[i]=this.tabPar[i+1];
		}
		this.tabPar = tabTemp;
	}
	public void removeProject(int index){
		Project[] tabTemp = new Project[this.tabSub.length-1];
		for(int i=0;i<index;i++){
			tabTemp[i]=this.tabPro[i];
		}
		for(int i=index;i<tabTemp.length;i++){
			tabTemp[i]=this.tabPro[i+1];
		}
		this.tabPro = tabTemp;
	}	
	
	public void addSubject(Subject sub){
		Subject[] tabTemp = new Subject[this.tabSub.length+1];
		for(int i=0;i<tabTemp.length-1;i++){
			tabTemp[i]=this.tabSub[i];
		}
		tabTemp[tabTemp.length-1]=sub;
		this.tabSub=tabTemp;
	}
	public void addStudent(Student stu){
		Student[] tabTemp = new Student[this.tabStu.length+1];
		for(int i=0;i<tabTemp.length-1;i++){
			tabTemp[i]=this.tabStu[i];
		}
		tabTemp[tabTemp.length-1]=stu;
		this.tabStu=tabTemp;
	}
	public void addParticipant(Participant par){
		Participant[] tabTemp = new Participant[this.tabPar.length+1];
		for(int i=0;i<tabTemp.length-1;i++){
			tabTemp[i]=this.tabPar[i];
		}
		tabTemp[tabTemp.length-1]=par;
		this.tabPar=tabTemp;
	}
	public void addProject(Project pro){
		Project[] tabTemp = new Project[this.tabPro.length+1];
		for(int i=0;i<tabTemp.length;i++){
			tabTemp[i]=this.tabPro[i];
		}
		tabTemp[tabTemp.length]=pro;
		this.tabPro=tabTemp;
	}
	
	public String getIdProjectFromStudent(Student pStudent){
		String pId = pStudent.getId();
		String projet="";
		for(int i=0;i<this.tabPro.length;i++){
			if(this.tabPro[i].getGroup().equals(pId)){
				projet = this.tabPro[i].getId();
			}
		}
		return projet;
	}
	public String getIdProjectFromParticipant(Participant pParticipant){
		String pidPart = pParticipant.getId();
		String projet="";
		for(int i=0;i<this.tabPro.length;i++){
			if(this.tabPro[i].getCustomer().equals(pidPart) || this.tabPro[i].getSupervisor().equals(pidPart)){
				projet = this.tabPro[i].getId();
			}
		}
		return projet;
	}
	public Project getProjectFromSubject(Subject pSubject){
		String pidSub = pSubject.getId();
		Project projet = new Project("Undefined","Undefined","Undefined","Undefined","Undefined");
		for(int i=0;i<this.tabSub.length;i++){
			if(this.tabPro[i].getSubject().equals(pidSub)){
				projet = this.tabPro[i];
			}
		}
		return projet;
	}

}
