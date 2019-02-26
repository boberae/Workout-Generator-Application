package workoutGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

/******************************************************************
Generator class tracks exercises in the lists and generates the workouts

@author Tony Bober
@version 1.0
 *****************************************************************/
public class Generator {

	/** ArrayList for each muscle group */
	ArrayList<String> list1= new ArrayList<>(); 
	ArrayList<String> list2= new ArrayList<>(); 
	ArrayList<String> list3= new ArrayList<>(); 
	
	/** Number of exercises from each muscle group to include in the workout */
	private int num1;
	private int num2;
	private int num3;
	
	
	/******************************************************************************
	 *  Constructor for the Generator if three muscles are included
	 ******************************************************************************/
	public Generator (DefaultListModel<String> list1, JTextField num1, DefaultListModel<String> list2, JTextField num2, DefaultListModel<String> list3, JTextField num3) {

		this.num1 = Integer.parseInt(num1.getText());
		this.num2 = Integer.parseInt(num2.getText());
		this.num3 = Integer.parseInt(num3.getText());
		
		this.list1 = ListBuilder(list1);
		this.list2 = ListBuilder(list2);
		this.list3 = ListBuilder(list3);
		
		CheckValues();
	}
	
	/******************************************************************************
	 *  Constructor for the Generator if two muscles are included
	 ******************************************************************************/
	public Generator (DefaultListModel<String> muscle1, JTextField num1, DefaultListModel<String> muscle2, JTextField num2) {

		this.num1 = Integer.parseInt(num1.getText());
		this.num2 = Integer.parseInt(num2.getText());
		num3 = 0;	
		
		list1 = ListBuilder(muscle1);
		list2 = ListBuilder(muscle2);
		list3 = new ArrayList<>();	
		
		CheckValues();
	}
	
	/******************************************************************************
	 *  Constructs the Arraylists for the muscle groups
	 ******************************************************************************/
	private ArrayList<String> ListBuilder (DefaultListModel<String> listModel) {
		ArrayList<String> exerciseList = new ArrayList<>();
		
		for(int i = 0; i < listModel.size(); i++)
			exerciseList.add((String) listModel.getElementAt(i));
		
		return exerciseList;
	}
	
	/******************************************************************************
	 *  Checks that there are enough exercises listed for each muscle group
	 ******************************************************************************/
	private void CheckValues() {
		if(num1>list1.size() || num2>list2.size() || num3>list3.size())
			throw new IllegalArgumentException();
	}
	
	/******************************************************************************
	 *  Generates the workout
	 ******************************************************************************/
	public DefaultListModel<String> Generate () {
		//ArrayList of the exercises chosen from all three exercises
		ArrayList<String> workoutList = new ArrayList<>();
		
		//Random number generator for the list
		Random rand = new Random();
		
		//Integer assigned random values to select exercises
		int n;

		//Add exercises from first muscle group
		for(int i = 0; i<num1; i++) {
			n = rand.nextInt(list1.size());		//Pick an integer between 1 and list1 size (inclusive)
			workoutList.add(list1.get(n));			//Add item to workoutList
			list1.remove(n);						//Remove that item from list1, and repeat for as many exercises as desired
		}
		
		//Add exercises from second muscle group
		for(int i = 0; i<num2; i++) {
			n = rand.nextInt(list2.size());		//Pick an integer between 1 and list2 size (inclusive)
			workoutList.add(list2.get(n));			//Add item to workoutList
			list2.remove(n);						//Remove that item from list2, and repeat for as many exercises as desired
		}
		
		//Add exercises from first muscle group
		for(int i = 0; i<num3; i++) {
			n = rand.nextInt(list3.size());		//Pick an integer between 1 and list3 size (inclusive)
			workoutList.add(list3.get(n));			//Add item to workoutList
			list3.remove(n);						//Remove that item from list3, and repeat for as many exercises as desired
		}
		
		//Randomly shuffle the workoutList
		Collections.shuffle(workoutList);
		
		//Add numbering to workoutList
		for(int i = 0; i<workoutList.size(); i++)
			workoutList.set(i, i+1 + ".      " + workoutList.get(i));
		
		//Convert workoutList to DefaultListModel
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(int i = 0; i<workoutList.size(); i++)
			listModel.addElement(workoutList.get(i));
		
		//Return list model with workout
		return listModel;
	}
	
}
