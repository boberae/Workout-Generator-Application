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


public class LegWorkoutGUI extends JFrame{

	/** Default Serial ID */
	private static final long serialVersionUID = 1L;

	/** Frame */
	private JFrame frame;
	
	/** Text Fields */
	private JTextField numberOfLeg;
	private JTextField numberOfCardio;
	
	/** Buttons */
	private JButton btnAddLegItem;
	private JButton btnRemoveLegItem;
	private JButton btnAddCardioItem;
	private JButton btnRemoveCardioItem;
	private JButton btnBack;
	private JButton btnFinish;
	
	/** ListModels */
	private DefaultListModel<String> legListModel;
	private DefaultListModel<String> cardioListModel;
	
	/** Lists */
	private JList<String> legList;
	private JList<String> cardioList;
	
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
					LegWorkoutGUI window = new LegWorkoutGUI();
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
	public LegWorkoutGUI() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Basic frame settings
		frame = new JFrame("Workout Generator");
		frame.setBounds(100, 100, 535, 460);
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
		
		
		/** Leg Exercises */
		JLabel lblLegExercises = new JLabel("Leg Exercises");
		lblLegExercises.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLegExercises.setBounds(10, 61, 95, 14);
		getFrame().getContentPane().add(lblLegExercises);
	
		//Generate the list model
		legListModel = fileManager.openList("Leg.txt");
				
		//Use the list model to populate the JList
		JScrollPane legPane = new JScrollPane();
		legList = new JList<String>(legListModel);
		legList.setToolTipText("");
		legList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		legPane.setBounds(10, 75, 218, 205);
		legPane.setViewportView(legList);
		getFrame().getContentPane().add(legPane);
		
		//Buttons
		btnAddLegItem = new JButton("Add Item");
		btnAddLegItem.setBounds(10, 280, 104, 23);
		btnAddLegItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		getFrame().getContentPane().add(btnAddLegItem);
		btnAddLegItem.addActionListener(listener);
		
		btnRemoveLegItem = new JButton("Remove Item");
		btnRemoveLegItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveLegItem.setBounds(124, 280, 104, 23);
		getFrame().getContentPane().add(btnRemoveLegItem);
		btnRemoveLegItem.addActionListener(listener);
		
		JLabel lblNumberOfLeg = new JLabel("Number of leg exercises to include:");
		lblNumberOfLeg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfLeg.setBounds(139, 334, 182, 14);
		getFrame().getContentPane().add(lblNumberOfLeg);
		
		//Text field for number of exercises to include
		numberOfLeg = new JTextField();
		numberOfLeg.setText(fileManager.openNumber("legNumber.txt"));
		numberOfLeg.setBounds(342, 331, 31, 20);
		getFrame().getContentPane().add(numberOfLeg);
		numberOfLeg.setColumns(10);
			
		
		/** Cardio Exercises */
		JLabel lblCardioExercises = new JLabel("Cardio Exercises");
		lblCardioExercises.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCardioExercises.setBounds(287, 61, 95, 14);
		getFrame().getContentPane().add(lblCardioExercises);
		
		//Generate the list model
		cardioListModel = fileManager.openList("Cardio.txt");
		
		//Use the list model to populate the JList
		JScrollPane cardioPane = new JScrollPane();
		cardioList = new JList<String>(cardioListModel);
		cardioList.setToolTipText("");
		cardioList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cardioPane.setBounds(287, 75, 218, 205);
		cardioPane.setViewportView(cardioList);
		getFrame().getContentPane().add(cardioPane);
		
		//Buttons
		btnAddCardioItem = new JButton("Add Item");
		btnAddCardioItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddCardioItem.setBounds(287, 280, 104, 23);
		getFrame().getContentPane().add(btnAddCardioItem);
		btnAddCardioItem.addActionListener(listener);
		
		btnRemoveCardioItem = new JButton("Remove Item");
		btnRemoveCardioItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveCardioItem.setBounds(401, 280, 104, 23);
		getFrame().getContentPane().add(btnRemoveCardioItem);
		btnRemoveCardioItem.addActionListener(listener);
		
		JLabel lblNumberOfCardio = new JLabel("Number of cardio exercises to include:");
		lblNumberOfCardio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfCardio.setBounds(139, 359, 195, 14);
		getFrame().getContentPane().add(lblNumberOfCardio);
		
		//Text field for number of cardio exercises to include
		numberOfCardio = new JTextField();
		numberOfCardio.setText(fileManager.openNumber("cardioNumber.txt"));
		numberOfCardio.setColumns(10);
		numberOfCardio.setBounds(342, 356, 31, 20);
		getFrame().getContentPane().add(numberOfCardio);
		
		
		/** Back and Finish buttons*/
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 375, 110, 35);
		getFrame().getContentPane().add(btnBack);
		btnBack.addActionListener(listener);
		
		btnFinish = new JButton("Finish");
		btnFinish.setBounds(395, 375, 110, 35);
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
				Generator generator = new Generator(legListModel, numberOfLeg, cardioListModel, numberOfCardio);
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
				fileManager.saveList("Leg.txt", legListModel);
				fileManager.saveList("Cardio.txt", cardioListModel);
				fileManager.saveNumber("LegNumber.txt", numberOfLeg.getText());
				fileManager.saveNumber("CardioNumber.txt", numberOfCardio.getText());
				
				//Start ListDisplayGUI
				try {
					ListDisplayGUI newWindow = new ListDisplayGUI("LegWorkoutGUI", listModel);
					newWindow.getFrame().setVisible(true);	
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				//Dispose of this CardioWorkoutGUI
				frame.dispose();
			}
			
			//Add/Remove Leg Exercises
			if(btnAddLegItem == e.getSource()) {
				legListModel = addItem(legListModel);
			}
			if(btnRemoveLegItem == e.getSource()) {
				legListModel = removeItem(legList, legListModel);
			}
			
			//Add/Remove Cardio Exercises
			if(btnAddCardioItem == e.getSource()) {
				cardioListModel = addItem(cardioListModel);
			}
			if(btnRemoveCardioItem == e.getSource()) {
				cardioListModel = removeItem(cardioList, cardioListModel);
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
