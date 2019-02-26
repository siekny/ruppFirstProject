package adminPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;

import classMembers.BookClass;
import connection.BookConnection;
import connection.DBConnection;
import connection.UserConnection;
import popForm.FormBookUser;

public class Books extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */

	private JTextField txtSearch;
	private JTextField txtISBN;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnSave, btnClear, btnImage, btnEdit, btnRemove;
	private JTextField txtQty;
	private JTextField txtPrice;
	private JLabel lblShowimage;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEdition;
	
	
	private String imageName;
	private File selectedPath;
	
	

	/**
	 * Create the panel.
	 */
	public Books() {
		
		initialize();
		initButton();
		initTable();
		initObjects();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		
		JLabel lblNewLabel = new JLabel("    List of Your Books");
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
		
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 255, 255));
		panel.add(panelTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		String[] colsName = new String[] {"id", "ISBN", "Title", "Author", "Edition", "Quantity", "Price", "In Stock"};
		
		
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
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.desktop);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		panelContent.setBorder(new MatteBorder(3, 0,0,0, new Color(243,156,18)));
		
		JPanel panelTopRight = new JPanel();
		panelTopRight.setBackground(SystemColor.desktop);
		
		JLabel lblNewLabel_12 = new JLabel("Insertion a New Book");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		panelTopRight.add(lblNewLabel_12);
		
		JPanel panelBodyRight = new JPanel();
		panelBodyRight.setBackground(SystemColor.desktop);
		panelContent.add(panelBodyRight, BorderLayout.CENTER);
		panelBodyRight.setLayout(new BorderLayout(0, 10));
		
		JPanel panelInner = new JPanel();
		panelInner.setBackground(SystemColor.desktop);
		panelBodyRight.add(panelInner, BorderLayout.NORTH);
		panelInner.setLayout(new GridLayout(9, 2, 0, 5));
		
		JLabel lblNewLabel_4 = new JLabel("     Table Information");
		panelInner.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBorder(new MatteBorder(0,0,1,0, Color.BLUE));
		
		JLabel label_9 = new JLabel("");
		panelInner.add(label_9);
		label_9.setBorder(new MatteBorder(0,0,1,0, Color.BLUE));
		
		JLabel lblImage = new JLabel("     Image : ");
		panelInner.add(lblImage);
		
		btnImage = new JButton("Choose Image");
		btnImage.setFocusPainted(false);
		btnImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelInner.add(btnImage);
		
		JPanel panelISBN = new JPanel();
		panelISBN.setBackground(SystemColor.desktop);
		FlowLayout fl_panelISBN = (FlowLayout) panelISBN.getLayout();
		fl_panelISBN.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelISBN);
		
		JLabel lblISBN = new JLabel("     ISBN : ");
		panelISBN.add(lblISBN);
		lblISBN.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_8 = new JLabel("*");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		panelISBN.add(lblNewLabel_8);
		
		txtISBN = new JTextField();
		panelInner.add(txtISBN);
		txtISBN.setColumns(15);
		txtISBN.setPreferredSize(new Dimension(100, 10));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(SystemColor.desktop);
		FlowLayout fl_panelTitle = (FlowLayout) panelTitle.getLayout();
		fl_panelTitle.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelTitle);
		
		JLabel lblTitle = new JLabel("     Title : ");
		panelTitle.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.RED);
		panelTitle.add(label_3);
		
		txtTitle = new JTextField();
		panelInner.add(txtTitle);
		txtTitle.setColumns(15);
		
		JPanel panelAuthor = new JPanel();
		panelAuthor.setBackground(SystemColor.desktop);
		FlowLayout fl_panelAuthor = (FlowLayout) panelAuthor.getLayout();
		fl_panelAuthor.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelAuthor);
		
		JLabel lblAuthor = new JLabel("     Author: ");
		panelAuthor.add(lblAuthor);
		lblAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_9 = new JLabel("*");
		panelAuthor.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtAuthor = new JTextField();
		txtAuthor.setBackground(new Color(255, 255, 255));
		panelInner.add(txtAuthor);
		txtAuthor.setColumns(15);
		
		JPanel panelEdition = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelEdition.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelEdition.setBackground(Color.WHITE);
		panelInner.add(panelEdition);
		
		JLabel lblEdition = new JLabel("     Edition:");
		panelEdition.add(lblEdition);
		
		JLabel label_7 = new JLabel("*");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.RED);
		panelEdition.add(label_7);
		
		cboEdition = new JComboBox();
		cboEdition.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cboEdition.setBackground(Color.WHITE);
		panelInner.add(cboEdition);
		
		JPanel panelQTY = new JPanel();
		panelQTY.setBackground(SystemColor.desktop);
		FlowLayout fl_panelQTY = (FlowLayout) panelQTY.getLayout();
		fl_panelQTY.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelQTY);
		
		JLabel lblQty = new JLabel("     Quantity: ");
		panelQTY.add(lblQty);
		
		JLabel label_5 = new JLabel("*");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.RED);
		panelQTY.add(label_5);
		
		txtQty = new JTextField();
		panelInner.add(txtQty);
		txtQty.setColumns(10);
		
		JPanel panelPrice = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelPrice.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelPrice.setBackground(Color.WHITE);
		panelInner.add(panelPrice);
		
		JLabel lblPrice = new JLabel("     Price:");
		panelPrice.add(lblPrice);
		
		JLabel label_6 = new JLabel("*");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(Color.RED);
		panelPrice.add(label_6);
		
		txtPrice = new JTextField();
		panelInner.add(txtPrice);
		txtPrice.setColumns(10);
		
		JPanel panelSave = new JPanel();
		panelSave.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_6 = (FlowLayout) panelSave.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panelInner.add(panelSave);
		
		btnSave = new JButton("Save");
		//btnSave.setIcon(new ImageIcon("images/add.png"));
		panelSave.add(btnSave);
		btnSave.setFocusPainted(false);
		btnSave.setForeground(new Color(60,141,188));
		//btnSave.setForeground(SystemColor.desktop);
		
		btnClear = new JButton("Clear");
		panelSave.add(btnClear);
		btnClear.setFocusPainted(false);
		btnClear.setBackground(SystemColor.menu);
		
		JPanel panelUpdate = new JPanel();
		panelUpdate.setBackground(new Color(255, 255, 255));
		FlowLayout fl_panelUpdate = (FlowLayout) panelUpdate.getLayout();
		fl_panelUpdate.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelUpdate);
		
		btnRemove = new JButton("Remove");
		btnRemove.setHorizontalAlignment(SwingConstants.RIGHT);
		//btnRemove.setForeground(Color.WHITE);
		btnRemove.setFocusPainted(false);
		btnRemove.setForeground(new Color(221, 75, 57));
		panelUpdate.add(btnRemove);
		
		btnEdit = new JButton("Update");
		//btnEdit.setForeground(Color.WHITE);
		btnEdit.setBackground(new Color(0, 166, 90));
		panelUpdate.add(btnEdit);
		
		JPanel panelShowImage = new JPanel();
		panelShowImage.setForeground(Color.WHITE);
		panelBodyRight.add(panelShowImage, BorderLayout.CENTER);
		
		lblShowimage = new JLabel("Image");
		lblShowimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowimage.setIcon(new ImageIcon("images/image.png"));
		lblShowimage.setHorizontalTextPosition(JButton.CENTER);
		lblShowimage.setVerticalTextPosition(JButton.BOTTOM);
		panelShowImage.add(lblShowimage);
		
		
	}

	
	public void initButton() {
		btnImage.addActionListener(this);
		btnSave.addActionListener(this);
		btnClear.addActionListener(this);
		btnEdit.addActionListener(this);
		btnRemove.addActionListener(this);
		txtSearch.addActionListener(this);
		
	}
	public void initObjects () {
		model.setRowCount(0);
		ArrayList<BookClass> bookList = new UserConnection().bookView();
		
		for(BookClass boo: bookList) {
			model.addRow(boo.getBookList());
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnImage)
				chooseImage();
			else if(e.getSource() == btnClear)
				clearTextFields();
			else if(e.getSource() == btnSave)
				saveBook();
			else if(e.getSource() == btnRemove)
				removeBook();
			else if(e.getSource() == btnEdit)
				editBook();
			else if(e.getSource() == txtSearch)
				searchBook();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
	
	public void initTable() {
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				btnEdit.setEnabled(true);
				
				int[] row = table.getSelectedRows();
				if(row.length == 1) {
					String getId = table.getModel().getValueAt(row[0], 0).toString();
					ArrayList<BookClass> bookList = new UserConnection().detailBook(Integer.parseInt(getId));
						
						if(e.getClickCount() == 1) {
							for(int i=0; i<bookList.size(); i++) {
								BookClass book = bookList.get(i);
								lblShowimage.setText(book.getImg());
								lblShowimage.setIcon(new ImageIcon(new ImageIcon("uploads/" + book.getImg()).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT)));
								txtISBN.setText(book.getIsbn());
								txtTitle.setText(book.getTitle());
								txtAuthor.setText(book.getAuthor());
								cboEdition.setSelectedItem(book.getEdition() + "");
								txtQty.setText(book.getQty() + "");
								txtPrice.setText(book.getPrice() + "");
							}
						}
						if (e.getClickCount() == 2) {
							for(int i=0; i<bookList.size(); i++) {
								BookClass book = bookList.get(i);
								new FormBookUser(book);
							}
							
						}
					
				}
					
				else {
					btnEdit.setEnabled(false);
					
					clearTextFields();
				}
				
				
				
				
			}
		});
	}
	
	
	public void saveBook() throws Exception {
		if(lblShowimage.getText().equals("Image"))
			throw new Exception("Image is required");
		
		else if(txtISBN.getText().isEmpty())
			throw new Exception("ISBN is required");
		
		else if(txtTitle.getText().isEmpty()) 
			throw new Exception("Book Title is required");
		
		else if(txtAuthor.getText().isEmpty())
			throw new Exception("Author cannot be null");
		
		else if(txtQty.getText().isEmpty())
			throw new Exception("QTY cannot be null");
		
		else if(Integer.parseInt(txtQty.getText()) <= 0)
			throw new Exception("QTY cannot be equal or less than zero");
		
		else if(txtPrice.getText().isEmpty())
			throw new Exception("Price cannot be null");
		
		else if(Double.parseDouble(txtPrice.getText()) <= 0)
			throw new Exception("Price cannot be equal or less than zero");
		
		else {
			Date date = new Date();
			BufferedImage img = ImageIO.read(selectedPath);
		    String strDateFormat = "yyyy_MMM_dd_hh_mm_ss";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    String formattedDate= dateFormat.format(date);
		    
			String location = "uploads/" +formattedDate + imageName;
			String format = "PNG";
			ImageIO.write(img, format, new File(location));
			
			BookClass book = new BookClass(txtISBN.getText(), txtTitle.getText(), formattedDate + imageName, Integer.parseInt(txtQty.getText()), 
							Double.parseDouble(txtPrice.getText()), txtAuthor.getText(), Integer.parseInt(cboEdition.getSelectedItem().toString()), 0);
			new BookConnection().addNewBook(book);
			model.setRowCount(0);
			initObjects();
		}
	}
	public void clearTextFields() {
		txtISBN.setText("");
		txtTitle.setText("");
		txtPrice.setText("");
		txtQty.setText("");
		txtAuthor.setText("");
		cboEdition.setSelectedItem("1");
		
		lblShowimage.setText("Image");
		lblShowimage.setIcon(new ImageIcon("images/image.png"));
	}
	
	public void removeBook() {
		try {
			
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
		                if(table.getModel().getValueAt(modelRow, 7).toString().equals(table.getModel().getValueAt(modelRow, 5).toString())) {
			                new BookConnection().removeBook(Integer.parseInt(id));
			               
							model.removeRow( modelRow );
				            row = table.getSelectedRow();
				           
		                }
		                else
		                	throw new Exception("Cannot delete becuase this book is borrowed!");
		            }
	
					JOptionPane.showConfirmDialog(null, "Data has been removed successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
				}
				
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	public void editBook() {
		try {
			
			if(table.getSelectionModel().isSelectionEmpty())
				JOptionPane.showConfirmDialog(null, "Please select row to Edit", "",  JOptionPane.CLOSED_OPTION , JOptionPane.ERROR_MESSAGE);
			else {
				
				int[] row = table.getSelectedRows();
				if(row.length == 1) {
					int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "Editing...", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
					if(confirm == JOptionPane.OK_OPTION) {
						String getId = table.getModel().getValueAt(row[0], 0).toString();
						
						if(table.getModel().getValueAt(row[0], 7).toString().equals(table.getModel().getValueAt(row[0], 5).toString())) {
							
							Date date = new Date();
							BufferedImage img = ImageIO.read(selectedPath);
						    String strDateFormat = "yyyy_MMM_dd_hh_mm_ss";
						    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
						    String formattedDate= dateFormat.format(date);
						    
							String location = "uploads/" +formattedDate + imageName;
							String format = "PNG";
							ImageIO.write(img, format, new File(location));
							
							BookClass book = new BookClass(txtISBN.getText(), txtTitle.getText(), formattedDate + imageName, Integer.parseInt(txtQty.getText()), 
									Double.parseDouble(txtPrice.getText()), txtAuthor.getText(), Integer.parseInt(cboEdition.getSelectedItem().toString()), 0);
							new BookConnection().updateBook(Integer.parseInt(getId), book);
							initObjects();
							JOptionPane.showConfirmDialog(null, "Data has been updated successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
						}
						else {
							JOptionPane.showConfirmDialog(null, "Cannot delete becuase this book is borrowed!", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
						}
					}
				}
					
				else {
					JOptionPane.showConfirmDialog(null, "Please select Specific row !", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	// CHOOSE IMAGE
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
			lblShowimage.setText(imageName);
//			System.out.println(imageName);
		}
		else if(result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "No Image", "", JOptionPane.OK_OPTION);
		}
	}
	
	
	//Method To Resize The ImageIcon
    public ImageIcon resizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lblShowimage.getWidth(), lblShowimage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    
    
    public void searchBook() {
    	if(txtSearch.getText().isEmpty()) 
    		initObjects();
    	else {
    		try {
    			Statement stmt = DBConnection.connectDB().createStatement();
    			String search = txtSearch.getText();
    			String sql = "SELECT * FROM books b WHERE b.isbn LIKE '%" + search + "%' OR " +
    					  "b.title LIKE '%" + search + "%' OR " + 
    					  "b.author LIKE '%" + search + "%' OR " + 
    					  "b.edition LIKE '%" + search + "%'";

    			ResultSet rss = stmt.executeQuery(sql);
    			model.setRowCount(0);
    			while(rss.next()) {
    				BookClass book = new BookClass(rss.getInt("id"), rss.getString("isbn"), rss.getString("title"), rss.getString("image"), rss.getInt("qty"),
    						rss.getDouble("price"), rss.getString("author"), rss.getInt("edition"), rss.getInt("numBorrow"));
    				
    				model.addRow(book.getBookList());
    			}
    			stmt.close();
    		}catch(Exception e) {
    			e.getStackTrace();
    		}
    	}
    }

	

	
}
