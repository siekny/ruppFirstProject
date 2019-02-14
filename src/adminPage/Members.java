package adminPage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import classMembers.BookClass;
import classMembers.UserClass;
import connection.DBConnection;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Members extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public Members() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(243,156,18)));
		add(panelMain, BorderLayout.CENTER);
		
		JPanel panelInner = new JPanel();
		panelMain.add(panelInner);
		panelInner.setPreferredSize(new Dimension(900, 550));
		panelInner.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255));
		panelInner.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("List of Users");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTop.add(lblNewLabel);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panelSearch.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(10);
		panelTop.add(panelSearch);
		
		JButton btnRefresh = new JButton("Reload");
		btnRefresh.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\ruppFirstProject\\images\\reload.png"));
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBackground(new Color(0,166,90));
		btnRefresh.setFocusPainted(false);
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearch.add(btnRefresh);
		
		
		JLabel lblNewLabel_1 = new JLabel("          Search : ");
		panelSearch.add(lblNewLabel_1);
		
		txtSearch = new JTextField();
		txtSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panelSearch.add(txtSearch);
		txtSearch.setColumns(30);
		
		JLabel lblNewLabel_2 = new JLabel("#Users  :  ");
		panelSearch.add(lblNewLabel_2);
		
		JLabel lblNoUsers = new JLabel("");
		panelSearch.add(lblNoUsers);
		
		JPanel panelTable = new JPanel();
		panelInner.add(panelTable, BorderLayout.CENTER);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		
		String[] colsName = new String[] {"ID", "Full Name", "Username", "Address", "Date of Membership", "Type of Membership", "Status"};
		model = new DefaultTableModel(null, colsName) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 0;
		    }
		};
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(model);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(new Color(255, 255, 255));
		panelTable.add(scroll);
		
		TableColumnModel tm = table.getColumnModel();
		//table.removeColumn(tm.getColumn(0));
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(new Color(255, 255, 255));
		panelInner.add(panelBottom, BorderLayout.SOUTH);
		
		JButton btnNewUser = new JButton("Create New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame FrameCreatingnewUser = new JFrame("Registering New User");
				JPanel panelOverallCreating = new JPanel(new BorderLayout());
				
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
				JLabel lblName = new JLabel("Full Name");
				panelCenter.add(lblName);
				JTextField txtName = new JTextField();
				panelCenter.add(txtName);
				JLabel lblUsername = new JLabel("Username");
				panelCenter.add(lblUsername);
				JTextField txtUsername = new JTextField();
				panelCenter.add(txtUsername);
				JLabel lblPassword = new JLabel("Password");
				panelCenter.add(lblPassword);
				JTextField txtPassword = new JTextField();
				panelCenter.add(txtPassword);
				JLabel lblSex = new JLabel("Sex");
				panelCenter.add(lblSex);
				JTextField txtSex = new JTextField();
				panelCenter.add(txtSex);
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
				JTextField txtDOB = new JTextField("dd-MM-yyyy");
				panelCenter.add(txtDOB);
				JLabel lblType = new JLabel("Type of Membership");
				panelCenter.add(lblType);
				JTextField txtType = new JTextField();
				panelCenter.add(txtType);
				JLabel lblStatus = new JLabel("Status");
				panelCenter.add(lblStatus);
				JTextField txtStatus = new JTextField();
				panelCenter.add(txtStatus);
				JLabel lblDateofMem = new JLabel("Date of Membership");
				panelCenter.add(lblDateofMem);
				JTextField txtDateofMem = new JTextField();
				txtDateofMem.setText(new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
				txtDateofMem.setEditable(false);
				panelCenter.add(txtDateofMem);
				JPanel panelbutton = new JPanel(new BorderLayout());
				JButton btnRegister = new JButton("Register");
				panelbutton.add(btnRegister, BorderLayout.CENTER);
				
				
				panelOverallCreating.add(panelNorth, BorderLayout.NORTH);
				panelOverallCreating.add(panelCenter,BorderLayout.CENTER);
				panelOverallCreating.add(panelbutton, BorderLayout.SOUTH);
				
				FrameCreatingnewUser.getContentPane().add(panelOverallCreating);
				FrameCreatingnewUser.setResizable(false);
				FrameCreatingnewUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				FrameCreatingnewUser.setSize(400, 400);
				FrameCreatingnewUser.setLocationRelativeTo(null);
				FrameCreatingnewUser.setVisible(true);
				
				btnRegister.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
					UserClass user = new UserClass(
							Integer.parseInt(txtId.getText()),
							txtName.getText(),
							txtUsername.getText(),
							txtPassword.getText(),
							txtSex.getText(),
							txtAddress.getText(),
							txtEmail.getText(),
							txtPhone.getText(),
							txtDOB.getText(),
							txtDateofMem.getText(),
							txtType.getText(),
							Integer.parseInt(txtStatus.getText())
							);
					
					Connection conn;
					Statement stm;
					ResultSet rss;
					//ArrayList<UserClass> Userlist = new ArrayList<UserClass>();
					try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruppProject","root", "");
					stm = conn.createStatement();
					String command = "Select * from users";
					
					String sql = "INSERT INTO users( fullname, username, password, sex, address, email, phone, dateofbirth, typeofmembership, dateofmembership, status ) "
							+ "VALUES( '" 
									//+ txtId.getText()+ "', '"
									+ txtName.getText()+"', '"
									+ txtUsername.getText()+"', '"
									+ txtPassword.getText()+"', '"
									+ txtSex.getText()+"', '"
									+ txtAddress.getText()+"', '"
									+ txtEmail.getText()+"', '"
									+ txtPhone.getText()+"', '"
									+ txtDOB.getText()+"', '"
									+ txtType.getText()+"', '"
									+ txtDateofMem.getText()+"', '"
									+ txtStatus.getText()		
							+"');";
					
					//String sql = "INSERT INTO tblStudents (id, fullname, username, password) VALUES ('" + id + "', '" + name + "', '" + sex + "', " + score + ");";
					rss = stm.executeQuery(command);
					
					rss.last();
					stm.execute(sql);
					
					rss.close();
					stm.close();
					conn.close();
					
					btnRefresh.doClick();
					FrameCreatingnewUser.dispose();
					
					}catch(SQLException ex) {
						ex.printStackTrace();
					}
				}
					
				});
			}
		});
		btnNewUser.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\ruppFirstProject\\images\\new-user.png"));
		btnNewUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewUser.setFocusPainted(false);
		btnNewUser.setForeground(new Color(255, 255, 255));
		btnNewUser.setBackground(new Color(0,154,191));
		panelBottom.add(btnNewUser);
		
		JButton btnResetpassword = new JButton("Reset Password");
		btnResetpassword.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\ruppFirstProject\\images\\key.png"));
		btnResetpassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetpassword.setFocusPainted(false);
		btnResetpassword.setForeground(new Color(255, 255, 255));
		btnResetpassword.setBackground(new Color(0,166,90));
		panelBottom.add(btnResetpassword);
		
		JButton btnDeleteuser = new JButton("Delete User(s)");
		btnDeleteuser.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\ruppFirstProject\\images\\trash.png"));
		btnDeleteuser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteuser.setFocusPainted(false);
		btnDeleteuser.setForeground(new Color(255, 255, 255));
		btnDeleteuser.setBackground(new Color(221,75,57));
		panelBottom.add(btnDeleteuser);
		
		JButton btnEdit = new JButton("Edit Member");
		btnEdit.setIcon(new ImageIcon("D:\\programs\\Rupp\\year 3\\java\\project\\ruppProject\\images\\edit.png"));
		btnEdit.setBackground(new Color(255, 140, 0));
		btnEdit.setForeground(new Color(255, 255, 255));
		panelBottom.add(btnEdit);
		
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				Statement stm;
				ResultSet rss;
				ArrayList<UserClass> Userlist = new ArrayList<UserClass>();
				try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruppProject","root", "");
				stm = conn.createStatement();
				String command = "Select * From USers";
				rss = stm.executeQuery(command);
				
				while(rss.next()) {
					UserClass temp = new UserClass(rss.getInt("id"), rss.getString("fullname"), rss.getString("username"),
							rss.getString("password"), rss.getString("sex"), rss.getString("address"),rss.getString("email"),
							rss.getString("phone"), rss.getString("dateofbirth"), rss.getString("typeofmembership"), 
							rss.getString("dateofmembership"), rss.getInt("status")
							);
					Userlist.add(temp);
				}
				
				//for(int row = model.getRowCount(); row<=0;row--)model.removeRow(row);
				model.setRowCount(0);
				
				for (int i=0;i<Userlist.size();i++) {
					UserClass user = Userlist.get(i);
					Object obj[]= { user.getID(), user.getFullname(), user.getUsername(),user.getAddress(),user.getDateofmembership(),
							user.getTypeofmembership(),user.getStatus()
					};
					model.addRow(obj);
				}
				
				rss.close();
				stm.close();
				conn.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			
		});
		
		btnDeleteuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn ;
				Statement stm;
				ResultSet rss;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruppProject", "root", "");
					stm = conn.createStatement();
					rss = stm.executeQuery("SELECT * FROM users");
					
					int index = table.getSelectedRow();
					int ID =Integer.parseInt(model.getValueAt(index, 0).toString());
					
					String sql = "DELETE FROM users where id = "+ ID; 
					
					stm.execute(sql);
					rss.close();
					stm.close();
					conn.close();
					btnRefresh.doClick();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnResetpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conn ;
				Statement stm;
				ResultSet rss;
				
				int index = table.getSelectedRow();
				int ID =Integer.parseInt(model.getValueAt(index, 0).toString());
				
				JFrame frameChangePassword = new JFrame("Reset Password");
				JPanel panelcontent = new JPanel(new BorderLayout());
				
				JLabel lblLogo = new JLabel("Library Management System");
				lblLogo.setForeground(new Color(255, 255, 255));
				lblLogo.setAlignmentX(CENTER_ALIGNMENT);
				panelcontent.add(lblLogo, BorderLayout.NORTH);
				
				JPanel panelcenter = new JPanel(new GridLayout(3, 2)); 
				
				JLabel lblUsername = new JLabel("Username");
				panelcenter.add(lblUsername);
				
				JTextField txtUsername = new JTextField();
				txtUsername.setText(model.getValueAt(index, 2).toString());
				txtUsername.setEditable(false);
				panelcenter.add(txtUsername);
				
				JLabel lbloldpassword = new JLabel("Old Password");
				panelcenter.add(lbloldpassword);
				
				JTextField txtoldpassword = new JTextField();
				txtoldpassword.setEditable(false);
				panelcenter.add(txtoldpassword);
				
				JLabel lblnewpassword = new JLabel("New Password");
				panelcenter.add(lblnewpassword);
				
				JTextField txtnewpassword = new JTextField();
				panelcenter.add(txtnewpassword);
				
				JButton btnChange = new JButton("Change Password");
				JPanel panelbtn = new JPanel(new BorderLayout());
				panelbtn.add(btnChange, BorderLayout.CENTER);
				panelcontent.add(panelcenter, BorderLayout.CENTER);
				panelcontent.add(panelbtn, BorderLayout.SOUTH);
				
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruppProject", "root", "");
					stm = conn.createStatement();
					//rss = stm.executeQuery("SELECT * FROM users");
					rss = stm.executeQuery("SELECT * FROM users WHERE id = " + ID);
					rss.next();
					txtoldpassword.setText(rss.getString("password"));
					//String sql2 = "UPDATE uses SET password = '" + newpassword +"' WHERE id = " + ID;
					
					//stm.execute(sql2);
					rss.close();
					stm.close();
					conn.close();
					btnRefresh.doClick();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frameChangePassword.getContentPane().add(panelcontent);
				frameChangePassword.setSize(400, 300);
				frameChangePassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frameChangePassword.setVisible(true);
				
				btnChange.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Connection cnn;
						Statement sta;
						
						String newpassword = txtnewpassword.getText();
						try {
							cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruppProject", "root", "");
							sta = cnn.createStatement();
							String sql2 = "UPDATE users SET password = '" + newpassword +"' WHERE id = " + ID;
							sta.execute(sql2);
							sta.close();
							cnn.close();
							btnRefresh.doClick();
							frameChangePassword.dispose();
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
					}
				});
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Frame
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
				JLabel lblName = new JLabel("Full Name");
				panelCenter.add(lblName);
				JTextField txtName = new JTextField();
				panelCenter.add(txtName);
				JLabel lblUsername = new JLabel("Username");
				panelCenter.add(lblUsername);
				JTextField txtUsername = new JTextField();
				panelCenter.add(txtUsername);
				JLabel lblPassword = new JLabel("Password");
				panelCenter.add(lblPassword);
				JTextField txtPassword = new JTextField();
				panelCenter.add(txtPassword);
				JLabel lblSex = new JLabel("Sex");
				panelCenter.add(lblSex);
				JTextField txtSex = new JTextField();
				panelCenter.add(txtSex);
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
				JTextField txtType = new JTextField();
				panelCenter.add(txtType);
				JLabel lblStatus = new JLabel("Status");
				panelCenter.add(lblStatus);
				JTextField txtStatus = new JTextField();
				panelCenter.add(txtStatus);
				JLabel lblDateofMem = new JLabel("Date of Membership");
				panelCenter.add(lblDateofMem);
				JTextField txtDateofMem = new JTextField();
				//txtDateofMem.setText(new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
				txtDateofMem.setEditable(true);
				panelCenter.add(txtDateofMem);
				JPanel panelbutton = new JPanel(new BorderLayout());
				JButton btnUpdate = new JButton("Register");
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
				
				int index = table.getSelectedRow();
				int ID =Integer.parseInt(model.getValueAt(index, 0).toString());
				String sql1= "SELECT * FROM users WHERE id = " + ID;
				
				Connection con;
				Statement stm;
				ResultSet res;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruppProject", "root", "");
					stm = con.createStatement();
					res = stm.executeQuery("SELECT * FROM users");
					res = stm.executeQuery(sql1);
					res.next();
						txtId.setText(res.getString("id")); 
						txtId.setEditable(false);
						txtName.setText(res.getString("fullname"));
						txtUsername.setText(res.getString("username"));
						txtPassword.setText(res.getString("password"));
						txtSex.setText(res.getString("sex"));
						txtAddress.setText(res.getString("address"));
						txtEmail.setText(res.getString("email"));
						txtPhone.setText(res.getString("phone"));
						txtDOB.setText(res.getString("dateofbirth"));
						txtType.setText(res.getString("typeofmembership"));
						txtDateofMem.setText(res.getString("dateofmembership"));
						txtStatus.setText(res.getString("status"));
					res.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				btnUpdate.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
					Connection cnn;
					Statement sta;
					ResultSet res;
					
						try {
							cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruppProject", "root", "");
							sta = cnn.createStatement();
							
							
							String sql2 = "UPDATE users SET password = '"
								+ txtName.getText()+"', '"
								+ txtUsername.getText()+"', '"
								+ txtPassword.getText()+"', '"
								+ txtSex.getText()+"', '"
								+ txtAddress.getText()+"', '"
								+ txtEmail.getText()+"', '"
								+ txtPhone.getText()+"', '"
								+ txtDOB.getText()+"', '"
								+ txtType.getText()+"', '"
								+ txtDateofMem.getText()+"', '"
								+ txtStatus.getText()
								+"' WHERE id = " + ID;
							
							sta.execute(sql2);
							//rss.close();
							sta.close();
							cnn.close();
							btnRefresh.doClick();
							frameEditinfo.dispose();
						} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
						}
					
				
			}
		});
		
		}
		});	

	}
	
	
}
	