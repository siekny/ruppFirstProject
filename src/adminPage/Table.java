package adminPage;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import connection.DBConnection;

import com.toedter.calendar.JDateChooser;

import classMembers.Tables;


public class Table extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */

	private JTextField txtSearch;
	private JTextField txtTableID;
	private JTextField txtNumSeats;
	private JTextField txtStatus;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnSave, btnClear;
	private JLabel lblNoUsers;
	private JButton btnRemove, btnUpdate;
	private JTextField txtCreatedBy;
	private JDateChooser dateCreatdAt;
	
	private Connection conn = DBConnection.connection();

	/**
	 * Create the panel.
	 */
	public Table() {
		
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
		
		JLabel lblNewLabel = new JLabel("    List of Your Tables");
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
		
		JLabel lblNewLabel_3 = new JLabel("#Table(s) : ");
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
		String[] colsName = new String[] {"id", "Table's ID", "Numbers of Seat", "Status", "Created At", "Created By"};
		
		
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
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.desktop);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		panelContent.setBorder(new MatteBorder(3, 0,0,0, new Color(243,156,18)));
		
		JPanel panelTopRight = new JPanel();
		panelTopRight.setBackground(SystemColor.desktop);
		panelContent.add(panelTopRight, BorderLayout.NORTH);
		
		JLabel lblNewLabel_12 = new JLabel("Create a New Table");
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
		
		JPanel panelTableID = new JPanel();
		panelTableID.setBackground(SystemColor.desktop);
		FlowLayout fl_panelTableID = (FlowLayout) panelTableID.getLayout();
		fl_panelTableID.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelTableID);
		
		JLabel lblTableID = new JLabel("     Table's ID : ");
		panelTableID.add(lblTableID);
		lblTableID.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_8 = new JLabel("*");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		panelTableID.add(lblNewLabel_8);
		
		txtTableID = new JTextField();
		panelInner.add(txtTableID);
		txtTableID.setColumns(15);
		txtTableID.setPreferredSize(new Dimension(100, 10));
		
		JPanel panelNumSeats = new JPanel();
		panelNumSeats.setBackground(SystemColor.desktop);
		FlowLayout fl_panelNumSeats = (FlowLayout) panelNumSeats.getLayout();
		fl_panelNumSeats.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelNumSeats);
		
		JLabel lblNumSeats = new JLabel("     Number of Seats : ");
		panelNumSeats.add(lblNumSeats);
		lblNumSeats.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_3 = new JLabel("*");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.RED);
		panelNumSeats.add(label_3);
		
		txtNumSeats = new JTextField();
		panelInner.add(txtNumSeats);
		txtNumSeats.setColumns(15);
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBackground(SystemColor.desktop);
		FlowLayout fl_panelStatus = (FlowLayout) panelStatus.getLayout();
		fl_panelStatus.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelStatus);
		
		JLabel lblStatus = new JLabel("     Status : ");
		panelStatus.add(lblStatus);
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_9 = new JLabel("*");
		panelStatus.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtStatus = new JTextField();
		txtStatus.setEditable(false);
		txtStatus.setBackground(new Color(255, 255, 255));
		panelInner.add(txtStatus);
		txtStatus.setColumns(15);
		
		JPanel panelCreatedAt = new JPanel();
		panelCreatedAt.setBackground(SystemColor.desktop);
		FlowLayout fl_panelCreatedAt = (FlowLayout) panelCreatedAt.getLayout();
		fl_panelCreatedAt.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelCreatedAt);
		
		JLabel lblCreated = new JLabel("     Created At: ");
		panelCreatedAt.add(lblCreated);
		
		JLabel label_5 = new JLabel("*");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.RED);
		panelCreatedAt.add(label_5);
		
		dateCreatdAt = new JDateChooser();
		dateCreatdAt.setBackground(Color.WHITE);
		panelInner.add(dateCreatdAt);
		
		JPanel panelCreatedBy = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCreatedBy.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelCreatedBy.setBackground(new Color(255, 255, 255));
		panelInner.add(panelCreatedBy);
		
		JLabel lblCreatedBy = new JLabel("      Created By : ");
		panelCreatedBy.add(lblCreatedBy);
		
		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		panelCreatedBy.add(lblNewLabel_5);
		
		txtCreatedBy = new JTextField();
		txtCreatedBy.setEditable(false);
		txtCreatedBy.setBackground(new Color(255, 255, 255));
		panelInner.add(txtCreatedBy);
		txtCreatedBy.setColumns(10);
		
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
		
		btnRemove = new JButton("Remove");
		btnRemove.setIcon(new ImageIcon("images/trash.png"));
		btnRemove.setHorizontalAlignment(SwingConstants.RIGHT);
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFocusPainted(false);
		btnRemove.setBackground(new Color(221, 75, 57));
		panelSave.add(btnRemove);
		
		JPanel panelClear = new JPanel();
		panelClear.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_2 = (FlowLayout) panelClear.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelInner.add(panelClear);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0,166,90));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setIcon(new ImageIcon("images/edit.png"));
		panelClear.add(btnUpdate);
		
		btnClear = new JButton("Clear");
		panelClear.add(btnClear);
		btnClear.setFocusPainted(false);
		btnClear.setBackground(SystemColor.menu);
		
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnClear.addActionListener(this);

		dateCreatdAt.setDate(new Date());
		txtCreatedBy.setText("Siekny");
		txtStatus.setText("Available");
		
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				String id = table.getModel().getValueAt(row, 0).toString();
				
				try {
                	Statement stmt = conn.createStatement();
	                String sql = "SELECT * FROM tables WHERE id = '" +Integer.parseInt(id) + "'";
	                ResultSet rss = stmt.executeQuery(sql);
	    			
	    			while(rss.next()) {
	    				Tables table = new Tables(rss.getString("tableID"), rss.getInt("numSeats"), rss.getInt("status"), rss.getString("createdBy"), rss.getString("createdAt"));
	    				txtTableID.setText(table.getTableID());
	    				txtNumSeats.setText(table.getNumSeats() + "");
	    				
	    				if(rss.getInt("status") == 0)	txtStatus.setText("Unavailable");
	    				else				txtStatus.setText("Available");
	    				
	    				txtCreatedBy.setText(table.getCreatedBy());
	    				
	    				SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
	    				
	    				
	    				try {
							dateCreatdAt.setDate(format.parse(table.getCreatedAt()));
							System.out.println(format.parse(table.getCreatedAt()));
							
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
						}
	    			}
		             
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				}
				
			}
		});
		
		
	}

	
	public void initObjects () {
		
		try {
			 
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM tables";
			ResultSet rss = stmt.executeQuery(sql);
			
			while(rss.next()) {
				Tables table = new Tables(rss.getString("tableID"), rss.getInt("numSeats"), rss.getInt("status"), rss.getString("createdBy"), rss.getString("createdAt"));
				model.addRow(table.rowTables(rss.getInt("id")));
			}
			
			rss.close();
		    stmt.close();
		    //conn.close();
		}catch (Exception ex) {}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnSave)				
					saveButton("save");

			else if(e.getSource() == btnRemove)
				removeTable();
			
			else if(e.getSource() == btnUpdate)
				saveButton("update");
			
			else if(e.getSource() == btnClear)
				clearTable();
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void saveButton(String btnValue) throws Exception {
		
		Statement stmt = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		SimpleDateFormat formatt = new SimpleDateFormat("yyyy MM, dd");
		if(txtTableID.getText().isEmpty())
			throw new Exception("Invalid Table's ID");
		else if(txtNumSeats.getText().isEmpty()) 
			throw new Exception("Number of Seats cannot be null");
		else if(Integer.parseInt(txtNumSeats.getText()) <= 0)
			throw new Exception("Number of Seats cannot be equal or less than Zeo");
		else if(Integer.parseInt(txtNumSeats.getText()) > 20)
			throw new Exception("Number of Seats cannot be bigger than 20");
		else if(formatter.format(dateCreatdAt.getDate()).isEmpty())
			throw new Exception("Created At cannot be null");
		else if (!formatt.format(dateCreatdAt.getDate()).matches("\\d{4} \\d{2}, \\d{2}")) {
		    throw new Exception("Invalid Date !");
		}
		int status;
	    if(txtStatus.getText().equals("Available"))	status = 0;	// 0 means Available
	    status = 1;

		try {
			System.out.println("Creating statement...");
		    stmt = conn.createStatement();
		    
		    // SAVE DATA
		    if(btnValue.equals("save")) {
		    	Tables table = new Tables(txtTableID.getText(), Integer.parseInt(txtNumSeats.getText()), status, txtCreatedBy.getText(), formatter.format(dateCreatdAt.getDate()));
			    String sql = "INSERT INTO tables (tableID, numSeats, status, createdBy, createdAt) VALUES ('" + table.getTableID() + "', '" + table.getNumSeats() + "', '" + table.isStatus() + "', '"+ table.getCreatedBy() + "', '" + table.getCreatedAt() + "')";
			    
			    stmt.execute(sql);
			      
			    stmt.close();
			     
			    JOptionPane.showMessageDialog(null, "Data has been inserted successfully !");
			    model.setRowCount(0);
			    initObjects();
		    }
		    
		    // UPDATE DATA
		    else if(btnValue.equals("update")) {
		    	if(table.getSelectionModel().isSelectionEmpty())
					JOptionPane.showConfirmDialog(null, "Please select at least one row to Remove", "",  JOptionPane.CLOSED_OPTION , JOptionPane.ERROR_MESSAGE);
				
		    	else {
			    	int row = table.getSelectedRow();
			    	String id = table.getModel().getValueAt(row, 0).toString();
			    	
			    	String sql = "update tables set tableID = '" + txtTableID.getText() + "'" + ", numSeats = '" + txtNumSeats.getText() + "'" + ", createdAt = '" + formatter.format(dateCreatdAt.getDate()) + "'" + " WHERE id = '" + Integer.parseInt(id) + "'";
			    	stmt.executeUpdate(sql);
			    	
			    	Tables ta = new Tables(txtTableID.getText(), Integer.parseInt(txtNumSeats.getText()), formatter.format(dateCreatdAt.getDate()));
			    	table.getModel().setValueAt(ta.getTableID(), row, 1);
			    	table.getModel().setValueAt(ta.getNumSeats(), row, 2);
			    	table.getModel().setValueAt(ta.getCreatedAt(), row, 4);
			    	stmt.close();
			    	
				    System.out.println(sql); 
				    JOptionPane.showMessageDialog(null, "Data has been updated successfully !");
				}
		    }
		    
		    
		}catch(Exception e){
	      e.printStackTrace();
	   }
	}
	
	
	// REMOVE TABLES FFOM DB
		public void removeTable() {
			
			if(table.getSelectionModel().isSelectionEmpty())
				JOptionPane.showConfirmDialog(null, "Please select at least one row to Remove", "",  JOptionPane.CLOSED_OPTION , JOptionPane.ERROR_MESSAGE);
			else {
				int row = table.getSelectedRow();
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "Deleting...", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
				if(confirm == JOptionPane.OK_OPTION) {
					while (row != -1)
		            {
		                int modelRow = table.convertRowIndexToModel( row );
		                String id = table.getModel().getValueAt(modelRow, 0).toString();
		                System.out.println(id);
		                
		                try {
		                	Statement stmt = conn.createStatement();
			                String sql = "DELETE FROM tables WHERE id = '" +Integer.parseInt(id) + "'";
			                System.out.println(sql);
							stmt.executeUpdate(sql);
							 model.removeRow( modelRow );
				             row = table.getSelectedRow();
				             
				             
				             
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
		                
		               
		               
		                //lblNoEmployee.setText((Integer.parseInt(lblNoEmployee.getText()) - 1) + "");
		            }
					
					txtTableID.setText("");
					txtNumSeats.setText("");
					dateCreatdAt.setDate(new Date());

					
					JOptionPane.showConfirmDialog(null, "Data has been deleted successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
				}
				
			}
		}
		
		
		public void clearTable() {
			txtTableID.setText("");
			txtNumSeats.setText("");
			dateCreatdAt.setDate(new Date());
		}
	
}
