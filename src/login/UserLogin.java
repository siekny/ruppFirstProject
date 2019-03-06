package login;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

import classMembers.InformationClass;
import classMembers.UserClass;
import main.Main;
import userPage.HomePage;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPasswordField;

public class UserLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtUsername;
	private JLabel labelSignUp;
	private UserClass userClass;
	public static JPasswordField passwordField;
	
	/**
	 * Create the panel.
	 */
	public UserLogin() {

		setLayout(new BorderLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelContent.getLayout();
		flowLayout.setVgap(100);
		flowLayout.setHgap(0);
		add(panelContent, BorderLayout.CENTER);
		
		JPanel paneltop = new JPanel();
		panelContent.add(paneltop);
		paneltop.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(0, 102, 204));
		panelContent.add(panelLeft);
		panelLeft.setPreferredSize(new Dimension(400, 400));
		
		JPanel panelLInner = new JPanel();
		panelLInner.setBackground(new Color(0, 102, 204));
		panelLeft.add(panelLInner);
		panelLInner.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panelLInner.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 204));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 204));
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/user.png"));
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 102, 204));
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 102, 204));
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("               Library Users Login              ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Library Users Provide Login Access");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 102, 204));
		panelLInner.add(panel_8, BorderLayout.NORTH);
		panel_8.setPreferredSize(new Dimension(400, 100));
		
		JPanel panelRight = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelRight.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panelRight.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 204)));
		panelRight.setBackground(new Color(255, 255, 255));
		panelContent.add(panelRight);
		panelRight.setPreferredSize(new Dimension(400, 400));
		
		JPanel panel_10 = new JPanel();
		panelRight.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 102, 204)));
		FlowLayout flowLayout_2 = (FlowLayout) panel_9.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		panel_9.setBackground(new Color(255, 255, 255));
		panel_10.add(panel_9, BorderLayout.NORTH);
		panel_9.setPreferredSize(new Dimension(400, 45));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 102, 204)));
		FlowLayout flowLayout_3 = (FlowLayout) panel_11.getLayout();
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		panel_11.setBackground(new Color(255, 255, 255));
		panel_10.add(panel_11, BorderLayout.CENTER);
		
		JPanel panelRInner = new JPanel();
		panel_11.add(panelRInner);
		panelRInner.setBackground(new Color(255, 255, 255));
		panelRInner.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panelRInner.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogin = new JLabel("User Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblLogin, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panelRInner.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(7, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Login Username");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_3);
		
		txtUsername = new JTextField();
		panel_7.add(txtUsername);
		txtUsername.setColumns(30);
		
		JLabel lblNewLabel_4 = new JLabel("Login Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(30);
		panel_7.add(passwordField);
		
		JLabel label_2 = new JLabel("");
		panel_7.add(label_2);
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(new Color(255, 255, 255));
		panel_7.add(panelButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setFocusPainted(false);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setOpaque(true);
		btnLogin.setBackground(new Color(0, 102, 204));
		btnLogin.setForeground(new Color(255, 255, 255));
		panelButton.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				userClass = UserClass.getUser(txtUsername.getText(), String.valueOf(passwordField.getPassword()));

				if(userClass != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy / HH:mm");
					Date date = new Date();
					userClass.addAction(new InformationClass(sdf.format(date), "Log-In"));
					
					HomePage.addUser(userClass);
					Main.enableContent(false, false, false, true);
					//Main.homePage = new HomePage();
					
					Main.content.add(Main.homePage);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username or Password is incorrect", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		
		
		//initObjects(content);
		
		
		labelSignUp = new JLabel("Or go to Admin Login ?");
		labelSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AdminLogin.txtUsername.setText("");
				AdminLogin.passwordField.setText("");
				
				Main.enableContent(false, true, false, false);
				
				Main.content.add(Main.adminLogin);
		        

			}
		});
		labelSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(labelSignUp);
		
		
		//JOptionPane.showOptionDialog(null, panelContent,"Create an Account of user", JOptionPane.CLOSED_OPTION,JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);
		
		
	}
	
	
}