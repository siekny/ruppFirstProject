package classMembers;

public class MemberRegisterClass extends PeopleClass {
	
	private String studentID;

	public MemberRegisterClass(int id, String fullname, String sex, String address, String email, String phone,
			String dateofbirth, String studentID) {
		super(id, fullname, sex, address, email, phone, dateofbirth);
		
		this.studentID = studentID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	

}
