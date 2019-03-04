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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class NewBorrower extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtStudentID;
	public static JTextField txtStudentName;
	public static JTextField txtContact;
	private JPanel panelLeft, panelRight, panelButton;
	
	private JPanel panelMain;
	private JTextField txtBorrowedDate;
	@SuppressWarnings("rawtypes")
	private JComboBox cboBorrowQty;
	private JButton btnAddnew, btnClear;
	private JTextField txtBookISBN;
	private JTextField txtBookQty;
	private JLabel lblBook_id;
	private JLabel lblCreateNewBorrower;
	private JLabel lblMsg1;
	public static JLabel lblMsg2;
	
	private BorrowerClass oldBorrow;
	
	private StringBuilder sb = new StringBuilder();
	
	private StringBuilder sbisbn = new StringBuilder();
	
	private String availableStuID = "Available to borrow!";
	private String availablebookISBN = "";
	//private String tempISBN;
	
	

	/**
	 * Create the panel.
	 */
	public NewBorrower(BorrowerClass borrow, int isNew) {
		
		setLayout(new BorderLayout(0, 0));
		
		initComponent();
		
		borrowInfo();
		initButton();
		
		divideNewOrEditBorrower(borrow, isNew);
		
		JOptionPane.showOptionDialog(null	, panelMain, "Create new Borrower", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initComponent () {
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(20, 20));
		
		JPanel panelTitle = new JPanel();
		panelMain.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setBackground(new Color(255, 255, 255));
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		lblCreateNewBorrower = new JLabel("Create a new Borrower ");
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
		panelInner.setLayout(new GridLayout(0, 2, 10, 0));
		
		panelLeft = new JPanel();
		panelLeft.setForeground(new Color(0, 0, 0));
		panelLeft.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Student Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelLeft.setBackground(new Color(255, 255, 255));
		panelInner.add(panelLeft);
		panelLeft.setLayout(new GridLayout(4, 2, 0, 5));
		
		initStudentInfo();
		
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
		txtBookQty.setEditable(false);
		panelRight.add(txtBookQty);
		txtBookQty.setColumns(10);
		
		JLabel label = new JLabel("");
		panelRight.add(label);
		
		lblMsg2 = new JLabel("");
		lblMsg2.setForeground(Color.RED);
		panelRight.add(lblMsg2);
		
		JPanel panelBorrowout = new JPanel();
		panelBorrowout.setBorder(new TitledBorder(null, "Borrow Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelBorrowout.setBackground(Color.WHITE);
		panelContent.add(panelBorrowout, BorderLayout.CENTER);
		panelBorrowout.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBorrowIN = new JPanel();
		panelBorrowIN.setBackground(Color.WHITE);
		panelBorrowout.add(panelBorrowIN, BorderLayout.NORTH);
		
		JPanel panelBorrow = new JPanel();
		panelBorrowIN.add(panelBorrow);
		panelBorrow.setBackground(Color.WHITE);
		panelBorrow.setLayout(new GridLayout(3, 2, 0, 5));
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
		btnAddnew.setContentAreaFilled(false);
		
		btnAddnew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddnew.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddnew.setFocusPainted(false);
		btnAddnew.setBackground(new Color(65, 105, 225));
		btnAddnew.setForeground(new Color(255,255,255));
		btnAddnew.setOpaque(true);
		panelButton.add(btnAddnew);
		
		btnClear = new JButton("Clear All");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setFocusPainted(false);
		panelButton.add(btnClear);
		
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
		txtStudentID = new JTextField();
		panelLeft.add(txtStudentID);
		txtStudentID.setHorizontalAlignment(SwingConstants.LEFT);
		txtStudentID.setColumns(20);

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
		
		JLabel label = new JLabel("");
		panelLeft.add(label);
		
		lblMsg1 = new JLabel("");
		lblMsg1.setForeground(Color.RED);
		panelLeft.add(lblMsg1);
	}

	
	public void borrowInfo() {
		
		DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
		txtBorrowedDate.setEditable(false);
		txtBorrowedDate.setColumns(20);
		txtBorrowedDate.setText(df.format(new Date()));
		
		
	}
	
	public void initBookISBN() {
		txtBookISBN = new JTextField();
		panelRight.add(txtBookISBN);
		txtBookISBN.setColumns(10);
		
	}

	public void initButton() {
		
		checkID();
	}

	public void checkID() {
		txtStudentID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE && sb.length() > 0)
					sb.deleteCharAt(sb.length()-1);
				else if(ke.getKeyCode() != KeyEvent.VK_BACK_SPACE)
					sb.append(ke.getKeyChar());
				
				else {}
				
				if(sb.toString().isEmpty()) 
					lblMsg1.setText("");
				
				
				try {
					lblMsg1.setText("");
					lblMsg1.setForeground(Color.BLUE);
					boolean returnDate = new UserConnection().getReturnDate(sb.toString());
					if(returnDate) {
						txtStudentName.setText(null);
						txtContact.setText(null);
						lblMsg1.setForeground(Color.RED);
						lblMsg1.setText("You haven't returned our book yet!");
						
					}
					else {
						lblMsg1.setForeground(Color.BLUE);
						lblMsg1.setText(availableStuID);
						
					}
				}catch(Exception e) {
					e.getStackTrace();
				}
				
				
			}
			
		});
		
		
		txtBookISBN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				
				txtBookQty.setText("");
				
				if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE && sbisbn.length() > 0)
					sbisbn.deleteCharAt(sbisbn.length()-1);
				else if(ke.getKeyCode() != KeyEvent.VK_BACK_SPACE)
					sbisbn.append(ke.getKeyChar());
				else {}

				
				try {
					lblMsg2.setText("");
					lblMsg2.setForeground(Color.BLUE);
					
					BookClass book = new UserConnection().getBookInfo(sbisbn.toString());
					txtBookQty.setText(book.numBookAvailable(book.getNumBorrow()) + "");
					lblBook_id.setText(book.getID() + "");
					
					if(Integer.parseInt(txtBookQty.getText()) < 1) {
						lblMsg2.setForeground(Color.RED);
						lblMsg2.setText("We are sorry! Our Books are out of stock!");
					}
					if(Integer.parseInt(txtBookQty.getText()) < Integer.parseInt(cboBorrowQty.getSelectedItem().toString())) {
						lblMsg2.setForeground(Color.RED);
						lblMsg2.setText("We don't have enough book(s) for you");
					}
					
				}catch(Exception e) {
					e.getStackTrace();
				}
				
			}
			
		});
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if(e.getActionCommand() == "Add New")
				addNewBorrow();
				
			else if(e.getActionCommand() == "Update")
				updateBorrower();

			else if(e.getSource() == btnClear)
				clearText();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
	

	public void addNewBorrow() throws Exception {
		
		if(!lblMsg1.getText().equals(availableStuID)) 
			throw new Exception("Check StudentID || BookISBN again!");
		else if(txtStudentID.getText().isEmpty())
			throw new Exception("StudentId is required!");
		
		else if(txtStudentName.getText().isEmpty())
			throw new Exception("StudentName is required!");
		
		else if(txtContact.getText().isEmpty())
			throw new Exception("Contact is required!");
		
		else if(!lblMsg2.getText().equals(availablebookISBN))
			throw new Exception("Check BookISBN again!");
		
		else if(txtBookISBN.getText().isEmpty())
			throw new Exception("Book ISBN is required!");
		else if(txtBookQty.getText().isEmpty())
			throw new Exception("BookQTY is required!");
		
		
		// if(txtStudentID.getText().isEmpty() && txtStudentName.getText().isEmpty() && txtContact.getText().isEmpty() && txtBookISBN.getText().isEmpty() && txtBookISBN.getText().isEmpty())
		//	throw new Exception("All Fields are required!");
		
		if(Integer.parseInt(txtBookQty.getText()) < 1)
			throw new Exception("We are sorry! Our Books are out of stock!");
		
		if(Integer.parseInt(txtBookQty.getText()) < Integer.parseInt(cboBorrowQty.getSelectedItem().toString())) 
			throw new Exception("We don't have enough book(s) for you");
		
		
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
	
	public void divideNewOrEditBorrower(BorrowerClass borrow, int isNew) {
		if(isNew == 1)	return;
		else if(isNew == 0)	{
			setOldData(borrow);
			txtBookISBN.setText("");
			txtBookQty.setText("");
		}
	}
	
	
	
	// INFORMATION FOR EDIT ONLY 
	public void setOldData(BorrowerClass borrow) {
		lblCreateNewBorrower.setText("Editing a Borrower");
		
		txtStudentID.setText(borrow.getStu_id());
		txtStudentName.setText(borrow.getName());
		txtContact.setText(borrow.getPhone());
		
		//tempISBN = borrow.getBookISBN();
		txtBookISBN.setText(borrow.getBookISBN());
		//txtBookISBN.setText("");
		
		oldBorrow = borrow;
		
		BookClass book = new UserConnection().getBookInfo(txtBookISBN.getText());
		txtBookQty.setText(book.numBookAvailable(book.getNumBorrow()) + "");
		
		cboBorrowQty.setSelectedItem(borrow.getBorrowQTY() + "");
		
		btnAddnew.setText("Update");
		
		// SET EDITABLE = FALSE
		txtStudentID.setEnabled(false);
		txtStudentName.setEnabled(false);
		txtContact.setEnabled(false);
		btnClear.setVisible(false);
	}
	
	
	public void updateBorrower() throws Exception {
		if(txtStudentID.getText().isEmpty())
			throw new Exception("Student Name is required!");
		
		
		if(txtBookISBN.getText().isEmpty()) 
			throw new Exception("Book ISBN is required");

		if(Integer.parseInt(txtBookQty.getText()) < 1)
			throw new Exception("We are sorry! Our Books are out of stock!");
		if(Integer.parseInt(txtBookQty.getText()) < Integer.parseInt(cboBorrowQty.getSelectedItem().toString()))
			throw new Exception("We don't have enough book(s) for you");
		int status = 1; // status == 1 means borrow but not yet return
		
		BorrowerClass newBrrow = new BorrowerClass(txtStudentID.getText(), Integer.parseInt(lblBook_id.getText()), txtStudentName.getText(), txtContact.getText(), 
				txtBookISBN.getText(), Integer.parseInt(cboBorrowQty.getSelectedItem().toString()) , txtBorrowedDate.getText(), status);
		
		new UserConnection().updateBorrower(oldBorrow, newBrrow);
	}
}
