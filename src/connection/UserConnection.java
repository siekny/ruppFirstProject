package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import classMembers.BookClass;
import classMembers.BorrowerClass;
import classMembers.MemberRegisterClass;

public class UserConnection {
	
	private Connection conn = DBConnection.connectDB();
	int numBorrow = 0;
	
	// COUNT TABLES
	public int countTable(String name) {
		int count = 0;
		String sql = null;
		try {
			Statement stmt = conn.createStatement();
			if(name.equals("books"))
				sql = "SELECT id FROM books";
			
			else if(name.equals("borrows"))
				sql = "SELECT id FROM borrows";
			
			else if(name.equals("users"))
				sql = "SELECT id FROM users";
			
	        ResultSet rss = stmt.executeQuery(sql);
	        
	        while(rss.next()) {
				count ++;
	        }
			rss.close();
			stmt.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return count;
	}
	
	
	// VIEW BOOKS FOR USER
	public ArrayList<BookClass> bookView() {
		ArrayList<BookClass> bookList = new ArrayList<BookClass>();
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM books";
	        ResultSet rss = stmt.executeQuery(sql);
	        while(rss.next()) {
	        	BookClass book = new BookClass(rss.getInt("id"), rss.getString("isbn"), rss.getString("title"), rss.getString("image"), rss.getInt("qty"),
						rss.getDouble("price"), rss.getString("author"), rss.getInt("edition"), rss.getInt("numBorrow"));
				
				
				bookList.add(book);

	        }

			rss.close();
			stmt.close();
			
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return bookList;
	}
	
	
	// VIEW DETAIL BOOK FOR USER
	public ArrayList<BookClass> detailBook(int id) {
		
		ArrayList<BookClass> bookList = new ArrayList<BookClass>();
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM books WHERE id = '" + id + "'";
	        ResultSet rss = stmt.executeQuery(sql);
	        
	        while(rss.next()) {
	        	BookClass book = new BookClass(rss.getInt("id"), rss.getString("isbn"), rss.getString("title"), rss.getString("image"), rss.getInt("qty"), 
						rss.getDouble("price"), rss.getString("author"), rss.getInt("edition"), rss.getInt("numBorrow"));
				
				
				bookList.add(book);
	        }

			rss.close();
			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return bookList;
	}
	
	
	// GET STUDENT INFO
	public MemberRegisterClass getMemberInfo(int id) {
		MemberRegisterClass member = null;
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM memberregisters WHERE id = '" + id + "'";
	        ResultSet rss = stmt.executeQuery(sql);

	        while(rss.next()) {
	        	member = new MemberRegisterClass(rss.getInt("id"), rss.getString("fullName"), rss.getString("sex"),rss.getString("address"), rss.getString("email"), rss.getString("phone"), rss.getString("dateofbirth"));
	        }

			rss.close();
			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		return member;
		
	}
	
	// GET BOOK INFO
	public BookClass getBookInfo(String isbn) {
			ArrayList<BookClass> bookList = new ArrayList<BookClass>();
			BookClass book = null;
			try {
				Statement stmt = conn.createStatement();
				String sql = "SELECT * FROM books WHERE id = '" + isbn + "' AND bookInStock > '" + 0 + "'";
		        ResultSet rss = stmt.executeQuery(sql);
		        
		        while(rss.next()) {
		        	book = new BookClass(rss.getInt("id"), rss.getString("isbn"), rss.getString("title"), rss.getString("image"), rss.getInt("qty"),
		        			rss.getDouble("price"), rss.getString("author"), rss.getInt("edition"), rss.getInt("numBorrow"));
					bookList.add(book);
		        }
		        if(bookList.size() == 0)
		        	throw new Exception("Sorry! We don't have this book yet!");

				rss.close();
				stmt.close();
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			return book;
			
		}
	
	// SHOW ALL BOOKS TRANSACTION
	public ArrayList<BorrowerClass> borrowView(int isShow) { // isShow = 0 means not show return date, isShow = 1 shows return date, isShow = 2 it's in recycle bin
		ArrayList<BorrowerClass> borrowList = new ArrayList<BorrowerClass>();
		
		try {
			Statement stmt = conn.createStatement();
			String returnDate = "0";
			int status_removed = 1;
			String sql = null;
			
			if(isShow == 0)
				sql = "SELECT * FROM borrows WHERE returnDate = '" + returnDate+ "'" + " && status_removed = '" + status_removed + "'";
			else if(isShow == 1)
				sql = "SELECT * FROM borrows WHERE status_removed = '" + status_removed + "'";
			else if(isShow == 2)
				sql = "SELECT * FROM borrows WHERE status_removed = '" + 0 + "'";
			
	        ResultSet rss = stmt.executeQuery(sql);
	        while(rss.next()) {
	        	BorrowerClass borrow = new BorrowerClass(rss.getInt("id"), rss.getString("student_id"), rss.getInt("book_id"), rss.getString("studentName"), 
	        			rss.getString("studentCurrentPhone"), rss.getString("bookISBN"), rss.getInt("borrowQTY"), rss.getString("borrowedDate"), 
	        			rss.getString("returnDate"), rss.getInt("status_removed"));

	        	borrowList.add(borrow);
	        }

			rss.close();
			stmt.close();
			
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return borrowList;
	}
	
	// GET RETURN DATE
	
	ArrayList<MemberRegisterClass> memberList = new ArrayList<MemberRegisterClass>();
	public boolean getReturnDate(String studentID) 
	{

		boolean returnDate = false;
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM borrows WHERE student_id = '" + studentID + "' AND returnDate = '" + 0 + "'";
			
	        ResultSet rss = stmt.executeQuery(sql);
	        
	        while(rss.next()) {
		        returnDate = true;
	        }
	       
	        
			rss.close();
			stmt.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return returnDate;
		
	}

	// ADD NEW BOOK TRANSACTION
	public void addBorrower(BorrowerClass borrow) throws Exception {
		Statement stmt = null;
		Statement stmt1 = null;
		Statement stmt2 = null;
					
		try {
		    stmt = conn.createStatement();
		    String sql = "INSERT INTO borrows (student_id, book_id, studentName, studentCurrentPhone, bookISBN, borrowQTY, borrowedDate, status_removed) VALUES "
		    		+ "('" + borrow.getstudent_id() + "', '" + borrow.getBook_id() + "', '"+ borrow.getStudentName() + "', '" + borrow.getStudentCurrentPhone() + "', "
		    		+ "'"+ borrow.getBookISBN() + "', '"  + borrow.getBorrowQTY() + "', '" + borrow.getBorrowedDate() + "', '" + borrow.getStatus() + "')";
		    stmt.execute(sql);
		    
		    stmt1 = conn.createStatement();
		    
		    String sql1 = "SELECT bookInStock, numBorrow FROM books WHERE id = '" + borrow.getBook_id() + "'";
		    ResultSet rss = stmt1.executeQuery(sql1);

	        while(rss.next()) {
	        	
	        	stmt2 = conn.createStatement();
	        	int bookInStock =  rss.getInt("bookInStock") -  borrow.getBorrowQTY();
	        	int numBorrow = rss.getInt("numBorrow") + borrow.getBorrowQTY();
	        	String sql2 = "UPDATE books SET numBorrow = '" + numBorrow + "'" + ", bookInStock = '" +bookInStock+ "' WHERE id = '" + borrow.getBook_id()+ "'";
	        	stmt2.executeUpdate(sql2);
	        }
	        stmt2.close();
	        stmt1.close();

			rss.close();
			stmt.close();
  
			JOptionPane.showMessageDialog(null, "Data has been inserted successfully !");
			   
		    stmt.close();
		    
		}catch(Exception e){
	      e.printStackTrace();
	   }
	}
	
	// UPDATE BORROWER
		public void updateBorrower(BorrowerClass oldBorrow, BorrowerClass borrow) throws Exception {
			Statement stmt = null;
			Statement stmt1 = null;
			Statement stmt2 = null;
			Statement stmt3 = null;
					
			// UPDATE OLD DATA
			try {
				 stmt = conn.createStatement();
			    String sql = "SELECT book_id, bookInStock, numBorrow FROM borrows AS borrow INNER JOIN books AS book ON borrow.book_id = book.id WHERE borrow.id = '" + oldBorrow.getId()+ "'";
			    ResultSet rss = stmt.executeQuery(sql);
			    
			    while(rss.next()) {
		        	
		        	stmt2 = conn.createStatement();
		        	int bookInStock =  rss.getInt("bookInStock") +  oldBorrow.getBorrowQTY();
		        	int numBorrow = rss.getInt("numBorrow") - oldBorrow.getBorrowQTY();
		        	String sql2 = "UPDATE books SET numBorrow = '" + numBorrow + "'" + ", bookInStock = '" +bookInStock+ "' WHERE id = '" + oldBorrow.getBook_id()+ "'";
		        	stmt2.executeUpdate(sql2);
		        }

			    // UPDATE NEW DATA
			    stmt3 = conn.createStatement();
			    String sql3 = "UPDATE borrows SET book_id = '" +borrow.getBook_id()+ "'"+ ", bookISBN = '" +borrow.getBookISBN()+"'"+ ", borrowQTY = '" +borrow.getBorrowQTY() + "' WHERE id = '" + oldBorrow.getId()+ "'";
			    System.out.println(sql3);
			    stmt3.executeUpdate(sql3);
			    
			    stmt1 = conn.createStatement();
			    String sql1 = "SELECT bookInStock, numBorrow FROM books WHERE id = '" + borrow.getBook_id() + "'";
			    ResultSet rss1 = stmt1.executeQuery(sql1);

		        while(rss1.next()) {
		        	
		        	stmt2 = conn.createStatement();
		        	int bookInStock =  rss1.getInt("bookInStock") -  borrow.getBorrowQTY();
		        	int numBorrow = rss1.getInt("numBorrow") + borrow.getBorrowQTY();
		        	String sql2 = "UPDATE books SET numBorrow = '" + numBorrow + "'" + ", bookInStock = '" +bookInStock+ "' WHERE id = '" + borrow.getBook_id()+ "'";
		        	stmt2.executeUpdate(sql2);
		        }
		        stmt3.close();
		        stmt2.close();
		        stmt1.close();

				rss.close();
				stmt.close();
	  
				JOptionPane.showMessageDialog(null, "Data has been updated successfully !");
				   
			    stmt.close();
			    
			}catch(Exception e){
		      e.printStackTrace();
		   }
		}

	// GET ID OF BORROWING BOOK
	public BorrowerClass borrowedBook(int id) {
		BorrowerClass borrowed = null;
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM borrows WHERE id = '" + id + "'";
	        ResultSet rss = stmt.executeQuery(sql);

	        while(rss.next()) {
	        	borrowed = new BorrowerClass(rss.getInt("id"), rss.getString("student_id"), rss.getInt("book_id"), rss.getString("studentName"), 
	        			rss.getString("studentCurrentPhone"), rss.getString("bookISBN"), rss.getInt("borrowQTY"), rss.getString("borrowedDate"), 
	        			rss.getString("returnDate"), rss.getInt("status_removed"));
	        }

			rss.close();
			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		return borrowed;
	}

	// RETURN BOOK
	public void returnBook(BorrowerClass borrow, int id) {
		
		try {
			DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
			Statement stmt = conn.createStatement();
			String sql = "UPDATE borrows SET returnDate = '" + df.format(new Date()) + "'" + ", overDays = '" + borrow.getSubstractDays() + "'" + ", fine = '" + borrow.getFineOverDays(borrow.getSubstractDays()) + "'" + " WHERE id = '" + id + "'";
			stmt.executeUpdate(sql);
			
			Statement stmt1 = conn.createStatement();
			String sql1 = "SELECT bookInStock, numBorrow FROM books WHERE id = '" + borrow.getBook_id() + "'";

			ResultSet rss = stmt1.executeQuery(sql1);
		    
	        while(rss.next()) {
	        	System.out.println(borrow.getBook_id());
	        	Statement stmt2 = conn.createStatement();
	        	int bookInStock =  rss.getInt("bookInStock") +  borrow.getBorrowQTY();
	        	int numBorrow = rss.getInt("numBorrow") - borrow.getBorrowQTY();
	        	String sql2 = "UPDATE books SET numBorrow = '" + numBorrow + "'" + ", bookInStock = '" +bookInStock+ "' WHERE id = '" + borrow.getBook_id()+ "'";
	        	stmt2.executeUpdate(sql2);
	        	System.out.println(borrow.getBook_id());
	        	
	        	stmt2.close();
	        }
	        rss.close();
	        
	        stmt1.close();
	        stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	// REMOVE BORROWERS
	public void removeBorrowed(int id) {

		try {
			
			Statement stmt = conn.createStatement();
			int status_removed = 0; // means it's in the recycle bin
			String sql = "UPDATE borrows SET status_removed = '" + status_removed + "'" + " WHERE id = '" + id + "'";
			stmt.executeUpdate(sql);

			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	// DELETE RECYCLEBIN OF BORROWING BOOKS
	public void removeRecycleBinofBorrowing(int id, int bookID, int numBorrow) {
		try {
			
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM borrows WHERE id = '" + id + "'";
			stmt.executeUpdate(sql);
			
			String sqlSelectBook = "SELECT numBorrow, bookInStock FROM books WHERE id = '" + bookID + "'" ;
			ResultSet rss = stmt.executeQuery(sqlSelectBook);
			while(rss.next()) {
				int updateNumBorrow = rss.getInt("numBorrow") - numBorrow;
				int updateBookInStock = rss.getInt("bookInStock") + numBorrow;
				String sqlUpdateBook = "UPDATE books SET numBorrow = '" + updateNumBorrow + "'" + ", bookInStock = '" + updateBookInStock + "'" + "WHERE id = '" + bookID+ "'";
				stmt.executeUpdate(sqlUpdateBook);
			}

			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	// RESTORE RECYCLE BIN OF BORROWING BOOKS
	public void restoreRecycleBinofBorrowing(int id) {
		try {
			Statement stmt = conn.createStatement();
			int status = 1;
			String sql = "UPDATE borrows SET status_removed = '" + status + "' WHERE id = '" + id + "'";
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	
	// SEARCH BORROWERS 
	public ArrayList<BorrowerClass>  searchBorrowers(String search) {
		ArrayList<BorrowerClass> resultsearchBorrowerList = new ArrayList<BorrowerClass>();
		try {
			Statement stmt = conn.createStatement();
			int status = 1;
			
			String sql = "SELECT * FROM borrows bo WHERE bo.student_id LIKE '%" + search + "%' OR " +
					  "bo.studentName LIKE '%" + search + "%' AND bo.status_removed = '" + status + "'OR " + 
					  "bo.studentCurrentPhone LIKE '%" + search + "%' AND bo.status_removed = '" + status + "'OR " + 
					  "bo.bookISBN LIKE '%" + search + "%' AND bo.status_removed = '" + status + "'OR " + 
					  "bo.borrowQTY LIKE '%" + search + "%'  AND bo.status_removed = '" + status + "'OR " + 
					  "bo.overDays LIKE '%" + search + "%' AND bo.status_removed = '" + status + "'";

			ResultSet rss = stmt.executeQuery(sql);
			
			while(rss.next()) {
				BorrowerClass resultofBorrowers =  new BorrowerClass(rss.getInt("id"), rss.getString("student_id"), rss.getInt("book_id"), rss.getString("studentName"), 
	        			rss.getString("studentCurrentPhone"), rss.getString("bookISBN"), rss.getInt("borrowQTY"), rss.getString("borrowedDate"), 
	        			rss.getString("returnDate"), rss.getInt("status_removed"));
				resultsearchBorrowerList.add(resultofBorrowers);
			}
			stmt.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return resultsearchBorrowerList;
		
	}
}
