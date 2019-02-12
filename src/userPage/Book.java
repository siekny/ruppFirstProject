package userPage;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

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
		panel.setBackground(Color.WHITE);
		panelContent.add(panel, BorderLayout.CENTER);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255));
		panelContent.add(panelTop, BorderLayout.NORTH);
		
		JButton btnList = new JButton("List");
		panelTop.add(btnList);
		
		JButton btnGrid = new JButton("Grid");
		panelTop.add(btnGrid);
		
		
		
	}

	public void initObjects () {
		
		int size = 20;
		
		panel.setLayout(new GridLayout(size/6+1, 6, 0, 0));
		
		JPanel[] panelBook = new JPanel[size];
		JButton[] btnBook = new JButton[size];
		
		for(int i=0; i<size; i++) {
			
			panelBook[i] = new JPanel();
			btnBook[i] = new JButton("Book" + i + "     " + "( " + i + " )");
			
			btnBook[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			panelBook[i].add(btnBook[i]);
			btnBook[i].setFocusPainted(false);
			btnBook[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnBook[i].setBackground(Color.WHITE);
			btnBook[i].setIcon(new ImageIcon("images/image_1.png"));
			btnBook[i].setHorizontalTextPosition(JButton.CENTER);
			btnBook[i].setVerticalTextPosition(JButton.BOTTOM);
			
			
			panelBook[i].add(btnBook[i]);
			panel.add(panelBook[i]);
		}
	}
}
