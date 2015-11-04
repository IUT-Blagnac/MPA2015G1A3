package Tests;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import Models.CSVReader;
import Models.CSVWriter;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class CSVTests extends TestCase{

    Process executionProgrammeATester;
    BufferedReader ecranProgrammeATester;
    BufferedWriter clavierProgrammeATester;
    String finDeLigne = System.getProperty("line.separator");

    public static void testWriter(){
    	 String[] line1 = {"Nom","Prenom","Age"};
         String[] line2 = {"Lama","Serge","654"};
         String[] line3 = {"Rage","Jean","2"};
         String[] line4 = {"Saoule","Sam","42"};
         ArrayList<String[]> lines11 = new ArrayList<>();

         lines11.add(line1);
         lines11.add(line2);
         lines11.add(line3);
         lines11.add(line4);

         String[][] linesArray = new String[lines11.size()][];
         for(int i = 0; i<lines11.size(); i++){
             linesArray[i]=lines11.get(i);
         }
         
    	File repertoireCourant = null;
		try {
			repertoireCourant = new File(".").getCanonicalFile();
			String rep = repertoireCourant.getPath().substring(0, repertoireCourant.getPath().length());
			CSVWriter writer = new CSVWriter(linesArray);
			System.out.println(rep);
	        writer.writeToFile(rep+"/Tests/testCSV.csv");
		} catch (IOException e1) {
			
		}
        
    }
    public static void testReader(){
    	File repertoireCourant = null;
    	CSVReader reader = null;
		try {
			repertoireCourant = new File(".").getCanonicalFile();
			String rep = repertoireCourant.getPath().substring(0, repertoireCourant.getPath().length());
			reader = new CSVReader(rep+"/Tests/testCSV.csv");
		} catch (IOException e1) {
			
		}
        
        String[] line1 = {"Nom","Prenom","Age"};
        String[] line2 = {"Lama","Serge","654"};
        String[] line3 = {"Rage","Jean","2"};
        String[] line4 = {"Saoule","Sam","42"};
        ArrayList<String[]> lines = new ArrayList<>();

        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);

        String[][] linesArray = new String[lines.size()][];

        for(int i = 0; i<lines.size(); i++){
            linesArray[i]=lines.get(i);
        }

        String expected = "";
        for (String[] line : linesArray) {
            for (String lineOfLine : line) {
                expected += lineOfLine + " ";
            }
            expected += "\n";
        }
        String received = reader.toString();
        assertEquals("Affiche : "+expected,expected,received);
    }

}
