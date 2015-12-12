package userProfile;
import java.awt.*;

import javax.swing.*;



import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {

  //Declared labels and text fields
    private JLabel labelFirstName, labelLastName, labelAddress, labelSSN, 
    labelState, labelZip, labelUsername, labelEmail, labelPassword, 
    labelSecureQuest, labelSecureAns;
    
    private JTextField textFirstName, textLastName, textAddress, textSSN, 
    textState, textZip, textUsername, textEmail, textPassword, textSecureQuest, textSecureAns;
   
    // declared buttons used on GUI screen
    private JButton mainButton, submitButton, logoutButton;
    // declare content pane
    private Container contentPane;

    public RegistrationForm() {
        registrationGUI();
    } 

    private void registrationGUI() {
        try {
        	
            // get content pane and set the layout to null
            contentPane = getContentPane();
            contentPane.setLayout(null);

            // create the name label and text box
            labelFirstName = new JLabel();
            labelFirstName.setText("First Name");	
            labelFirstName.setLocation(5, 10);	
            labelFirstName.setSize(200, 25);
            contentPane.add(labelFirstName);

            textFirstName = new JTextField();	
            textFirstName.setText("");
            textFirstName.setLocation(120, 10);	
            textFirstName.setSize(200, 25);   
            contentPane.add(textFirstName); 

         // create the name label and text box
            labelLastName = new JLabel();	
            labelLastName.setText("Last Name");	
            labelLastName.setLocation(5, 50);	
            labelLastName.setSize(200, 25);
            contentPane.add(labelLastName);

            textLastName = new JTextField();
            textLastName.setText("");
            textLastName.setLocation(120, 50);	
            textLastName.setSize(200, 25);  
            contentPane.add(textLastName); 
            
            // create the address label and text box
            labelAddress = new JLabel();
            labelAddress.setText("Address");
            labelAddress.setLocation(5, 90);
            labelAddress.setSize(80, 25);
            contentPane.add(labelAddress);

            textAddress = new JTextField();
            textAddress.setText("");
            textAddress.setLocation(120, 90);
            textAddress.setSize(200, 25);
            contentPane.add(textAddress);
            
            //create the SSN label and text box
            labelSSN = new JLabel();
            labelSSN.setText("SSN");
            labelSSN.setLocation(5, 210);
            labelSSN.setSize(300, 25);
            contentPane.add(labelSSN);

            textSSN = new JTextField();
            textSSN.setText("");
            textSSN.setLocation(120, 210);
            textSSN.setSize(130, 25);
            contentPane.add(textSSN);

            // create the user label and text box
            labelUsername = new JLabel();
            labelUsername.setText("Username");
            labelUsername.setLocation(5, 370);
            labelUsername.setSize(300, 25);
            contentPane.add(labelUsername);
             
            textUsername = new JTextField();
            textUsername.setText("");
            textUsername.setLocation(120, 370);
            textUsername.setSize(130, 25);
            contentPane.add(textUsername);
            
            // create the state label and text box
            labelState = new JLabel();
            labelState.setText("State");
            labelState.setLocation(5, 130);
            labelState.setSize(300, 25);
            contentPane.add(labelState);

            textState = new JTextField();
            textState.setText("");
            textState.setLocation(120, 130);
            textState.setSize(130, 25);
            contentPane.add(textState);

            labelZip = new JLabel();
            labelZip.setText("Zip Code");
            labelZip.setLocation(5, 170);
            labelZip.setSize(300, 25);
            contentPane.add(labelZip);

            textZip = new JTextField();
            textZip.setText("");
            textZip.setLocation(120, 170);
            textZip.setSize(130, 25);
            contentPane.add(textZip);
            
            labelEmail = new JLabel();
            labelEmail.setText("Email");
            labelEmail.setLocation(5, 250);
            labelEmail.setSize(300, 25);
            contentPane.add(labelEmail);
            
            textEmail = new JTextField();
            textEmail.setText("");
            textEmail.setToolTipText("Must be a valid email address containing ' @ '");
            textEmail.setLocation(120, 250);
            textEmail.setSize(130, 25);
            contentPane.add(textEmail);
            
            // create the password label and text box
            labelPassword = new JLabel();
            labelPassword.setText("Password");
            labelPassword.setLocation(5, 290);
            labelPassword.setSize(300, 25);
            contentPane.add(labelPassword);
            
            textPassword = new JTextField();
            textPassword.setText("");
            textPassword.setLocation(120, 290);
            textPassword.setSize(130, 25);
            contentPane.add(textPassword);
            
            //create security question
            labelSecureQuest = new JLabel();
            labelSecureQuest.setText("Security Question?");
            labelSecureQuest.setLocation(5, 330);
            labelSecureQuest.setSize(300, 25);
            contentPane.add(labelSecureQuest);

            textSecureQuest = new JTextField();
            textSecureQuest.setText("");
            textSecureQuest.setLocation(120, 330);
            textSecureQuest.setSize(130, 25);
            contentPane.add(textSecureQuest);
            
          //create security answer
            labelSecureAns = new JLabel();
            labelSecureAns.setText("Answer");
            labelSecureAns.setLocation(260, 330);
            labelSecureAns.setSize(300, 25);
            contentPane.add(labelSecureAns);

            textSecureAns = new JTextField();
            textSecureAns.setText("");
            textSecureAns.setLocation(320, 330);
            textSecureAns.setSize(130, 25);
            contentPane.add(textSecureAns);
            
            // create the buttons and give them size and location
            submitButton = new JButton();
            submitButton.setText("Submit");
            submitButton.setLocation(50, 450);
            submitButton.setSize(100, 30);
            contentPane.add(submitButton);
            submitButton.addActionListener(this);

            logoutButton = new JButton();
            logoutButton.setText("Logout");
            logoutButton.setLocation(250, 450);
            logoutButton.setSize(100, 30);
            contentPane.add(logoutButton);
            logoutButton.addActionListener(this);

            mainButton = new JButton();
            mainButton.setText("Main Menu");
            mainButton.setLocation(150, 450);
            mainButton.setSize(100, 30);
            contentPane.add(mainButton);
            mainButton.addActionListener(this);

            // set properties of window
            setTitle("Registration Screen");	
            setSize(900, 700);
            setVisible(true);
            
        } catch (Exception e) {
        }
    }
    public void actionPerformed(ActionEvent event) {
    	//if statements setting what actions each button will have if selected
		if(event.getSource() == logoutButton){
			System.exit(0);

		}
		if (event.getSource() == submitButton) {
			//tells the submit button what to do and then enters main menu			

			
			new Main();
		}
		//tells the main button what to do
		if (event.getSource() == mainButton){
			
			new Main();
		}
       
}

    public static void main(String args[]) {
    	new RegistrationForm();    
    	
    }
  
}
