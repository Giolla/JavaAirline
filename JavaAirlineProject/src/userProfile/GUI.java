package userProfile;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class GUI extends JFrame {
	
	private JFrame frame;
	private JPanel panel1;
	private JLabel labelUser;
	private JLabel labelPass;
	private JTextField username;
	private JPasswordField password;
	private JButton button;


	private ArrayList <String> userNames = new ArrayList();
	private ArrayList <String> userPasswords = new ArrayList();

	private Color c = new Color (225,100,214);
	
	public GUI () {
		//call to Jframe constructor and pass in tiltle for window
		super("Log in");
		// !!! Need to figure out how to make txt and password fields closer together
		setLayout(new FlowLayout(45,95,145));
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		
		//
		//add(frame);
		add(panel1);
		//add(panel2);
		/**
		 * Need a Back button!! 
		 * 
		 * Need a splash screen
		 * 
		 * Also need to probably redo the layout to make it look better
		 * 
		 * Need a JoptionPane or another Frame that asks if user is a first time customer
		 * 
		 */
		
		panel1.add(username = new JTextField(10));
		panel1.add(labelUser = new JLabel("username"));
		panel1.add(password = new JPasswordField(10));
		panel1.add(labelPass = new JLabel("password"));
		panel1.add(button = new JButton("Enter"));
		
		//ActionListener obj
		Action act = new Action ();
		
		username.addActionListener(act);
		password.addActionListener(act);
		button.addActionListener(act);
		
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == username) {
				
				//logic here to check the username against database or we can just make an arrayList e.g....
				userNames.add(username.getText());
			} else if (event.getSource() == password) {
				
				// logic to store password (more than one user??)
				userPasswords.add(password.getText());
				
			} else if (event.getSource() == button) {
				//logic to move to the next window
				//and close current window
				//panel1.disable();
				
				
			}
			
		}
		
	}
	
}
