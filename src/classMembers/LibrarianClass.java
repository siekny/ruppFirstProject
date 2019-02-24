package classMembers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.DBConnection;

public class LibrarianClass extends PeopleClass{

	protected String dateofmembership;
	protected String username;
	protected String password;
	protected int status;
	
	public LibrarianClass() {

	}
	
	public LibrarianClass(int id, String fullname, String username, String password, String sex, String address, String email,
			String phone, String dateofbirth, String dateofmembership, int status) {
		
		super(id, fullname, sex, address, email, phone, dateofbirth);
		this.password = password;
		this.status = status;	
		this.dateofmembership = dateofmembership;
		this.username = username;
	}
	
	public static ArrayList<InformationClass> getListOfAction(int id){
		
		ArrayList<InformationClass> list = new ArrayList<InformationClass>();
		
		try {
			Connection connection = DBConnection.connectDB();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			
			String sql = "SELECT date, action FROM users_info WHERE userid = " + id;
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(new InformationClass(resultSet.getString("date"), resultSet.getString("action")));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	public void addAction(InformationClass info) {	
		try {
			Connection connection = DBConnection.connectDB();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "INSERT INTO users_info (userid, date, action) VALUES ('"+ id +"', '"+ info.getDate() +"', '"+ info.getAction() +"')";
			statement.execute(sql);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}		
	}

	public String getPassword() {
		return password;
	}

	public int getStatus() {
		return status;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getDateofmembership() {
		return dateofmembership;
	}

}
