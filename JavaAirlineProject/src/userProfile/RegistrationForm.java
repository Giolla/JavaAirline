package userProfile;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationForm extends JFrame implements ActionListener {

  //Declared labels and text fields
    protected JLabel labelFirstName, labelLastName, labelAddress, labelSSN, 
    labelState, labelZip, labelUsername, labelEmail, labelPassword, 
    labelSecureQuest, labelSecureAns;
    
    protected JTextField textFirstName, textLastName, textAddress, textSSN, 
    textState, textZip, textUsername, textEmail, textSecureQuest, textSecureAns;
    
    JPasswordField JPasswordField1 = new JPasswordField();

   
    // declared buttons used on GUI screen
    private JButton submitButton, logoutButton;
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
            contentPane.setVisible(true);

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
            
           
    		JPasswordField1.setBounds(380,360,150,22);
    		JPasswordField1.setLocation(120, 290);
            contentPane.add(JPasswordField1);
            
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
            logoutButton.setText("Cancel");
            logoutButton.setLocation(250, 450);
            logoutButton.setSize(100, 30);
            contentPane.add(logoutButton);
            logoutButton.addActionListener(this);


            // set properties of window
            setTitle("Registration Screen");	
            setSize(500, 550);
            setVisible(true);
            
        } catch (Exception e) {
        }
    }
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent event) {
    	//if statements setting what actions each button will have if selected
		if(event.getSource() == logoutButton){
			System.exit(0);

		}
		if (event.getSource() == submitButton) {
			
			try {
				// Driver for mysql
				Class.forName("com.mysql.jdbc.Driver");
				 // connection link obj
				 Connection link = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Run4Ever");	
				 // query statement obj
				 
				 Statement stmt = link.createStatement();

				
					String customerSQL = "INSERT INTO USER VALUES ('" + textUsername.getText() + "' , '" + textFirstName.getText() + "' , '" + 
					textLastName.getText()+ "', '" + textAddress.getText() + "' , '" + textSSN.getText() 
					+ "' , '" + textState.getText()+ "', '" + textZip.getText()+ "' , '" 
					+  "' , '" + textEmail.getText()+ "' , '" + textSecureQuest.getText()
					+ "', '" + textSecureAns.getText() + "')";
					stmt.executeUpdate(customerSQL);
					JOptionPane.showMessageDialog(null, "Registration Successful");
				
				stmt.close();
				link.close();
			    } catch (ClassNotFoundException e) {
			    	System.out.println("An error occurred");
			    	e.printStackTrace();
				}

				catch(SQLException e) {
				e.printStackTrace();
			}
		
			new Main();
		}
		       
}

    public static void main(String args[]) {
    	new RegistrationForm();    
    	
    }
  
}
