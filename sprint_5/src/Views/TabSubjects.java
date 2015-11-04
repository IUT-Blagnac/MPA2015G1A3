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

public class TabSubjects extends JPanel {

	private JList list;
	public static DefaultListModel listModel;
	private JScrollPane panTable;
	private boolean overwrite = false;
	private JFrame frame;

	public TabSubjects(Subject[] tabSub) {
		super();
		this.setLayout(new BorderLayout());
		listModel = new DefaultListModel();
		for(int i=0;i<tabSub.length;i++){
			listModel.addElement(tabSub[i].getId()+"  :  "+tabSub[i].getName());
		}
		
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new ActionJListSubject(list));
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
				if(!listModel.isEmpty() && index >= 0){
					LoadWindow.tabModel.removeSubject(index);
					listModel.remove(index);
				}
			}
		});
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AddWindow crea = new AddWindow(LoadWindow.tabModel.getSubject());
				crea.setLocationRelativeTo(null);
				crea.setVisible(true);
				crea.pack();
				
			}

		});
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ModifyWindow crea = new ModifyWindow(LoadWindow.tabModel.getSubject(list.getSelectedIndex()));
				crea.setLocationRelativeTo(null);
				crea.setVisible(true);
				crea.pack();
				
			}

		});
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Subject[] tabSubject = LoadWindow.tabModel.getSubject();
				String[][] newTab = new String[tabSubject.length+1][3];
				String[] title ={"id","Name","Title"};
				newTab[0] = title;
				for (int i = 1; i < newTab.length; i++) {
						newTab[i][0] = tabSubject[i-1].getId();
						newTab[i][1] = tabSubject[i-1].getName();
						newTab[i][2] = tabSubject[i-1].getTitle();
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

class ActionJListSubject extends MouseAdapter{
	  protected JList list;
	    
	  public ActionJListSubject(JList l){
	   list = l;
	   }
	    
	  public void mouseClicked(MouseEvent e){
	   if(e.getClickCount() == 2){
	     int index = list.locationToIndex(e.getPoint());
	     ViewWindow showSubject = new ViewWindow(LoadWindow.tabModel.getSubject(index));
	     showSubject.setVisible(true);
	     showSubject.setLocationRelativeTo(null);
	     showSubject.pack();
	     }
	   }
}
