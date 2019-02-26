package workoutGenerator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class TricepWorkoutGUI extends JFrame{

	/** Default Serial ID */
	private static final long serialVersionUID = 1L;

	/** Frame */
	private JFrame frame;
	
	/** Text Fields */
	private JTextField numberOfChest;
	private JTextField numberOfTricep;
	private JTextField numberOfShoulder;
	
	/** Buttons */
	private JButton btnAddChestItem;
	private JButton btnRemoveChestItem;
	private JButton btnAddTricepItem;
	private JButton btnRemoveTricepItem;
	private JButton btnAddShoulderItem;
	private JButton btnRemoveShoulderItem;
	private JButton btnBack;
	private JButton btnFinish;
	
	/** ListModels */
	private DefaultListModel<String> chestListModel;
	private DefaultListModel<String> tricepListModel;
	private DefaultListModel<String> shoulderListModel;
	
	/** Lists */
	private JList<String> chestList;
	private JList<String> tricepList;
	private JList<String> shoulderList;
	
	/** FileManager class manages the txt files storing the workout lists */
	private FileManager fileManager;
	
	/** ButtonListener for the various buttons */
	private ButtonListener listener;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TricepWorkoutGUI window = new TricepWorkoutGUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public TricepWorkoutGUI() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Basic frame settings
		frame = new JFrame("Workout Generator");
		frame.setBounds(100, 100, 710, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Button listener
		listener = new ButtonListener();
		
		//File manager
		fileManager = new FileManager();
		
		//Title Labels
		JLabel lblAddOrRemove = new JLabel("Add or remove exercises:");
		lblAddOrRemove.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddOrRemove.setBounds(10, 11, 218, 14);
		getFrame().getContentPane().add(lblAddOrRemove);
		
		JLabel lblProgramWillGenerate = new JLabel("Program will generate a workout from these lists");
		lblProgramWillGenerate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProgramWillGenerate.setBounds(10, 36, 333, 14);
		getFrame().getContentPane().add(lblProgramWillGenerate);
		
		
		/** Chest Exercises */
		JLabel lblChestExercises = new JLabel("Chest Exercises");
		lblChestExercises.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblChestExercises.setBounds(10, 61, 95, 14);
		getFrame().getContentPane().add(lblChestExercises);
	
		//Generate the list model
		chestListModel = fileManager.openList("Chest.txt");
				
		//Use the list model to populate the JList
		JScrollPane chestPane = new JScrollPane();
		chestList = new JList<String>(chestListModel);
		chestList.setToolTipText("");
		chestList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chestPane.setBounds(10, 75, 218, 205);
		chestPane.setViewportView(chestList);
		getFrame().getContentPane().add(chestPane);
		
		//Buttons
		btnAddChestItem = new JButton("Add Item");
		btnAddChestItem.setBounds(10, 280, 104, 23);
		btnAddChestItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getFrame().getContentPane().add(btnAddChestItem);
		btnAddChestItem.addActionListener(listener);
		
		btnRemoveChestItem = new JButton("Remove Item");
		btnRemoveChestItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveChestItem.setBounds(124, 280, 104, 23);
		getFrame().getContentPane().add(btnRemoveChestItem);
		btnRemoveChestItem.addActionListener(listener);
		
		JLabel lblNumberOfChest = new JLabel("Number of chest exercises to include:");
		lblNumberOfChest.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfChest.setBounds(227, 346, 182, 14);
		getFrame().getContentPane().add(lblNumberOfChest);
		
		//Text field for number of exercises to include
		numberOfChest = new JTextField();
		numberOfChest.setText(fileManager.openNumber("chestNumber.txt"));
		numberOfChest.setBounds(425, 343, 31, 20);
		getFrame().getContentPane().add(numberOfChest);
		numberOfChest.setColumns(10);
			
		
		/** Tricep Exercises */
		JLabel lblTricepExercises = new JLabel("Tricep Exercises");
		lblTricepExercises.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTricepExercises.setBounds(238, 61, 95, 14);
		getFrame().getContentPane().add(lblTricepExercises);
		
		//Generate the list model
		tricepListModel = fileManager.openList("Tricep.txt");
		
		//Use the list model to populate the JList
		JScrollPane tricepPane = new JScrollPane();
		tricepList = new JList<String>(tricepListModel);
		tricepList.setToolTipText("");
		tricepList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tricepPane.setBounds(238, 75, 218, 205);
		tricepPane.setViewportView(tricepList);
		getFrame().getContentPane().add(tricepPane);
		
		//Buttons
		btnAddTricepItem = new JButton("Add Item");
		btnAddTricepItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddTricepItem.setBounds(238, 280, 104, 23);
		getFrame().getContentPane().add(btnAddTricepItem);
		btnAddTricepItem.addActionListener(listener);
		
		btnRemoveTricepItem = new JButton("Remove Item");
		btnRemoveTricepItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveTricepItem.setBounds(352, 280, 104, 23);
		getFrame().getContentPane().add(btnRemoveTricepItem);
		btnRemoveTricepItem.addActionListener(listener);
		
		JLabel lblNumberOfTricep = new JLabel("Number of tricep exercises to include:");
		lblNumberOfTricep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfTricep.setBounds(227, 371, 182, 14);
		getFrame().getContentPane().add(lblNumberOfTricep);
		
		//Text field for number of tricep exercises to include
		numberOfTricep = new JTextField();
		numberOfTricep.setText(fileManager.openNumber("tricepNumber.txt"));
		numberOfTricep.setColumns(10);
		numberOfTricep.setBounds(425, 368, 31, 20);
		getFrame().getContentPane().add(numberOfTricep);
		
		
		/** Shoulder Exercises */
		JLabel lblShoulderExercises = new JLabel("Shoulder Exercises");
		lblShoulderExercises.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblShoulderExercises.setBounds(466, 61, 95, 14);
		getFrame().getContentPane().add(lblShoulderExercises);
		
		//Generate the list model
		shoulderListModel = fileManager.openList("Shoulder.txt");
		
		//Use the list model to populate the JList
		JScrollPane shoulderPane = new JScrollPane();
		shoulderList = new JList<String>(shoulderListModel);
		shoulderList.setToolTipText("");
		shoulderList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		shoulderPane.setBounds(466, 75, 218, 205);
		shoulderPane.setViewportView(shoulderList);
		getFrame().getContentPane().add(shoulderPane);
		
		//Buttons
		btnAddShoulderItem = new JButton("Add Item");
		btnAddShoulderItem.setBounds(466, 280, 104, 23);
		btnAddShoulderItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getFrame().getContentPane().add(btnAddShoulderItem);
		btnAddShoulderItem.addActionListener(listener);
		
		btnRemoveShoulderItem = new JButton("Remove Item");
		btnRemoveShoulderItem.setBounds(580, 280, 104, 23);
		btnRemoveShoulderItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getFrame().getContentPane().add(btnRemoveShoulderItem);
		btnRemoveShoulderItem.addActionListener(listener);
		
		JLabel lblNumberOfShoulder = new JLabel("Number of shoulder exercises to include:");
		lblNumberOfShoulder.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfShoulder.setBounds(227, 396, 195, 14);
		getFrame().getContentPane().add(lblNumberOfShoulder);
		
		//Text field for number of shoulder exercises to include
		numberOfShoulder = new JTextField();
		numberOfShoulder.setText(fileManager.openNumber("shoulderNumber.txt"));
		numberOfShoulder.setColumns(10);
		numberOfShoulder.setBounds(425, 393, 31, 20);
		getFrame().getContentPane().add(numberOfShoulder);
		
		
		/** Back and Finish buttons*/
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 375, 110, 35);
		getFrame().getContentPane().add(btnBack);
		btnBack.addActionListener(listener);
		
		btnFinish = new JButton("Finish");
		btnFinish.setBounds(574, 375, 110, 35);
		getFrame().getContentPane().add(btnFinish);
		btnFinish.addActionListener(listener);
		
	}
	
	
	/******************************************************************
    Controls what to do when a button is pressed
	*****************************************************************/
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			//Back Button Event
			if(btnBack == e.getSource()) {
				//Open WorkoutTypeGUI
				try {
					WorkoutTypeGUI newWindow = new WorkoutTypeGUI();
					newWindow.getFrame().setVisible(true);					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				//Dispose of this frame
				frame.dispose();
			}
			
			//Finish Button Event
			if(btnFinish == e.getSource()) {
				
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				
				//Create the generator, generate the workout
				try {
				Generator generator = new Generator(chestListModel, numberOfChest, tricepListModel, numberOfTricep, shoulderListModel, numberOfShoulder);
				listModel = generator.Generate();
				}
				//Catch any errors in the number fields
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getFrame(), "Please enter a number for each muscle group");
					return;
				}
				catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(getFrame(), "Make sure all lists have enough exercises to choose from");
					return;
				}
				
				//Save the current inputs to files
				fileManager.saveList("Chest.txt", chestListModel);
				fileManager.saveList("Tricep.txt", tricepListModel);
				fileManager.saveList("Shoulder.txt", shoulderListModel);
				fileManager.saveNumber("ChestNumber.txt", numberOfChest.getText());
				fileManager.saveNumber("TricepNumber.txt", numberOfTricep.getText());
				fileManager.saveNumber("ShoulderNumber.txt", numberOfShoulder.getText());
				
				//Start ListDisplayGUI
				try {
					ListDisplayGUI newWindow = new ListDisplayGUI("TricepWorkoutGUI", listModel);
					newWindow.getFrame().setVisible(true);	
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				//Dispose of this TricepWorkoutGUI
				frame.dispose();
			}
			
			//Add/Remove Chest Exercises
			if(btnAddChestItem == e.getSource()) {
				chestListModel = addItem(chestListModel);
			}
			if(btnRemoveChestItem == e.getSource()) {
				chestListModel = removeItem(chestList, chestListModel);
			}
			
			//Add/Remove Tricep Exercises
			if(btnAddTricepItem == e.getSource()) {
				tricepListModel = addItem(tricepListModel);
			}
			if(btnRemoveTricepItem == e.getSource()) {
				tricepListModel = removeItem(tricepList, tricepListModel);
			}
			
			//Add/Remove Shoulder Exercises
			if(btnAddShoulderItem == e.getSource()) {
				shoulderListModel = addItem(shoulderListModel);
			}
			if(btnRemoveShoulderItem == e.getSource()) {
				shoulderListModel = removeItem(shoulderList, shoulderListModel);
			}
		}
		
	}
	
	/******************************************************************
    Remove items from one of the lists
	*****************************************************************/
	private DefaultListModel<String> removeItem(JList<String> list, DefaultListModel<String> listModel) {
		int[] selectedItems = list.getSelectedIndices();
		for(int i=selectedItems.length; i>0; i--)
			listModel.removeElementAt(selectedItems[i-1]);
		return listModel;
	}
	
	/******************************************************************
    Add items to one of the lists
	*****************************************************************/
	private DefaultListModel<String> addItem(DefaultListModel<String> listModel) {
		String newItem = JOptionPane.showInputDialog(null, "Name of new exercise:");
		listModel.addElement(newItem);
		return listModel;
	}

	/******************************************************************
    Getter allows frame to be accessed from another GUI
	*****************************************************************/
	public JFrame getFrame() {
		return frame;
	}

	
}
