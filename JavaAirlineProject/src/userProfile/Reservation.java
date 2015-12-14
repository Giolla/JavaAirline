package userProfile;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Reservation extends Database implements ActionListener,FocusListener {
	JFrame f;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	Choice h;
	JTextArea textArea;
	JButton b1,b2,b3;
	PreparedStatement prepStatement;
	Statement statement;
	ResultSet resultSet;
	int x;
	JLabel imgL;
	ImageIcon img;
	public void disable() {
		t1.setEnabled(false);
		t2.setEnabled(false);
		t3.setEnabled(false);
		t4.setEnabled(false);
		t5.setEnabled(false);
		t6.setEnabled(false);
		t7.setEnabled(false);
		h.setEnabled(false);
		b2.setEnabled(false);
	}
	
	public void enable() {
		t1.setEnabled(true);
		t2.setEnabled(true);
		t3.setEnabled(true);
		t4.setEnabled(true);
		t5.setEnabled(true);
		t6.setEnabled(true);
		t7.setEnabled(true);
		h.setEnabled(true);
		b2.setEnabled(true);
	}
	
	Reservation() {

		f = new JFrame("Reservation");
		f.getContentPane().setLayout(null);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		label1 = new JLabel("Passenger Number:");
		label1.setBounds(130,50,100,30);
		label2=new JLabel("Flight Number:");
		label2.setBounds(50,80,100,30);
		label3=new JLabel("Depart Time:");
		label3.setBounds(50,110,100,30);
		label4=new JLabel("Arrival Time:");
		label4.setBounds(250,140,100,30);
		label5=new JLabel("Depart Date:");
		label5.setBounds(50,170,100,30);
		label6=new JLabel("Depart From:");
		label6.setBounds(50,200,100,30);
		label7=new JLabel("To:");
		label7.setBounds(250,200,50,30);
		label8=new JLabel("Total Seats:");
		label8.setBounds(50,230,100,30);
		t1=new JTextField(10);
		t1.setBounds(230,50,120,30);
		t2=new JTextField(10);
		t2.addFocusListener(this);
		t2.setBounds(150,80,100,30);
		t3=new JTextField(10);
		t3.setBounds(150,110,100,30);
		t4=new JTextField(10);
		t4.setBounds(300,170,100,30);
		t5=new JTextField(10);
		t5.setBounds(150,200,100,30);
		t6=new JTextField(10);
		t6.setBounds(150,200,100,30);
		t7=new JTextField(10);
		t7.setBounds(300,230,100,30);

		b1=new JButton("Insert");
		b1.setBackground(Color.BLUE);
		b1.setBounds(50,270,100,30);
		b1.addActionListener(this);
		b2=new JButton("Next");
		b2.setBackground(Color.BLUE);
		b2.setBounds(160,270,100,30);
		b2.addActionListener(this);
		b3=new JButton("Main");
		b3.setBackground(Color.BLUE);
		b3.setBounds(270,270,100,30);
		b3.addActionListener(this);

		b1.setMnemonic('I');
		b2.setMnemonic('N');
		b3.setMnemonic('M');

		f.getContentPane().add(label1);
		f.getContentPane().add(label2);
		f.getContentPane().add(label3);
		f.getContentPane().add(label4);
		f.getContentPane().add(label5);
		f.getContentPane().add(label6);
		f.getContentPane().add(label7);
		f.getContentPane().add(label8);
		f.getContentPane().add(t1);
		f.getContentPane().add(t2);
		f.getContentPane().add(t3);
		f.getContentPane().add(t4);
		f.getContentPane().add(t5);
		f.getContentPane().add(t6);
		f.getContentPane().add(t7);
		f.getContentPane().add(h);
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().add(b3);
		f.getContentPane().add(imgL);
		f.setSize(1300,1000);
		f.setVisible(true);
		disable();
	}
	public void focusLost(FocusEvent e) {
		if(t2.getText().length()!= 0) {
			try {
				prepStatement = link.prepareStatement("select Flight_Num from Flights where Flight_Num =?");
				prepStatement.setString(1,t2.getText());
				resultSet=prepStatement.executeQuery();
				
				if(resultSet.next()){
					t3.setText(resultSet.getString(1));
				}
			} catch(Exception e1) {
				System.out.println("Connection failed:" + e1);
			}
		}
	}
	
	public void focusGained(FocusEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1) {
			enable();
			b1.setEnabled(false);
			try{
				statement = link.createStatement();
				resultSet = statement.executeQuery("select ? from Passenger");
				resultSet.next();
				x = resultSet.getInt(1);
				t1.setText(String.valueOf(x));

			} catch(Exception e1) {
				System.out.println("Connection failed:" + e1);
			}
		}
		if(e.getSource() == b2) {
			try {
				prepStatement = link.prepareStatement("insert into Reservation values(?,?,?,?,?,?,?,?)");
				prepStatement.setString(1,t1.getText());
				prepStatement.setString(2,t2.getText());
				prepStatement.setString(3,t3.getText());
				prepStatement.setString(4,h.getSelectedItem());
				prepStatement.setString(5,t4.getText());
				prepStatement.setString(6,t5.getText());
				prepStatement.setString(7,t6.getText());
				prepStatement.setString(8,t7.getText());
				prepStatement.executeUpdate();


				//update Passenger no.
				prepStatement = link.prepareStatement("update Passenger set Passenger_Num = ? where Passenger_Num = ?");
				prepStatement.setInt(1,(x+1));
				prepStatement.setInt(2,x);
				prepStatement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Record Saved");

				b1.setEnabled(true);
				b2.setEnabled(false);
				f.setVisible(false);
			} catch(Exception e1) {
				System.out.println("Connection failed:"+e1);
			}
			
			try {
				statement = link.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				resultSet = statement.executeQuery("select * from Reservation");
				resultSet.last();
				x = resultSet.getInt(1);
				Passenger P = new Passenger(x);
				statement = link.createStatement();
				resultSet = statement.executeQuery("select * from Passenger");
				resultSet.next();
				x = resultSet.getInt(1);
				P.t1.setText(String.valueOf(x));
				prepStatement = link.prepareStatement("update Passenger set Passenger_Num = ? where Passenger_Num =?");
				prepStatement.setInt(1,(x+1));
				prepStatement.setInt(2,x);
				prepStatement.executeUpdate();
			} catch(Exception e1) {
				
				System.out.println("Connection failed:" + e1);
			}
		}
		
		if(e.getSource() == b3) {
			f.setVisible(false);
			new Main();
		}
	}
			
	public static void main(String[] args) {
		new Reservation();
	}
}