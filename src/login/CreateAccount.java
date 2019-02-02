package login;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;

import main.Main;
import javax.swing.border.MatteBorder;

public class CreateAccount extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFullName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;

	private JPanel contentPane;
	/**
	 * Create the panel.
	 */
	public CreateAccount(JPanel content) {
		setBackground(new Color(233,235,238));
		
		setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		add(contentPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(220, 227, 237)));
		panel.setPreferredSize(new Dimension(800, 500));
		panel.setBackground(new Color(233, 235, 238));
		panel.setLayout(new BorderLayout(50, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 235, 238));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		
		JLabel lblNewLabel_5 = new JLabel("Restaurant Registration Form");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBackground(new Color(233, 235, 238));
		lblNewLabel_5.setFont(new Font("Tekton Pro", Font.BOLD, 30));
		lblNewLabel_5.setForeground(new Color(66,103,178));
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(233, 235, 238));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(233, 235, 238));
		panel_2.add(panel_8, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(221,223,226)));
		panel_8.add(panel_3);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(new BorderLayout(20, 20));
		// panel_3.setPreferredSize(new Dimension(450, 200));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		//panel_4.setPreferredSize(new Dimension(100, 50));
		
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(new BorderLayout(0, 0));
		//panel_4.setPreferredSize(new Dimension(100, 30));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("images/user_1.png"));
		panel_4.add(lblNewLabel_4, BorderLayout.NORTH);
		//lblNewLabel_4.setPreferredSize(new Dimension(100, 50));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tekton Pro", Font.BOLD, 20));
		lblNewLabel_4.setForeground(new Color(228, 94, 93));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(30, 30));
		
		JPanel panel_5 = new JPanel();
		panel_9.add(panel_5);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(new GridLayout(5, 2, 0, 5));
		
		JLabel lblNewLabel = new JLabel("Full Name");
		panel_5.add(lblNewLabel);
		
		txtFullName = new JTextField();
		panel_5.add(txtFullName);
		txtFullName.setColumns(25);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		panel_5.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		panel_5.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		panel_5.add(lblNewLabel_2);
		
		txtPassword = new JTextField();
		panel_5.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		panel_5.add(lblNewLabel_3);
		
		txtConfirmPassword = new JTextField();
		panel_5.add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);
		
		JLabel label = new JLabel("");
		panel_5.add(label);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_6);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_6.add(btnRegister);
		btnRegister.setFocusPainted(false);
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setBackground(new Color(66, 103, 178));
		btnRegister.setForeground(new Color(255, 255, 255));
		
		JLabel lblOrLogin = new JLabel("                      Or Login ?");
		lblOrLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				content.add(Main.log);
				Main.enableContent(true, false, false);
			}
		});
		lblOrLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOrLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblOrLogin);
		
		
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_9.add(panel_10, BorderLayout.EAST);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_12, BorderLayout.SOUTH);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_11, BorderLayout.WEST);
		
		//JOptionPane.showOptionDialog(null, contentPane,"Create an Account of user", JOptionPane.CLOSED_OPTION,JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);

		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				content.add(Main.log);
				Main.enableContent(true, false, false);
			}
		});
		
		//int a = JOptionPane.showOptionDialog(null, contentPane,"Create an Account of user", JOptionPane.CLOSED_OPTION,JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);
		
	}


}
