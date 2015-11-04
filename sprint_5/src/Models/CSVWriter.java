package Models;
import java.io.*;
import java.util.ArrayList;

/**
 * CSVWriter class can write CSV files in this format : quotes between items and each items separated with commas
 * @author Maxime Bouveron, G1A3
 * @version 1.0
 */
public class CSVWriter {
    private String[][] linesToPrint;

    /**
     * CSVWriter constructor
     * @param lines the ArrayList of Strings lists which you want to be written in CSV
     */
    public CSVWriter(String[][] lines){
        
    	this.linesToPrint = lines;
    }

    /**
     * Transforms the array in a string to be printed
     * @return The string to be printed in the file
     */
    private String array2CSV(){
        String returnMsg = "";
        for(String[] line : this.linesToPrint){
            for(String item : line){
                returnMsg += item;
                returnMsg += ";";
            }
            returnMsg = returnMsg.substring(0,returnMsg.length()-1);
            returnMsg += "\n";
        }
        return returnMsg;
    }

    /**
     * Writes the array specified in the constructor in the specified file
     * @param fileName the csv created or replaced
     */
    public void writeToFile(String fileName){
        try (Writer bfwriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            bfwriter.write(array2CSV());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
