package classMembers;


public class Tables {
	
	private String tableID;
	private int numSeats;
	private int status;
	private String createdBy;
	private String createdAt;
	
	public Tables(String tableID, int numSeats, int status, String createdBy, String createdAt) {
		super();
		this.tableID = tableID;
		this.numSeats = numSeats;
		this.status = status;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
	}
	
	public Tables(String tableID, int numSeats, String createdAt) {
		super();
		this.tableID = tableID;
		this.numSeats = numSeats;
		this.createdAt = createdAt;
	}
	
	public Tables() {}
	
	public Object[] rowTables (int id) {
		return new Object[] {id, tableID, numSeats, status, createdAt, createdBy};
	}
	
	public String getTableID() {
		return tableID;
	}
	public void setTableID(String tableID) {
		this.tableID = tableID;
	}
	public int getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	public int isStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
