package popForm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

import classMembers.BorrowerClass;
import connection.UserConnection;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Cursor;

public class ReturnBook extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTxtstudentid;
	private JTextField txtStudentname;
	private JTextField txtBookisbn;
	private JTextField txtQty;
	private JTextField txtBorroweddate;
	
	private JPanel panelContent;
	private JTextField txtReturndate;
	private JTextField txtActualreturndate;
	private JTextField txtFineamount;
	
	private JButton btnReturn;
	private JTextField txtOverdays;
	
	private JLabel lblBorrowedid;

	/**
	 * Create the panel.
	 */
	public ReturnBook(BorrowerClass borrowed) {
		
		setLayout(new BorderLayout(0, 0));
		
		panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelInner = new JPanel();
		panelInner.setBackground(new Color(255, 255, 255));
		panelContent.add(panelInner);
		panelInner.setLayout(new BorderLayout(20, 20));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 255, 255));
		panelTitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(65, 105, 225)));
		panelInner.add(panelTitle, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ISSUE RETURN TABLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(lblNewLabel);
		
		JPanel paneText = new JPanel();
		paneText.setBackground(new Color(255, 255, 255));
		panelInner.add(paneText, BorderLayout.CENTER);
		paneText.setLayout(new GridLayout(1, 2, 10, 5));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(255, 255, 255));
		paneText.add(panelLeft);
		panelLeft.setLayout(new GridLayout(6, 2, 0, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		panelLeft.add(lblNewLabel_1);
		
		txtTxtstudentid = new JTextField();
		panelLeft.add(txtTxtstudentid);
		txtTxtstudentid.setBackground(new Color(255, 255, 255));
		txtTxtstudentid.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		txtTxtstudentid.setEditable(false);
		txtTxtstudentid.setColumns(5);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		panelLeft.add(lblNewLabel_2);
		
		txtStudentname = new JTextField();
		txtStudentname.setBackground(new Color(255, 255, 255));
		txtStudentname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		panelLeft.add(txtStudentname);
		txtStudentname.setEditable(false);
		txtStudentname.setColumns(5);
		
		JLabel lblNewLabel_3 = new JLabel("Book ISBN");
		panelLeft.add(lblNewLabel_3);
		
		txtBookisbn = new JTextField();
		txtBookisbn.setBackground(new Color(255, 255, 255));
		txtBookisbn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		panelLeft.add(txtBookisbn);
		txtBookisbn.setEditable(false);
		txtBookisbn.setColumns(5);
		
		JLabel lblNewLabel_4 = new JLabel("QTY of Book Borrowed");
		panelLeft.add(lblNewLabel_4);
		
		txtQty = new JTextField();
		txtQty.setBackground(new Color(255, 255, 255));
		txtQty.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		panelLeft.add(txtQty);
		txtQty.setEditable(false);
		txtQty.setColumns(5);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Issue");
		panelLeft.add(lblNewLabel_5);
		
		txtBorroweddate = new JTextField();
		txtBorroweddate.setBackground(new Color(255, 255, 255));
		panelLeft.add(txtBorroweddate);
		txtBorroweddate.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		txtBorroweddate.setEditable(false);
		txtBorroweddate.setColumns(10);
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(255, 255, 255));
		paneText.add(panelRight);
		panelRight.setLayout(new GridLayout(5, 2, 0, 5));
		
		JLabel lblReturndate = new JLabel("Return Date");
		panelRight.add(lblReturndate);
		
		txtReturndate = new JTextField();
		txtReturndate.setForeground(Color.RED);
		txtReturndate.setBackground(new Color(255, 255, 255));
		txtReturndate.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		panelRight.add(txtReturndate);
		txtReturndate.setEditable(false);
		txtReturndate.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Actual Return Date");
		panelRight.add(lblNewLabel_6);
		
		txtActualreturndate = new JTextField();
		txtActualreturndate.setForeground(Color.BLUE);
		txtActualreturndate.setBackground(new Color(255, 255, 255));
		txtActualreturndate.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		panelRight.add(txtActualreturndate);
		txtActualreturndate.setEditable(false);
		txtActualreturndate.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Over Date ( Day (s))");
		panelRight.add(lblNewLabel_8);
		
		txtOverdays = new JTextField();
		txtOverdays.setBackground(new Color(255, 255, 255));
		txtOverdays.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		txtOverdays.setEditable(false);
		panelRight.add(txtOverdays);
		txtOverdays.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fine Amount ( R )");
		panelRight.add(lblNewLabel_7);
		
		txtFineamount = new JTextField();
		txtFineamount.setBackground(new Color(255, 255, 255));
		txtFineamount.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		txtFineamount.setEditable(false);
		panelRight.add(txtFineamount);
		txtFineamount.setColumns(10);
		
		JLabel label = new JLabel("");
		panelRight.add(label);
		
		btnReturn = new JButton("Return");
		btnReturn.setBackground(new Color(60, 179, 113));
		btnReturn.setContentAreaFilled(false);
		btnReturn.setOpaque(true);
		btnReturn.setForeground(new Color(255, 255, 255));
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelRight.add(btnReturn);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setVisible(false);
		panelBottom.setBackground(new Color(255, 255, 255));
		panelInner.add(panelBottom, BorderLayout.SOUTH);
		
		lblBorrowedid = new JLabel("");
		lblBorrowedid.setVisible(false);
		lblBorrowedid.setBackground(new Color(255, 255, 255));
		panelBottom.add(lblBorrowedid);
		
		initTextBoxReturn(borrowed);
		initButtonReturn(borrowed);
		JOptionPane.showOptionDialog(null	, panelContent, "Return Book", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);

	}
	
	public void initTextBoxReturn(BorrowerClass borrowedReturn) {
		
		DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
		
		txtTxtstudentid.setText(borrowedReturn.getStu_id() + "");
		txtStudentname.setText(borrowedReturn.getName());
		txtBookisbn.setText(borrowedReturn.getBookISBN() + "");
		txtQty.setText(borrowedReturn.getBorrowQTY() + "");
		txtBorroweddate.setText(borrowedReturn.getBorrowedDate());
		txtReturndate.setText(borrowedReturn.getReturnDate());
		txtActualreturndate.setText(df.format(new Date()));
		txtOverdays.setText(borrowedReturn.getOverDate() + "");
		txtFineamount.setText(borrowedReturn.getFineOverDays(Integer.parseInt(txtOverdays.getText())) + "");
		
		lblBorrowedid.setText(borrowedReturn.getId() + "");
	}
	public void initButtonReturn(BorrowerClass borrowed) {
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Wanna Return this Book?", "Returning...", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				if(confirm == JOptionPane.OK_OPTION) {
					new UserConnection().returnBook(borrowed, Integer.parseInt(lblBorrowedid.getText()));
					JOptionPane.showMessageDialog(null, "Book has been returned successfully!");
				}
				else
					return;
				
			}
		});
	}

}
