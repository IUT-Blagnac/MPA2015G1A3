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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Models.Participant;
import Models.Student;
import Models.Subject;

public class ModifyWindow extends JFrame{
	
	private JTextField group;
	private JTextField id;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField name;
	private JTextField title;
	private JFrame frame;
	private Subject subject;
	private Student student;
	private Participant participant;
	
	
	ModifyWindow(Subject sub){
		
	
		super("Subject Creation");
		frame=this;
		subject = sub;
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
		
		id = new JTextField(sub.getId());
		id.setColumns(2);
		id.setEditable(false);
		name = new JTextField(sub.getName());
		name.setColumns(10);
		title = new JTextField(sub.getTitle());
		title.setColumns(20);
		
		JButton modify = new JButton("Modify");
		
		
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
		pan.add(modify, BorderLayout.SOUTH);
		this.add(pan);
		
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				LoadWindow.tabModel.getSubject(subject.getId()).setName(name.getText());
				LoadWindow.tabModel.getSubject(subject.getId()).setTitle(title.getText());
				TabSubjects.listModel.clear();
				for(int i=0;i<LoadWindow.tabModel.getSubject().length;i++){
					TabSubjects.listModel.addElement(LoadWindow.tabModel.getSubject()[i].getId()+"  :  "+LoadWindow.tabModel.getSubject()[i].getName());
				}
				dispose();
			}
		});
		
	}
	
	ModifyWindow(Student stu){
		
		super("Student Creation");
		frame=this;
		student = stu;
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
		
		id = new JTextField(stu.getId());
		id.setColumns(2);
		id.setEditable(false);
		group = new JTextField(stu.getGroup());
		group.setColumns(3);
		firstName = new JTextField(stu.getFirstName());
		firstName.setColumns(10);
		lastName = new JTextField(stu.getLastName());
		lastName.setColumns(10);
		
		JButton modify = new JButton("Modify");
		
		
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
		pan.add(modify, BorderLayout.SOUTH);
		this.add(pan);
		
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				LoadWindow.tabModel.getStudent(student.getId()).setGroup(group.getText());
				LoadWindow.tabModel.getStudent(student.getId()).setFirstName(firstName.getText());
				LoadWindow.tabModel.getStudent(student.getId()).setLastName(lastName.getText());
				TabGroups.listModelStu.clear();
				for(int i=0;i<LoadWindow.tabModel.getStudent().length;i++){
					TabGroups.listModelStu.addElement(LoadWindow.tabModel.getStudent()[i].getId()+"  :  "+LoadWindow.tabModel.getStudent()[i].getGroup()+" - "+LoadWindow.tabModel.getStudent()[i].getFirstName()+" "+LoadWindow.tabModel.getStudent()[i].getLastName());
				}
				dispose();
			}
		});
		
		
		
		
	}

ModifyWindow(Participant par){
		
		super("Student Creation");
		frame=this;
		participant = par;
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
		
		id = new JTextField(par.getId());
		id.setColumns(2);
		id.setEditable(false);
		firstName = new JTextField(par.getFirstName());
		firstName.setColumns(10);
		lastName = new JTextField(par.getLastName());
		lastName.setColumns(10);
		
		JButton create = new JButton("Modify");
		
		
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
				
				
				LoadWindow.tabModel.getParticipant(participant.getId()).setFirstName(firstName.getText());
				LoadWindow.tabModel.getParticipant(participant.getId()).setLastName(lastName.getText());
				TabParticipants.listModelPar.clear();
				for(int i=0;i<LoadWindow.tabModel.getParticipant().length;i++){
					TabParticipants.listModelPar.addElement(LoadWindow.tabModel.getParticipant()[i].getId()+"  :  "+LoadWindow.tabModel.getParticipant()[i].getFirstName()+" "+LoadWindow.tabModel.getParticipant()[i].getLastName());
				}
				dispose();
				
			}
		});	
	}
}
