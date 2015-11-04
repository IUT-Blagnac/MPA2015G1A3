package Views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import Models.CSVWriter;
import Models.Participant;
import Models.Student;
import Models.Subject;
import Models.TabModels;

/**
 * Pane containing informations about the project
 * 
 * @author Mathieu BERTIN, G1A3
 * @version 2.0
 *
 */


public class TabParticipants extends JPanel {


	private JList list;
	private JScrollPane panTable;
	public static DefaultListModel listModelPar;
	private boolean overwrite = false;
	private JFrame frame;
	
	public TabParticipants(Participant[] tabPar) {
		super();
		this.setLayout(new BorderLayout());
		listModelPar = new DefaultListModel();
		for(int i=0;i<tabPar.length;i++){
			listModelPar.addElement(tabPar[i].getId()+"  :  "+tabPar[i].getFirstName()+" "+tabPar[i].getLastName());
		}
		
		list = new JList(listModelPar);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
				if(!listModelPar.isEmpty() && index >= 0){
					LoadWindow.tabModel.removeParticipant(index);
					listModelPar.remove(index);
				}
			}

		});
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AddWindow crea = new AddWindow(LoadWindow.tabModel.getParticipant());
				crea.setLocationRelativeTo(null);
				crea.setVisible(true);
				crea.setSize(new Dimension(250,250));
				
			}

		});
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ModifyWindow modif = new ModifyWindow(LoadWindow.tabModel.getParticipant(list.getSelectedIndex()));
				modif.setLocationRelativeTo(null);
				modif.setVisible(true);
				modif.setSize(new Dimension(250,250));
				
			}

		});
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Participant[] tabParticipant = LoadWindow.tabModel.getParticipant();
				String[][] newTab = new String[tabParticipant.length+1][3];
				String[] title ={"id","First Name","Last Name"};
				newTab[0] = title;
				for (int i = 1; i < newTab.length; i++) {
						newTab[i][0] = tabParticipant[i-1].getId();
						newTab[i][1] = tabParticipant[i-1].getFirstName();
						newTab[i][2] = tabParticipant[i-1].getLastName();
					
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
