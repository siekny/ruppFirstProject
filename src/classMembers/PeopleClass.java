package classMembers;

public class PeopleClass {
	protected int id;
	protected String fullname;
	protected String password;
	protected String sex;
	protected String address;
	protected String email;
	protected String phone;
	protected String dateofbirth;
	protected String typeofmembership;
	protected int status;
	
	public PeopleClass(int id, String fullname, String password, String sex, String address, String email, String phone,
			String dateofbirth, String typeofmembership, int status) {
		this.id = id;
		this.fullname = fullname;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.dateofbirth = dateofbirth;
		this.typeofmembership = typeofmembership;
		this.status = status;
	}

	public int getID() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public String getPassword() {
		return password;
	}

	public String getSex() {
		return sex;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public String getTypeofmembership() {
		return typeofmembership;
	}

	public int getStatus() {
		return status;
	}
}
