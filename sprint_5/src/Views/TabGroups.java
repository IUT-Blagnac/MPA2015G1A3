package Views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import Models.CSVWriter;
import Models.Student;
import Models.Subject;
import Models.TabModels;

/**
 * Pane containing informations about the project
 * 
 * @author G1A3
 * @version 2.0
 *
 */


public class TabGroups extends JPanel {

	private JList list;
	private JScrollPane panTable;
	public static DefaultListModel listModelStu;
	private boolean overwrite = false;
	private JFrame frame;
	
	public TabGroups(Student[] tabStu) {
		super();
		this.setLayout(new BorderLayout());
		listModelStu = new DefaultListModel();
		for(int i=0;i<tabStu.length;i++){
			listModelStu.addElement(tabStu[i].getId()+"  :  "+tabStu[i].getGroup()+" - "+tabStu[i].getFirstName()+" "+tabStu[i].getLastName());
		}
		
		list = new JList(listModelStu);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new ActionJListGroup(list));
		panTable = new JScrollPane(list);
		
		Color cButton = new Color(220, 220, 220);
		JButton delete = new JButton("Delete");
		JButton add = new JButton("Add");
		JButton save = new JButton("Save");
		JButton modify = new JButton("Modify");
		
		delete.setBackground(cButton);
		add.setBackground(cButton);
		save.setBackground(cButton);
		modify.setBackground(cButton);
		
		JPanel panButton = new JPanel();
		panButton.add(add);
		panButton.add(delete);
		panButton.add(modify);
		panButton.add(save);
		this.add(panButton, BorderLayout.SOUTH);
		
		
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index =list.getSelectedIndex();
				if(!listModelStu.isEmpty() && index >= 0){
					Views.LoadWindow.tabModel.removeStudent(index);
					listModelStu.remove(index);
				}
			}
		});
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AddWindow crea = new AddWindow(Views.LoadWindow.tabModel.getStudent());
				crea.setLocationRelativeTo(null);
				crea.setVisible(true);
				crea.pack();
				
			}

		});
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ModifyWindow modif = new ModifyWindow(LoadWindow.tabModel.getStudent(list.getSelectedIndex()));
				modif.setLocationRelativeTo(null);
				modif.setVisible(true);
				modif.pack();
				
			}

		});
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Student[] tabStudent = Views.LoadWindow.tabModel.getStudent();
				String[][] newTab = new String[tabStudent.length+1][4];
				String[] title ={"id","Group","First Name","Last Name"};
				newTab[0] = title;
				for (int i = 1; i < newTab.length; i++) {
						newTab[i][0] = tabStudent[i-1].getId();
						newTab[i][1] = tabStudent[i-1].getGroup();
						newTab[i][2] = tabStudent[i-1].getFirstName();
						newTab[i][3] = tabStudent[i-1].getLastName();
					
				}

				File repertoireCourant = null;
				try {
					repertoireCourant = new File(".").getCanonicalFile();
					String rep = repertoireCourant.getPath().substring(0, repertoireCourant.getPath().length()-3)+"data";
					JFileChooser loader = new JFileChooser(rep);
					int returnVal = loader.showOpenDialog(null);
					String chemin = "" + loader.getSelectedFile();
					File test = new File(chemin);
					if(test.exists() && returnVal == JFileChooser.APPROVE_OPTION){
						message();
						if (overwrite){
							CSVWriter writer = new CSVWriter(newTab);
							writer.writeToFile(chemin);
							JOptionPane.showMessageDialog(frame,
									"Modifications have been saved here : "+chemin);
						}
				    }else if (returnVal == JFileChooser.APPROVE_OPTION){
				    	CSVWriter writer = new CSVWriter(newTab);
						writer.writeToFile(chemin);
						JOptionPane.showMessageDialog(frame,
								"Modifications have been saved here : "+chemin);
				    }
				} catch (IOException e1) {}
				
				
				
			}

		});
		
		
		this.add(panTable);
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setVisible(true);
		
		
		

	}
	
	private void message(){
		if (JOptionPane.showConfirmDialog(this, "This file already exists, do you want to overwrite it  ?", "Attention", JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION){
			overwrite=true;
		}else {
			overwrite=false;
		}
	}
}

class ActionJListGroup extends MouseAdapter{
	  protected JList list;
	    
	  public ActionJListGroup(JList l){
	   list = l;
	   }
	    
	  public void mouseClicked(MouseEvent e){
	   if(e.getClickCount() == 2){
	     int index = list.locationToIndex(e.getPoint());
	     ViewWindow showSubject = new ViewWindow(Views.LoadWindow.tabModel.getStudent(index));
	     showSubject.setVisible(true);
	     showSubject.setLocationRelativeTo(null);
	     showSubject.pack();
	     }
	   }
}