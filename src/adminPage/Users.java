package adminPage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class Users extends JPanel {

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
	public Users() {
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
		
		
		String[] colsName = new String[] {"id", "Full Name", "Username", "Status", "Created At"};
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
		table.removeColumn(tm.getColumn(0));
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(new Color(255, 255, 255));
		panelInner.add(panelBottom, BorderLayout.SOUTH);
		
		JButton btnNewUser = new JButton("Create New User");
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

	}

}
