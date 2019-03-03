package popForm;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classMembers.BookClass;
import connection.UserConnection;

public class BookList extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public BookList() {
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		model = new DefaultTableModel(null, new String[] {"id", "ISBN", "Title", "Author", "Edition", "Quantity", "NumBorrow", "InStock"}) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 0;
		    }
		};
		
		table = new JTable(model);
		table.getTableHeader().setBackground(new Color(60, 141, 188));
		
		
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll, BorderLayout.CENTER);
		
		
		UserConnection connect = new UserConnection();
		
		
		initObj();
		
		table.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String id = table.getModel().getValueAt(row, 0).toString();
				
				ArrayList<BookClass> bookList = connect.detailBook(Integer.parseInt(id));
				
				if (e.getClickCount() == 2) {
					for(int i=0; i<bookList.size(); i++) {
						BookClass book = bookList.get(i);
						new FormBookUser(book);
					}
					
				}
			}
		});
		
		
		
	}
	
	public void initObj() {
		
		UserConnection connect = new UserConnection();
		ArrayList<BookClass> bookList = connect.bookView();
		
		for(BookClass boo: bookList) {
			model.addRow(boo.getBookList());
		}
	}

}
