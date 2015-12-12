package userProfile;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


	class ViewReservation extends Database implements ActionListener {
		
		//opens frame and buttons
		JFrame f;
		JButton b1, b2;
		

		ViewReservation() {
			
			//name of the frame
			f = new JFrame("View Reservations");
			f.getContentPane().setLayout(null);

			//sets button size, name, and gave action listeners
			
			b1 = new JButton("Logout");
			b1.setBounds(160,270,100,30);
			b1.addActionListener(this);
			b2 = new JButton("Main Menu");
			b2.setBounds(270,270,100,30);
			b2.addActionListener(this);

			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			
			
			f.setSize(900, 700);
			f.setVisible(true);
			
		}
		
		
		//set what actions each button will perform
		public void actionPerformed(ActionEvent e) {
			//returns to main menu
			if(e.getSource() == b2) {
	
				f.setVisible(false);
				new Main();
			}
			//exits application
			else if(e.getSource() == b1) {
				f.setVisible(false);
				System.exit(0);
			}
		}

		public static void main(String args[]) {
			
			new ViewReservation();
		}
}
