package popForm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Cursor;

import classMembers.BookClass;
import classMembers.BorrowerClass;
import connection.UserConnection;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class NewBorrower extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtStudentID;
	private JTextField txtStudentName;
	private JTextField txtContact;
	private JPanel panelLeft, panelRight, panelButton;
	
	private JPanel panelMain;
	private JTextField txtBorrowedDate;
	@SuppressWarnings("rawtypes")
	private JComboBox cboBorrowQty;
	private JButton btnAddnew, btnClear;
	private JTextField txtBookISBN;
	private JTextField txtBookQty;
	private JLabel lblBook_id;
	
	
	

	/**
	 * Create the panel.
	 */
	public NewBorrower() {
		setLayout(new BorderLayout(0, 0));
		
		initComponent();
		//initStudentInfo();
		
		borrowInfo();
		initButton();
		
		JOptionPane.showOptionDialog(null	, panelMain, "Create new Borrower", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComponent () {
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(20, 20));
		
		JPanel panelTitle = new JPanel();
		panelMain.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setBackground(new Color(255, 255, 255));
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCreateNewBorrower = new JLabel("Create a new Borrower ");
		lblCreateNewBorrower.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewBorrower.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(lblCreateNewBorrower, BorderLayout.NORTH);
		
		JPanel panelContent = new JPanel();
		panelMain.add(panelContent);
		panelContent.setBackground(new Color(255, 255, 255));
		panelContent.setLayout(new BorderLayout(0, 20));
		
		JPanel panelInner = new JPanel();
		panelInner.setBackground(new Color(255, 255, 255));
		panelContent.add(panelInner, BorderLayout.NORTH);
		panelInner.setLayout(new GridLayout(0, 2, 20, 0));
		
		panelLeft = new JPanel();
		panelLeft.setBorder(new TitledBorder(null, "Student Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelLeft.setBackground(new Color(255, 255, 255));
		panelInner.add(panelLeft);
		panelLeft.setLayout(new GridLayout(4, 2, 0, 5));
		
		initStudentInfo();
		
		//initBookInfo();
		
		
		panelRight = new JPanel();
		panelRight.setBorder(new TitledBorder(null, "Book Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelRight.setBackground(new Color(255, 255, 255));
		panelInner.add(panelRight);
		panelRight.setLayout(new GridLayout(4, 2, 0, 5));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.setBackground(Color.WHITE);
		panelRight.add(panel);
		
		JLabel label_6 = new JLabel("Book ISBN ");
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		panel.add(label_7);
		
		initBookISBN();
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_3.setBackground(Color.WHITE);
		panelRight.add(panel_3);
		
		JLabel label_8 = new JLabel("Book Available");
		panel_3.add(label_8);
		
		JLabel label_1_1 = new JLabel("*");
		label_1_1.setForeground(Color.RED);
		panel_3.add(label_1_1);
		
		txtBookQty = new JTextField();
		panelRight.add(txtBookQty);
		txtBookQty.setColumns(10);
		
		JLabel label = new JLabel("");
		panelRight.add(label);
		
		JPanel panelBorrowout = new JPanel();
		panelBorrowout.setBorder(new TitledBorder(null, "Borrow Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelBorrowout.setBackground(Color.WHITE);
		panelContent.add(panelBorrowout, BorderLayout.CENTER);
		panelBorrowout.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBorrowIN = new JPanel();
		panelBorrowIN.setBackground(Color.WHITE);
		panelBorrowout.add(panelBorrowIN, BorderLayout.CENTER);
		
		JPanel panelBorrow = new JPanel();
		panelBorrowIN.add(panelBorrow);
		panelBorrow.setBackground(Color.WHITE);
		panelBorrow.setLayout(new GridLayout(7, 2, 0, 5));
		JPanel panelBorrowQty = new JPanel();
		panelBorrow.add(panelBorrowQty);
		panelBorrowQty.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_6 = (FlowLayout) panelBorrowQty.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		JLabel lblQtyOfBorrowing = new JLabel("QTY of Borrowing");
		panelBorrowQty.add(lblQtyOfBorrowing);
		
		JLabel label_7_1 = new JLabel("*");
		label_7_1.setForeground(Color.RED);
		panelBorrowQty.add(label_7_1);
		
		cboBorrowQty = new JComboBox(new String[] {"1", "2", "3"});
		panelBorrow.add(cboBorrowQty);
		cboBorrowQty.setFocusable(false);
		cboBorrowQty.setBackground(Color.WHITE);
		
		JPanel panelBorrowDate = new JPanel();
		panelBorrow.add(panelBorrowDate);
		panelBorrowDate.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_7 = (FlowLayout) panelBorrowDate.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_8 = new JLabel("Borrowed Date (MMM, d, yyy)");
		panelBorrowDate.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("*");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		panelBorrowDate.add(lblNewLabel_9);
		
		txtBorrowedDate = new JTextField();
		panelBorrow.add(txtBorrowedDate);
		
		
		JPanel panel_2 = new JPanel();
		panelBorrow.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		
		panelButton = new JPanel();
		panelBorrow.add(panelButton);
		panelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FlowLayout flowLayout_11 = (FlowLayout) panelButton.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		panelButton.setBackground(new Color(255, 255, 255));
		btnAddnew = new JButton("Add New");
		btnAddnew.setFocusPainted(false);
		btnAddnew.setBackground(new Color(65, 105, 225));
		btnAddnew.setForeground(new Color(65, 105, 225));
		panelButton.add(btnAddnew);
		
		btnClear = new JButton("Clear All");
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setFocusPainted(false);
		panelButton.add(btnClear);
		
		JLabel label_4 = new JLabel("");
		panelBorrow.add(label_4);
		
		JLabel label_9 = new JLabel("");
		panelBorrow.add(label_9);
		
		JLabel label_10 = new JLabel("");
		panelBorrow.add(label_10);
		
		btnAddnew.addActionListener(this);
		btnClear.addActionListener(this);
		
		lblBook_id = new JLabel("");
		lblBook_id.setVisible(false);
		panelBorrowout.add(lblBook_id, BorderLayout.SOUTH);
		
		borrowInfo();
	}
	
	public void initStudentInfo() {
		JPanel panelStudentID = new JPanel();
		panelStudentID.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_4 = (FlowLayout) panelStudentID.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panelLeft.add(panelStudentID);
		
		JLabel lblStudentId = new JLabel("Student ID");
		panelStudentID.add(lblStudentId);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		panelStudentID.add(label_3);
		
		initStudentID();
		
		JPanel panelStudentName = new JPanel();
		panelStudentName.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_3 = (FlowLayout) panelStudentName.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelLeft.add(panelStudentName);
		
		JLabel lblStudentName = new JLabel("Student Name");
		panelStudentName.add(lblStudentName);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		panelStudentName.add(label_4);
		
		txtStudentName = new JTextField();
		txtStudentName.setBackground(new Color(255, 255, 255));
		panelLeft.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		JPanel panelStudentContact = new JPanel();
		panelStudentContact.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_8 = (FlowLayout) panelStudentContact.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panelLeft.add(panelStudentContact);
		
		JLabel lblContact = new JLabel("Contact");
		panelStudentContact.add(lblContact);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		panelStudentContact.add(label_8);
		
		txtContact = new JTextField();
		txtContact.setBackground(new Color(255, 255, 255));
		panelLeft.add(txtContact);
		txtContact.setColumns(10);
	}
	
//	public void initBookInfo() {
//		
//		initBookISBN();
//	}
	
	public void borrowInfo() {
		
		DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
		txtBorrowedDate.setEditable(false);
		txtBorrowedDate.setColumns(20);
		txtBorrowedDate.setText(df.format(new Date()));
		
		
	}
	
	public void initButton() {
	}
	
	public void initStudentID() {
		txtStudentID = new JTextField();
		panelLeft.add(txtStudentID);
		txtStudentID.setColumns(10);
		
		txtStudentID.addActionListener(action);
		
	}
	
	public void initBookISBN() {
		txtBookISBN = new JTextField();
		txtBookISBN.setColumns(20);
		panelRight.add(txtBookISBN);
		txtBookISBN.addActionListener(action);
	}

	Action action = new AbstractAction()
	{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e)
	    {
			try {
				if(e.getSource() == txtStudentID) {
					
					if(txtStudentID.getText().isEmpty()) {
						txtStudentID.setText("");
						throw new Exception("Student ID is required!");	
					}
					else {
						boolean returnDate = new UserConnection().getReturnDate(txtStudentID.getText());
						if(returnDate)
							throw new Exception("You haven't returned our book yet!");
						else
							throw new Exception("Available to borrow!");
						
					}
				}
				else if(e.getSource() == txtBookISBN) {
					if(txtBookISBN.getText().isEmpty()) {
						txtBookQty.setText("");
						txtBookISBN.setText("");
						throw new Exception("Book ISBN is required!");
					}
					else {
						BookClass book = new UserConnection().getBookInfo(txtBookISBN.getText());
						System.out.println(book.getTitle());
						txtBookQty.setText(book.numBookAvailable(book.getNumBorrow()) + "");
						lblBook_id.setText(book.getID() + "");
					}
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
	        		
	    }

	};
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnAddnew)
			try {
				addNewBorrow();
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		else if(e.getSource() == btnClear)
			clearText();
		
	}
	
	public void addNewBorrow() throws Exception {
		if(txtStudentID.getText().isEmpty())
			throw new Exception("StudentID is required!");
		
		if(txtStudentName.getText().isEmpty())
			throw new Exception("Student Name is required!");
		
		
		if(txtBookISBN.getText().isEmpty()) 
			throw new Exception("Book ISBN is required");
		
		if(txtContact.getText().isEmpty())
			throw new Exception("Contact is required!");
		
		if(Integer.parseInt(txtBookQty.getText()) < 1)
			throw new Exception("We are sorry! Our Books are out of stock!");
		
		int status = 1; // status == 1 means borrow but not yet return
		
		BorrowerClass borrow = new BorrowerClass(txtStudentID.getText(), Integer.parseInt(lblBook_id.getText()), txtStudentName.getText(), txtContact.getText(), 
				txtBookISBN.getText(), Integer.parseInt(cboBorrowQty.getSelectedItem().toString()) , txtBorrowedDate.getText(), status);
		
		new UserConnection().addBorrower(borrow);

	}
	
	public void clearText() {
		txtStudentID.setText("");
		txtStudentName.setText("");
		txtContact.setText("");
		
		txtBookISBN.setText("");
		txtBookQty.setText("");
		
	}
	
}
