package adminPage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import classMembers.UserClass;
import connection.DBConnection;
import popForm.UserInfoDetail;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class UserLoginHistory extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel model;
	private StringBuilder sb = new StringBuilder();
	
	public UserLoginHistory() {
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
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				txtSearch.setText("");
				sb.setLength(0);
				showAllUserInfo();
			}
		});		
		panelSearch.add(btnRefresh);
		
		JLabel lblNewLabel_1 = new JLabel("          Search : ");
		panelSearch.add(lblNewLabel_1);
		
		txtSearch = new JTextField("");
		txtSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE && sb.length() > 0)
					sb.deleteCharAt(sb.length()-1);
				else if(ke.getKeyCode() != KeyEvent.VK_BACK_SPACE)
					sb.append(ke.getKeyChar());
				else {}
					
				if(sb.toString().equals("")) {
					showAllUserInfo();
					return;
				}
				
				try {
					Connection connection = DBConnection.connectDB();
					Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					String sql = "";
					
					try {
						Integer.parseInt(sb.toString());
						sql = "SELECT * FROM users WHERE status != 1 AND (id = " + sb.toString() + " OR fullname LIKE '" + sb.toString() + "%' OR " +
								"username LIKE '" + sb.toString() + "%')";
					}
					catch(NumberFormatException e) {
						sql = "SELECT * FROM users WHERE status != 1 AND (fullname LIKE '" + sb.toString() + "%' OR " +
								 "username LIKE '" + sb.toString() + "%')";
					}

					ResultSet resultSet = statement.executeQuery(sql);
					
					
					if(!resultSet.next()) {
						model.setRowCount(0);
						return;
					}
					else
						resultSet.previous();
					
					model.getDataVector().removeAllElements();			
					while(resultSet.next()) {
						model.addRow(
								new Object[] {
										"", resultSet.getString("id"), resultSet.getString("fullname"), resultSet.getString("username"),
										resultSet.getString("sex"), resultSet.getString("phone"), resultSet.getString("dateofmembership"),
										"Member"
										}
								);
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
		});
		
		panelSearch.add(txtSearch);
		txtSearch.setColumns(30);
		
		JLabel lblNewLabel_2 = new JLabel("#Users  :  ");
		panelSearch.add(lblNewLabel_2);
		
		JLabel lblNoUsers = new JLabel("");
		panelSearch.add(lblNoUsers);
		
		JPanel panelTable = new JPanel();
		panelInner.add(panelTable, BorderLayout.CENTER);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		String[] colsName = new String[] {"", "ID", "Fullname", "Username", "Sex", "Phone", "Date of Membership", "Type of Membership"};
		model = new DefaultTableModel(null, colsName) {

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
		table.removeColumn(tm.getColumn(0));
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(new Color(255, 255, 255));
		panelInner.add(panelBottom, BorderLayout.SOUTH);
		
		JButton btnDetail = new JButton("View Detail");
		btnDetail.setIcon(new ImageIcon("C:\\Users\\Acer\\Downloads\\eye.png"));
		btnDetail.setBackground(new Color(255, 140, 0));
		btnDetail.setForeground(new Color(255, 255, 255));
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				try {
					UserClass userClass = UserClass.getUser(Integer.parseInt("" + model.getValueAt(table.getSelectedRow(), 1)));
					UserInfoDetail uid = new UserInfoDetail(userClass);
					uid.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					uid.setVisible(true);
				}
				catch(Exception e) {
					
				}
			}
		});
		panelBottom.add(btnDetail);

		showAllUserInfo();
		
	}
	
	public void showAllUserInfo() {
		model.getDataVector().removeAllElements();
		try {
			Connection connection = DBConnection.connectDB();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sql = "SELECT * FROM users WHERE status != 1";
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				model.addRow(
						new Object[] {
								"", resultSet.getString("id"), resultSet.getString("fullname"), resultSet.getString("username"),
								resultSet.getString("sex"), resultSet.getString("phone"), resultSet.getString("dateofmembership"),
								"Member"
								}
						);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
