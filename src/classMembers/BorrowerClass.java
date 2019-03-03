package classMembers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowerClass extends HistoryBookBorrowClass{
	
	private int id;
	private BookClass book;
	private String bookISBN;
	
	private int borrowQTY;
	private String borrowedDate;
	private String returnDate; 
	private int overDate;
	private int status;
	
	public BorrowerClass() {
		
	}
	
	public BorrowerClass(int id, BookClass book, String bookISBN, int borrowQTY, String borrowedDate, String returnDate,
			int status) {
		super();
		this.id = id;
		this.book = book;
		this.bookISBN = bookISBN;
		this.borrowQTY = borrowQTY;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.status = status;
	}

	public BorrowerClass(String student_id, int book_id, String studentName, String student_phone,
			String bookISBN, int borrowQTY, String borrowedDate, int status) {
		super(student_id, studentName, student_phone);
		book = new BookClass();
		this.book.setID(book_id);
		this.bookISBN = bookISBN;
		this.borrowQTY = borrowQTY;
		this.borrowedDate = borrowedDate;
		this.status = status;
	}
	
	public BorrowerClass(int id, String student_id, int book_id, String studentName, String student_phone,
			String bookISBN, int borrowQTY, String borrowedDate, String returnDate,
			int status) {
		super(student_id, studentName, student_phone);
		 book = new BookClass();
		this.id = id;
		this.book.setID(book_id);
		this.bookISBN = bookISBN;
		this.borrowQTY = borrowQTY;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.status = status;
		
	}
	public BorrowerClass(int id, String student_id, int book_id, String studentName, String student_phone,
			String bookISBN, int borrowQTY, String borrowedDate, String returnDate, int overDate, int status) {
		super(student_id, studentName, student_phone);
		 book = new BookClass();
		this.id = id;
		this.book.setID(book_id);
		this.bookISBN = bookISBN;
		this.borrowQTY = borrowQTY;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.overDate = overDate;
		this.status = status;
		
	}
	
	public Object[] getBorrowColumns() {
		//System.out.println(super.getName() + "\t" + super.getPhone());
		return new Object[] {id, super.getStu_id(), book.getID(), super.getName(), super.getPhone(),  bookISBN, borrowQTY, borrowedDate, actualReturnDate()};
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
	public int getOverDate() {
		overDate = 0;
		try {
			DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
			String actualReturnDate = df.format(new Date());
			SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
			Date getreturnDate = sdf.parse(getReturnDate());
			Date getactualReturnDate = sdf.parse(actualReturnDate);
			 
			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
			long diff = getactualReturnDate.getTime() - getreturnDate.getTime();
 
			overDate = (int) (diff / (24 * 60 * 60 * 1000));
			if(overDate <1)
				overDate = 0;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return overDate;
	}
	
	public double getFineOverDays(int overDays) {
		int feePerDay = 1000;
		return feePerDay * overDays;
	}

	public int getId() {
		return id;
	}
	
	public int getBook_id() {
		return book.getID();
	}
	public void setBook_id(int book_id) {
		this.book.setID(book_id);
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
