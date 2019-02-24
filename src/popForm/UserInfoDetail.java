package popForm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import classMembers.InformationClass;
import classMembers.LibrarianClass;
import classMembers.UserClass;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserInfoDetail extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JLabel lblId;
	private JLabel lblUsername;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblDom;
	private JLabel lblFullname;
	private JLabel lblSex;
	private JLabel lblEmail;
	private JLabel lblDob;
	private JLabel lblTom;
	
	private UserClass userClass;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			UserInfoDetail dialog = new UserInfoDetail();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserInfoDetail(UserClass userClass) {
		setBounds(250, 100, 850, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		this.userClass = userClass;
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new GridLayout(2, 1, 0, 0));
			{
				JLabel label = new JLabel(" ");
				panel.add(label);
			}
			{
				JLabel lblUsersInformation = new JLabel("User's Information");
				lblUsersInformation.setFont(new Font("Tahoma", Font.PLAIN, 30));
				lblUsersInformation.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblUsersInformation);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JLabel label = new JLabel(" ");
					label.setFont(new Font("Tahoma", Font.PLAIN, 20));
					panel_1.add(label, BorderLayout.NORTH);
				}
				{
					JPanel panel_2 = new JPanel();
					panel_1.add(panel_2, BorderLayout.CENTER);
					panel_2.setLayout(new GridLayout(1, 2, 25, 0));
					{
						JPanel panel_3 = new JPanel();
						panel_2.add(panel_3);
						panel_3.setLayout(new GridLayout(5, 2, 0, 0));
						{
							JLabel lblNewLabel = new JLabel("ID");
							lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel);
						}
						{
							lblId = new JLabel("");
							lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblId);
						}
						{
							JLabel lblNewLabel_2 = new JLabel("Username");
							lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_2);
						}
						{
							lblUsername = new JLabel("");
							lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblUsername);
						}
						{
							JLabel lblNewLabel_3 = new JLabel("Address");
							lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_3);
						}
						{
							lblAddress = new JLabel("");
							lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblAddress.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblAddress);
						}
						{
							JLabel lblNewLabel_6 = new JLabel("Phone");
							lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_6);
						}
						{
							lblPhone = new JLabel("");
							lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblPhone.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblPhone);
						}
						{
							JLabel lblNewLabel_8 = new JLabel("Date of Membership");
							lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_8);
						}
						{
							lblDom = new JLabel("");
							lblDom.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblDom.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblDom);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_2.add(panel_3);
						panel_3.setLayout(new GridLayout(5, 2, 0, 0));
						{
							JLabel lblNewLabel_11 = new JLabel("Fullname");
							lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_11);
						}
						{
							lblFullname = new JLabel("");
							lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblFullname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblFullname);
						}
						{
							JLabel lblNewLabel_13 = new JLabel("Sex");
							lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_13);
						}
						{
							lblSex = new JLabel("");
							lblSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblSex.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblSex);
						}
						{
							JLabel lblNewLabel_14 = new JLabel("Email");
							lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_14);
						}
						{
							lblEmail = new JLabel("");
							lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblEmail);
						}
						{
							JLabel lblNewLabel_18 = new JLabel("Date of Birth");
							lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_18);
						}
						{
							lblDob = new JLabel("");
							lblDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblDob.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblDob);
						}
						{
							JLabel lblNewLabel_19 = new JLabel("Type of Membership");
							lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_19);
						}
						{
							lblTom = new JLabel("");
							lblTom.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblTom.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblTom);
						}
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					dtm = new DefaultTableModel(null, new Object[] {"Date", "Action"}) {
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int row, int column) {
							return column == 0;
						}
					};
					table = new JTable(dtm);
					scrollPane = new JScrollPane(table);
					panel_1.add(scrollPane, BorderLayout.CENTER);
				}
				{
					JLabel label = new JLabel(" ");
					label.setFont(new Font("Tahoma", Font.PLAIN, 30));
					panel_1.add(label, BorderLayout.NORTH);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			{
				JLabel label = new JLabel(" ");
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(label);
			}
		}
		{
			JLabel label = new JLabel("     ");
			contentPanel.add(label, BorderLayout.WEST);
		}
		{
			JLabel label = new JLabel("     ");
			contentPanel.add(label, BorderLayout.EAST);
		}
		
		showUserInfo();
		
	}

	public void showUserInfo() {
		lblId.setText(userClass.getID() + "");
		lblUsername.setText(userClass.getUsername());
		lblAddress.setText(userClass.getAddress());
		lblPhone.setText(userClass.getPhone());
		lblDom.setText(userClass.getDateofmembership());
		lblFullname.setText(userClass.getFullname());
		lblSex.setText(userClass.getSex());
		lblEmail.setText(userClass.getEmail());
		lblDob.setText(userClass.getDateofbirth());
		lblTom.setText("Member");
		
		List<InformationClass> infos = LibrarianClass.getListOfAction(userClass.getID());
		for(InformationClass temp : infos)
			dtm.addRow(new Object[] {temp.getDate(), temp.getAction()});
	}

}
