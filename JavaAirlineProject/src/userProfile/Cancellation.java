package userProfile;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

	public class Cancellation implements ActionListener, ItemListener {
		JFrame f;
		JLabel label1,label2,label3,label4,label5,label6;
		JTextField t1,t2,t3,t4,t5,t6,t7;
		JButton b1, b2, b3;
		Choice h;
		List list;
		Connection link;
		PreparedStatement prepStatement;
		ResultSet resultSet;
		Statement statement;
		
		Cancellation() {
			f = new JFrame("Cancel a Reservation");
			f.getContentPane().setLayout(null);
			
			
			// below it is supposed to create filled in text for the chosen flight number
			label1 = new JLabel("Flight_ID");
			label1.setBounds(130,50,50,30);
			label2 = new JLabel("From_Loc");
			label2.setBounds(50,90,100,30);
			label3 = new JLabel("To_Loc");
			label3.setBounds(50,120,100,30);
			label4 = new JLabel("Depart_Date");
			label4.setBounds(50,150,100,30);
			label5 = new JLabel("Depart_Time");
			label5.setBounds(50,180,100,30);
			label6 = new JLabel("Arrival_Time");
			label6.setBounds(50,210,100,30);
			
			h = new Choice();
			h.setBounds(230,50,140,30);
			h.addItemListener(this);
			t1 = new JTextField(10);
			t1.addActionListener(this);
			t1.setBounds(150,90,100,30);
			t2 =  new JTextField(10);
			t2.addActionListener(this);
			t2.setBounds(150,120,100,30);
			t3=new JTextField(10);
			t3.addActionListener(this);
			t3.setBounds(150,150,100,30);
			t4=new JTextField(10);
			t4.addActionListener(this);
			t4.setBounds(150,180,100,30);
			t5=new JTextField(10);
			t5.addActionListener(this);
			t5.setBounds(150,210,100,30);
			t6=new JTextField(10);
			t6.addActionListener(this);
			t6.setBounds(300,210,100,30);
			
			f.getContentPane().add(label1);
			f.getContentPane().add(label2);
			f.getContentPane().add(label3);
			f.getContentPane().add(label4);
			f.getContentPane().add(label5);
			f.getContentPane().add(label6);
			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			f.getContentPane().add(h);
			f.getContentPane().add(t1);
			f.getContentPane().add(t2);
			f.getContentPane().add(t3);
			f.getContentPane().add(t4);
			f.getContentPane().add(t5);
			f.getContentPane().add(t6);
			f.getContentPane().add(t7);
			f.getContentPane().add(list);
			f.setSize(1300,1000);
			f.setVisible(true);
			start();

			//named buttons and gave ActionListeners
			b1 = new JButton("Ok");
			b1.addActionListener(this);
			b1.setBounds(50,270,100,30);
			b2 = new JButton("Main Menu");
			b2.addActionListener(this);
			b2.setBounds(160,270,100,30);
			b3 = new JButton("Logout");
			b3.addActionListener(this);
			b3.setBounds(270, 270, 100, 30);

			//added buttons to frame
			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			f.getContentPane().add(b3);

			//set frame size and visibility
			f.setSize(900, 700);
			f.setVisible(true);

		}

		public void start(){
			try {
				statement = link.createStatement();
				resultSet = statement.executeQuery("select * from Booking where");
				while(resultSet.next()) {
					h.add(resultSet.getString(1));
				}
			} catch(Exception e){
				System.out.println("Connection failed:" + e);
			}
		}
		
		public void itemStateChanged(ItemEvent e){
			System.out.println((String)h.getSelectedItem());
			try {
				list.removeAll();
				prepStatement=link.prepareStatement("select Flight_ID from Booking, User where Flight_ID=?, and Username=");
				prepStatement.setString(1,h.getSelectedItem());
				resultSet=prepStatement.executeQuery();
				resultSet.next();
				t1.setText(resultSet.getString(2));
				t2.setText(resultSet.getString(3));
				t3.setText(resultSet.getString(4));
				t4.setText(resultSet.getString(5));
				t5.setText(resultSet.getString(6));
				t6.setText(resultSet.getString(7));
				t7.setText(resultSet.getString(8));
				prepStatement=link.prepareStatement("select * from Passenger where PNR_No=?");
				prepStatement.setString(1,h.getSelectedItem());
				resultSet=prepStatement.executeQuery();
				
				while(resultSet.next()) {
					list.add(resultSet.getString(2)+"                                  "+resultSet.getString(3)+"                           "+resultSet.getString(4));
				}
			} catch(Exception e1) {
				System.out.println("Connection failed"+e1);
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == b1) {
				try {
					prepStatement = link.prepareStatement("delete from Booking where Flight_ID=?");
					prepStatement.setString(1, h.getSelectedItem());
					prepStatement.executeUpdate();

					JOptionPane.showMessageDialog(null,"Reservation Cancelled");
					f.setVisible(false);
				} catch(Exception e1){
					System.out.println("Connection failed:"+e1);
				}
			}
			if(e.getSource() == b2){
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

