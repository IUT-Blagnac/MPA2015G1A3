package Views;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Models.Participant;
import Models.Project;
import Models.Student;
import Models.Subject;

public class ViewWindow extends JFrame{
	
	ViewWindow(Subject subject){
		super(subject.getName());
		GridLayout grid = new GridLayout(6,1);
		this.setLayout(grid);
		
		Project pProject = LoadWindow.tabModel.getProject(subject.getId());
		Participant pSupervisor= LoadWindow.tabModel.getParticipant(pProject.getSupervisor());
		Participant pCustomer = LoadWindow.tabModel.getParticipant(pProject.getCustomer());
		
		JLabel id = new JLabel("<html><b>Id :</b>  "+subject.getId()+"</html>");
		JLabel name = new JLabel("<html><b>Name :</b>  "+subject.getName()+"</html>");
		JLabel title = new JLabel("<html><b>Title :</b>  "+subject.getTitle()+"</html>");
		JLabel group = new JLabel("<html><b>Group :</b> "+pProject.getGroup()+"</html>");
		JLabel supervisor = new JLabel("<html><b>Supervisor :</b> "+pSupervisor.getFirstName()+" "+pSupervisor.getLastName()+"</html>");
		JLabel customer = new JLabel("<html><b>Customer :</b> "+pCustomer.getFirstName()+" "+pCustomer.getLastName()+"</html>");
		
		this.add(id);
		this.add(name);
		this.add(title);
		this.add(group);
		this.add(supervisor);
		this.add(customer);
	}
	
	
	ViewWindow(Student student){
		super(student.getFirstName()+" "+student.getLastName());
		GridLayout grid = new GridLayout(6,1);
		this.setLayout(grid);
		
		Project pProject = LoadWindow.tabModel.getProject(student.getId());
		Subject pSubject = new Subject("Undefined","Undefined","Undefined");
		for(int i=0;i<LoadWindow.tabModel.getProject().length;i++){
			if(LoadWindow.tabModel.getProject()[i].getGroup().equals(student.getGroup())){
				pSubject = LoadWindow.tabModel.getSubject(LoadWindow.tabModel.getProject()[i].getId());
			}
		}
		
		
		JLabel id = new JLabel("Id :  "+student.getId());
		JLabel group = new JLabel("Group :  "+student.getGroup());
		JLabel firstname = new JLabel("First name :  "+student.getFirstName());
		JLabel lastname = new JLabel("Last name : "+student.getLastName());
		JLabel subject = new JLabel("Subject : "+pSubject.getId()+" : "+pSubject.getName());
		
		this.add(id);
		this.add(group);
		this.add(firstname);
		this.add(lastname);
		this.add(subject);
	}

}
