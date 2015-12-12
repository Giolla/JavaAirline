package userProfile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

	class Cancellation extends Database implements ActionListener {
		JFrame f;
		JButton b1, b2, b3;
		Cancellation() {
			f = new JFrame("Cancel a Reservation");
			f.getContentPane().setLayout(null);

			//named buttons and gave ActionListeners
			b1 = new JButton("Ok");
			b1.addActionListener(this);
			b1.setBounds(50,270,100,30);
			b2 = new JButton("Main Menu");
			b2.addActionListener(this);
			b2.setBounds(160,270,100,30);
			b3 = new JButton("Logout");
			b3.addActionListener(this);
			b3.setBounds(270,270,100,30);

			//added buttons to frame
			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			f.getContentPane().add(b3);

			//set frame size and visibility
			f.setSize(900,700);
			f.setVisible(true);

		}

		// Tells buttons what to do
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == b1) {
				f.setVisible(false);
				//not yet assigned a task
				
			}
			else if(e.getSource() == b2) {
	
				f.setVisible(false);
				new Main();
			}
			else if(e.getSource() == b3) {
				
				f.setVisible(false);
				System.exit(0);
			}
		}


		public static void main(String args[]) {
			new Cancellation();
		}
	}

