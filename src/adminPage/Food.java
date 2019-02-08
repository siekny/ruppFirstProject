package adminPage;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;

import connection.DBConnection;
import connection.FoodConnection;
import classMembers.FoodClass;


public class Food extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */

	private JTextField txtSearch;
	private JTextField txtFoodID;
	private JTextField txtName;
	private JTextField txtPrice;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCategory;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnSave, btnClear;
	private JLabel lblNoUsers;

	private JLabel lblShowimage;
	private JButton btnRemove, btnUpdate, btnImage, btnDetail;
	private String imageName;
	private File selectedPath;
	
	private Connection conn = DBConnection.connection();

	/**
	 * Create the panel.
	 */
	public Food() {
		
		initialize();
		initObjects();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initialize () {
		setBackground(new Color(236,240,245));
		setLayout(new BorderLayout(20, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(10, 10));
		panel.setPreferredSize(new Dimension(750, 100));
		
		JPanel panelTopLeft = new JPanel();
		panelTopLeft.setBackground(SystemColor.desktop);
		panel.add(panelTopLeft, BorderLayout.NORTH);
		panelTopLeft.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("    List of Your Food");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTopLeft.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(68,68,68));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new MatteBorder(3,0,0,0, new Color(0,166,90)));
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(SystemColor.desktop);
		FlowLayout fl_panelSearch = (FlowLayout) panelSearch.getLayout();
		fl_panelSearch.setVgap(10);
		fl_panelSearch.setAlignment(FlowLayout.LEFT);
		panelTopLeft.add(panelSearch);
		
		JLabel lblNewLabel_2 = new JLabel("  Search :    ");
		panelSearch.add(lblNewLabel_2);
		
		txtSearch = new JTextField();
		panelSearch.add(txtSearch);
		txtSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		txtSearch.setColumns(33);
		
		JLabel lblNewLabel_3 = new JLabel("#Food(s) : ");
		panelSearch.add(lblNewLabel_3);
		
		lblNoUsers = new JLabel("");
		panelSearch.add(lblNoUsers);
		lblNoUsers.setForeground(Color.BLUE);
		lblNoUsers.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panelNumUsers = new JPanel();
		panelSearch.add(panelNumUsers);
		panelNumUsers.setBackground(SystemColor.desktop);
		FlowLayout fl_panelNumUsers = (FlowLayout) panelNumUsers.getLayout();
		fl_panelNumUsers.setAlignment(FlowLayout.RIGHT);
		
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 255, 255));
		panel.add(panelTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		String[] colsName = new String[] {"id", "Food's ID", "Food Name", "Category", "Price"};
		
		
		model = new DefaultTableModel(null, colsName) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 0;
		    }
		};
		panelTable.setLayout(new BorderLayout(0, 0));
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(new Color(255, 255, 255));
		panelTable.add(scroll);
		
		TableColumnModel tm = table.getColumnModel();
		table.removeColumn(tm.getColumn(0));
		
		JPanel panelButtonLeft = new JPanel();
		panel.add(panelButtonLeft, BorderLayout.SOUTH);
		panelButtonLeft.setBackground(new Color(255, 255, 255));
		
		btnDetail = new JButton("Detail");
		btnDetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDetail.setFocusPainted(false);
		btnDetail.setForeground(Color.WHITE);
		btnDetail.setIcon(new ImageIcon("images/reload.png"));
		panelButtonLeft.add(btnDetail);
		
		btnRemove = new JButton("Remove");
		btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemove.setIcon(new ImageIcon("images/trash.png"));
		btnRemove.setHorizontalAlignment(SwingConstants.RIGHT);
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFocusPainted(false);
		btnRemove.setBackground(new Color(221, 75, 57));
		panelButtonLeft.add(btnRemove);
		
		btnUpdate = new JButton("Edit");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBackground(new Color(0,166,90));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setIcon(new ImageIcon("images/edit.png"));
		panelButtonLeft.add(btnUpdate);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.desktop);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		panelContent.setBorder(new MatteBorder(3, 0,0,0, new Color(243,156,18)));
		
		JPanel panelTopRight = new JPanel();
		panelTopRight.setBackground(SystemColor.desktop);
		panelContent.add(panelTopRight, BorderLayout.NORTH);
		
		JLabel lblNewLabel_12 = new JLabel("Create a New Food");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		panelTopRight.add(lblNewLabel_12);
		
		JPanel panelBodyRight = new JPanel();
		panelBodyRight.setBackground(SystemColor.desktop);
		panelContent.add(panelBodyRight, BorderLayout.CENTER);
		panelBodyRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInner = new JPanel();
		panelBodyRight.add(panelInner, BorderLayout.NORTH);
		panelInner.setBackground(SystemColor.desktop);
		panelInner.setLayout(new GridLayout(9, 2, 0, 5));
		
		JLabel lblNewLabel_4 = new JLabel("     Food Information");
		panelInner.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBorder(new MatteBorder(0,0,1,0, Color.BLUE));
		
		JLabel label_9 = new JLabel("");
		panelInner.add(label_9);
		label_9.setBorder(new MatteBorder(0,0,1,0, Color.BLUE));
		
		JPanel panelImage = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelImage.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelImage.setBackground(Color.WHITE);
		panelInner.add(panelImage);
		
		JLabel lblImage = new JLabel("     Image : ");
		panelImage.add(lblImage);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		panelImage.add(label_5);
		
		btnImage = new JButton("Choose Image");
		btnImage.setBackground(new Color(211, 211, 211));
		panelInner.add(btnImage);
		
		JPanel panelFoodID = new JPanel();
		panelFoodID.setBackground(SystemColor.desktop);
		FlowLayout fl_panelFoodID = (FlowLayout) panelFoodID.getLayout();
		fl_panelFoodID.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelFoodID);
		
		JLabel lblFoodID = new JLabel("     Food's ID : ");
		panelFoodID.add(lblFoodID);
		lblFoodID.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_8 = new JLabel("*");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		panelFoodID.add(lblNewLabel_8);
		
		txtFoodID = new JTextField();
		panelInner.add(txtFoodID);
		txtFoodID.setColumns(15);
		txtFoodID.setPreferredSize(new Dimension(100, 10));
		
		JPanel panelNumSeats = new JPanel();
		panelNumSeats.setBackground(SystemColor.desktop);
		FlowLayout fl_panelNumSeats = (FlowLayout) panelNumSeats.getLayout();
		fl_panelNumSeats.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelNumSeats);
		
		JLabel lblNumSeats = new JLabel("     Name of Food : ");
		panelNumSeats.add(lblNumSeats);
		lblNumSeats.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.RED);
		panelNumSeats.add(label_3);
		
		txtName = new JTextField();
		panelInner.add(txtName);
		txtName.setColumns(15);
		
		JPanel panelCategory = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelCategory.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelCategory.setBackground(Color.WHITE);
		panelInner.add(panelCategory);
		
		JLabel lblCategory = new JLabel("     Category : ");
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		panelCategory.add(lblCategory);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		panelCategory.add(label_4);
		
		cboCategory = new JComboBox(new String[] {"Food", "Drink", "Dessert"});
		cboCategory.setBackground(Color.WHITE);
		panelInner.add(cboCategory);
		
		JPanel panelPrice = new JPanel();
		panelPrice.setBackground(SystemColor.desktop);
		FlowLayout fl_panelPrice = (FlowLayout) panelPrice.getLayout();
		fl_panelPrice.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelPrice);
		
		JLabel lblPrice = new JLabel("     Price : ");
		panelPrice.add(lblPrice);
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_9 = new JLabel("*");
		panelPrice.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtPrice = new JTextField();
		txtPrice.setBackground(new Color(255, 255, 255));
		panelInner.add(txtPrice);
		txtPrice.setColumns(15);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelInner.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		panelInner.add(label_2);
		
		JPanel panelSave = new JPanel();
		panelSave.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_6 = (FlowLayout) panelSave.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panelInner.add(panelSave);
		
		btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("images/add.png"));
		panelSave.add(btnSave);
		btnSave.setFocusPainted(false);
		btnSave.setBackground(new Color(60,141,188));
		btnSave.setForeground(SystemColor.desktop);

		
		JPanel panelClear = new JPanel();
		panelClear.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_2 = (FlowLayout) panelClear.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelClear);
		
		btnClear = new JButton("Clear");
		panelClear.add(btnClear);
		btnClear.setFocusPainted(false);
		btnClear.setBackground(SystemColor.menu);
		
		JPanel panelShowImage = new JPanel();
		panelBodyRight.add(panelShowImage, BorderLayout.CENTER);
		panelShowImage.setBackground(new Color(255, 255, 255));
		
		lblShowimage = new JLabel("");
		lblShowimage.setIcon(new ImageIcon("images/image.png"));
		lblShowimage.setHorizontalTextPosition(JLabel.CENTER);
		lblShowimage.setVerticalTextPosition(JLabel.BOTTOM);
		panelShowImage.add(lblShowimage);
		
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnClear.addActionListener(this);
		btnImage.addActionListener(this);
		btnDetail.addActionListener(this);
	}

	public void initObjects () {
		
		try {
			model.setRowCount(0);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM food";
			ResultSet rss = stmt.executeQuery(sql);
			
			while(rss.next()) {
				FoodClass food = new FoodClass(rss.getString("foodID"), rss.getString("name"), rss.getDouble("price"), rss.getString("category"), rss.getString("image"));
				model.addRow(food.getRowFood(rss.getInt("id")));
				
			}
			
			rss.close();
		    stmt.close();
		    //conn.close();
		}catch (Exception ex) {}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnImage)
				chooseImage();
			else if(e.getSource() == btnSave)				
					saveButton("save");

			else if(e.getSource() == btnRemove)
				removeFood();

			else if(e.getSource() == btnClear)
				clearFood();
			else if(e.getSource() == btnDetail)
				detailFood();
			else if(e.getSource() == btnUpdate)
				updateFood();
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void chooseImage() {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("* .Image", "jpg", "gif", "png", "jpeg");
		filechooser.addChoosableFileFilter(filter);
		
		int result = filechooser.showSaveDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			selectedPath = filechooser.getSelectedFile();
			String path = selectedPath.getAbsolutePath();
			lblShowimage.setIcon(resizeImage(path));
			imageName = selectedPath.getName();
			System.out.println(imageName);
		}
		else if(result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "No Image", "", JOptionPane.OK_OPTION);
		}
	}
	
	public void saveButton(String btnValue) throws Exception {

		if(lblShowimage.getText().isEmpty())
			throw new Exception("Image is required");
		else if(txtFoodID.getText().isEmpty())
			throw new Exception("Invalid Food's ID");
		else if(txtName.getText().isEmpty()) 
			throw new Exception("Food Name cannot be null");
		else if(txtPrice.getText().isEmpty())
			throw new Exception("Price cannot be null");
		else if(Double.parseDouble(txtPrice.getText()) <= 0)
			throw new Exception("Price cannot be equal or less than zero");
		
		Date date = new Date();
		BufferedImage img = ImageIO.read(selectedPath);
	    String strDateFormat = "yyyy_MMM_dd_hh_mm_ss";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	    
		String location = "images/" +formattedDate + imageName;
		String format = "PNG";
		ImageIO.write(img, format, new File(location));
		
		FoodClass food = new FoodClass(txtFoodID.getText(), txtName.getText(), Double.parseDouble(txtPrice.getText()), cboCategory.getSelectedItem().toString(),formattedDate + imageName);
		new FoodConnection().add(food, format, selectedPath);
		model.setRowCount(0);
		initObjects();

	}
	
	// DETAIL FOOD
	public void detailFood() throws SQLException {
		if(table.getSelectionModel().isSelectionEmpty())
			JOptionPane.showConfirmDialog(null, "Please select one row to view detail !", "", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		else {
			int[] row = table.getSelectedRows();
			if(row.length == 1) {
				String getId = table.getModel().getValueAt(row[0], 0).toString();
				
				new FoodConnection().detailFood(Integer.parseInt(getId));
			}
				
			else {
				JOptionPane.showConfirmDialog(null, "Please select Specific row !", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
	}
	
	
	// REMOVE Food FFOM DB
		public void removeFood() {
			
			if(table.getSelectionModel().isSelectionEmpty())
				JOptionPane.showConfirmDialog(null, "Please select at least one row to Remove", "",  JOptionPane.CLOSED_OPTION , JOptionPane.ERROR_MESSAGE);
			else {
				int row = table.getSelectedRow();
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "Deleting...", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				if(confirm == JOptionPane.OK_OPTION) {
					while (row != -1)
		            {
		                int modelRow = table.convertRowIndexToModel( row );
		                String id = table.getModel().getValueAt(modelRow, 0).toString();
		                System.out.println(id);
		                
		                new FoodConnection().removeFood(Integer.parseInt(id));
		               
						model.removeRow( modelRow );
			            row = table.getSelectedRow();  
		            }
					
					clearFood();
					
					JOptionPane.showConfirmDialog(null, "Data has been deleted successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
				}
				
			}
		}
		
		// EDIT FOOD
		public void updateFood() throws SQLException {
			if(table.getSelectionModel().isSelectionEmpty())
				JOptionPane.showConfirmDialog(null, "Please select one row to view details !", "", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
			else {
				int[] row = table.getSelectedRows();
				if(row.length == 1) {
					String getId = table.getModel().getValueAt(row[0], 0).toString();
					
					new FoodConnection().editFood(Integer.parseInt(getId));
					initObjects();
				}
					
				else {
					JOptionPane.showConfirmDialog(null, "Please select Specific row !", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				}
				
			}
		}
		
		
		public void clearFood() {
			txtFoodID.setText("");
			txtName.setText("");
			txtPrice.setText("");
			cboCategory.setSelectedIndex(0);
			lblShowimage.setText("");
			lblShowimage.setIcon(new ImageIcon("images/image.png"));
		}
		
		//Method To Resize The ImageIcon
	    public ImageIcon resizeImage(String imgPath){
	        ImageIcon MyImage = new ImageIcon(imgPath);
	        Image img = MyImage.getImage();
	        Image newImage = img.getScaledInstance(lblShowimage.getWidth(), lblShowimage.getHeight(),Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImage);
	        return image;
	    }
	
}
