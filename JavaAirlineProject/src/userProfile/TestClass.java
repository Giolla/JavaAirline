package userProfile;

import javax.swing.JFrame;

import java.awt.Color;
import java.sql.*;

public class TestClass extends Database {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		
		
		// call to connect to database method (need logic here to run
		// when user requests a query or this method could be called from another layer like the reservation screen GUI
		//connect();
		
		
		GUI window1 = new GUI();
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window1.setSize(700, 600);
		window1.setVisible(true);
		
		
		
		
		
	}

}
