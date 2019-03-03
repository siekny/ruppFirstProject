package popForm;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.MatteBorder;

import classMembers.BookClass;

public class FormBookUser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblISBN, lblTitle, lblAuthor, 
			lblEdition, lblPrice, lblTotalQty, lblNumBorrow, lblNumInStock;
	
	private JLabel lblAmountInStock, lblImage;

	/**
	 * Create the panel.
	 */
	public FormBookUser(BookClass emp) {
		
		initialize();
		getDetailEmp(emp);
		
		JOptionPane.showConfirmDialog(null	, contentPane, "Detail of an Employee", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION);
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
		
		JPanel panelImage = new JPanel();
		panelImage.setBackground(new Color(255, 255, 255));
		panelContent.add(panelImage, BorderLayout.NORTH);
		panelImage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("images/me.png"));
		panelImage.add(lblImage);
		
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
		panelLeft.setLayout(new GridLayout(4, 2, 0, 15));
		
		JLabel lblNewLabel_3 = new JLabel("ISBN : ");
		panelLeft.add(lblNewLabel_3);
		
		lblISBN = new JLabel("");
		lblISBN.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblISBN);
		
		JLabel lblNewLabel_4 = new JLabel("Title : ");
		panelLeft.add(lblNewLabel_4);
		
		lblTitle = new JLabel("");
		lblTitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblTitle);
		
		JLabel lblNewLabel_5 = new JLabel("Author : ");
		panelLeft.add(lblNewLabel_5);
		
		lblAuthor = new JLabel("");
		lblAuthor.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblAuthor);
		JLabel lblNewLabel_10 = new JLabel("Edition : ");
		panelLeft.add(lblNewLabel_10);
		
		lblEdition = new JLabel("");
		lblEdition.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelLeft.add(lblEdition);
		
		JPanel panelInfoRight = new JPanel();
		panelInfoRight.setBackground(new Color(255, 255, 255));
		panel_1.add(panelInfoRight);
		panelInfoRight.setLayout(new BorderLayout(10, 10));
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(255, 255, 255));
		panelInfoRight.add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new GridLayout(4, 2, 0, 15));

		JLabel lblNewLabel_11 = new JLabel("Price : ");
		panelRight.add(lblNewLabel_11);
		
		lblPrice = new JLabel("");
		lblPrice.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelRight.add(lblPrice);
		
		JLabel lblNewLabel_12 = new JLabel("Total Quantity : ");
		panelRight.add(lblNewLabel_12);
		
		lblTotalQty = new JLabel("");
		lblTotalQty.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelRight.add(lblTotalQty);
		
		JLabel lblNewLabel_13 = new JLabel("Amount of Borrow : ");
		panelRight.add(lblNewLabel_13);
		
		lblNumBorrow = new JLabel("");
		lblNumBorrow.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelRight.add(lblNumBorrow);
		
		lblAmountInStock = new JLabel("Amount in Stock : ");
		panelRight.add(lblAmountInStock);
		
		lblNumInStock = new JLabel("");
		lblNumInStock.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelRight.add(lblNumInStock);
		
	}
	
	public void getDetailEmp(BookClass book) {
		lblImage.setIcon(new ImageIcon(new ImageIcon("uploads/" + book.getImg()).getImage().getScaledInstance(150, 90, Image.SCALE_SMOOTH)));
		lblISBN.setText(book.getIsbn());
		lblTitle.setText(book.getTitle());
		lblAuthor.setText(book.getAuthor());
		
		lblEdition.setText(book.getEdition() + "");
		lblPrice.setText(book.getPrice() + "");
		lblTotalQty.setText(book.getQty() + "");
		lblNumBorrow.setText(book.getNumBorrow() + "");
		lblNumInStock.setText(book.numBookAvailable(book.getNumBorrow()) + "");
		
	}
}
