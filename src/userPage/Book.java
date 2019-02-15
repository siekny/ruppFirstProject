package userPage;

import javax.swing.JPanel;

import popForm.BookGrid;
import popForm.BookList;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class Book extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelContent, panel;
	private JButton btnReload, btnList, btnGrid;
	
	private BookGrid grid;
	private BookList list;


	/**
	 * Create the panel.
	 */
	public Book() {
		
		initialize();
		//initObjects();
		initClass();

	}
	
	public void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		panelContent = new JPanel();
		add(panelContent);
		panelContent.setLayout(new BorderLayout(10, 20));
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(236,240,245));
		panelContent.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel panelReload = new JPanel();
		panelTop.add(panelReload, BorderLayout.WEST);
		panelReload.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnReload = new JButton("Reload");
		btnReload.setFocusPainted(false);
		btnReload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelReload.add(btnReload);
		
		JPanel panelOptionList = new JPanel();
		panelTop.add(panelOptionList, BorderLayout.CENTER);
		
		btnList = new JButton("List");
		btnList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelOptionList.add(btnList);
		btnList.setFocusPainted(false);
		
		btnGrid = new JButton("Grid");
		btnGrid.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelOptionList.add(btnGrid);
		btnGrid.setFocusPainted(false);
		
		panel = new JPanel();
		panel.setBackground(new Color(236,240,245));
		panelContent.add(panel, BorderLayout.CENTER);
		
		btnReload.addActionListener(this);
		btnList.addActionListener(this);
		btnGrid.addActionListener(this);
		
		
		
	}

	public void initClass() {
		grid = new BookGrid();
		list = new BookList();
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(grid);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnReload)
			loadBook();
		else if(e.getSource() == btnList)
			listBook();
		else if(e.getSource() == btnGrid)
			gridBook();
		
	}
	
	public void loadBook() {
		initClass();
	}
	
	public void listBook() {
		panel.add(list);
		grid.setVisible(false);
		list.setVisible(true);
	}
	
	public void gridBook() {
		panel.add(grid);
		list.setVisible(false);
		grid.setVisible(true);
	}
}
