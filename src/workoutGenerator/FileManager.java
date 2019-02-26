package workoutGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class FileManager {

	
	/** No action needed in the constructor */
	public FileManager() {

	}
	
	/******************************************************************
	Opens the list from a file 
	******************************************************************/
	public DefaultListModel<String> openList(String fileName) {
		try
		{
			// open the data file
			Scanner fileReader = new Scanner(new File(fileName)); 

			//ListModel to populate with the exercises from the txt file
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			
			// read in every item from the txt file
			while(fileReader.hasNextLine()) {
				listModel.addElement(fileReader.nextLine());
			}
			
			fileReader.close();
			return listModel;
		}

		// could not find file
		catch(Exception error) 
		{
			return new DefaultListModel<String>();
		}
		
	}
	
	
	/******************************************************************
	Saves the list to a file 
	******************************************************************/
	public void saveList(String fileName, DefaultListModel<String> listModel)
	{
		// Create file named fileName.txt
		PrintWriter out = null;
		try 
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} 

		// fileName invalid
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		// Print each line of the list model to file
		for(int i = 0; i < listModel.size(); i++)
			out.println(listModel.getElementAt(i));
		
		// Close file
		out.close(); 
	}
	
	/******************************************************************
	Opens the textfield number from a file 
	******************************************************************/
	public String openNumber(String fileName) {
		try
		{
			// open the data file
			Scanner fileReader = new Scanner(new File(fileName)); 
			
			// create string variable for the number to be read in
			String num = "";
			
			// read in the first (and only) line from the text file
			if(fileReader.hasNextLine()) {
				num = fileReader.nextLine();
			}
			
			fileReader.close();
			return num;
		}

		// could not find file
		catch(Exception error) 
		{
			return "";
		}
	}
	
	/******************************************************************
	Saves the textfield number to a file 
	******************************************************************/
	public void saveNumber(String fileName, String num)
	{
		// Create file named fileName.txt
		PrintWriter out = null;
		try 
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} 

		// fileName invalid
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		// Print each line of the list model to file
		out.println(num);
		
		// Close file
		out.close(); 
	}
	
}
