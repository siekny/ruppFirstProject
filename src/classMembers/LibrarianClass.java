package classMembers;

public class LibrarianClass extends PeopleClass{

	protected String password;
	protected String typeofmembership;
	protected int status;
	
	
	public LibrarianClass(int id, String fullname, String password, String sex, String address, String email,
			String phone, String dateofbirth, String typeofmembership, int status) {
		
		super(id, fullname, sex, address, email, phone, dateofbirth);
		this.password = password;
		this.typeofmembership = typeofmembership;
		this.status = status;
	}
	
	public String getPassword() {
		return password;
	}

	public String getTypeofmembership() {
		return typeofmembership;
	}

	public int getStatus() {
		return status;
	}

}
