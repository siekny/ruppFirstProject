package classMembers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DBConnection;

public class AdminClass extends LibrarianClass{

	public AdminClass(int id, String fullname, String password, String sex, String address, String email, String phone,
			String dateofbirth, int status) {
		super(id, fullname, password, sex, address, email, phone, dateofbirth, status);

	}
	
	public static AdminClass getAdmin(String username, String password) {
		
		try {
			Connection connection = DBConnection.connectDB();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sql = "SELECT * FROM users WHERE status = 1";
			ResultSet resultSet = statement.executeQuery(sql);
			
			
			
			while(resultSet.next()) {
				if(
						username.equals(resultSet.getString("fullname")) &&
						password.equals(resultSet.getString("password"))
				  ) { 
					return new AdminClass(
											resultSet.getInt("id"),
											resultSet.getString("fullname"),
											resultSet.getString("password"),
											resultSet.getString("sex"),
											resultSet.getString("address"),
											resultSet.getString("email"),
											resultSet.getString("phone"),
											resultSet.getString("dateofbirth"),
											resultSet.getInt("status")
										  );
					
					}
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
