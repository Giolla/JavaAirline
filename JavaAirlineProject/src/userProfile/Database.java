package userProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Database extends JFrame implements ActionListener   {
	
		JFrame frame;
		JButton search;
		JComboBox fromLoc, toLoc, fromDate, fromTime;
		JLabel fromLabel, toLabel, fromDateLabel, fromTimeLabel;
		PreparedStatement ps = null;
		Connection link;
		ResultSet rs = null;
		
	public  Database() {
		
		frame = new JFrame("Make a Reservation");
		frame.getContentPane().setLayout(null);		
	
		//Arrival date/time comboBoxes and labels
		fromDateLabel = new JLabel("Departure Date");
		fromDateLabel.setBounds(50,230,100,30);
		fromDate = new JComboBox(new String[]{"12/15/2015", 
				  "12/21/2015", "12/21/2015", "12/24/2015"});
		fromDate.addActionListener(this);
		fromDate.setBounds(50,200,100,30);
		
		fromTimeLabel = new JLabel("Departure Time");
		fromTimeLabel.setBounds(160,230,100,30);
		fromTime = new JComboBox(new String[]{"13:00", 
				  "15:00", "15:30", "08:00"});
		fromTime.addActionListener(this);
		fromTime.setBounds(160,200,100,30);
				
		//Departure label and comboBox
		fromLabel = new JLabel("Departure");
		fromLabel.setBounds(50,300,100,30);
		fromLoc = new JComboBox(new String[]{"Atlanta", 
				  "Charleston", "New York", "Los Angeles", 

"Orlando", "San Francisco"});
		fromLoc.addActionListener(this);
		fromLoc.setBounds(50,270,100,30);
		
		toLabel = new JLabel("Arrival");
		toLabel.setBounds(160,300,100,30);
		toLoc = new JComboBox(new String[]{"Atlanta", 
				  "Charleston", "New York", "Los Angeles", "Orlando", "San Francisco"});
		toLoc.addActionListener(this);
		toLoc.setBounds(160,270,100,30);
		
		search = new JButton("Ok");
		search.addActionListener(this);
		search.setBounds(270,270,100,30);
		
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
		
		frame.setSize(400,400);
		frame.setVisible(true);
		
		
		StateChange state = new StateChange();
		
		  try {
				// Driver for mysql
				Class.forName("com.mysql.jdbc.Driver");
				 // connection link obj
				 link = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Run4Ever");	
				 // query statement obj
				
		  	} catch (SQLException sqle) {
				System.out.println("An error occurred.Maybe user/password is invalid");
				sqle.printStackTrace();
			} catch (ClassNotFoundException cfne) {
				cfne.printStackTrace();
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		private class StateChange implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		// if (e.getStateChange() == ItemEvent.SELECTED) {
		//  String toLoc = (String)e.getItem();
		// System.out.println(s);
		    
		// here i just used strings to get content from comboBox
				String fromL = fromLoc.getSelectedItem().toString();
				String fromD = fromDate.getSelectedItem().toString();
				String toL = toLoc.getSelectedItem().toString();
				
				try {
								
				 ps = link.prepareStatement("select * from flights where from_date = ? and from_loc = ? and to_loc = ?");
				 ps.setString(1, fromD);
				 ps.setString(2, fromL);
				 ps.setString(3, toL);
				 rs = ps.executeQuery();
				 
				 while (rs.next()) {
					 
				}
				} catch (SQLException sqle) {
					System.out.println("An error occurred.Maybe user/password is invalid");
					sqle.printStackTrace();
				}
				
				
				
					
	}
		}
}
