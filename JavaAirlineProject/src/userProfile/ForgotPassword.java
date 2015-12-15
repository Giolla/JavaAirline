package userProfile;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;




	public class ForgotPassword implements ActionListener {
		
		//opens frame and buttons
		JFrame f1;
	
		
		JButton enterButt, cancelButt, quitButt;
	
		ForgotPassword() {
			
			
			f1 = new JFrame("Forgot Password");
			f1.getContentPane().setLayout(null);
			f1.getContentPane().setBackground(Color.LIGHT_GRAY);
			//Set boundaries for buttons and ActionListeners

			enterButt = new JButton("Enter");
			enterButt.addActionListener(this);
			enterButt.setBounds(50, 60, 210, 60);
			
			cancelButt = new JButton("Cancel to Login");
			cancelButt.addActionListener(this);
			cancelButt.setBounds(50, 120, 210, 60);
			quitButt = new JButton("Quit");
			quitButt.addActionListener(this);
			quitButt.setBounds(50, 180, 210, 60);

			
		
			
			f1.getContentPane().add(enterButt);
		
			f1.getContentPane().add(cancelButt);
			f1.getContentPane().add(quitButt);

			f1.setSize(400, 400);
			f1.setVisible(true);

		}
		public void actionPerformed(ActionEvent e) {
	
			//if statements setting what actions each button will have if selected
			if(e.getSource() == enterButt){
	
				//if (ans == ) {
					
				f1.setVisible(false);
				new Main();
				//} else {
					//JOptionPane.showMessageDialog(null,"Incorrect answer, try again");
					
				//}
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
