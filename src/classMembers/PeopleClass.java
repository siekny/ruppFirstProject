package classMembers;

public class PeopleClass {
	
	protected int id;
	protected String fullname;	
	protected String sex;
	protected String address;
	protected String email;
	protected String phone;
	protected String dateofbirth;
	
	public PeopleClass(int id, String fullname, String sex, String address, String email, String phone,
			String dateofbirth) {
		this.id = id;
		this.fullname = fullname;

		this.sex = sex;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.dateofbirth = dateofbirth;
		
	}

	public int getID() {
		return id;
	}

	public String getFullname() {
		return fullname;
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
}
