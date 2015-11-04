package Controler;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Views.LoadWindow;

public class OPTI {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		}
		catch(UnsupportedLookAndFeelException e){
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(ClassNotFoundException e){
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		LoadWindow fen = new LoadWindow();
		fen.setLocationRelativeTo(null);
		fen.setVisible(true);

	}

}
