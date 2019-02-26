package workoutGenerator;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;


public class GoogleMail {

	public static void main(String[] args) {
		DefaultListModel<String> testList = new DefaultListModel<String>();
		testList.addElement("Item 1");
		testList.addElement("Item 2");
		testList.addElement("Item 3");
		SendEmail("tonybober94@gmail.com", testList);
	}
	
	public static boolean SendEmail (String recipient, DefaultListModel<String> listModel) {
		
		//Username and password for sender account
		final String username = "WorkoutGeneratorApplication@gmail.com";
		final String password = "WorkoutGenerator1!";

		//Properties for GMail via SMTP
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		//Start an SMTP session
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		//Converting the ListModel to a string to be sent
		String messageBody = "";
		for(int i = 0; i<listModel.getSize(); i++) {
			messageBody += listModel.getElementAt(i) + "\n";
		}

		//Send the email
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipient));
			message.setSubject("Today's Workout");
			message.setText("Here is today's workout:\n\n" + messageBody);

			Transport.send(message);

			return true;	//Return true if message delivered successfully

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
			
	}
}