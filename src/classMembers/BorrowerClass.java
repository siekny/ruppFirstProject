package classMembers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowerClass {
	
	private int id;
	private String student_id;
//	private int book_id;
	private BookClass book;
	
	
	private String studentName;
	private String studentCurrentPhone;
	private String bookISBN;
	
	private int borrowQTY;
	private String borrowedDate;
	
	private String returnDate;
	private int status;
	
	public BorrowerClass() {}
	
	public BorrowerClass(String student_id, int book_id, String studentName, String studentCurrentPhone,
			String bookISBN, int borrowQTY, String borrowedDate, int status) {
		super();
		 book = new BookClass();
		this.student_id = student_id;
		this.book.setID(book_id);
		this.studentName = studentName;
		this.studentCurrentPhone = studentCurrentPhone;
		this.bookISBN = bookISBN;
		this.borrowQTY = borrowQTY;
		this.borrowedDate = borrowedDate;
		this.status = status;
	}
	
	public BorrowerClass(int id, String student_id, int book_id, String studentName, String studentCurrentPhone,
			String bookISBN, int borrowQTY, String borrowedDate, String returnDate,
			int status) {
		super();
		 book = new BookClass();
		this.id = id;
		this.student_id = student_id;
		this.book.setID(book_id);
		this.studentName = studentName;
		this.studentCurrentPhone = studentCurrentPhone;
		this.bookISBN = bookISBN;
		this.borrowQTY = borrowQTY;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.status = status;
		
	}
	public BorrowerClass(int id, String student_id, String returnDate) {
		this.id = id;
		this.student_id = student_id;
		this.returnDate = returnDate;
	}
	
	public Object[] getBorrowColumns() {
		
		return new Object[] {id, student_id, book.getID(), studentName, studentCurrentPhone, bookISBN, borrowQTY, borrowedDate, actualReturnDate()};
	}
	
	public BookClass getBook() {
		return book;
	}
	
	public void setBook(BookClass book) {
		this.book = book;
	}
	
	public String actualReturnDate() {
		return returnDate;
	}
	public String getReturnDate() {
		String return_date = "";
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
			int amountDaysReturn = 7;
			Date getborrowedDate = sdf.parse(borrowedDate);
			 
			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
			long diff = getborrowedDate.getTime() + amountDaysReturn*24*60*60*1000;
 
			DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
			return_date = df.format(new Date(diff));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return return_date;
		
	}
	public int getSubstractDays() {
		int diffDays = 0;
		try {
			DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
			String actualReturnDate = df.format(new Date());
			SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
			Date getreturnDate = sdf.parse(getReturnDate());
			Date getactualReturnDate = sdf.parse(actualReturnDate);
			 
			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
			long diff = getactualReturnDate.getTime() - getreturnDate.getTime();
 
			diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			if(diffDays <1)
				diffDays = 0;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diffDays;
	}
	
	public double getFineOverDays(int overDays) {
		int feePerDay = 1000;
		return feePerDay * overDays;
	}

	public int getId() {
		return id;
	}
	
	public String getstudent_id() {
		return student_id;
	}
	public void setstudent_id(String student_id) {
		this.student_id = student_id;
	}
	public int getBook_id() {
		return book.getID();
	}
	public void setBook_id(int book_id) {
		this.book.setID(book_id);
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCurrentPhone() {
		return studentCurrentPhone;
	}
	public void setStudentCurrentPhone(String studentCurrentPhone) {
		this.studentCurrentPhone = studentCurrentPhone;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	
	public int getBorrowQTY() {
		return borrowQTY;
	}
	public void setBorrowQTY(int borrowQTY) {
		this.borrowQTY = borrowQTY;
	}
	public String getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(String borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
//	public String getReturnDate() {
//		return returnDate;
//		
//	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
