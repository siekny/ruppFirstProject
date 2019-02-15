package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import classMembers.BookClass;

public class UserConnection {
	
	private Connection conn = DBConnection.connectDB();
	int numBorrow = 0;
	
	// COUNT BOOK
	public int countBooks() {
		int count = 0;
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT id FROM books";
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
	
	// VIEW BOOK FOR USER
	public ArrayList<BookClass> bookView() {
		ArrayList<BookClass> bookList = new ArrayList<BookClass>();
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM books";
	        ResultSet rss = stmt.executeQuery(sql);
	        while(rss.next()) {
	        	BookClass book = new BookClass(rss.getInt("id"), rss.getString("isbn"), rss.getString("title"), rss.getString("image"), rss.getInt("qty"), rss.getString("publisher"), 
						rss.getInt("publishedYear"), rss.getDouble("price"), rss.getString("author"), rss.getInt("edition"), rss.getInt("status"), rss.getInt("numBorrow"));
				
				
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
	        	BookClass book = new BookClass(rss.getInt("id"), rss.getString("isbn"), rss.getString("title"), rss.getString("image"), rss.getInt("qty"), rss.getString("publisher"), 
						rss.getInt("publishedYear"), rss.getDouble("price"), rss.getString("author"), rss.getInt("edition"), rss.getInt("status"), rss.getInt("numBorrow"));
				
				
				bookList.add(book);
	        }

			rss.close();
			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return bookList;
	}
}
