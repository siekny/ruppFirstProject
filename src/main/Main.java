package main;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;

import adminPage.MainPage;
import login.*;
import userPage.HomePage;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public static JPanel content;
	
	// initialize objects
	public static UserLogin log;
	public static AdminLogin adminLogin;
	public static MainPage mainPage;
	public static HomePage homePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public Main() throws Exception {
		
		initialize();
		initObjects();
		
	}
	
	public void initialize () {
		//setTitle("Library Management System");
//		setUndecorated(true);
//		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(236,240,245));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		content = new JPanel();
		contentPane.add(content, BorderLayout.CENTER);
		content.setLayout(new BorderLayout(0, 0));
		//JScrollPane scroll = new JScrollPane(content);
		//contentPane.add(scroll, BorderLayout.CENTER);
	}
	
	public void initObjects () {
		
		
		log = new UserLogin();
		adminLogin = new AdminLogin();
		mainPage = new MainPage (content);
		homePage = new HomePage();
		
		content.add(log);
		enableContent(true, false, false, false);
		
	}
	
	public static void enableContent(boolean selectLogin, boolean selectCreateAcc, boolean selectAdminPage, boolean selectHomePage) {
		log.setVisible(selectLogin);
		adminLogin.setVisible(selectCreateAcc);
		mainPage.setVisible(selectAdminPage);
		homePage.setVisible(selectHomePage);
		
	}
	
}