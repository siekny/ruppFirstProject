package adminPage;

import javax.swing.JPanel;
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

public class MainPage extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnRestaurant, btnHome, btnProfile, btnUser, btnTable, btnFood, btnBooking, btnHistory, btnBar, btnClose, btnLogout;
	public JPanel content;

	/**
	 * Create the panel.
	 */
	public MainPage(JPanel content) {
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
		
		btnRestaurant = new JButton("RMS");
		btnRestaurant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestaurant.setContentAreaFilled(false);
		btnRestaurant.setFocusPainted(false);
		btnRestaurant.setBorderPainted(false);
		btnRestaurant.setForeground(new Color(255, 255, 255));
		btnRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelSide1.add(btnRestaurant);
		
		btnProfile = new JButton("");
		btnProfile.setContentAreaFilled(false);
		btnProfile.setBorderPainted(false);
		btnProfile.setFocusPainted(false);
		panelSide1.add(btnProfile);
		
		btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\home.png"));
		btnHome.setBackground(new Color(34,45,50));
		btnHome.setFocusPainted(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setBorderPainted(false);
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setForeground(new Color(255, 255, 255));
		panelSide1.add(btnHome);
		
		btnUser = new JButton("");
		btnUser.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\users.png"));
		btnUser.setFocusPainted(false);
		btnUser.setBorderPainted(false);
		btnUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser.setBackground(new Color(34,45,50));
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUser.setForeground(new Color(255, 255, 255));
		btnUser.setHorizontalAlignment(SwingConstants.LEFT);
		panelSide1.add(btnUser);
		
		btnTable = new JButton("");
		btnTable.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\table.png"));
		btnTable.setBorderPainted(false);
		btnTable.setFocusPainted(false);
		btnTable.setBackground(new Color(34,45,50));
		btnTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTable.setHorizontalAlignment(SwingConstants.LEFT);
		btnTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTable.setForeground(new Color(255, 255, 255));
		panelSide1.add(btnTable);
		
		btnFood = new JButton("");
		btnFood.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\food.png"));
		btnFood.setFocusPainted(false);
		btnFood.setBorderPainted(false);
		btnFood.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFood.setBackground(new Color(34,45,50));
		btnFood.setHorizontalAlignment(SwingConstants.LEFT);
		btnFood.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFood.setForeground(new Color(255, 255, 255));
		panelSide1.add(btnFood);
		
		btnBooking = new JButton("");
		btnBooking.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\booking.png"));
		btnBooking.setBorderPainted(false);
		btnBooking.setFocusPainted(false);
		btnBooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBooking.setBackground(new Color(34,45,50));
		btnBooking.setHorizontalAlignment(SwingConstants.LEFT);
		btnBooking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBooking.setForeground(new Color(255, 255, 255));
		panelSide1.add(btnBooking);
		
		btnHistory = new JButton("");
		btnHistory.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\history.png"));
		btnHistory.setFocusPainted(false);
		btnHistory.setBorderPainted(false);
		btnHistory.setBackground(new Color(34,45,50));
		btnHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHistory.setForeground(new Color(255, 255, 255));
		btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistory.setHorizontalAlignment(SwingConstants.LEFT);
		panelSide1.add(btnHistory);
		
		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\logout.png"));
		btnLogout.setBorderPainted(false);
		btnLogout.setFocusPainted(false);
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBackground(new Color(34,45,50));
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setForeground(new Color(255, 255, 255));
		panelSide1.add(btnLogout);
		
		btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\close.png"));
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
		btnBar.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppFirstProject\\images\\menu.png"));
		panelInner1_1.add(btnBar);
		
		JPanel panelInner1_2 = new JPanel();
		panelInner1_2.setBackground(new Color(54,127,169));
		panelInn1.add(panelInner1_2, BorderLayout.CENTER);
		panelInner1_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("   Restaurant Management System");
		lblNewLabel.setFont(new Font("Hobo Std", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelInner1_2.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panelInn2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelInn2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelInn.add(panelInn2);
		
		JLabel lblNewLabel_1 = new JLabel("TITLE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panelInn2.add(lblNewLabel_1);
		
		btnLogout.addActionListener(this);
		btnClose.addActionListener(this);
		btnProfile.addActionListener(this);
		btnHome.addActionListener(this);
		btnUser.addActionListener(this);
		btnTable.addActionListener(this);
		btnFood.addActionListener(this);
		btnBooking.addActionListener(this);
		btnHistory.addActionListener(this);
		btnBar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnProfile)
			profileButton();
		else if(e.getSource() == btnHome)
			homeButton();
		else if(e.getSource() == btnUser)
			userButton();
		else if(e.getSource() == btnTable)
			tableButton();
		else if(e.getSource() == btnFood)
			foodButton();
		else if(e.getSource() == btnBooking)
			bookingButton();
		else if(e.getSource() == btnHistory)
			historyButton();
		else if(e.getSource() == btnLogout)
			logoutButton();
		else if(e.getSource() == btnClose) 
			System.exit(0);
		else if(e.getSource() == btnBar)
			barButton();
		
	}

	public void profileButton() {
		buttonClick(btnProfile, btnLogout, btnHome, btnUser, btnTable, btnFood, btnBooking, btnHistory, btnClose);
	}
	
	public void homeButton() {
		buttonClick(btnHome, btnLogout, btnProfile, btnUser, btnTable, btnFood, btnBooking, btnHistory, btnClose);
	}
	
	public void userButton() {
		buttonClick(btnUser, btnHome, btnLogout, btnProfile, btnTable, btnFood, btnBooking, btnHistory, btnClose);
	}
	
	public void tableButton() {
		buttonClick(btnTable, btnLogout, btnProfile, btnHome, btnUser, btnFood, btnBooking, btnHistory, btnClose);
	}
	public void foodButton() {
		buttonClick(btnFood, btnLogout, btnProfile, btnHome, btnUser, btnTable, btnBooking, btnHistory, btnClose);
	}
	
	public void bookingButton() {
		buttonClick(btnBooking, btnLogout, btnProfile, btnHome, btnUser, btnTable, btnFood, btnHistory, btnClose);
	}
	
	public void historyButton() {
		buttonClick(btnHistory, btnLogout, btnProfile, btnHome, btnUser, btnTable, btnFood, btnBooking, btnClose);
	}
	
	public void logoutButton() {
		Main.content.add(Main.log);
		buttonClick(btnLogout, btnProfile, btnHome, btnUser, btnTable, btnFood, btnBooking, btnHistory, btnClose);
    	Main.enableContent(true, false, false);
	}
	
	public void barButton() {
		if(btnRestaurant.getText() == "RMS") {
			btnRestaurant.setText("Restaurant");
			btnProfile.setText("   My Profile");
			btnHome.setText("   Home");
			btnUser.setText("   List of Users");
			btnTable.setText("   List of Tables");
			btnFood.setText("   List of Food");
			btnBooking.setText("   User Bookings");
			btnHistory.setText("   History of Booking         ");
			btnLogout.setText("   User Logout");
			btnClose.setText("   Close Program");
		}else {
			btnRestaurant.setText("RMS");
			btnProfile.setText("");
			btnHome.setText("");
			btnUser.setText("");
			btnTable.setText("");
			btnFood.setText("");
			btnBooking.setText("");
			btnHistory.setText("");
			btnLogout.setText("");
			btnClose.setText("");
		}
	}
	
	
	public void buttonClick(JButton btnClick, JButton btnNonClick1, JButton btnNonClick2, JButton btnNonClick3, JButton btnNonClick4, JButton btnNonClick5, JButton btnNonClick6, JButton btnNonClick7, JButton btnNonClick8) {
		btnClick.setBackground(new Color(30, 40, 44));
		btnNonClick1.setBackground(new Color(34,45,50));
		btnNonClick2.setBackground(new Color(34,45,50));
		btnNonClick3.setBackground(new Color(34,45,50));
		btnNonClick4.setBackground(new Color(34,45,50));
		btnNonClick5.setBackground(new Color(34,45,50));
		btnNonClick6.setBackground(new Color(34,45,50));
		btnNonClick7.setBackground(new Color(34,45,50));
		btnNonClick8.setBackground(new Color(34,45,50));
	}
}
