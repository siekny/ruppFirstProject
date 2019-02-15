package popForm;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classMembers.BookClass;
import connection.UserConnection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookGrid extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BookGrid() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		UserConnection connect = new UserConnection();
		ArrayList<BookClass> bookList = null;
		JLabel[] label = null;
		bookList = connect.bookView();
		
		int size = bookList.size();
		
		JPanel[] panelBook = new JPanel[size];
		JButton[] btnBook = new JButton[size];
		
		
		for(int i=0; i<size; i++) {
			BookClass book = bookList.get(i);
			
			panelBook[i] = new JPanel();
			panelBook[i].setBackground(new Color(236,240,245));
			btnBook[i] = new JButton(book.getTitle() + "  " + "( " + book.getQty() + " )");
			
			btnBook[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			panelBook[i].add(btnBook[i]);
			btnBook[i].setFocusPainted(false);
			btnBook[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnBook[i].setBackground(Color.WHITE);
			btnBook[i].setIcon(new ImageIcon(new ImageIcon("uploads/" + book.getImg()).getImage().getScaledInstance(150, 90, Image.SCALE_SMOOTH)));
			btnBook[i].setHorizontalTextPosition(JButton.CENTER);
			btnBook[i].setVerticalTextPosition(JButton.BOTTOM);
			
			
			panelBook[i].add(btnBook[i]);
			panel.add(panelBook[i]);
			
			
			btnBook[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(null, book.numBookAvailable(numBorrow));
					new FormBookUser(book);
					//connect.getNumBorrowBook(numBorrow);
					
				}
			});
		}
		
		if(size < 24) {
			panel.setLayout(new GridLayout(4, 6, 0, 0));
			label = new JLabel[24-size];
			for(int j=0; j<24-size; j++) {
				label[j] = new JLabel();
				panel.add(label[j]);
			}
		}
		else {
			if(size%6 == 0)
				panel.setLayout(new GridLayout(size/6, 6, 0, 0));
			else
				panel.setLayout(new GridLayout(size/6+1, 6, 0, 0));
				
		}

	}

}
