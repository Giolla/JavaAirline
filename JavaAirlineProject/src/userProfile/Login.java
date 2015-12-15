package userProfile;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Login implements ActionListener {
	
	JFrame frame;
	Main M;
	JLabel label1,label2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2, b3, b4;

	Login() {
		frame = new JFrame("Login");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		label1 = new JLabel("User Name");
		label1.setForeground(Color.BLUE);
		label1.setBounds(50,50,100,30);
		label2 = new JLabel("Password");
		label2.setForeground(Color.BLUE);
		label2.setBounds(50,80,100,30);
		t1 = new JTextField(10);
		t1.setForeground(Color.BLUE);
		t1.addActionListener(this);
		t1.setBounds(150,50,100,30);
		t2 = new JPasswordField(10);
		t2.setForeground(Color.BLUE);
		t2.setEchoChar('*');
		t2.addActionListener(this);
		t2.setBounds(150,80,100,30);
		b1 = new JButton("Ok");
		b1.setForeground(Color.BLUE);
		b1.addActionListener(this);
		b1.setBounds(65,120,100,30);
		b2 = new JButton("Cancel");
		b2.setForeground(Color.BLUE);
		b2.addActionListener(this);
		b2.setBounds(165,120,100,30);
		b3 = new JButton("Forgot Password");
		b3.addActionListener(this);
		b3.setBounds(65,150,100,30);
		b3.setForeground(Color.BLUE);

		b4 = new JButton("Registration");
		b4.addActionListener(this);
		b4.setBounds(165,150,100,30);
		b4.setForeground(Color.BLUE);
		b1.setMnemonic('O');
		b2.setMnemonic('C');
		b3.setMnemonic('f');
		b4.setMnemonic('r');

		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(t1);
		frame.getContentPane().add(t2);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(b3);
		frame.getContentPane().add(b4);

		frame.setBounds(300,300,300,250);
	
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
	// generic login made for now
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b1){
			if(t1.getText().length() == 0 || t2.getText().length() == 0){
				JOptionPane.showMessageDialog(null,"Fields are empty");
			} else if(t1.getText().equals("admin") && t2.getText().equals("1234")){
				frame.setVisible(false);
				M = new Main();
			} else {
				JOptionPane.showMessageDialog(null,"Invalid User Name or Password");
			}
		}
		if(e.getSource() == b3){
			frame.setVisible(false);
			new ForgotPassword();
		}
		if(e.getSource() == b4){
			frame.setVisible(false);
			new RegistrationForm();
		}
		
		if(e.getSource() == b2) {
			frame.setVisible(false);
			System.exit(0);
		}
	}
}




