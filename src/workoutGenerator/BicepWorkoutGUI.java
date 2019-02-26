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


public class BicepWorkoutGUI extends JFrame{

	/** Default Serial ID */
	private static final long serialVersionUID = 1L;

	/** Frame */
	private JFrame frame;
	
	/** Text Fields */
	private JTextField numberOfBack;
	private JTextField numberOfBicep;
	private JTextField numberOfAb;
	
	/** Buttons */
	private JButton btnAddBackItem;
	private JButton btnRemoveBackItem;
	private JButton btnAddBicepItem;
	private JButton btnRemoveBicepItem;
	private JButton btnAddAbItem;
	private JButton btnRemoveAbItem;
	private JButton btnBack;
	private JButton btnFinish;
	
	/** ListModels */
	private DefaultListModel<String> backListModel;
	private DefaultListModel<String> bicepListModel;
	private DefaultListModel<String> abListModel;
	
	/** Lists */
	private JList<String> backList;
	private JList<String> bicepList;
	private JList<String> abList;
	
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
					BicepWorkoutGUI window = new BicepWorkoutGUI();
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
	public BicepWorkoutGUI() {
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
		
		
		/** Back Exercises */
		JLabel lblBackExercises = new JLabel("Back Exercises");
		lblBackExercises.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBackExercises.setBounds(10, 61, 95, 14);
		getFrame().getContentPane().add(lblBackExercises);
	
		//Generate the list model
		backListModel = fileManager.openList("Back.txt");
				
		//Use the list model to populate the JList
		JScrollPane backPane = new JScrollPane();
		backList = new JList<String>(backListModel);
		backList.setToolTipText("");
		backList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		backPane.setBounds(10, 75, 218, 205);
		backPane.setViewportView(backList);
		getFrame().getContentPane().add(backPane);
		
		//Buttons
		btnAddBackItem = new JButton("Add Item");
		btnAddBackItem.setBounds(10, 280, 104, 23);
		btnAddBackItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getFrame().getContentPane().add(btnAddBackItem);
		btnAddBackItem.addActionListener(listener);
		
		btnRemoveBackItem = new JButton("Remove Item");
		btnRemoveBackItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveBackItem.setBounds(124, 280, 104, 23);
		getFrame().getContentPane().add(btnRemoveBackItem);
		btnRemoveBackItem.addActionListener(listener);
		
		JLabel lblNumberOfBack = new JLabel("Number of back exercises to include:");
		lblNumberOfBack.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfBack.setBounds(227, 346, 182, 14);
		getFrame().getContentPane().add(lblNumberOfBack);
		
		//Text field for number of exercises to include
		numberOfBack = new JTextField();
		numberOfBack.setText(fileManager.openNumber("backNumber.txt"));
		numberOfBack.setBounds(409, 343, 31, 20);
		getFrame().getContentPane().add(numberOfBack);
		numberOfBack.setColumns(10);
			
		
		/** Bicep Exercises */
		JLabel lblBicepExercises = new JLabel("Bicep Exercises");
		lblBicepExercises.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBicepExercises.setBounds(238, 61, 95, 14);
		getFrame().getContentPane().add(lblBicepExercises);
		
		//Generate the list model
		bicepListModel = fileManager.openList("Bicep.txt");
		
		//Use the list model to populate the JList
		JScrollPane bicepPane = new JScrollPane();
		bicepList = new JList<String>(bicepListModel);
		bicepList.setToolTipText("");
		bicepList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bicepPane.setBounds(238, 75, 218, 205);
		bicepPane.setViewportView(bicepList);
		getFrame().getContentPane().add(bicepPane);
		
		//Buttons
		btnAddBicepItem = new JButton("Add Item");
		btnAddBicepItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddBicepItem.setBounds(238, 280, 104, 23);
		getFrame().getContentPane().add(btnAddBicepItem);
		btnAddBicepItem.addActionListener(listener);
		
		btnRemoveBicepItem = new JButton("Remove Item");
		btnRemoveBicepItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveBicepItem.setBounds(352, 280, 104, 23);
		getFrame().getContentPane().add(btnRemoveBicepItem);
		btnRemoveBicepItem.addActionListener(listener);
		
		JLabel lblNumberOfBicep = new JLabel("Number of bicep exercises to include:");
		lblNumberOfBicep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfBicep.setBounds(227, 371, 182, 14);
		getFrame().getContentPane().add(lblNumberOfBicep);
		
		//Text field for number of bicep exercises to include
		numberOfBicep = new JTextField();
		numberOfBicep.setText(fileManager.openNumber("bicepNumber.txt"));
		numberOfBicep.setColumns(10);
		numberOfBicep.setBounds(409, 368, 31, 20);
		getFrame().getContentPane().add(numberOfBicep);
		
		
		/** Ab Exercises */
		JLabel lblAbExercises = new JLabel("Ab Exercises");
		lblAbExercises.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAbExercises.setBounds(466, 61, 95, 14);
		getFrame().getContentPane().add(lblAbExercises);
		
		//Generate the list model
		abListModel = fileManager.openList("Ab.txt");
		
		//Use the list model to populate the JList
		JScrollPane abPane = new JScrollPane();
		abList = new JList<String>(abListModel);
		abList.setToolTipText("");
		abList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		abPane.setBounds(466, 75, 218, 205);
		abPane.setViewportView(abList);
		getFrame().getContentPane().add(abPane);
		
		//Buttons
		btnAddAbItem = new JButton("Add Item");
		btnAddAbItem.setBounds(466, 280, 104, 23);
		btnAddAbItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getFrame().getContentPane().add(btnAddAbItem);
		btnAddAbItem.addActionListener(listener);
		
		btnRemoveAbItem = new JButton("Remove Item");
		btnRemoveAbItem.setBounds(580, 280, 104, 23);
		btnRemoveAbItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getFrame().getContentPane().add(btnRemoveAbItem);
		btnRemoveAbItem.addActionListener(listener);
		
		JLabel lblNumberOfAb = new JLabel("Number of ab exercises to include:");
		lblNumberOfAb.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfAb.setBounds(227, 396, 182, 14);
		getFrame().getContentPane().add(lblNumberOfAb);
		
		//Text field for number of ab exercises to include
		numberOfAb = new JTextField();
		numberOfAb.setText(fileManager.openNumber("abNumber.txt"));
		numberOfAb.setColumns(10);
		numberOfAb.setBounds(409, 393, 31, 20);
		getFrame().getContentPane().add(numberOfAb);
		
		
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
				Generator generator = new Generator(backListModel, numberOfBack, bicepListModel, numberOfBicep, abListModel, numberOfAb);
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
				fileManager.saveList("Back.txt", backListModel);
				fileManager.saveList("Bicep.txt", bicepListModel);
				fileManager.saveList("Ab.txt", abListModel);
				fileManager.saveNumber("BackNumber.txt", numberOfBack.getText());
				fileManager.saveNumber("BicepNumber.txt", numberOfBicep.getText());
				fileManager.saveNumber("AbNumber.txt", numberOfAb.getText());
				
				//Start ListDisplayGUI
				try {
					ListDisplayGUI newWindow = new ListDisplayGUI("BicepWorkoutGUI", listModel);
					newWindow.getFrame().setVisible(true);	
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				//Dispose of this BicepWorkoutGUI
				frame.dispose();
			}
			
			//Add/Remove Back Exercises
			if(btnAddBackItem == e.getSource()) {
				backListModel = addItem(backListModel);
			}
			if(btnRemoveBackItem == e.getSource()) {
				backListModel = removeItem(backList, backListModel);
			}
			
			//Add/Remove Bicep Exercises
			if(btnAddBicepItem == e.getSource()) {
				bicepListModel = addItem(bicepListModel);
			}
			if(btnRemoveBicepItem == e.getSource()) {
				bicepListModel = removeItem(bicepList, bicepListModel);
			}
			
			//Add/Remove Ab Exercises
			if(btnAddAbItem == e.getSource()) {
				abListModel = addItem(abListModel);
			}
			if(btnRemoveAbItem == e.getSource()) {
				abListModel = removeItem(abList, abListModel);
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
