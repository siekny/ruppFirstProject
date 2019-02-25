package adminPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;


import classMembers.BookClass;



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
	
	private JLabel lblNoUsers;
	private JTextField txtQty;
	private JTextField txtPrice;

	private JComboBox cboEdition;
	
	
	
	/**
	 * Create the panel.
	 */

	public Books() {
		
		initialize();
	
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
		

	
		JPanel panelInner = new JPanel();
		panelInner.setBackground(SystemColor.desktop);

		
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
		
Inner.add(label_2);
	
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
		
		btnClear = new JButton("Clear");
		
		btnClear.setFocusPainted(false);
		btnClear.setBackground(SystemColor.menu);
	
		

			@Override
			
				
				
			}
		});
			
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
							JOptionPane.showConfirmDialog(null, "Data has been removed successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
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
		
}
