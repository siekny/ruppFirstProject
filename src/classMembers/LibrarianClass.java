package classMembers;

import java.util.ArrayList;
import java.util.List;

public class LibrarianClass extends PeopleClass{

	protected String password;
	protected int status;
	protected List<String> action;
	
	public LibrarianClass() {
		super();
	}
	
	public LibrarianClass(int id, String fullname, String password, String sex, String address, String email,
			String phone, String dateofbirth, int status) {
		
		super(id, fullname, sex, address, email, phone, dateofbirth);
		this.password = password;
		this.status = status;
		
		action = new ArrayList<String>();
	}
	
	public LibrarianClass getLibrarian() {
		
		return new LibrarianClass();
	}
	
	public void addListofAction(List<String> action) {
		this.action.addAll(action);
	}
	
	public void addAction(String action) {
		this.action.add(action);
	}
	
	public ArrayList<String> getListOfAction(){
		return (ArrayList<String>) action;
	}
	
	public String getPassword() {
		return password;
	}

	public int getStatus() {
		return status;
	}

}
