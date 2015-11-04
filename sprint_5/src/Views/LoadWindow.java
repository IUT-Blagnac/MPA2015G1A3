package Views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import Models.TabModels;

public class LoadWindow extends JFrame {

	/**
	 * @author Groupe1A3
	 */
	private JFileChooser loader;
	private JTextField[] text = {new JTextField(""),new JTextField(""),new JTextField(""),new JTextField("")};
	private String[] textFieldTab = { "adressEtu", "adressSuj", "adressSup","adressPro" };
	private JButton[] button = new JButton[8];
	private String[] buttonTab = { "loadEtu", "delEtu", "loadSuj", "delSuj","loadSup", "delSup", "loadPro", "delPro" };
	private JLabel[] labels = { new JLabel("CSV Students :  "),new JLabel("CSV Subjects :  "), new JLabel("CSV Supervisors :  "),new JLabel("CSV Projects :  ") };
	private Color cButton = new Color(220, 220, 220);
	private JButton create;
	private JFrame frame;;
	public static TabModels tabModel;
	
	public LoadWindow() {
		super("OPTI Home");
		frame = this;
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(700, 250));
		this.setResizable(false);
		create();
		
		File repertoireCourant = null;
		try {
			repertoireCourant = new File(".").getCanonicalFile();
			String rep = repertoireCourant.getPath().substring(0, repertoireCourant.getPath().length()-3)+"data";
			text[0].setText(rep+"/etudiants2014_2015.csv");
			text[1].setText(rep+"/sujets2014_2015.csv");
			text[2].setText(rep+"/intervenants2014_2015.csv");
			text[3].setText(rep+"/projets2014_2015.csv");
		} catch (IOException e1) {
			
		}
		JPanel grid = new JPanel();
		GridLayout grille = new GridLayout(4, 4);
		grid.setLayout(grille);
		grid.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		grille.setVgap(2);
		grille.setHgap(2);
		
		JPanel pTitle = new JPanel();
		JLabel title = new JLabel("OPTI");
		title.setFont(new Font(getName(), 1, 30));

		JPanel crea = new JPanel();
		create = new JButton("Create");
		create.setBackground(cButton);
		
		crea.add(create);
		pTitle.add(title);
		this.add(pTitle, BorderLayout.NORTH);
		this.add(crea, BorderLayout.SOUTH);
		this.add(grid, BorderLayout.CENTER);
		int j = 0;
		for (int i = 0; i < 4; i++) {
			grid.add(labels[i]);
			grid.add(text[i]);
			grid.add(button[j]);
			grid.add(button[j + 1]);
			j += 2;
		}
		
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(text[0].getText().substring(text[0].getText().length(),text[0].getText().length()));
				if(text[0].getText().equals("") || (!(text[0].getText().substring(text[0].getText().length()-3,text[0].getText().length())).equals("csv"))){
					labels[0].setForeground(Color.RED);
					labels[1].setForeground(Color.BLACK);
					labels[2].setForeground(Color.BLACK);
					labels[3].setForeground(Color.BLACK);
				}else if(text[1].getText().equals("") || (!(text[1].getText().substring(text[1].getText().length()-3,text[1].getText().length())).equals("csv"))){
					labels[0].setForeground(Color.BLACK);
					labels[1].setForeground(Color.RED);
					labels[2].setForeground(Color.BLACK);
					labels[3].setForeground(Color.BLACK);
				}else if(text[2].getText().equals("") || (!(text[2].getText().substring(text[2].getText().length()-3,text[2].getText().length())).equals("csv"))){
					labels[0].setForeground(Color.BLACK);
					labels[1].setForeground(Color.BLACK);
					labels[2].setForeground(Color.RED);
					labels[3].setForeground(Color.BLACK);
				}else if(text[3].getText().equals("") || (!(text[3].getText().substring(text[3].getText().length()-3,text[3].getText().length())).equals("csv"))){
					labels[0].setForeground(Color.BLACK);
					labels[1].setForeground(Color.BLACK);
					labels[2].setForeground(Color.BLACK);
					labels[3].setForeground(Color.RED);
				}else {
					tabModel = new TabModels(text[0].getText(),text[1].getText(),text[2].getText(),text[3].getText());
					MainWindow fen = new MainWindow(tabModel);
					fen.setLocationRelativeTo(null);
					fen.setVisible(true);
					frame.dispose();
				}
			}

		});
	}

	private void quitter() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure ?", "Attention",
				JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
			System.exit(0);
	}

	public void createTextField() {

		for (int i = 0; i < textFieldTab.length; i++) {
			text[i] = new JTextField();
		}

	}

	public void createButton() {

		for (int i = 0; i < buttonTab.length; i += 2) {
			button[i] = new JButton("Find...");
			button[i + 1] = new JButton("Clear");
		}
	}

	public void create() {
		createTextField();
		createButton();

		int j = 0;
		for (int i = 0; i < 4; i++) {
			labels[i].setHorizontalAlignment(SwingConstants.TRAILING);
			text[i].setEditable(false);
			button[j].setBackground(cButton);
			button[j + 1].setBackground(cButton);
			j += 2;
		}

		listener();
	}

	private void listener() {
		
		button[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				File repertoireCourant = null;
				try {
					repertoireCourant = new File(".").getCanonicalFile();
					String rep = repertoireCourant.getPath().substring(0, repertoireCourant.getPath().length()-3)+"data";
					loader = new JFileChooser(rep);
					loader.showOpenDialog(null);
					String chemin = "" + loader.getSelectedFile();
					if (!chemin.equals("null")) {
						text[0].setText(chemin);
					}
				} catch (IOException e1) {}
				
			}

		});

		button[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text[0].setText("");
			}

		});

		button[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				File repertoireCourant = null;
				try {
					repertoireCourant = new File(".").getCanonicalFile();
					String rep = repertoireCourant.getPath().substring(0, repertoireCourant.getPath().length()-3)+"data";
					loader = new JFileChooser(rep);
					loader.showOpenDialog(null);
					String chemin = "" + loader.getSelectedFile();
					if (!chemin.equals("null")) {
						text[1].setText(chemin);
					}
				} catch (IOException e1) {}
				
			}

		});

		button[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text[1].setText("");
			}

		});

		button[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				File repertoireCourant = null;
				try {
					repertoireCourant = new File(".").getCanonicalFile();
					String rep = repertoireCourant.getPath().substring(0, repertoireCourant.getPath().length()-3)+"data";
					loader = new JFileChooser(rep);
					loader.showOpenDialog(null);
					String chemin = "" + loader.getSelectedFile();
					if (!chemin.equals("null")) {
						text[2].setText(chemin);
					}
				} catch (IOException e1) {}
				
			}

		});

		button[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text[2].setText("");
			}

		});

		button[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				File repertoireCourant = null;
				try {
					repertoireCourant = new File(".").getCanonicalFile();
					String rep = repertoireCourant.getPath().substring(0, repertoireCourant.getPath().length()-3)+"data";
					loader = new JFileChooser(rep);
					loader.showOpenDialog(null);
					String chemin = "" + loader.getSelectedFile();
					if (!chemin.equals("null")) {
						text[3].setText(chemin);
					}
				} catch (IOException e1) {}
				
			}

		});

		button[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text[3].setText("");
			}

		});
		
		
		
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				quitter();
			}
		});
	}
}
