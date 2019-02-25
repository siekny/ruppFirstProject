package userPage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import main.Main;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import adminPage.Home;
import adminPage.Profile;
import classMembers.UserClass;


public class HomePage extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnLibrary, btnHome, btnProfile, btnBorrow, btnBook, btnBar, btnClose, btnLogout, btnRegister;
	public JPanel content;
	private JLabel lblTitle;
	private JPanel panelContent;
	
	// initialize objects
	private Book book;
	private Borrow borrow;
	private Profile profile;
	//private HomeUser home;
	private Home home;
	private Register register;

	/**
	 * Create the panel.
	 */
	public HomePage(JPanel content) {
		initialize();
		initObjects();
	}
	
	public void initialize () {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelWhole = new JPanel();
		add(panelWhole, BorderLayout.CENTER);
		panelWhole.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSide = new JPanel();
		panelWhole.add(panelSide, BorderLayout.WEST);
		panelSide.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSide1 = new JPanel();
		panelSide.add(panelSide1, BorderLayout.CENTER);
		panelSide1.setLayout(new GridLayout(12, 1, 0, 0));
		panelSide1.setBackground(new Color(34,45,50));
		
		btnLibrary = new JButton("LMS");
		btnLibrary.setContentAreaFilled(false);
		btnLibrary.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLibrary.setFocusPainted(false);
		btnLibrary.setBorderPainted(false);
		btnLibrary.setForeground(new Color(255, 255, 255));
		btnLibrary.setBackground(new Color(54, 127, 169));
		btnLibrary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelSide1.add(btnLibrary);
		
		btnHome = new JButton("");
		btnHome.setBorderPainted(false);
		btnHome.setIcon(new ImageIcon("images/home.png"));
		btnHome.setBackground(new Color(34,45,50));
		btnHome.setFocusPainted(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setForeground(new Color(255, 255, 255));
		panelSide1.add(btnHome);
		
		btnProfile = new JButton("");
		btnProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfile.setForeground(new Color(255, 255, 255));
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfile.setBackground(new Color(34, 45, 50));
		btnProfile.setIcon(new ImageIcon("images/profile.png"));
		btnProfile.setBorderPainted(false);
		btnProfile.setFocusPainted(false);
		panelSide1.add(btnProfile);
		btnProfile.addActionListener(this);
		
		btnRegister = new JButton("");
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setIcon(new ImageIcon("images/users.png"));
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setFocusPainted(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setBackground(new Color(34, 45, 50));
		panelSide1.add(btnRegister);
		
		btnBook = new JButton("");
		btnBook.setIcon(new ImageIcon("images/book.png"));
		btnBook.setBorderPainted(false);
		btnBook.setFocusPainted(false);
		btnBook.setBackground(new Color(34,45,50));
		btnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBook.setHorizontalAlignment(SwingConstants.LEFT);
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBook.setForeground(new Color(255, 255, 255));
		panelSide1.add(btnBook);
		
		btnBorrow = new JButton("");
		btnBorrow.setIcon(new ImageIcon("images/users.png"));
		btnBorrow.setFocusPainted(false);
		btnBorrow.setBorderPainted(false);
		btnBorrow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBorrow.setBackground(new Color(34,45,50));
		btnBorrow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBorrow.setForeground(new Color(255, 255, 255));
		btnBorrow.setHorizontalAlignment(SwingConstants.LEFT);
		panelSide1.add(btnBorrow);
		btnBorrow.addActionListener(this);
		
		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon("images/logout.png"));
		btnLogout.setBorderPainted(false);
		btnLogout.setFocusPainted(false);
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBackground(new Color(34,45,50));
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setForeground(new Color(255, 255, 255));
		panelSide1.add(btnLogout);
		
		btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon("images/close.png"));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(new Color(34,45,50));
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setHorizontalAlignment(SwingConstants.LEFT);
		panelSide1.add(btnClose);
		
		JPanel panelMain = new JPanel();
		panelWhole.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInn = new JPanel();
		panelMain.add(panelInn, BorderLayout.NORTH);
		panelInn.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelInn1 = new JPanel();
		panelInn.add(panelInn1);
		panelInn1.setBackground(new Color(54,127,169));
		panelInn1.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInner1_1 = new JPanel();
		panelInner1_1.setBackground(new Color(54,127,169));
		FlowLayout flowLayout = (FlowLayout) panelInner1_1.getLayout();
		flowLayout.setHgap(0);
		panelInn1.add(panelInner1_1, BorderLayout.WEST);
		
		btnBar = new JButton("");
		btnBar.setFocusPainted(false);
		btnBar.setContentAreaFilled(false);
		btnBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBar.setBorderPainted(false);
		btnBar.setIcon(new ImageIcon("images/menu.png"));
		panelInner1_1.add(btnBar);
		
		JPanel panelInner1_2 = new JPanel();
		panelInner1_2.setBackground(new Color(54,127,169));
		panelInn1.add(panelInner1_2, BorderLayout.CENTER);
		panelInner1_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("   Library Management System For User");
		lblNewLabel.setFont(new Font("Hobo Std", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelInner1_2.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panelInn2 = new JPanel();
		panelInn2.setBackground(new Color(236,240,245));
		panelInn2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		FlowLayout flowLayout_1 = (FlowLayout) panelInn2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelInn.add(panelInn2);
		
		lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setForeground(new Color(51, 51, 51));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		panelInn2.add(lblTitle);
		
		panelContent = new JPanel();
		panelContent.setLayout(new BorderLayout(0, 0));
		panelContent.setBackground(new Color(236,240,245));
		
		JScrollPane scroll = new JScrollPane(panelContent);
		panelMain.add(scroll, BorderLayout.CENTER);
		
		btnLogout.addActionListener(this);
		btnClose.addActionListener(this);
		btnHome.addActionListener(this);
		btnBook.addActionListener(this);
		btnBar.addActionListener(this);
		btnRegister.addActionListener(this);
		
		

	}
	
	public void initObjects () {
		book = new Book();
		borrow = new Borrow();
		profile = new Profile(new UserClass(1,"M Ember","thisismember","123","F","USA","member@gmail.com","0989898","10-10-2010","Member","20-10-2020",2));
		home = new Home();
		register = new Register();
		BorderLayout borderLayout = (BorderLayout) home.getLayout();
		borderLayout.setVgap(20);
		borderLayout.setHgap(20);
		
		homeButton();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnProfile)
			profileButton();
		else if(e.getSource() == btnHome)
			homeButton();
		else if(e.getSource() == btnBorrow)
			borrowButton();
		else if(e.getSource() == btnBook)
			bookButton();
		else if(e.getSource() == btnRegister)
			registerButton();
		else if(e.getSource() == btnLogout)
			logoutButton();
		else if(e.getSource() == btnClose) 
			System.exit(0);
		else if(e.getSource() == btnBar)
			barButton();
		
	}

	public void profileButton() {
		lblTitle.setText("  MY PROFILE");
		panelContent.add(profile);
		enableContent(false, false, true, false, false);
		buttonClick(btnProfile, btnLogout, btnHome, btnBorrow, btnBook, btnRegister);
	}
	
	public void homeButton() {
		lblTitle.setText("  DASHBOARD");
		panelContent.add(home);
		enableContent(false, true, false, false, false);
		buttonClick(btnHome, btnProfile, btnLogout, btnBorrow, btnBook, btnRegister);
	}
	
	public void registerButton() {
		lblTitle.setText("  LIST OF REGISTERS");
		panelContent.add(register);
		enableContent(false, false, false, false, true);
		buttonClick(btnRegister, btnHome, btnProfile, btnLogout, btnBorrow, btnBook);
	}
	
	public void borrowButton() {
		lblTitle.setText("  LIST OF BOOK TRANSACTION");
		panelContent.add(borrow);
		enableContent(true, false, false, false, false);
		buttonClick(btnBorrow, btnHome, btnLogout, btnProfile, btnBook, btnRegister);
	}
	
	public void bookButton() {
		lblTitle.setText("  LIST OF BOOKS");
		panelContent.add(book);
		enableContent(false, false, false, true, false);
		buttonClick(btnBook, btnLogout, btnProfile, btnHome, btnBorrow, btnRegister);
	}

	public void logoutButton() {
		lblTitle.setText("  USER LOGOUT");
		Main.content.add(Main.log);
		buttonClick(btnLogout, btnProfile, btnHome, btnBorrow, btnBook, btnRegister);
    	Main.enableContent(true, false, false, false);
	}
	
	public void barButton() {
		if(btnLibrary.getText() == "LMS") {
			btnLibrary.setText("Library MGT");
			btnProfile.setText("   My Profile");
			btnHome.setText("   Dashboard");
			btnRegister.setText("   Register");
			btnBorrow.setText("   Book Transaction      ");
			btnBook.setText("   List of Books");
			btnLogout.setText("   User Logout");
			btnClose.setText("   Close Program");
		}else {
			btnLibrary.setText("LMS");
			btnProfile.setText("");
			btnHome.setText("");
			btnBorrow.setText("");
			btnBook.setText("");
			btnLogout.setText("");
			btnClose.setText("");
			btnRegister.setText("");
		}
	}
	
	
	public void buttonClick(JButton btnClick, JButton btnNonClick1, JButton btnNonClick2, JButton btnNonClick3, JButton btnNonClick4, JButton btnNonClick5) {
		btnClick.setBackground(new Color(30, 40, 44));
		btnNonClick1.setBackground(new Color(34,45,50));
		btnNonClick2.setBackground(new Color(34,45,50));
		btnNonClick3.setBackground(new Color(34,45,50));
		btnNonClick4.setBackground(new Color(34,45,50));
		btnNonClick5.setBackground(new Color(34,45,50));
	}
	
	public void enableContent(boolean isBorrow, boolean isHome, boolean isProfile, boolean isBook, boolean isRegister) {
		borrow.setVisible(isBorrow);
		home.setVisible(isHome);
		profile.setVisible(isProfile);
		book.setVisible(isBook);
		register.setVisible(isRegister);
		
	}
}
