package userProfile;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



	public class Main implements ActionListener {
		
		//opens frame and buttons
		JFrame f;
		JButton reserveBut, /*paxBut,*/ cancelBut, exitBut;
		
		Reservation r;
		Cancellation c;


		Main() {
			
			f = new JFrame("Main Menu");
			f.getContentPane().setLayout(null);
			f.getContentPane().setBackground(Color.LIGHT_GRAY);
			//Set boundaries for buttons and ActionListeners

			reserveBut = new JButton("Search Reservation");
			reserveBut.addActionListener(this);
			reserveBut.setBounds(150,390,210,60);
			/*paxBut = new JButton("View Passenger");
			paxBut.addActionListener(this);
			paxBut.setBounds(580,390,210,60);*/
			cancelBut = new JButton("Cancel Reservation");
			cancelBut.addActionListener(this);
			cancelBut.setBounds(580,390,210,60);
			exitBut = new JButton("Logout");
			exitBut.addActionListener(this);
			exitBut.setBounds(580,490,210,60);


			f.getContentPane().add(reserveBut);
			/*f.getContentPane().add(paxBut);*/
			f.getContentPane().add(cancelBut);
			f.getContentPane().add(exitBut);

			f.setSize(900,700);
			f.setVisible(true);

		}
		public void actionPerformed(ActionEvent e) {
	
			//if statements setting what actions each button will have if selected
			if(e.getSource() == reserveBut){
	
				f.setVisible(false);
				r = new Reservation();

			}
			
			/*if (e.getSource() == paxBut) {
				f.setVisible(false);
			    new Passenger();
			}*/

			if(e.getSource() == cancelBut) {
	
				f.setVisible(false);
				new Cancellation();
			}
			if(e.getSource() == exitBut) {
				
				f.setVisible(false);
				System.exit(0);
			}
		}
		public static void main(String args[]) {
			//opens the main menu
			 new Main();
		}
}