package connection;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JOptionPane;

import classMembers.BookClass;


public class BookConnection {
	
	private Connection conn = DBConnection.connectDB();

	
	public void addNewBook(BookClass book) throws Exception {
		Statement stmt = null;
		/*BufferedImage img = ImageIO.read(selectedPath);
		
		Date date = new Date();
	    String strDateFormat = "yyyy_MMM_dd_hh_mm_ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate = dateFormat.format(date);
	    
		String location = "uploads/" +formattedDate + imageName;
		String format = "PNG";
		
		ImageIO.write(img, format, new File(location));

		*/
		try {
			
		    stmt = conn.createStatement();
		    int numBorrow = 0;
		    int bookInStock = book.getQty();
		    String sql = "INSERT INTO books (isbn, title, image, qty, numBorrow, bookInStock, price, author, edition) VALUES ('" + book.getIsbn() + "', '" + book.getTitle() + "', '" + 
		    		book.getImg() + "', '" + book.getQty() + "', '" + numBorrow + "', '"+ bookInStock + "', '"+ book.getPrice() + "', '" + book.getAuthor() + "', '" + book.getEdition() + "')";
			    
			stmt.execute(sql);
  
			JOptionPane.showMessageDialog(null, "Data has been inserted successfully !");
			   
		    stmt.close();
		    
		}catch(Exception e){
	      e.printStackTrace();
	   }
	}

	// REMOVE BOOK(S)
	public void removeBook(int id) {
		try {
			Statement stmt = conn.createStatement();
			String sqlSelect = "SELECT image FROM books WHERE id = '" + id + "'";
			ResultSet rss = stmt.executeQuery(sqlSelect);
			while(rss.next()) {
				File file = new File("uploads/" + rss.getString("image"));
				file.delete();
			}
			String sql = "DELETE FROM books WHERE id = '" + id + "'";
			stmt.executeUpdate(sql);
			  
	         
			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void updateBook(int id, BookClass book) {
		try {
			Statement stmt = conn.createStatement();
			
			String sqlSelect = "SELECT image FROM books WHERE id = '" + id + "'";
			ResultSet rss = stmt.executeQuery(sqlSelect);
			while(rss.next()) {
				File file = new File("uploads/" + rss.getString("image"));
				file.delete();
			}
			
			String sql = "UPDATE books SET image = '" + book.getImg() + "', isbn = '" + book.getIsbn() + "', title = '" + 
					book.getTitle() +"', qty = '" + book.getQty() + "', price = '" + book.getPrice() + "', author = '" + 
					book.getAuthor() +"', edition = '" + book.getEdition() + "' WHERE id = '" + id + "'";
			stmt.executeUpdate(sql);
			  
	         
			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
