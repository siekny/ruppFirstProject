package classMembers;

import java.util.Date;

public class UserClass extends PeopleClass{
	
	/*
	
	private int id;
	private String fullname;
	private String password;
	private String sex;
	private String address;
	private String email;
	private String phone;
	private String dateofbirth;
	private String typeofmembership;
	private int status;
	
	//*/
	
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
			String typeofmembership,
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
		
			super(id, fullname, password, sex, address, email, phone, dateofbirth, typeofmembership, status);
			this.username = username;
			this.dateofmembership = dateofmembership;
	}
	
	public String getUsername() {
		return this.username;
	}
	public String getDateofmembership() {
		return this.dateofmembership;
	}
	
	/*
	
	public int getID() {
		return this.id;
	}
	public String getFullname() {
		return this.fullname;
	}
	public String getAddress() {
		return this.address;
	}
	
	public String getTypeofmembership() {
		return this.typeofmembership;
	}
	public int getStatus() {
		return this.status;
	}
	public String getPassword() {
		return this.password;
	}
	public String getSex() {
		return this.sex;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getDOB() {
		return this.dateofbirth;
	}
	
	//*/
}
