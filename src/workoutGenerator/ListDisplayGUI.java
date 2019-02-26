package workoutGenerator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;


public class ListDisplayGUI extends JFrame{
 
	/** Default Serial ID */ 
	private static final long serialVersionUID = 1L;

	/** Frame */
	private JFrame frame;
	
	/** Text Field */
	private JTextField emailTextField;
	
	/** ButtonListener for the various buttons */
	private ButtonListener listener;
	
	/** Buttons */
	private JButton btnEmail;
	private JButton btnBack;
	private JButton btnClose;
	
	/** Name of GUI we came from */
	private String prevGUI;
	
	/** ListModel provided by the generator */
	private DefaultListModel<String> listModel;
	
	/** FileManager to open and save email text field */
	private FileManager fileManager;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultListModel<String> testList = new DefaultListModel<String>();
					testList.addElement("Item 1");
					testList.addElement("Item 2");
					ListDisplayGUI window = new ListDisplayGUI("WorkoutTypeGUI", testList);
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
	public ListDisplayGUI(String prevGUI, DefaultListModel<String> listModel) {
		this.prevGUI = prevGUI;
		this.listModel = listModel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Basic frame settings
		frame = new JFrame("Workout Generator");
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//ButtonListener
		listener = new ButtonListener();
		
		//FileManager
		fileManager = new FileManager();
		
		//Labels
		JLabel lblTodaysWorkout = new JLabel("Today's Workout:");
		lblTodaysWorkout.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTodaysWorkout.setBounds(10, 9, 156, 22);
		frame.getContentPane().add(lblTodaysWorkout);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmailAddress.setBounds(10, 253, 93, 14);
		frame.getContentPane().add(lblEmailAddress);
		
		//List
		JScrollPane scrollPane = new JScrollPane();
		JList<String> list = new JList<String>(listModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setBounds(10, 34, 364, 208);
		scrollPane.setViewportView(list);
		frame.getContentPane().add(scrollPane);
		
		//Email Address Text Field
		emailTextField = new JTextField();
		emailTextField.setText(fileManager.openNumber("recipientEmail.txt"));	//Even though it's called "openNumber", this method will also work for an email address
		emailTextField.setBounds(10, 271, 229, 22);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		//Email Button
		btnEmail = new JButton("Email Workout");
		btnEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEmail.setBounds(249, 271, 125, 23);
		frame.getContentPane().add(btnEmail);
		btnEmail.addActionListener(listener);
		
		//Back Button
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBack.setBounds(10, 327, 125, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(listener);
		
		//Close Button
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClose.setBounds(249, 327, 125, 23);
		frame.getContentPane().add(btnClose);
		btnClose.addActionListener(listener);
	}
	
	/******************************************************************
    Controls what to do when a button is pressed
	*****************************************************************/
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			//Email Button Event
			if(btnEmail == e.getSource()) {
				boolean emailSent = GoogleMail.SendEmail(emailTextField.getText(), listModel);
				if(emailSent) {
					JOptionPane.showMessageDialog(getFrame(), "Message sent");		//Notify that message was sent
					fileManager.saveNumber("recipientEmail.txt", emailTextField.getText());		//Save the email address entered in the text field
				}
			}
			
			//Back Button Event
			if(btnBack == e.getSource()) {
				//Open the GUI we came from
				try {
					if(prevGUI == "WorkoutTypeGUI") {
						WorkoutTypeGUI newWindow = new WorkoutTypeGUI();
						newWindow.getFrame().setVisible(true);	
					}
					else if(prevGUI == "BicepWorkoutGUI") {
						BicepWorkoutGUI newWindow = new BicepWorkoutGUI();
						newWindow.getFrame().setVisible(true);	
					}				
					else if(prevGUI == "TricepWorkoutGUI") {
						TricepWorkoutGUI newWindow = new TricepWorkoutGUI();
						newWindow.getFrame().setVisible(true);	
					}
					else if(prevGUI == "LegWorkoutGUI") {
						LegWorkoutGUI newWindow = new LegWorkoutGUI();
						newWindow.getFrame().setVisible(true);	
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
				//Dispose of this frame
				frame.dispose();
			}
			
			//Close Button Event
			if(btnClose == e.getSource()) {
				//Dispose of this frame
				frame.dispose();
			}
			
		}
	}
	
	/******************************************************************
    Getter allows frame to be accessed from another GUI
	*****************************************************************/
	public JFrame getFrame() {
		return frame;
	}
}