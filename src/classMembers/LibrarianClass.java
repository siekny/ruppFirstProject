package classMembers;

import java.util.ArrayList;
import java.util.List;

public class LibrarianClass extends PeopleClass{

	protected String password;
	protected String typeofmembership;
	protected int status;
	protected List<String> action;
	
	
	public LibrarianClass(int id, String fullname, String password, String sex, String address, String email,
			String phone, String dateofbirth, String typeofmembership, int status) {
		
		super(id, fullname, sex, address, email, phone, dateofbirth);
		this.password = password;
		this.typeofmembership = typeofmembership;
		this.status = status;
		
		action = new ArrayList<String>();
	}
	
	public void addListofAction(List<String> action) {
		this.action.addAll(action);
	}
	
	public void addAction(String action) {
		this.action.add(action);
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
