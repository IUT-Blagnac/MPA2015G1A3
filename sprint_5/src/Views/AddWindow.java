package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Models.Participant;
import Models.Student;
import Models.Subject;

public class AddWindow extends JFrame{
	
	private JTextField group;
	private JTextField id;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField name;
	private JTextField title;
	private JFrame frame;
	
	
	AddWindow(Subject[] sub){
		
	
		super("Subject Creation");
		frame=this;
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		JPanel panGrid = new JPanel();
		JPanel pan = new JPanel(new BorderLayout(30,30));
		
		JLabel header = new JLabel("Subject creation");
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setFont(new Font(getName(), 1, 18));
		
		JLabel lId = new JLabel("Id : ");
		JLabel lName = new JLabel("Name : ");
		JLabel lTitle = new JLabel("Title : ");
		
		id = new JTextField("");
		id.setColumns(2);
		name = new JTextField("");
		name.setColumns(10);
		title = new JTextField("");
		title.setColumns(20);
		
		JButton create = new JButton("Create");
		
		
		panGrid.add(lId);
		panGrid.add(id);
		panGrid.add(lName);
		panGrid.add(name);
		panGrid.add(lTitle);
		panGrid.add(title);
		panGrid.add(new JLabel(""));
		panGrid.add(new JLabel(""));
		pan.add(header,BorderLayout.NORTH);
		pan.add(panGrid,BorderLayout.CENTER);
		pan.add(create, BorderLayout.SOUTH);
		this.add(pan);
		
		
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Subject subject =new Subject(id.getText(),name.getText(),title.getText());
				LoadWindow.tabModel.addSubject(subject);
				TabSubjects.listModel.addElement(id.getText()+"  :  "+name.getText());
				frame.dispose();
				
			}

		});
		
	}
	
	AddWindow(Student[] stu){
		
		super("Student Creation");
		frame=this;
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		JPanel panGrid = new JPanel();
		JPanel pan = new JPanel(new BorderLayout(30,30));
		
		JLabel header = new JLabel("Student creation");
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setFont(new Font(getName(), 1, 18));
		
		JLabel lId = new JLabel("Id : ");
		JLabel lGroup = new JLabel("Group : ");
		JLabel lFirstName = new JLabel("Frist Name : ");
		JLabel lLastName = new JLabel("Last Name : ");
		
		id = new JTextField("");
		id.setColumns(2);
		group = new JTextField("");
		group.setColumns(3);
		firstName = new JTextField("");
		firstName.setColumns(10);
		lastName = new JTextField("");
		lastName.setColumns(10);
		
		JButton create = new JButton("Create");
		
		
		panGrid.add(lId);
		panGrid.add(id);
		panGrid.add(lGroup);
		panGrid.add(group);
		panGrid.add(lFirstName);
		panGrid.add(firstName);
		panGrid.add(lLastName);
		panGrid.add(lastName);
		pan.add(header,BorderLayout.NORTH);
		pan.add(panGrid,BorderLayout.CENTER);
		pan.add(create, BorderLayout.SOUTH);
		this.add(pan);
		
		
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Student student =new Student(id.getText(),group.getText(),firstName.getText(),lastName.getText());
				LoadWindow.tabModel.addStudent(student);
				TabGroups.listModelStu.addElement(id.getText()+"  :  "+group.getText()+" - "+firstName.getText()+" "+lastName.getText());
				frame.dispose();
			}

		});
		
		
		
		
	}

AddWindow(Participant[] par){
		
		super("Participant Creation");
		frame=this;
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		JPanel panGrid = new JPanel();
		JPanel pan = new JPanel(new BorderLayout(30,30));
		
		JLabel header = new JLabel("participant creation");
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setFont(new Font(getName(), 1, 18));
		
		JLabel lId = new JLabel("Id : ");
		JLabel lGroup = new JLabel("Group : ");
		JLabel lFirstName = new JLabel("Frist Name : ");
		JLabel lLastName = new JLabel("Last Name : ");
		
		id = new JTextField("");
		id.setColumns(2);
		firstName = new JTextField("");
		firstName.setColumns(10);
		lastName = new JTextField("");
		lastName.setColumns(10);
		
		JButton create = new JButton("Create");
		
		
		panGrid.add(lId);
		panGrid.add(id);
		panGrid.add(lFirstName);
		panGrid.add(firstName);
		panGrid.add(lLastName);
		panGrid.add(lastName);
		pan.add(header,BorderLayout.NORTH);
		pan.add(panGrid,BorderLayout.CENTER);
		pan.add(create, BorderLayout.SOUTH);
		this.add(pan);
		
		
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Participant participant =new Participant(id.getText(),firstName.getText(),lastName.getText());
				LoadWindow.tabModel.addParticipant(participant);
				TabParticipants.listModelPar.addElement(id.getText()+"  :  "+firstName.getText()+" "+lastName.getText());
				frame.dispose();
				
			}
		});	
	}
}
