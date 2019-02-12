package adminPage;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import com.toedter.calendar.JYearChooser;

public class Books extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */

	private JTextField txtSearch;
	private JTextField txtISBN;
	private JTextField txtTitle;
	private JTextField txtPublisher;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnSave, btnClear;
	private JLabel lblNoUsers;
	

	/**
	 * Create the panel.
	 */
	public Books() {
		
		initialize();
		initObjects();
	}
	
	public void initialize () {
		setBackground(new Color(236,240,245));
		setLayout(new BorderLayout(20, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(10, 10));
		panel.setPreferredSize(new Dimension(750, 100));
		
		JPanel panelTopLeft = new JPanel();
		panelTopLeft.setBackground(SystemColor.desktop);
		panel.add(panelTopLeft, BorderLayout.NORTH);
		panelTopLeft.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("    List of Your Books");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTopLeft.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(68,68,68));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new MatteBorder(3,0,0,0, new Color(0,166,90)));
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(SystemColor.desktop);
		FlowLayout fl_panelSearch = (FlowLayout) panelSearch.getLayout();
		fl_panelSearch.setVgap(10);
		fl_panelSearch.setAlignment(FlowLayout.LEFT);
		panelTopLeft.add(panelSearch);
		
		JLabel lblNewLabel_2 = new JLabel("  Search :    ");
		panelSearch.add(lblNewLabel_2);
		
		txtSearch = new JTextField();
		panelSearch.add(txtSearch);
		txtSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		txtSearch.setColumns(33);
		
		JLabel lblNewLabel_3 = new JLabel("#Book(s) : ");
		panelSearch.add(lblNewLabel_3);
		
		lblNoUsers = new JLabel("");
		panelSearch.add(lblNoUsers);
		lblNoUsers.setForeground(Color.BLUE);
		lblNoUsers.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panelNumUsers = new JPanel();
		panelSearch.add(panelNumUsers);
		panelNumUsers.setBackground(SystemColor.desktop);
		FlowLayout fl_panelNumUsers = (FlowLayout) panelNumUsers.getLayout();
		fl_panelNumUsers.setAlignment(FlowLayout.RIGHT);
		
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 255, 255));
		panel.add(panelTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		String[] colsName = new String[] {"id", "ISBN", "Title", "Publisher", "PbulishedYear", "Price", "Author", "Edition", "Status"};
		
		
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
		panelTable.setLayout(new BorderLayout(0, 0));
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(new Color(255, 255, 255));
		panelTable.add(scroll);
		
		TableColumnModel tm = table.getColumnModel();
		table.removeColumn(tm.getColumn(0));
		
		JPanel panelButtonLeft = new JPanel();
		panel.add(panelButtonLeft, BorderLayout.SOUTH);
		panelButtonLeft.setBackground(new Color(255, 255, 255));
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.setBackground(new Color(255, 140, 0));
		btnDetail.setFocusPainted(false);
		btnDetail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDetail.setForeground(new Color(255, 255, 255));
		panelButtonLeft.add(btnDetail);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setHorizontalAlignment(SwingConstants.RIGHT);
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFocusPainted(false);
		btnRemove.setBackground(new Color(221, 75, 57));
		panelButtonLeft.add(btnRemove);
		
		JButton btnEdit = new JButton("Update");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBackground(new Color(0, 166, 90));
		panelButtonLeft.add(btnEdit);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.desktop);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		panelContent.setBorder(new MatteBorder(3, 0,0,0, new Color(243,156,18)));
		
		JPanel panelTopRight = new JPanel();
		panelTopRight.setBackground(SystemColor.desktop);
		panelContent.add(panelTopRight, BorderLayout.NORTH);
		
		JLabel lblNewLabel_12 = new JLabel("Insertion a New Book");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		panelTopRight.add(lblNewLabel_12);
		
		JPanel panelBodyRight = new JPanel();
		panelBodyRight.setBackground(SystemColor.desktop);
		panelContent.add(panelBodyRight, BorderLayout.CENTER);
		panelBodyRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInner = new JPanel();
		panelInner.setBackground(SystemColor.desktop);
		panelBodyRight.add(panelInner, BorderLayout.CENTER);
		panelInner.setLayout(new GridLayout(14, 2, 0, 5));
		
		JLabel lblNewLabel_4 = new JLabel("     Table Information");
		panelInner.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBorder(new MatteBorder(0,0,1,0, Color.BLUE));
		
		JLabel label_9 = new JLabel("");
		panelInner.add(label_9);
		label_9.setBorder(new MatteBorder(0,0,1,0, Color.BLUE));
		
		JLabel lblImage = new JLabel("     Image : ");
		panelInner.add(lblImage);
		
		JButton btnImage = new JButton("Choose Image");
		btnImage.setFocusPainted(false);
		btnImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelInner.add(btnImage);
		
		JPanel panelISBN = new JPanel();
		panelISBN.setBackground(SystemColor.desktop);
		FlowLayout fl_panelISBN = (FlowLayout) panelISBN.getLayout();
		fl_panelISBN.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelISBN);
		
		JLabel lblISBN = new JLabel("     ISBN : ");
		panelISBN.add(lblISBN);
		lblISBN.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_8 = new JLabel("*");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		panelISBN.add(lblNewLabel_8);
		
		txtISBN = new JTextField();
		panelInner.add(txtISBN);
		txtISBN.setColumns(15);
		txtISBN.setPreferredSize(new Dimension(100, 10));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(SystemColor.desktop);
		FlowLayout fl_panelTitle = (FlowLayout) panelTitle.getLayout();
		fl_panelTitle.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelTitle);
		
		JLabel lblTitle = new JLabel("     Title : ");
		panelTitle.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.RED);
		panelTitle.add(label_3);
		
		txtTitle = new JTextField();
		panelInner.add(txtTitle);
		txtTitle.setColumns(15);
		
		JPanel panelPublisher = new JPanel();
		panelPublisher.setBackground(SystemColor.desktop);
		FlowLayout fl_panelPublisher = (FlowLayout) panelPublisher.getLayout();
		fl_panelPublisher.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelPublisher);
		
		JLabel lblPublisher = new JLabel("     Publisher : ");
		panelPublisher.add(lblPublisher);
		lblPublisher.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_9 = new JLabel("*");
		panelPublisher.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtPublisher = new JTextField();
		txtPublisher.setBackground(new Color(255, 255, 255));
		panelInner.add(txtPublisher);
		txtPublisher.setColumns(15);
		
		JPanel panelPublishedYear = new JPanel();
		panelPublishedYear.setBackground(SystemColor.desktop);
		FlowLayout fl_panelPublishedYear = (FlowLayout) panelPublishedYear.getLayout();
		fl_panelPublishedYear.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelPublishedYear);
		
		JLabel lblPublishedYear = new JLabel("     PublishedYear : ");
		panelPublishedYear.add(lblPublishedYear);
		
		JLabel label_5 = new JLabel("*");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.RED);
		panelPublishedYear.add(label_5);
		
		JYearChooser yearChooser = new JYearChooser();
		panelInner.add(yearChooser);
		
		JLabel label = new JLabel("");
		label.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLUE));
		panelInner.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLUE));
		panelInner.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelInner.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		panelInner.add(label_2);
		
		JPanel panelSave = new JPanel();
		panelSave.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_6 = (FlowLayout) panelSave.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panelInner.add(panelSave);
		
		btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("images/add.png"));
		panelSave.add(btnSave);
		btnSave.setFocusPainted(false);
		btnSave.setBackground(new Color(60,141,188));
		btnSave.setForeground(SystemColor.desktop);
		
		JPanel panelClear = new JPanel();
		panelClear.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_2 = (FlowLayout) panelClear.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelClear);
		
		btnClear = new JButton("Clear");
		panelClear.add(btnClear);
		btnClear.setFocusPainted(false);
		btnClear.setBackground(SystemColor.menu);
		
		
	}

	
	public void initObjects () {
		
		
	}

	
}
