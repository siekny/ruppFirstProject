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
	private JButton btnAddNew, btnDetail, btnRemove, btnEdit, btnReLoad;
	private JButton btnReturn;
	private JButton btnBorrowonly;
	private JButton btnRecycleBin;

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
		
		JLabel lblNewLabel = new JLabel("Library Book Checkin/Checkout Sheet");
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
		btnReLoad.setIcon(new ImageIcon("images/reload.png"));
		btnReLoad.setForeground(new Color(255, 255, 255));
		btnReLoad.setBackground(new Color(0,166,90));
		btnReLoad.setFocusPainted(false);
		btnReLoad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearch.add(btnReLoad);
		
		btnBorrowonly = new JButton("Borrow Only");
		btnBorrowonly.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBorrowonly.setFocusPainted(false);
		btnBorrowonly.setBackground(new Color(128, 128, 128));
		btnBorrowonly.setForeground(Color.WHITE);
		panelSearch.add(btnBorrowonly);
		
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
		String[] colsName = new String[] {"id", "StudentID", "BookID", "Full Name", "Contact", "Book ISBN", "Borrowed BookQTY", "Borrowed Date", "Return Date"};
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
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(new Color(255, 255, 255));
		panelTable.add(scroll);
		
		TableColumnModel tm = table.getColumnModel();
		table.removeColumn(tm.getColumn(0));
		table.removeColumn(tm.getColumn(1));
	}
	
	public void initButton() {
		
		btnAddNew = new JButton("Add New");
		btnAddNew.setForeground(new Color(255, 255, 255));
		btnAddNew.setBackground(new Color(65, 105, 225));
		btnAddNew.setFocusPainted(false);
		btnAddNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelButton.add(btnAddNew);
		
		btnReturn = new JButton("Return");
		btnReturn.setBackground(new Color(105, 105, 105));
		btnReturn.setFocusPainted(false);
		btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturn.setForeground(Color.WHITE);
		panelButton.add(btnReturn);
		btnReturn.addActionListener(this);
		
		btnDetail = new JButton("Detail");
		btnDetail.setFocusPainted(false);
		btnDetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDetail.setBackground(new Color(255, 140, 0));
		btnDetail.setForeground(new Color(255, 255, 255));
		panelButton.add(btnDetail);
		
		btnEdit = new JButton("Edit");
		btnEdit.setFocusPainted(false);
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.setBackground(new Color(46, 139, 87));
		panelButton.add(btnEdit);
		btnEdit.addActionListener(this);
		
		btnRemove = new JButton("Remove");
		btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemove.setBackground(new Color(178, 34, 34));
		btnRemove.setFocusPainted(false);
		btnRemove.setForeground(new Color(255, 255, 255));
		panelButton.add(btnRemove);
		
		btnRecycleBin = new JButton("Recycle Bin");
		btnRecycleBin.setBackground(new Color(255, 255, 255));
		btnRecycleBin.setForeground(new Color(0, 0, 0));
		btnRecycleBin.setFocusPainted(false);
		btnRecycleBin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelButton.add(btnRecycleBin);
		
		btnReLoad.addActionListener(this);
		btnAddNew.addActionListener(this);
		btnDetail.addActionListener(this);
		btnRemove.addActionListener(this);
		btnBorrowonly.addActionListener(this);
		btnRecycleBin.addActionListener(this);
	}
	
	public void showBorrower() {
		
		model.setRowCount(0);
		
		ArrayList<BorrowerClass> borrowList = new UserConnection().borrowView(1); // show return date
		
		for(int i=0; i<borrowList.size(); i++) {
			BorrowerClass book = borrowList.get(i);
			model.addRow(book.getBorrowColumns());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnAddNew)
			newBorrower();
		else if(e.getSource() == btnReturn)
			returnBorrow();
		else if(e.getSource() == btnRemove)
			removeBorrowers();
		else if(e.getSource() == btnBorrowonly)
			borrowedBookOnly();
		else if(e.getSource() == btnReLoad)
			showBorrower();
		else if(e.getSource() == btnRecycleBin)
			recycleofBorrowed();
	}
	public void borrowedBookOnly() {
		model.setRowCount(0);
		
		ArrayList<BorrowerClass> borrowList = new UserConnection().borrowView(0); // not show return date
		
		for(int i=0; i<borrowList.size(); i++) {
			BorrowerClass book = borrowList.get(i);
			model.addRow(book.getBorrowColumns());
		}
	}
	
	public void newBorrower() {
		new NewBorrower();
	}
	public void returnBorrow() {
	
		if(table.getSelectionModel().isSelectionEmpty())
			JOptionPane.showConfirmDialog(null, "Please select row to return !", "", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		else {
			int[] row = table.getSelectedRows();
			if(row.length == 1) {
				String getId = table.getModel().getValueAt(row[0], 0).toString();
				BorrowerClass borrowed = new UserConnection().borrowedBook(Integer.parseInt(getId));
				
				new ReturnBook(borrowed);
				model.removeRow(row[0]);
			}
				
			else {
				JOptionPane.showConfirmDialog(null, "Please select Specific row !", "", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
	}

	public void removeBorrowers() {
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
	                
	                new UserConnection().removeBorrowed(Integer.parseInt(id));
	               
					model.removeRow( modelRow );
		            row = table.getSelectedRow();  
	            }

				JOptionPane.showConfirmDialog(null, "Data has been removed successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
	
	public void recycleofBorrowed() {
		new RecycleofBorrowed();
		showBorrower();
	}


}
