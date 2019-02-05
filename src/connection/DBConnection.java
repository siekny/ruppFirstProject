package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	// JDBC driver name and database URL
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final static String DB_URL = "jdbc:mysql://localhost/rupp_database";

	//  Database credentials
	private final static String USER = "root";
	private final static String PASS = "";
	
	public static Connection connection () {
		Connection conn = null;
		
		try {
			//Register JDBC driver
		      Class.forName(JDBC_DRIVER);
		      
			//Open a connection
		    System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);

		 
		}catch(SQLException se){
	        //Handle errors for JDBC
	        se.printStackTrace();
	   }catch(Exception e){
	       //Handle errors for Class.forName
	       e.printStackTrace();
	   }
		return conn;
	}
}
