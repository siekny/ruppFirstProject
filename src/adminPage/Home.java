package adminPage;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import connection.UserConnection;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Home extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnCountBooks, btnCountBorrows, btnCountUsers;

	/**
	 * Create the panel.
	 */
	public Home() {
		
		initialize();
		initObjects();
	}
	
	public void initialize() {
		setLayout(new BorderLayout(20, 20));
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(new Color(244, 244, 244));
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(20, 20));
		
		JPanel panelTop = new JPanel();
		panelContent.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelTop.setBackground(new Color(244,244,244));
		
		JPanel panelBook = new JPanel();
		panelBook.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(237,237,237)));
		panelBook.setBackground(Color.WHITE);
		panelTop.add(panelBook);
		panelBook.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnBooksManagement = new JButton("          Books         ");
		btnBooksManagement.setForeground(Color.WHITE);
		btnBooksManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBooksManagement.setFocusPainted(false);
		btnBooksManagement.setBorderPainted(false);
		btnBooksManagement.setBackground(new Color(91,179,92));
		panelBook.add(btnBooksManagement);
		
		JButton button_2 = new JButton("");
		button_2.setContentAreaFilled(false);
		button_2.setIcon(new ImageIcon("images/book-h.png"));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(Color.WHITE);
		panelBook.add(button_2);
		
		btnCountBooks = new JButton("5000");
		btnCountBooks.setContentAreaFilled(false);
		btnCountBooks.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCountBooks.setFocusPainted(false);
		btnCountBooks.setBorderPainted(false);
		btnCountBooks.setBackground(Color.WHITE);
		panelBook.add(btnCountBooks);
		
		JPanel panelBorrow = new JPanel();
		panelBorrow.setBackground(new Color(255, 255, 255));
		panelBorrow.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(237,237,237)));
		panelTop.add(panelBorrow);
		panelBorrow.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("          Book Transaction          ");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255,152,3));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBorrow.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("images/study.png"));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		panelBorrow.add(btnNewButton_2);
		
		btnCountBorrows = new JButton("500");
		btnCountBorrows.setContentAreaFilled(false);
		btnCountBorrows.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCountBorrows.setBackground(new Color(255, 255, 255));
		btnCountBorrows.setBorderPainted(false);
		btnCountBorrows.setFocusPainted(false);
		panelBorrow.add(btnCountBorrows);
		
		JPanel panelUser = new JPanel();
		panelUser.setBackground(new Color(255, 255, 255));
		panelUser.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(237,237,237)));
		panelTop.add(panelUser);
		panelUser.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnUsersManagement = new JButton("          Users         ");
		btnUsersManagement.setForeground(Color.WHITE);
		btnUsersManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUsersManagement.setFocusPainted(false);
		btnUsersManagement.setBorderPainted(false);
		btnUsersManagement.setBackground(new Color(77,140,252));
		panelUser.add(btnUsersManagement);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("images/group.png"));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		panelUser.add(btnNewButton_3);
		
		btnCountUsers = new JButton("5");
		btnCountUsers.setContentAreaFilled(false);
		btnCountUsers.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCountUsers.setFocusPainted(false);
		btnCountUsers.setBorderPainted(false);
		btnCountUsers.setBackground(Color.WHITE);
		panelUser.add(btnCountUsers);
		
		JPanel panelBody = new JPanel();
		panelBody.setBackground(new Color(244, 244, 244));
		panelContent.add(panelBody, BorderLayout.CENTER);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("images/book.gif"));
		panelBody.add(lblImage);
	}
	public void initObjects() {
		UserConnection connect = new UserConnection();
		btnCountBooks.setText(connect.countTable("books") + "");
		btnCountUsers.setText(connect.countTable("users") + "");
		btnCountBorrows.setText(connect.countTable("borrows") + "");
	}

}
