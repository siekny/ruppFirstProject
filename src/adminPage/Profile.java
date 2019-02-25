package adminPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import classMembers.InformationClass;
import classMembers.LibrarianClass;
import classMembers.UserClass;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

public class Profile extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// ALL IMPORTANT LABELS
	JPanel panel_11;
	JLabel lblId;
	JLabel lblFullname;
	JLabel lblUsername;
	JLabel lblSex;
	JLabel lblAddress;
	JLabel lblEmail;
	JLabel lblPhone;
	JLabel lblDob;
	JLabel lblTom;
	JLabel lblDom;
	
	// ALL IMPORTANT TABLES
	JPanel panel_8;
	DefaultTableModel table;
	JTable jTable;
	JScrollPane scrollPane;
	
	// INFORMATION
	LibrarianClass librarianClass;
	
	public Profile(LibrarianClass librarianClass) {
		setLayout(new BorderLayout(0, 0));
		
		this.librarianClass = librarianClass;	
		initObject();
		initLabel();
		initTable();
		
	}
	
	private void initObject() {
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/user_1.png"));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel label_1 = new JLabel("  ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(label_1);
		
		JLabel lblInformation = new JLabel("Information");
		panel_4.add(lblInformation);
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInformation.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel(" ");
		panel_5.add(label_2, BorderLayout.NORTH);
		
		JLabel label_8 = new JLabel(" ");
		panel_5.add(label_8, BorderLayout.SOUTH);
		
		JLabel label_9 = new JLabel("          ");
		panel_5.add(label_9, BorderLayout.WEST);
		
		JLabel label_10 = new JLabel("          ");
		panel_5.add(label_10, BorderLayout.EAST);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		panel_11 = new JPanel();
		panel_9.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new GridLayout(11, 2, 0, 0));		
		
		JLabel label_13 = new JLabel("          ");
		panel_9.add(label_13, BorderLayout.WEST);
		
		JLabel label_14 = new JLabel("           ");
		panel_9.add(label_14, BorderLayout.EAST);
		
		JLabel label_11 = new JLabel(" ");
		panel_9.add(label_11, BorderLayout.SOUTH);
		
		JLabel label_12 = new JLabel(" ");
		panel_9.add(label_12, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel label_3 = new JLabel("   ");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_6.add(label_3);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblHistory);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_7.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel label_4 = new JLabel(" ");
		panel_7.add(label_4, BorderLayout.NORTH);
		
		JLabel label_5 = new JLabel(" ");
		panel_7.add(label_5, BorderLayout.SOUTH);
		
		JLabel label_6 = new JLabel("          ");
		panel_7.add(label_6, BorderLayout.WEST);
		
		JLabel label_7 = new JLabel("          ");
		panel_7.add(label_7, BorderLayout.EAST);	
	}
	
	private void initLabel() {
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		
		lblId = new JLabel("");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
				
		JLabel lblNewLabel_1 = new JLabel("Fullname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
		lblFullname = new JLabel("");
		lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFullname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));	
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		
		lblUsername = new JLabel("");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));		
		
		JLabel lblNewLabel_3 = new JLabel("Sex");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
		lblSex = new JLabel("");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSex.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));		
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		
		lblAddress = new JLabel("");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));		
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		
		lblEmail = new JLabel("");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));		
		
		JLabel lblNewLabel_6 = new JLabel("Phone");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		
		lblPhone = new JLabel("");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));		
		
		JLabel lblNewLabel_7 = new JLabel("Date of Birth");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		
		lblDob = new JLabel("");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDob.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));	
		
		JLabel lblNewLabel_8 = new JLabel("Type of Membership");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		
		lblTom = new JLabel("");
		lblTom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTom.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));		
		
		JLabel lblNewLabel_9 = new JLabel("Date of Membership");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));	
		
		lblDom = new JLabel("");
		lblDom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDom.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		// SET UP INFORMATION
		
		lblId.setText(librarianClass.getID() + "");
		lblFullname.setText(librarianClass.getFullname());
		lblSex.setText(librarianClass.getSex());
		lblAddress.setText(librarianClass.getAddress());
		lblEmail.setText(librarianClass.getEmail());
		lblPhone.setText(librarianClass.getPhone());
		lblDob.setText(librarianClass.getDateofbirth());
		lblUsername.setText(librarianClass.getUsername());
		lblDom.setText(librarianClass.getDateofmembership());
		lblTom.setText((librarianClass.getStatus() == 1 ? "Admin" : "Member"));
		
		panel_11.add(lblNewLabel);
		panel_11.add(lblId);
		panel_11.add(lblNewLabel_1);
		panel_11.add(lblFullname);	
		panel_11.add(lblNewLabel_2);
		panel_11.add(lblUsername);
		panel_11.add(lblNewLabel_3);
		panel_11.add(lblSex);
		panel_11.add(lblNewLabel_4);
		panel_11.add(lblAddress);
		panel_11.add(lblNewLabel_5);
		panel_11.add(lblEmail);
		panel_11.add(lblNewLabel_6);
		panel_11.add(lblPhone);
		panel_11.add(lblNewLabel_7);
		panel_11.add(lblDob);
		panel_11.add(lblNewLabel_8);
		panel_11.add(lblTom);
		panel_11.add(lblNewLabel_9);
		panel_11.add(lblDom);
		
		JPanel panel = new JPanel();
		panel_11.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_11.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnUpdateInfomation = new JButton("Update Infomation");
		JButton btnUpdatePassword = new JButton("Update Password");	
		
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFrame frameChangePassword = new JFrame("Reset Password");
				JPanel panelcontent = new JPanel(new BorderLayout());
				
				JLabel lblLogo = new JLabel("Library Management System");
				lblLogo.setForeground(new Color(255, 255, 255));
				lblLogo.setAlignmentX(CENTER_ALIGNMENT);
				panelcontent.add(lblLogo, BorderLayout.NORTH);
				
				JPanel panelcenter = new JPanel(new GridLayout(4, 2)); 
				
				JLabel lblUsername = new JLabel("Username");
				panelcenter.add(lblUsername);
				
				JTextField txtUsername = new JTextField();
				txtUsername.setText(librarianClass.getUsername());
				txtUsername.setEditable(false);
				panelcenter.add(txtUsername);
				
				JLabel lbloldpassword = new JLabel("New Password");
				panelcenter.add(lbloldpassword);
				
				JPasswordField password1 = new JPasswordField();
				panelcenter.add(password1);
				
				JLabel lblnewpassword = new JLabel("Confirm New Password");
				panelcenter.add(lblnewpassword);
				
				JPasswordField password2 = new JPasswordField();
				panelcenter.add(password2);
				
				JButton btnChange = new JButton("Change Password");
				JPanel panelbtn = new JPanel(new BorderLayout());
				panelbtn.add(btnChange, BorderLayout.CENTER);
				panelcontent.add(panelcenter, BorderLayout.CENTER);
				panelcontent.add(panelbtn, BorderLayout.SOUTH);
				
				frameChangePassword.getContentPane().add(panelcontent);
				frameChangePassword.setSize(400, 300);
				frameChangePassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frameChangePassword.setVisible(true);
				
				btnChange.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						if(!String.valueOf(password1.getPassword()).equals(String.valueOf(password2.getPassword()))) {
							JOptionPane.showMessageDialog(null, "Password is not match.", "Error", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						
						Connection cnn;
						Statement sta;
						
						try {
							cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rupp_project", "root", "");
							sta = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
							String sql2 = "UPDATE users SET password = '" + String.valueOf(password1.getPassword()) +"' WHERE id = " + librarianClass.getID();
							sta.execute(sql2);
							sta.close();
							cnn.close();
							frameChangePassword.dispose();
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
					}
				});
			}
		});
				
		btnUpdateInfomation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JFrame frameEditinfo = new JFrame("Registering New User");
				JPanel panelOverallEditing = new JPanel(new BorderLayout());
				
				JLabel lblLogo = new JLabel("Library Management System");
				lblLogo.setForeground(new Color(255, 255, 255));
				lblLogo.setAlignmentX(CENTER_ALIGNMENT);
				
				JPanel panelNorth = new JPanel();
				panelNorth.setBackground(new Color(54, 127, 169));
				panelNorth.add(lblLogo, CENTER_ALIGNMENT);
				
				JPanel panelCenter = new JPanel(new GridLayout(12, 2));
				JLabel lblId = new JLabel("ID");
				panelCenter.add(lblId);
				JTextField txtId = new JTextField();
				panelCenter.add(txtId);
				JLabel lblName = new JLabel("Fullname");
				panelCenter.add(lblName);
				JTextField txtName = new JTextField();
				panelCenter.add(txtName);
				JLabel lblUsername = new JLabel("Username");
				panelCenter.add(lblUsername);
				JTextField txtUsername = new JTextField();
				panelCenter.add(txtUsername);
				JLabel lblSex = new JLabel("Sex");
				panelCenter.add(lblSex);
				JComboBox<String> cboSex = new JComboBox<String>();
				cboSex.addItem("Male");
				cboSex.addItem("Female");
				cboSex.setSelectedIndex(0);
				panelCenter.add(cboSex);
				JLabel lblAddress = new JLabel("Address");
				panelCenter.add(lblAddress);
				JTextField txtAddress = new JTextField();
				panelCenter.add(txtAddress);
				JLabel lblemail = new JLabel("Email");
				panelCenter.add(lblemail);
				JTextField txtEmail = new JTextField();
				panelCenter.add(txtEmail);
				JLabel lblPhone = new JLabel("Phone Number");
				panelCenter.add(lblPhone);
				JTextField txtPhone = new JTextField();
				panelCenter.add(txtPhone);
				JLabel lblDOB = new JLabel("Date of Birth");
				panelCenter.add(lblDOB);
				JTextField txtDOB = new JTextField();
				panelCenter.add(txtDOB);
				JLabel lblType = new JLabel("Type of Membership");
				panelCenter.add(lblType);
				JComboBox<String> cboType = new JComboBox<String>();
				cboType.addItem("Admin");
				cboType.addItem("Member");
				cboType.setSelectedIndex(0);
				panelCenter.add(cboType);

				JPanel panelbutton = new JPanel(new BorderLayout());
				JButton btnUpdate = new JButton("Update");
				panelbutton.add(btnUpdate, BorderLayout.CENTER);			
				
				panelOverallEditing.add(panelNorth, BorderLayout.NORTH);
				panelOverallEditing.add(panelCenter,BorderLayout.CENTER);
				panelOverallEditing.add(panelbutton, BorderLayout.SOUTH);
				
				frameEditinfo.getContentPane().add(panelOverallEditing);
				frameEditinfo.setResizable(false);
				frameEditinfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frameEditinfo.setSize(400, 400);
				frameEditinfo.setLocationRelativeTo(null);
				frameEditinfo.setVisible(true);
				
				txtId.setText(librarianClass.getID()+""); 
				txtId.setEditable(false);
				txtName.setText(librarianClass.getFullname());
				txtUsername.setText(librarianClass.getUsername());
				cboSex.setSelectedIndex((librarianClass.getSex().equals("M") ? 0 : 1));
				txtAddress.setText(librarianClass.getAddress());
				txtEmail.setText(librarianClass.getEmail());
				txtPhone.setText(librarianClass.getPhone());
				txtDOB.setText(librarianClass.getDateofbirth());
				cboType.setSelectedIndex(librarianClass.getStatus() - 1);

				btnUpdate.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
					Connection cnn;
					Statement sta;
					
						try {
							cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rupp_project", "root", "");
							sta = cnn.createStatement();
							
							
							String sql2 = "UPDATE users SET " 
									+ "fullname = '" + txtName.getText() + "', "
									+ "username = '" + txtUsername.getText() + "', "
									+ "sex = '" + (cboSex.getSelectedIndex() == 0 ? 'M' : 'F') + "', "
									+ "address = '" + txtAddress.getText() + "', "
									+ "email = '" + txtEmail.getText() + "', " 
									+ "phone = '" + txtPhone.getText() + "', "
									+ "dateofbirth = '" + txtDOB.getText() + "', "
									+ "status = " + (cboType.getSelectedIndex() == 0 ? 1 : 2) + " "
									+ "WHERE id = " + librarianClass.getID();
							
							sta.execute(sql2);
							sta.close();
							cnn.close();

							frameEditinfo.dispose();
						} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
						}
					
				
			}
		});
		
		}
		});	
		
		if(librarianClass.getStatus() == 1) {
			panel_1.add(btnUpdatePassword, BorderLayout.SOUTH);
			panel.add(btnUpdateInfomation, BorderLayout.SOUTH);
		}
	}
	
	private void initTable() {
		table = new DefaultTableModel(null, new Object[] {"Date/Time", "Action"});
		List<InformationClass> infos = LibrarianClass.getListOfAction(librarianClass.getID());
		for(InformationClass temp : infos)
			table.addRow(new Object[] {temp.getDate(), temp.getAction()});
		
		jTable = new JTable(table);
		jTable.setRowHeight(23);
		jTable.setPreferredScrollableViewportSize(new Dimension(350, 350));
		jTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jTable.setEnabled(false);
		
		scrollPane = new JScrollPane(jTable);
		panel_8.add(scrollPane, BorderLayout.CENTER);
	}
	
}
