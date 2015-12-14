package userProfile;

import java.awt.*;
import javax.swing.*;
// welcome screen 
class Welcome implements Runnable {
	JFrame frame;
	JLabel label1,label2,label3;
	Thread thread;
	Login loggedIn;
	ImageIcon splash;
	Welcome() {
		splash = new ImageIcon("Splash.jpg");
		thread = new Thread(this);
		frame = new JFrame("Welcome");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		label1 = new JLabel("Java Airlines!");
		label1.setBounds(250,300,900,50);
		label1.setFont(new Font("Courier new",Font.BOLD,60));
		label1.setForeground(Color.RED);
		label2 = new JLabel("By Rodney, Javar, and Giorgi");
		label2.setFont(new Font("Courier new",Font.BOLD,35));
		label2.setBounds(350,380,800,40);
		label2.setForeground(Color.BLUE);
		label3 = new JLabel(splash);
		label3.setBounds(0,0,1300,1000);
		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(label3);
		frame.setSize(1300,1000);
		frame.setVisible(true);
		thread.start();
	}
	public void run(){
		int x = 1;
		while(x <= 5) {
			try {
				Thread.sleep(1000);
			} catch(Exception e){}
			x++;
		}
		frame.setVisible(false);
		loggedIn =new Login();
	}
}


