package Models;
import java.io.*;
import java.util.ArrayList;

/**
 * CSVReader class can read ONLY CSV files written in this format : quotes between items and each items separated with commas
 * @author Maxime Bouveron, G1A3
 * @version 1.0
 */
public class CSVReader {

    private ArrayList<String[]> lines = new ArrayList<>();

    /**
     * CSVReader constructor
     * @param filePath the path of the file to be read
     */
    public CSVReader(String filePath){
        try (BufferedReader bfreader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"))){

            String currentLine;
            String[] currentItems;

            while ((currentLine = bfreader.readLine()) != null) {
                currentItems = currentLine.split(";");
                this.lines.add(currentItems);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * getLines method
     * @return the CSV file items in an ArrayList of String list
     */
    public String[][] getLines(){
        String[][] stringLines = new String[this.lines.size()][];
        for(int i = 0; i<this.lines.size();i++){
        	stringLines[i] = lines.get(i);
        }
    	return stringLines;
    }

    /**
     * To string method
     * @return a string representation of the CSV files with spaces instead of quotes and commas
     */

    public String toString(){
        String returnMsg = "";
        for(String[] line : this.lines){
            for(String item : line){
                returnMsg += item;
                returnMsg += " ";
            }
            returnMsg += "\n";
        }
        return returnMsg;
    }
    
}
