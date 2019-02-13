package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection connectDB() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruppProject","root", "");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
}
