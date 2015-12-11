package userProfile;
import java.awt.*;
import javax.swing.*;


public class GUI extends JFrame {

	
	private Color c = new Color (225,100,214);
	
	public GUI () {
		super("Log in");
		setLayout(new FlowLayout(45,95,145));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		add(panel1);
		add(panel2);
		
		panel1.add(new JTextField(10));
		panel1.add(new JLabel("username"));
		panel1.add(new JPasswordField(10));
		panel1.add(new JLabel("password"));
		panel1.add(new JButton("Enter"));

		
	}
	
	
	
}
