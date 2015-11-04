package Views;
import java.awt.*;
import javax.swing.*;

/**
 * Pane ontaining informations about the project
 * @author Mathieu BERTIN, G1A3
 * @version 2.0
 *
 */

public class TabAbout extends JPanel {
	private JLabel infos[] = {new JLabel("Project : OPTI"), new JLabel("BERTIN Mathieu"), new JLabel("BOURGUET Guillaume"), new JLabel("BOUVERON Maxime"), new JLabel("HELLER Tanguy"),
							  new JLabel("Group 1A3"), new JLabel(""), new JLabel("University Toulouse 2"), new JLabel("IUT of Blagnac"), new JLabel("DUT INFO S3/Module MPA"),
					          new JLabel("Sprint 5")};
	
	/**
	 * About constructor
	 */
	public TabAbout() {
		super();
		this.setLayout(new GridLayout(11, 1));
		
		for (int i = 0; i < infos.length; i++) {
			this.add(infos[i]);
		}
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setVisible(true);
	}

}
