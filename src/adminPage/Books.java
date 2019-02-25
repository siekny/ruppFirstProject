package adminPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import classMembers.BookClass;

public class Books extends JPanel {

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
	private JButton btnSave, btnClear;
	private JLabel lblNoUsers;
	private JTextField txtQty;
	private JTextField txtPrice;
	
	private JComboBox cboEdition;
	String s;
	
	
	/**
	 * Create the panel.
	 */
	
	public Books() {
		
		initialize();
		
		initObjects();
	}
	
	
	
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
		JLabel lblNewLabel_3 = new JLabel("#Book(s) : ");
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
		
		String[] colsName = new String[] {"id", "ISBN", "Title", "Author", "Edition", "Quantity", "Price"};
		
		
		
		model = new DefaultTableModel(null, colsName) {	
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
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.setBackground(new Color(255, 140, 0));
		btnDetail.setFocusPainted(false);
		btnDetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDetail.setForeground(new Color(255, 255, 255));
		panelButtonLeft.add(btnDetail);
		//Show Data From DB
		btnDetail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				Statement stm;
				ResultSet rss;
				ArrayList<BookClass> list = new ArrayList<BookClass>();
				try {
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/rupp_project","root", "");
				stm = conn.createStatement();
				String command = "Select * From books";
				rss = stm.executeQuery(command);
				
					 while(rss.next()) {
				        	BookClass book = new BookClass( rss.getInt("id"),rss.getString("isbn"), rss.getString("title") , "", rss.getInt("qty"), 
									 rss.getDouble("price"), rss.getString("author"), rss.getInt("edition"), 0);
							
				list.add(book);
				}
				
				model.setRowCount(0);
				
				for (int i=0;i<list.size();i++) {
					BookClass b = list.get(i);
					Object obj[]= {b.getID(), b.getIsbn(),b.getTitle(),b.getAuthor(),b.getEdition(),b.getQty(),b.getPrice()
					};
					model.addRow(obj);
				}
				
				rss.close();
				stm.close();
				conn.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
					
			}
		});
		
		//Remove record
		JButton btnRemove = new JButton("Remove");
		btnRemove.setHorizontalAlignment(SwingConstants.RIGHT);
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFocusPainted(false);
		btnRemove.setBackground(new Color(221, 75, 57));
		panelButtonLeft.add(btnRemove);
		
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn ;
				Statement stm;
				ResultSet rss;
				try {
					
					conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/rupp_project", "root", "");
					stm = conn.createStatement();
					rss = stm.executeQuery("SELECT * FROM books");
					int index = table.getSelectedRow();
					String i =model.getValueAt(index,0).toString();
					String sql = "DELETE FROM books where id = "+i; 
					stm.executeUpdate(sql);
					rss.close();
					stm.close();
					conn.close();
					btnDetail.doClick();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 
				
			}
		});
		
		//Update Data
		JButton btnEdit = new JButton("Update");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBackground(new Color(0, 166, 90));
		panelButtonLeft.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int j = table.getSelectedRow();
				model = (DefaultTableModel) table.getModel();
				txtISBN.setText(model.getValueAt(j,1).toString());
				txtTitle.setText(model.getValueAt(j,2).toString());
				txtAuthor.setText(model.getValueAt(j,3).toString());
				txtQty.setText(model.getValueAt(j,5).toString());
				txtPrice.setText(model.getValueAt(j,6).toString());	
				
				btnSave.setEnabled(false);
				
				
			}
		});
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.desktop);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		panelContent.setBorder(new MatteBorder(3, 0,0,0, new Color(243,156,18)));
		
		JPanel panelTopRight = new JPanel();
		panelTopRight.setBackground(SystemColor.desktop);
		panelContent.add(panelTopRight, BorderLayout.NORTH);
		
		JLabel lblNewLabel_12 = new JLabel("Insertion a New Book");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		panelTopRight.add(lblNewLabel_12);
		
		JPanel panelBodyRight = new JPanel();
		panelBodyRight.setBackground(SystemColor.desktop);
		panelContent.add(panelBodyRight, BorderLayout.CENTER);
		
		panelBodyRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInner = new JPanel();
		panelInner.setBackground(SystemColor.desktop);

		panelBodyRight.add(panelInner, BorderLayout.CENTER);
		panelInner.setLayout(new GridLayout(14, 2, 0, 5));
		
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
		
		
		JButton btnImage = new JButton("Choose Image");
		btnImage.setFocusPainted(false);
		btnImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelInner.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 final String basePath =
					      "C:\\Desktop";
				JFileChooser fileChooser = new JFileChooser(basePath);				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             s= path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
	
		        	 JOptionPane.showMessageDialog(null, "Image Needed!!");
		         }	
			}
		});
		
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
		
		
		JComboBox cboEdition = new JComboBox();
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
		
		JLabel label = new JLabel("");
		label.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLUE));
		panelInner.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLUE));
		panelInner.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelInner.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		panelInner.add(label_2);
		
		JPanel panelSave = new JPanel();
		panelSave.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_6 = (FlowLayout) panelSave.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panelInner.add(panelSave);
		
		//Save Changed
		JButton btnEdit2 = new JButton("Edit");
		btnEdit2.setForeground(Color.BLACK);
		btnEdit2.setFocusPainted(false);
		btnEdit2.setBackground(new Color(60, 141, 188));
		panelSave.add(btnEdit2);
		btnEdit2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection conn ;
				Statement stm;
				ResultSet rss;
				btnEdit2.setEnabled(true);
				try {
					
					conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/rupp_project", "root", "");
					stm = conn.createStatement();
					rss = stm.executeQuery("SELECT * FROM books");
					int index = table.getSelectedRow();
					
					String i =model.getValueAt(index,0).toString();
					
					String sql = "UPDATE books SET isbn = '" + txtISBN.getText() + "', title = '" + txtTitle.getText() + "', author = '" + txtAuthor.getText() + "', edition= '" + cboEdition.getSelectedItem() + "', qty = '" + Integer.parseInt(txtQty.getText()) + "' ,price = '" + Double.parseDouble(txtPrice.getText()) + "' where id = "+i; 
					stm.executeUpdate(sql);

					rss.close();
					stm.close();
					conn.close();
					JOptionPane.showMessageDialog(null, "Updated Successfully!!");
					btnDetail.doClick();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	btnSave.setEnabled(true);
			}
		});
		
		btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("images/add.png"));
		panelSave.add(btnSave);
		btnSave.setFocusPainted(false);
		btnSave.setBackground(new Color(60,141,188));
		btnSave.setForeground(SystemColor.desktop);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEdit2.setEnabled(false);
				
				 try{
		               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/rupp_project","root", "");
		               PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into books(isbn,title,image,qty,price,author,edition) values (?,?,?,?,?,?,?)");
		               InputStream is = new FileInputStream(new File(s));
		               ps.setString(1, txtISBN.getText());
		               ps.setString(2, txtTitle.getText());
		               ps.setBlob(3, is, 16 );
		               ps.setInt(4, Integer.parseInt(txtQty.getText()));
		               ps.setDouble(5, Double.parseDouble(txtPrice.getText()));
		               ps.setString(6, txtAuthor.getText());
		               ps.setObject(7, cboEdition.getSelectedItem());
		              
		               ps.executeUpdate();
		               JOptionPane.showMessageDialog(null, "Saved Successfully");
		               
		           }catch(Exception ex){
		               ex.printStackTrace();
		           } btnDetail.doClick();
			
			}	
		});
		
		JPanel panelClear = new JPanel();
		panelClear.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_2 = (FlowLayout) panelClear.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelClear);
		
		btnClear = new JButton("Clear");
		
		panelClear.add(btnClear);
		btnClear.setFocusPainted(false);
		btnClear.setBackground(SystemColor.menu);
	
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				txtISBN.setText("");
				txtTitle.setText("");
				txtAuthor.setText("");
				txtQty.setText("");
				cboEdition.setSelectedIndex(0);
				txtPrice.setText("");
				
				
			}
		});
			
	}
	

	public void initObjects () {
	}	
		
}
