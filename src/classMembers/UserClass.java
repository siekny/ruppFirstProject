package classMembers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import connection.DBConnection;

public class UserClass extends LibrarianClass{
	
	private String dateofmembership;
	private String username;
	
	public UserClass(
			int id,
			String fullname,
			String username,
			String password,
			String sex,
			String address,
			String email,
			String phone,
			String dateofbirth,
			String dateofmembership,
			int status
			){
		
			/*
		
			this.id = id;
			this.fullname = fullname;		
			this.password = password;
			this.sex = sex;
			this.address = address;
			this.email = email;
			this.phone = phone;
			this.dateofbirth = dateofbirth;
			this.status = status;
			this.typeofmembership = typeofmembership;
		
			//*/
		
			super(id, fullname, password, sex, address, email, phone, dateofbirth, status);
			this.username = username;
			this.dateofmembership = dateofmembership;
	}
	
	public UserClass() {
		
	}

	public static UserClass getUser(String username, String password) {
		
		try {
			Connection connection = DBConnection.connectDB();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sql = "SELECT * FROM users WHERE status != 1";
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				if(
						username.equals(resultSet.getString("fullname")) &&
						password.equals(resultSet.getString("password"))
				  ) { 
					return new UserClass(
											resultSet.getInt("id"),
											resultSet.getString("fullname"),
											resultSet.getString("username"),
											resultSet.getString("password"),
											resultSet.getString("sex"),
											resultSet.getString("address"),
											resultSet.getString("email"),
											resultSet.getString("phone"),
											resultSet.getString("dateofbirth"),
											resultSet.getString("dateofmembership"),
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
	
	public String getUsername() {
		return this.username;
	}
	
	public String getDateofmembership() {
		return this.dateofmembership;
	}
	
	

}
