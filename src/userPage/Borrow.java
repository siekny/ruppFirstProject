package userPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.*;

import classMembers.*;
import connection.*;
import popForm.*;

public class Borrow extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel model;
	
	private JPanel panelTable, panelButton, panelSearch;
	private JButton btnAddNew, btnRemove, btnEdit, btnReLoad;
	private JButton btnReturn;
	private JButton btnBorrowonly;
	private JButton btnRecycleBin;
	private JButton btnReturnonly;

	/**
	 * Create the panel.
	 */
	public Borrow() {
		
		setLayout(new BorderLayout(0, 0));
		
		initComponent();
		initTable();
		initButton();
		
		showBorrower();

	}
	
	public void initComponent() {
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(243,156,18)));
		add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelInner = new JPanel();
		panelInner.setBackground(Color.WHITE);
		panelMain.add(panelInner);
		panelInner.setPreferredSize(new Dimension(1100, 600));
		panelInner.setLayout(new BorderLayout(20, 20));
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255));
		panelInner.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new GridLayout(2, 1, 0, 0));
		
		
		JLabel lblNewLabel = new JLabel("Book Transaction");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTop.add(lblNewLabel);
		
		panelSearch = new JPanel();
		panelSearch.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panelSearch.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(10);
		panelTop.add(panelSearch);
		
		btnReLoad = new JButton("Reload");
		btnReLoad.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReLoad.setIcon(new ImageIcon("images/reload.png"));
		btnReLoad.setForeground(new Color(255, 255, 255));
		btnReLoad.setBackground(new Color(0,166,90));
		btnReLoad.setContentAreaFilled(false);
		btnReLoad.setOpaque(true);
		btnReLoad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearch.add(btnReLoad);
		
		btnBorrowonly = new JButton("Borrow Only");
		btnBorrowonly.setContentAreaFilled(false);
		btnBorrowonly.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrowonly.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBorrowonly.setBackground(new Color(65, 105, 225));
		btnBorrowonly.setForeground(Color.WHITE);
		btnBorrowonly.setOpaque(true);
		panelSearch.add(btnBorrowonly);
		
		btnReturnonly = new JButton("Return Only");
		btnReturnonly.setBackground(new Color(255, 153, 51));
		btnReturnonly.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturnonly.setContentAreaFilled(false);
		btnReturnonly.setForeground(new Color(255, 255, 255));
		btnReturnonly.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReturnonly.setOpaque(true);
		panelSearch.add(btnReturnonly);
		
		JLabel lblNewLabel_1 = new JLabel("          Search : ");
		panelSearch.add(lblNewLabel_1);
		
		txtSearch = new JTextField();
		txtSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panelSearch.add(txtSearch);
		txtSearch.setColumns(30);
		
		JLabel lblNewLabel_2 = new JLabel("#Borrowers  :  ");
		panelSearch.add(lblNewLabel_2);
		
		JLabel lblNoUsers = new JLabel("");
		panelSearch.add(lblNoUsers);
		
		panelTable = new JPanel();
		panelInner.add(panelTable, BorderLayout.CENTER);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		panelButton = new JPanel();
		panelButton.setBackground(new Color(255, 255, 255));
		panelInner.add(panelButton, BorderLayout.EAST);
		panelButton.setLayout(new GridLayout(12, 1, 0, 5));
	}
	
	public void initTable() {
		String[] colsName = new String[] {"id", "BookID", "StudentID"
				, "Full Name", "Contact", "Book ISBN", "Borrowed BookQTY", "Borrowed Date", "Return Date"};
		model = new DefaultTableModel(null, colsName) {
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 0;
		    }
		};
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(model);
		table.getTableHeader().setBackground(new Color(60, 141, 188));
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(new Color(255, 255, 255));
		panelTable.add(scroll);
		
		TableColumnModel tm = table.getColumnModel();
		table.removeColumn(tm.getColumn(0));
		table.removeColumn(tm.getColumn(1));
	}
	
	public void initButton() {
		
		btnAddNew = new JButton("Add New");
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddNew.setForeground(new Color(255, 255, 255));
		btnAddNew.setBackground(new Color(65, 105, 225));
		btnAddNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelButton.add(btnAddNew);
		btnAddNew.setContentAreaFilled(false);
		btnAddNew.setOpaque(true);
		
		btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReturn.setBackground(new Color(139, 69, 19));
		btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setContentAreaFilled(false);
		btnReturn.setOpaque(true);
		panelButton.add(btnReturn);
		btnReturn.addActionListener(this);
		
		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.setBackground(new Color(46, 139, 87));
		btnEdit.setContentAreaFilled(false);
		btnEdit.setOpaque(true);
		panelButton.add(btnEdit);
		btnEdit.addActionListener(this);
		
		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemove.setBackground(new Color(178, 34, 34));
		btnRemove.setForeground(new Color(255, 255, 255));
		btnRemove.setContentAreaFilled(false);
		btnRemove.setOpaque(true);
		panelButton.add(btnRemove);
		
		btnRecycleBin = new JButton("Recycle Bin");
		btnRecycleBin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRecycleBin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRecycleBin.setBackground(new Color(255,255,255));
		btnRecycleBin.setForeground(new Color(0, 0, 0));
		btnRecycleBin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecycleBin.setContentAreaFilled(false);
		btnRecycleBin.setOpaque(true);
		panelButton.add(btnRecycleBin);
		
		btnReLoad.addActionListener(this);
		btnAddNew.addActionListener(this);
		btnRemove.addActionListener(this);
		btnBorrowonly.addActionListener(this);
		btnRecycleBin.addActionListener(this);
		btnReturnonly.addActionListener(this);
		
		txtSearch.addActionListener(this);
		
		doubleClickTable();
	}
	
	// Double Click on row of table
	public void doubleClickTable() {
		table.addMouseListener(new MouseAdapter() {
	
		@Override
		public void mousePressed(MouseEvent e) {
			
			int row = table.getSelectedRow();
			String id = table.getModel().getValueAt(row, 0).toString();
			
			BorrowerClass detail = new UserConnection().borrowDetail(Integer.parseInt(id));
			
			if (e.getClickCount() == 2) {
					new BorrowDetail(detail);
				}
				
			}
		});
	}
	
	public void showBorrower() {
		
		model.setRowCount(0);
		
		ArrayList<BorrowerClass> borrowList = new UserConnection().borrowView(0); // show both return date 
		
		for(int i=0; i<borrowList.size(); i++) {
			BorrowerClass book = borrowList.get(i);
			model.addRow(book.getBorrowColumns());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if(e.getSource() == btnAddNew)
				newBorrower();
			else if(e.getSource() == btnReturn)
				returnBorrow();
			else if(e.getSource() == btnRemove)
				removeBorrowers();
			else if(e.getSource() == btnBorrowonly)
				borrowedBookOnly(1);
			else if(e.getSource() == btnReturnonly)
				borrowedBookOnly(2);
			else if(e.getSource() == btnReLoad)
				showBorrower();
			else if(e.getSource() == btnRecycleBin)
				recycleofBorrowed();
			else if(e.getSource() == btnEdit)
				editBorrower();
			else if(e.getSource() == txtSearch)
				searchBorrower();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
	public void borrowedBookOnly(int category) {
		final int BORROWED = 1;
		final int RETURNED = 2;
		
		model.setRowCount(0);
		
		ArrayList<BorrowerClass> list = null;
		switch(category) {
			case BORROWED:
				list = new UserConnection().borrowView(1); 
				break;
			case RETURNED:
				list = new UserConnection().borrowView(3); 
				break;
		}
	
		for(int i=0; i<list.size(); i++) {
			BorrowerClass book = list.get(i);
			model.addRow(book.getBorrowColumns());
		}
	}
	
	public void editBorrower() {
		if(table.getSelectionModel().isSelectionEmpty())
			JOptionPane.showConfirmDialog(null, "Please select row to edit !", "", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		else {
			int[] row = table.getSelectedRows();
			if(row.length == 1) {
				String getId = table.getModel().getValueAt(row[0], 0).toString();
				
				if(table.getModel().getValueAt(row[0], 8).toString().equals("0")) {
					BorrowerClass borrowed = new UserConnection().borrowedBook(Integer.parseInt(getId));
					new NewBorrower(borrowed, 0);	// 0 is form for editing borrower
					showBorrower();
				}
				else {
					JOptionPane.showConfirmDialog(null, "This Book's been returned!", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				}
			}
				
			else {
				JOptionPane.showConfirmDialog(null, "Please select Specific row !", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
			
		}
			
	}
	public void newBorrower() {
		new NewBorrower(null, 1);	// 1 is form for adding new borrower
		showBorrower();
		
	}
	public void returnBorrow() {
	
		if(table.getSelectionModel().isSelectionEmpty())
			JOptionPane.showConfirmDialog(null, "Please select row to return !", "", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		else {
			int[] row = table.getSelectedRows();
			if(row.length == 1) {
				String getId = table.getModel().getValueAt(row[0], 0).toString();
				
				if(table.getModel().getValueAt(row[0], 8).toString().equals("0")) {
					BorrowerClass borrowed = new UserConnection().borrowedBook(Integer.parseInt(getId));
					new ReturnBook(borrowed);
					showBorrower();
				}
				else {
					JOptionPane.showConfirmDialog(null, "This Book's been returned!", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				}
			}
				
			else {
				JOptionPane.showConfirmDialog(null, "Please select Specific row !", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
	}

	
	public void removeBorrowers() throws Exception {
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
	                
	               
	                if(table.getModel().getValueAt(modelRow, 8).toString().equals("0")) {
	                	new UserConnection().removeBorrowed(Integer.parseInt(id));
	               
					
						model.removeRow( modelRow );
			            row = table.getSelectedRow();  
	                }
	                else
	                	throw new Exception("Already returned! cannot remove");
	            }

				JOptionPane.showConfirmDialog(null, "Data has been removed successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
	
	public void recycleofBorrowed() {
		new RecycleofBorrowed();
		showBorrower();
	}
	
	public void searchBorrower() {
		model.setRowCount(0);
		if(txtSearch.getText().isEmpty())
			showBorrower();
		else {
			ArrayList<BorrowerClass> borrowListSearch = new UserConnection().searchBorrowers(txtSearch.getText());
			for(int i=0; i<borrowListSearch.size(); i++) {
				BorrowerClass borrowSearch = borrowListSearch.get(i);
				model.addRow(borrowSearch.getBorrowColumns());
			}
		}
		
	}


}
