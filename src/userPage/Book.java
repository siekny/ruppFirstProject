package userPage;

import javax.swing.JPanel;

import classMembers.BookClass;
import connection.UserConnection;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Book extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelContent, panel;


	/**
	 * Create the panel.
	 */
	public Book() {
		
		initialize();
		initObjects();

	}
	
	public void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		panelContent = new JPanel();
		add(panelContent);
		panelContent.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(236,240,245));
		panelContent.add(panel, BorderLayout.CENTER);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(236,240,245));
		panelContent.add(panelTop, BorderLayout.NORTH);
		
		JButton btnList = new JButton("List");
		panelTop.add(btnList);
		
		JButton btnGrid = new JButton("Grid");
		panelTop.add(btnGrid);
		
		
		
	}

	public void initObjects () {
		
		UserConnection connect = new UserConnection();
		ArrayList<BookClass> bookList = connect.bookView();

		int size = connect.countBooks();
		
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
					JOptionPane.showMessageDialog(null, book.getID());
					
				}
			});
		}
		
		if(size < 24) {
			panel.setLayout(new GridLayout(4, 6, 0, 0));
			JLabel[] label = new JLabel[24-size];
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
