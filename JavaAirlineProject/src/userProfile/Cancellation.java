package userProfile;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

	public class Cancellation implements ActionListener{
		JFrame frame;
		JButton search, logout;
		JComboBox fromLoc, toLoc, fromDate, fromTime;
		JLabel fromLabel, toLabel, fromDateLabel, fromTimeLabel;
		PreparedStatement ps = null;
		Connection link;
		ResultSet rs = null;
		
	public  Cancellation() {
		
		frame = new JFrame("Cancel a Reservation");
		frame.getContentPane().setLayout(null);		
	
		//Arrival date/time comboBoxes and labels
		fromDateLabel = new JLabel("Departure Date");
		fromDateLabel.setBounds(50,230,100,30);
		fromDate = new JComboBox(new String[]{"12/15/2015", 
				  "12/21/2015", "12/21/2015", "12/24/2015"});
		fromDate.addActionListener(this);
		fromDate.setBounds(50, 200, 100, 30);
		
		fromTimeLabel = new JLabel("Departure Time");
		fromTimeLabel.setBounds(160, 230, 100, 30);
		fromTime = new JComboBox(new String[]{"13:00", 
				  "15:00", "15:30", "08:00"});
		fromTime.addActionListener(this);
		fromTime.setBounds(160, 200, 100, 30);
				
		//Departure label and comboBox
		fromLabel = new JLabel("Departure");
		fromLabel.setBounds(50,300,100,30);
		fromLoc = new JComboBox(new String[]{"Atlanta", 
				  "Charleston", "New York", "Los Angeles", 

"Orlando", "San Francisco"});
		fromLoc.addActionListener(this);
		fromLoc.setBounds(50, 270, 100, 30);
		
		toLabel = new JLabel("Arrival");
		toLabel.setBounds(160,300,100,30);
		toLoc = new JComboBox(new String[]{"Atlanta", 
				  "Charleston", "New York", "Los Angeles", "Orlando", "San Francisco"});
		toLoc.addActionListener(this);
		toLoc.setBounds(160, 270, 100, 30);
		
		search = new JButton("Main Menu");
		search.addActionListener(this);
		search.setBounds(270, 270, 100, 30);
		
		logout = new JButton("Logout");
		logout.addActionListener(this);
		logout.setBounds(270, 200, 100, 30);
		
		//adding the buttons in frame
		frame.getContentPane().add(fromDateLabel);
		frame.getContentPane().add(fromDate);
		frame.getContentPane().add(fromTimeLabel);
		frame.getContentPane().add(fromTime);
		frame.getContentPane().add(fromLabel);
		frame.getContentPane().add(fromLoc);
		frame.getContentPane().add(toLabel);
		frame.getContentPane().add(toLoc);
		frame.getContentPane().add(search);
		frame.getContentPane().add(logout);

		
		frame.setSize(400, 400);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == search){
			frame.setVisible(false);
			new Main();
		}
		
		if(e.getSource() == logout) {
			frame.setVisible(false);
			System.exit(0);
		
	}
	}

		

		public static void main(String args[]) {
			new Cancellation();
		}
		
	}

