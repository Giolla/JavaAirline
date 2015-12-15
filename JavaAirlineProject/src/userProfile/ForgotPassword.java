package userProfile;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;




	public class ForgotPassword implements ActionListener {
		
		//opens frame and buttons
		JFrame f1;
		JLabel label1, label2, label3;
		JTextField t1;
		String password = "1234", answer;
		
		JButton enterButt, cancelButt, quitButt;
	
		ForgotPassword() {
			
			label1 = new JLabel("How are you today?");
			label1.setForeground(Color.BLUE);
			label1.setBounds(15, 10, 150, 40);
			label2 = new JLabel("Your Password is:");
			label2.setForeground(Color.BLUE);
			label2.setBounds(15, 70, 150, 40);
			label3 = new JLabel(password);
			label3.setForeground(Color.BLUE);
			label3.setBounds(200, 70, 150, 30);
			label3.setVisible(false);
			
			t1 = new JTextField(10);
			t1.setForeground(Color.BLUE);
			t1.addActionListener(this);
			t1.setBounds(200, 10, 150, 30);
			
			
			f1 = new JFrame("Forgot Password");
			f1.getContentPane().setLayout(null);
			f1.getContentPane().setBackground(Color.LIGHT_GRAY);
			//Set boundaries for buttons and ActionListeners

			enterButt = new JButton("Enter");
			enterButt.addActionListener(this);
			enterButt.setBounds(50, 120, 210, 60);
			
			cancelButt = new JButton("Cancel to Login");
			cancelButt.addActionListener(this);
			cancelButt.setBounds(50, 180, 210, 60);
			quitButt = new JButton("Quit");
			quitButt.addActionListener(this);
			quitButt.setBounds(50, 240, 210, 60);

			
		
			
			f1.getContentPane().add(enterButt);
		
			f1.getContentPane().add(cancelButt);
			f1.getContentPane().add(quitButt);
			f1.getContentPane().add(label1);
			f1.getContentPane().add(t1);
			f1.getContentPane().add(label2);
			f1.getContentPane().add(label3);
			f1.setSize(400, 400);
			f1.setVisible(true);

		}
		public void actionPerformed(ActionEvent e) {
	
			//if statements setting what actions each button will have if selected
			if(e.getSource() == enterButt){
				
					if(t1.getText().length() == 0){
						
						JOptionPane.showMessageDialog(null,"Fields are empty");
						
					} else if(t1.getText().equals("good")){
						
						label3.setVisible(true);
						
						f1.setVisible(false);
						
					} else {
						
						JOptionPane.showMessageDialog(null,"Invalid Answer");
					}
			}
			
			if(e.getSource() == cancelButt) {
	
				f1.setVisible(false);
				new Login();
			}
			if(e.getSource() == quitButt) {
				
				f1.setVisible(false);
				System.exit(0);
			}
		}
		public static void main(String args[]) {
			
			 new ForgotPassword();
		}
}
