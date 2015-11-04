package Views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import Models.Subject;
import Models.TabModels;

/**
 * Main class containing tabbed pane
 * @author Mathieu BERTIN, G1A3
 * @version 2.0
 *
 */

public class MainWindow extends JFrame {
	
	
	public static JTabbedPane onglets;
	/**
	 * Fenetre constructor
	 * @param pTabMod The name of the window
	 */
	public MainWindow(TabModels pTabMod) {
		super("OPTI");
		
		this.setPreferredSize(new Dimension(500,900));
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		JPanel pan = new JPanel(new BorderLayout());
		JButton quitter = new JButton("Close");
		quitter.setBackground(new Color(220,220,220));
		pan.add(quitter, BorderLayout.SOUTH);
		
        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                quitter();
            }
        });
       
        
        onglets = new JTabbedPane(SwingConstants.TOP);
      
        JPanel projects = new TabProjects(LoadWindow.tabModel.getProject());
        onglets.addTab("Projects", projects);
        JPanel sujets = new TabSubjects(LoadWindow.tabModel.getSubject());
        onglets.addTab("Subjects", sujets);
        JPanel groupe = new TabGroups(LoadWindow.tabModel.getStudent());
        onglets.addTab("Groups", groupe);
        JPanel interv = new TabParticipants(LoadWindow.tabModel.getParticipant());
        onglets.addTab("Participants", interv);
        JPanel aPropos = new TabAbout();
        onglets.addTab("About", aPropos);
        
        onglets.setOpaque(true);
        pan.add(onglets, BorderLayout.CENTER);
        
        
		this.setContentPane(pan);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                quitter();
            }
        });
        this.setSize(800, 600);
	}
	
	/**
	 * This method is called when the user click on the red cross or the button Quitter
	 */
	private void quitter() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure ?", "Attention", JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
	            System.exit(0);
	    }

}
