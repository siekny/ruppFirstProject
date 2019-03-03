package classMembers;

public class HistoryBookBorrowClass {
	
	private int id;
	private String stu_id;
	private String name;
	private String phone;
	
	public HistoryBookBorrowClass() {}
	public HistoryBookBorrowClass(int id, String stu_id, String name, String phone) {
		super();
		this.id = id;
		this.stu_id = stu_id;
		this.name = name;
		this.phone = phone;
	}
	
	public HistoryBookBorrowClass(String stu_id, String name, String phone) {
		super();
		this.stu_id = stu_id;
		this.name = name;
		this.phone = phone;
	}
	
	public Object[] getHistoryBook() {
		return new Object[] { stu_id, name, phone };
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
