package popForm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserInfoDetail extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserInfoDetail dialog = new UserInfoDetail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserInfoDetail() {
		setBounds(250, 100, 850, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
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
							JLabel lblNewLabel_1 = new JLabel("");
							lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_1);
						}
						{
							JLabel lblNewLabel_2 = new JLabel("Username");
							lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_2);
						}
						{
							JLabel lblNewLabel_4 = new JLabel("");
							lblNewLabel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_4);
						}
						{
							JLabel lblNewLabel_3 = new JLabel("Address");
							lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_3);
						}
						{
							JLabel lblNewLabel_5 = new JLabel("");
							lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_5);
						}
						{
							JLabel lblNewLabel_6 = new JLabel("Phone");
							lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_6);
						}
						{
							JLabel lblNewLabel_7 = new JLabel("");
							lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_7);
						}
						{
							JLabel lblNewLabel_8 = new JLabel("Date of Membership");
							lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_8);
						}
						{
							JLabel lblNewLabel_9 = new JLabel("");
							lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_9);
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
							JLabel lblNewLabel_12 = new JLabel("");
							lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_12.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_12);
						}
						{
							JLabel lblNewLabel_13 = new JLabel("Sex");
							lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_13);
						}
						{
							JLabel lblNewLabel_15 = new JLabel("");
							lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_15.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_15);
						}
						{
							JLabel lblNewLabel_14 = new JLabel("Email");
							lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_14);
						}
						{
							JLabel lblNewLabel_16 = new JLabel("");
							lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_16.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_16);
						}
						{
							JLabel lblNewLabel_18 = new JLabel("Date of Birth");
							lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_18);
						}
						{
							JLabel lblNewLabel_17 = new JLabel("");
							lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_17.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_17);
						}
						{
							JLabel lblNewLabel_19 = new JLabel("Type of Membership");
							lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 20));
							panel_3.add(lblNewLabel_19);
						}
						{
							JLabel lblNewLabel_10 = new JLabel("");
							lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
							lblNewLabel_10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
							panel_3.add(lblNewLabel_10);
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
					label.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
	}

}
