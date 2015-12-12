package userProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database  {
	

	private String departure;
	private String destination;
	
	
		public static void connect () throws SQLException, ClassNotFoundException {
	
					try {
			// Driver for mysql
			Class.forName("com.mysql.jdbc.Driver");
			
			// connection link obj
			Connection link = DriverManager.getConnection(
					//this obj creates a link to localhost database named "world" using username "root" and password "Run4Ever"
					"jdbc:mysql://localhost:3306/world", "root", "Run4Ever");
			// querry statement obj
			Statement qStatement = link.createStatement();
			// querry result return obj
			ResultSet qResult = qStatement.executeQuery("select * from city");
			
			// prints querry result while available (specified to print "Name" and "Population" columns from querry result)
			while (qResult.next()) {
				System.out.println(qResult.getString("Name") + " "
						+ qResult.getString("Population"));
			}
			} catch (SQLException sqle) {
			System.out
					.println("An error occurred. Maybe user/password is invalid");
			sqle.printStackTrace();
			} catch (ClassNotFoundException cfne) {
			cfne.printStackTrace();
			}
			
			}

}
