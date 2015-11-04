package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Models.Project;

public class TabProjects extends JPanel {
	
	public TabProjects(Project[] proj){
		
		super();
		this.setLayout(new BorderLayout());
		JPanel pan = new JPanel(new GridLayout(LoadWindow.tabModel.getProject().length,1,2,2));
		ArrayList<JButton> tabBut = new ArrayList<JButton>();
		for(int i=0;i<LoadWindow.tabModel.getProject().length;i++){
			String SubjectName= LoadWindow.tabModel.getSubject(proj[i].getSubject()).getName();
			String SubjectTitle= LoadWindow.tabModel.getSubject(proj[i].getSubject()).getTitle();
			String Supervisor = LoadWindow.tabModel.getParticipant(proj[i].getSupervisor()).getFirstName()+" "+LoadWindow.tabModel.getParticipant(proj[i].getSupervisor()).getLastName();
			String Customer = LoadWindow.tabModel.getParticipant(proj[i].getCustomer()).getFirstName()+" "+LoadWindow.tabModel.getParticipant(proj[i].getCustomer()).getLastName();
			String student ="";
			for(int j=0;j<LoadWindow.tabModel.getStudent().length;j++){
				if(LoadWindow.tabModel.getStudent()[j].getGroup().equals(proj[i].getGroup())){
					student += LoadWindow.tabModel.getStudent()[j].getFirstName()+" "+LoadWindow.tabModel.getStudent()[j].getLastName()+" - ";
				}
			}
			
			tabBut.add(new JButton("<html><center>"+proj[i].getId()+"<br>"+SubjectName+"<br>"+SubjectTitle+"<br>Groupe "+proj[i].getGroup()+" : "+student+"<br>Supervisor : "+Supervisor+"<br>Customer : "+Customer+"</center></html>"));
			pan.add(tabBut.get(i));
			
		}
		
		Color cButton = new Color(220, 220, 220);
		JButton delete = new JButton("Delete");
		JButton add = new JButton("Add");
		JButton save = new JButton("Save");
		JButton modify = new JButton("Modify");
		
		delete.setBackground(cButton);
		add.setBackground(cButton);
		save.setBackground(cButton);
		modify.setBackground(cButton);
		
		JPanel panButton = new JPanel(new FlowLayout());
		panButton.add(add);
		panButton.add(modify);
		panButton.add(delete);
		

		JScrollPane scroll = new JScrollPane(pan);
		this.add(scroll,BorderLayout.CENTER);
		this.add(panButton, BorderLayout.EAST);
		this.setVisible(true);
	}
	

	
	
}
