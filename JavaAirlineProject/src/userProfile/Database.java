package userProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database  {
	
	public Database() {
	
		try {
		// Driver for mysql
			Class.forName("com.mysql.jdbc.Driver");
			
		// connection link obj
			Connection link = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Run4Ever");	
		//this obj creates a link to localhost database named "world" using username "root" and password "Run4Ever"
							
			} catch (SQLException sqle) {
				System.out.println("An error occurred. Maybe user/password is invalid");
				sqle.printStackTrace();
			} catch (ClassNotFoundException cfne) {
				cfne.printStackTrace();
			}
			
	}

}
