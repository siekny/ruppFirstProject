package popForm;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.MatteBorder;
import classMembers.BorrowerClass;

public class BorrowDetail extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblStudentID, lblStudentName, lblContact, 
			lblBookISBN, lblBorrowedDate, lblDueDate, lblActualReturnDate, lblFineAmount, lblOverdate, lblBorrowedQTY;
	
	private JLabel lblAmountInStock;

	/**
	 * Create the panel.
	 */
	public BorrowDetail(BorrowerClass detail) {
		
		initialize();
		getBorrowDetail(detail);
		
		JOptionPane.showConfirmDialog(null	, contentPane, "Detail", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION);
	}

	public void initialize() {
		setBackground(new Color(236,240,245));
		setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 255, 255));
		panelTitle.setBorder(new MatteBorder(0, 0, 3, 0, new Color(54,127,169)));
		panel.add(panelTitle, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Detail of a Book");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panelTitle.add(lblNewLabel);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		panel.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 10));
		
		JPanel panelDetail = new JPanel();
		panelDetail.setBackground(new Color(255, 255, 255));
		panelContent.add(panelDetail, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panelDetail.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 30, 0));
		
		JPanel panelInfoLeft = new JPanel();
		panelInfoLeft.setBackground(new Color(255, 255, 255));
		panel_1.add(panelInfoLeft);
		panelInfoLeft.setLayout(new BorderLayout(10, 10));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(255, 255, 255));
		panelInfoLeft.add(panelLeft, BorderLayout.CENTER);
		panelLeft.setLayout(new GridLayout(5, 2, 0, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Student ID : ");
		panelLeft.add(lblNewLabel_3);
		
		lblStudentID = new JLabel("");
		lblStudentID.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblStudentID);
		
		JLabel lblNewLabel_4 = new JLabel("Student Name : ");
		panelLeft.add(lblNewLabel_4);
		
		lblStudentName = new JLabel("");
		lblStudentName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblStudentName);
		
		JLabel lblNewLabel_5 = new JLabel("Contact : ");
		panelLeft.add(lblNewLabel_5);
		
		lblContact = new JLabel("");
		lblContact.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblContact);
		JLabel lblNewLabel_10 = new JLabel("Book ISBN : ");
		panelLeft.add(lblNewLabel_10);
		
		lblBookISBN = new JLabel("");
		lblBookISBN.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblBookISBN);
		
		JLabel label = new JLabel("QTY : ");
		panelLeft.add(label);
		
		lblBorrowedQTY = new JLabel("0");
		lblBorrowedQTY.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblBorrowedQTY);
		
		JPanel panelInfoRight = new JPanel();
		panelInfoRight.setBackground(new Color(255, 255, 255));
		panel_1.add(panelInfoRight);
		panelInfoRight.setLayout(new BorderLayout(10, 10));
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(255, 255, 255));
		panelInfoRight.add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new GridLayout(5, 2, 0, 15));
		
		JLabel lblNewLabel_12 = new JLabel("Borrowed Date : ");
		panelRight.add(lblNewLabel_12);
		
		lblBorrowedDate = new JLabel("");
		lblBorrowedDate.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelRight.add(lblBorrowedDate);
		
		JLabel lblNewLabel_13 = new JLabel("Due Date : ");
		panelRight.add(lblNewLabel_13);
		
		lblDueDate = new JLabel("");
		lblDueDate.setForeground(Color.BLUE);
		lblDueDate.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelRight.add(lblDueDate);
		
		lblAmountInStock = new JLabel("Actual Return Date : ");
		panelRight.add(lblAmountInStock);
		
		lblActualReturnDate = new JLabel("");
		lblActualReturnDate.setForeground(Color.RED);
		lblActualReturnDate.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelRight.add(lblActualReturnDate);
		
		JLabel lblNewLabel_1 = new JLabel("OverDate  ( Days ) : ");
		panelRight.add(lblNewLabel_1);
		
		lblOverdate = new JLabel("");
		panelRight.add(lblOverdate);
		
		JLabel lblNewLabel_2 = new JLabel("Fine Amount ( R ) : ");
		panelRight.add(lblNewLabel_2);
		
		lblFineAmount = new JLabel("");
		panelRight.add(lblFineAmount);
		
	}
	
	public void getBorrowDetail(BorrowerClass detail) {
		
		lblStudentID.setText(detail.getStu_id());
		lblStudentName.setText(detail.getName());
		lblContact.setText(detail.getPhone());
		lblBookISBN.setText(detail.getBookISBN());
		lblBorrowedQTY.setText(detail.getBorrowQTY() + "");
		
		lblBorrowedDate.setText(detail.getBorrowedDate());
		lblDueDate.setText(detail.getReturnDate());
		lblActualReturnDate.setText(detail.actualReturnDate());
		lblOverdate.setText(detail.getOverDate() + "");
		lblFineAmount.setText(detail.getFineOverDays(detail.getOverDate()) + "");
		
	}
}
