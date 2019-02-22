package adminPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import classMembers.LibrarianClass;
import classMembers.UserClass;

import java.awt.Dimension;

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

	public Profile() {
		setLayout(new BorderLayout(0, 0));

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
		panel_11.setLayout(new GridLayout(10, 2, 0, 0));		
		
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
		
		String typeOfMemberShip;
		if(librarianClass.getStatus() == 1)	typeOfMemberShip = "Admin";
		else	typeOfMemberShip = "Member";		
		lblTom.setText(typeOfMemberShip);
		
		if(librarianClass instanceof UserClass) {
			UserClass temp = (UserClass) librarianClass;
			lblUsername.setText(temp.getUsername());
			lblDom.setText(temp.getDateofmembership());
		}
		
		/////////////////////
		
		boolean isAdmin = (librarianClass.getStatus() == 1);
		
		panel_11.add(lblNewLabel);
		panel_11.add(lblId);
		panel_11.add(lblNewLabel_1);
		panel_11.add(lblFullname);	
		
		if(!isAdmin) {
			panel_11.add(lblNewLabel_2);
			panel_11.add(lblUsername);
		}
		
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
		
		if(!isAdmin) {
			panel_11.add(lblNewLabel_9);
			panel_11.add(lblDom);
		}
	}
	
	private void initTable() {
		table = new DefaultTableModel(null, new Object[] {"Date/Time", "Action"});
		
		jTable = new JTable(table);
		jTable.setRowHeight(23);
		jTable.setPreferredScrollableViewportSize(new Dimension(350, 350));
		jTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jTable.setEnabled(false);
		
		scrollPane = new JScrollPane(jTable);
		panel_8.add(scrollPane, BorderLayout.CENTER);
	}
	
}
