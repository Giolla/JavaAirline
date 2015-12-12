package userProfile;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


	class Reservation extends Database implements ActionListener {
		
		
		JFrame f;
		JButton b1,b2,b3;

		Reservation() {

			f = new JFrame("Make a Reservation");
			f.getContentPane().setLayout(null);

			//sets button size, name, and gave action listeners
			b1 = new JButton("Reserve");
			b1.setBounds(50,270,100,30);
			b1.addActionListener(this);
			b2 = new JButton("Logout");
			b2.setBounds(160,270,100,30);
			b2.addActionListener(this);
			b3 = new JButton("Main Menu");
			b3.setBounds(270,270,100,30);
			b3.addActionListener(this);

			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			f.getContentPane().add(b3);
			
			f.setSize(900, 700);
			f.setVisible(true);
			
		}
		
		//set what actions each button will perform
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == b1) {
				f.setVisible(false);
				
				//not yet assigned a task
				
			}
			else if(e.getSource() == b3) {
	
				f.setVisible(false);
				new Main();
			}
			else if(e.getSource() == b2) {
				
				f.setVisible(false);
				System.exit(0);
			}
		}

		public static void main(String args[])
		{
			new Reservation();
		}
}
