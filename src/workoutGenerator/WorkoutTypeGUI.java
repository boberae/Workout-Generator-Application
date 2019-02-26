package workoutGenerator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class WorkoutTypeGUI extends JFrame {

	/** Default Serial ID */
	private static final long serialVersionUID = 1L;

	/** Frame*/
	private JFrame frame;
	
	/** Buttons */
	private JButton btnContinue;
	
	/** Button Listener */
	private ButtonListener listener;
	
	/** RadioButtons */
	private JRadioButton rdbtnBicep;
	private JRadioButton rdbtnTricep;
	private JRadioButton rdbtnLeg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkoutTypeGUI window = new WorkoutTypeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WorkoutTypeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Basic Frame settings
		frame = new JFrame("Workout Generator");
		frame.setBounds(100, 100, 335, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Button listener
		listener = new ButtonListener();
		
		//Label
		JLabel lblSelectMuscleGroup = new JLabel("Select muscle group for today's workout:");
		lblSelectMuscleGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectMuscleGroup.setBounds(10, 11, 335, 20);
		frame.getContentPane().add(lblSelectMuscleGroup);
		
		//RadioButtons for workout type
		rdbtnBicep = new JRadioButton("Back, Biceps, Abs");
		rdbtnBicep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnBicep.setBounds(6, 47, 152, 23);
		frame.getContentPane().add(rdbtnBicep);
		
		rdbtnTricep = new JRadioButton("Chest, Triceps, Shoulders");
		rdbtnTricep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnTricep.setBounds(6, 73, 152, 23);
		frame.getContentPane().add(rdbtnTricep);
		
		rdbtnLeg = new JRadioButton("Legs");
		rdbtnLeg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnLeg.setBounds(6, 99, 109, 23);
		frame.getContentPane().add(rdbtnLeg);
		
		//Setting the three RadioButtons as a ButtonGroup allows only one to be selected
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnBicep);
		rdbtnGroup.add(rdbtnTricep);
		rdbtnGroup.add(rdbtnLeg);
		
		//Continue Button
		btnContinue = new JButton("Continue");
		btnContinue.setBounds(220, 137, 89, 23);
		frame.getContentPane().add(btnContinue);
		btnContinue.addActionListener(listener);
	}
	
	/******************************************************************
    Controls what to do when a button is pressed
	******************************************************************/
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			//Continue Button Event
			if(btnContinue == e.getSource()) {

				if(rdbtnBicep.isSelected()) {
					//Open BicepWorkoutGUI
					try {
						BicepWorkoutGUI newWindow = new BicepWorkoutGUI();
						newWindow.getFrame().setVisible(true);	
					} catch (Exception e1) {
						e1.printStackTrace();
					}				
					//Dispose of this WorkoutTypeGUI
					frame.dispose();
				}
				
				else if(rdbtnTricep.isSelected()) {
					//Open TricepWorkoutGUI
					try {
						TricepWorkoutGUI newWindow = new TricepWorkoutGUI();
						newWindow.getFrame().setVisible(true);	
					} catch (Exception e1) {
						e1.printStackTrace();
					}				
					//Dispose of this WorkoutTypeGUI
					frame.dispose();
				}
				
				else if(rdbtnLeg.isSelected()) {
					//Open LegWorkoutGUI
					try {
						LegWorkoutGUI newWindow = new LegWorkoutGUI();
						newWindow.getFrame().setVisible(true);	
					} catch (Exception e1) {
						e1.printStackTrace();
					}				
					//Dispose of this WorkoutTypeGUI
					frame.dispose();
				}
				
				else {
					JOptionPane.showMessageDialog(getFrame(), "Please select a muscle group for the workout.");
				}
			}
						
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


}
