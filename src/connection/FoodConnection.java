package connection;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import classMembers.FoodClass;
import popForm.FoodDetail;
import popForm.FoodUpdate;


public class FoodConnection {
	
	//private String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private String DB_URL = "jdbc:mysql://localhost/rupp_database";
	private String username = "root";
	private String password = "";
	private PreparedStatement ps = null;
	private Connection conn = DBConnection.connection();
	
	public void add(FoodClass food, String imageName, File selectedPath) throws Exception {
		Statement stmt = null;
		BufferedImage img = ImageIO.read(selectedPath);
		
		Date date = new Date();
	    String strDateFormat = "yyyy_MMM_dd_hh_mm_ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	    
		String location = "images/" +formattedDate + imageName;
		String format = "PNG";
		
		ImageIO.write(img, format, new File(location));

		
		try {
			System.out.println("Creating statement...");
		    stmt = conn.createStatement();
		    String sql = "INSERT INTO Food (foodID, name, price, category, image) VALUES ('" + food.getFoodID() + "', '" + food.getName() + "', '" + food.getPrice() + "', '"+ food.getCategory() + "', '" + food.getImage() + "')";
			    
			stmt.execute(sql);
  
			JOptionPane.showMessageDialog(null, "Data has been inserted successfully !");
			   
		    stmt.close();
		    
		}catch(Exception e){
	      e.printStackTrace();
	   }
	}
	
	public String showFood() {
		FileOutputStream fos = null;
		String sql = "SELECT * FROM food";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DB_URL, username, password);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Blob b = rs.getBlob("image");
			String id = rs.getString("id");
			
			fos = new FileOutputStream("images/" +id+ ".jpg");
			int len = (int) b.length();
			byte[] buf = b.getBytes(1,  len);
			
			fos.write(buf, 0, len);
			
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "-1";
	}
	
	//	DETAIL FOOD
	public void detailFood(int id) {
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM food WHERE id = '" +id + "'";
	        ResultSet rss = stmt.executeQuery(sql);
	        
	        while(rss.next()) {
	        	
				FoodClass foodclass = new FoodClass(rss.getString("foodID"), rss.getString("name"), rss.getDouble("price"), rss.getString("category"), rss.getString("image"));
				new FoodDetail(foodclass);
	        }

			rss.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// REMOVE FOOD
	public void removeFood(int id) {
		try {
        	Statement stmt = conn.createStatement();
            String sql = "DELETE FROM food WHERE id = '" + id + "'";
            System.out.println(sql);
			stmt.executeUpdate(sql);
             
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	// EDIT FOOD
	public void editFood(int id) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM food WHERE id = '" + id + "'";
	        ResultSet rss = stmt.executeQuery(sql);
	        while(rss.next()) {
				FoodClass foodclass = new FoodClass(rss.getString("foodID"), rss.getString("name"), rss.getDouble("price"), rss.getString("category"), rss.getString("image"));
				new FoodUpdate(foodclass, rss.getInt("id"));
				
	        }

			rss.close();
			stmt.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
}
