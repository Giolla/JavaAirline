package userProfile;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Passenger extends Database implements ActionListener {
	JFrame frame;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
	JButton b1, b2, b3;
	Checkbox c1, c2, c3, c4, c5;
	CheckboxGroup cbGroup;
	JTextArea textArea;
	PreparedStatement prepStatement;
	Statement statement;
	ResultSet resultSet;
	int passenger_num;
	JLabel imgL;
	ImageIcon img;
	
	Passenger(int p) {
		passenger_num = p;

		imgL=new JLabel(img);
		imgL.setBounds(0,400,400,200);
		frame = new JFrame("Passenger");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		label1 = new JLabel("Username:");
		label1.setBounds(50,50,100,30);
		t1 = new JTextField(15);
		t1.setBounds(170,50,100,30);
		label2 = new JLabel("Password");
		label2.setBounds(50,100,100,30);
		t2 = new JTextField(15);
		t2.setBounds(170,100,100,30);
		label3 = new JLabel("First Name:");
		label3.setBounds(50,150,120,30);
		t3 = new JTextField(15);
		t3.setBounds(170,150,120,30);
		label4 = new JLabel("Last Name: ");
		label4.setBounds(50,200,120,30); 
		t4 = new JTextField(15);
		t4.setBounds(170,200,120,30);
		label5 = new JLabel("Social Security");
		label5.setBounds(50,250,120,30);
		t5 = new JTextField(10);
		t5.setBounds(170,250,140,30);
		label6 = new JLabel("Address:");
		label6.setBounds(50,300,120,30);
		t6 = new JTextField(25);
		t6.setBounds(170,300,180,30);
		label7 = new JLabel("Zip:");
		label7.setBounds(50,350,120,30);
		t7 = new JTextField(5);
		t7.setBounds(170,350,120,30);
		label8=new JLabel("State:");
		label8.setBounds(50,400,120,30);
		t8 = new JTextField(2);
		t8.setBounds(170,450,120,30);
		label9 = new JLabel("Phone Number:");
		label9.setBounds(50,500,120,30);
		t9 = new JTextField(10);
		t9.setBounds(170,500,120,30);
		label10 = new JLabel("Email:");
		label10.setBounds(50,550,120,30);
		t10 = new JTextField(20);
		t10.setBounds(170,550,120,30);
		label11 = new JLabel("Security Question:");
		label11.setBounds(50,600,120,30);
		t11 = new JTextField(50);
		t11.setBounds(170,650,120,30);
		label12 = new JLabel("Answer:");
		label12.setBounds(50,700,120,30);
		t12 = new JTextField(15);
		t12.setBounds(170,7000,120,30);

		
		b1 = new JButton("Save");
		b1.addActionListener(this);
		b2 = new JButton("Main Menu");
		b2.addActionListener(this);
		b2.setBounds(170,330,100,30);
		b3 = new JButton("Logout");
		b3.addActionListener(this);
		b3.setBounds(290,330,100,30);

		b1.setMnemonic('S');
		b2.setMnemonic('M');
		b3.setMnemonic('L');

		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(label3);
		frame.getContentPane().add(label4);
		frame.getContentPane().add(label5);
		frame.getContentPane().add(label6);
		frame.getContentPane().add(label7);
		frame.getContentPane().add(label8);
		frame.getContentPane().add(t1);
		frame.getContentPane().add(t2);
		frame.getContentPane().add(t3);
		frame.getContentPane().add(t4);
		frame.getContentPane().add(t5);
		frame.getContentPane().add(t6);
		frame.getContentPane().add(t7);
		frame.getContentPane().add(t8);
		frame.getContentPane().add(t9);
		frame.getContentPane().add(t10);
		frame.getContentPane().add(t11);
		frame.getContentPane().add(t12);
		frame.setSize(1300,1000);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			//lets users fill out form
			try	{
				String cat="";
				prepStatement = link.prepareStatement("insert into TempPassenger values(?,?,?,?,?,?,?,?,?,?,?,?)");
				prepStatement.setString(1,t1.getText());
				prepStatement.setString(2,t2.getText());
				prepStatement.setString(3,t3.getText());
				prepStatement.setString(4,t4.getText());
				prepStatement.setString(5,t5.getText());
				prepStatement.setString(6,t6.getText());
				prepStatement.setString(7,t7.getText());
				prepStatement.setString(8,t8.getText());
				prepStatement.setString(9,t9.getText());
				prepStatement.setString(10,t10.getText());
				prepStatement.setString(11,t11.getText());
				prepStatement.setString(12,t12.getText());

				statement=link.createStatement();
				resultSet = statement.executeQuery("select * from TempPassenger");
				while(resultSet.next()){
					prepStatement = link.prepareStatement("insert into Passenger values(?,?,?,?,?,?,?,?,?,?,?,?)");
					prepStatement.setString(1,resultSet.getString(1));
					prepStatement.setString(2,resultSet.getString(2));
					prepStatement.setString(3,resultSet.getString(3));
					prepStatement.setString(4,resultSet.getString(4));
					prepStatement.setString(5,resultSet.getString(5));
					prepStatement.setString(6,resultSet.getString(6));
					prepStatement.setString(7,resultSet.getString(7));
					prepStatement.setString(8,resultSet.getString(8));
					prepStatement.setString(9,resultSet.getString(9));
					prepStatement.setString(10,resultSet.getString(10));
					prepStatement.setString(11,resultSet.getString(11));
					prepStatement.setString(12,resultSet.getString(12));
				
				
					prepStatement.executeUpdate();
					prepStatement.close();
				}
				statement = con.createStatement();
				statement.executeUpdate("delete from TempPassenger");
				JOptionPane.showMessageDialog(null,"Record Saved");
				b2.setEnabled(false);
				b1.setEnabled(false);
				statement.close();
			} catch(Exception e1) {
				System.out.println("Connection failed:"+e1);
			}
		}
		
		if(e.getSource()==b2) {
			
			frame.setVisible(false);
			new Main();
		}

		if(e.getSource()==b3) {
			frame.setVisible(false);
			System.exit(0);
		}
	}	
	public static void main(String args[]){
		new Passenger(0);
	}
}