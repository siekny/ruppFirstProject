package popForm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.MatteBorder;
import classMembers.FoodClass;
import javax.swing.ImageIcon;

public class FoodDetail extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblFoodID, lblName, lblCategory, lblPrice, lblImage;

	/**
	 * Create the panel.
	 */
	public FoodDetail(FoodClass food) {
		
		initialize();
		getDetailFood(food);
		
		JOptionPane.showConfirmDialog(null	, contentPane, "Detail of a Food", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION);
	}

	public void initialize() {
		setBackground(new Color(236,240,245));
		setLayout(new BorderLayout(0, 0));
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 10));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new MatteBorder(0, 0, 3, 0, new Color(54,127,169)));
		panel.add(panelTitle, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Detail of Employee");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panelTitle.add(lblNewLabel);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		panel.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 10));
		panelContent.setPreferredSize(new Dimension(600, 350));
		
		
		JPanel panelImage = new JPanel();
		panelImage.setBackground(new Color(255, 255, 255));
		panelContent.add(panelImage, BorderLayout.NORTH);
		panelImage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("images/image.png"));
		panelImage.add(lblImage);
		
		JPanel panelDetail = new JPanel();
		panelDetail.setBackground(new Color(255, 255, 255));
		panelContent.add(panelDetail, BorderLayout.SOUTH);
		
		JPanel panelInfoLeft = new JPanel();
		panelDetail.add(panelInfoLeft);
		panelInfoLeft.setBackground(new Color(255, 255, 255));
		panelInfoLeft.setLayout(new BorderLayout(10, 10));
		panelInfoLeft.setPreferredSize(new Dimension(400, 180));
		
		JPanel panelHead = new JPanel();
		panelHead.setBorder(new MatteBorder(0, 0, 3, 0, new Color(0,166,90)));
		panelHead.setBackground(new Color(255, 255, 255));
		panelInfoLeft.add(panelHead, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Food Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelHead.add(lblNewLabel_1);
		
		JPanel panelBody = new JPanel();
		panelBody.setBackground(new Color(255, 255, 255));
		panelInfoLeft.add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(new GridLayout(4, 2, 0, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Food's ID : ");
		panelBody.add(lblNewLabel_3);
		
		lblFoodID = new JLabel("");
		lblFoodID.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelBody.add(lblFoodID);
		
		JLabel lblNewLabel_4 = new JLabel("Name of Food : ");
		panelBody.add(lblNewLabel_4);
		
		lblName = new JLabel("");
		lblName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelBody.add(lblName);
		
		JLabel lblNewLabel_5 = new JLabel("Food Category : ");
		panelBody.add(lblNewLabel_5);
		
		lblCategory = new JLabel("");
		lblCategory.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelBody.add(lblCategory);
		
		JLabel lblNewLabel_6 = new JLabel("Price : ");
		panelBody.add(lblNewLabel_6);
		
		lblPrice = new JLabel("");
		lblPrice.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(220, 220, 220)));
		panelBody.add(lblPrice);
		
//		JPanel panelRight = new JPanel();
//		panelRight.setBackground(Color.WHITE);
//		panelDetail.add(panelRight);
//		panelRight.setLayout(new BorderLayout(10, 10));
//		
//		JPanel panelHead2 = new JPanel();
//		panelHead2.setBorder(new MatteBorder(0, 0, 3, 0, new Color(0,166,90)));
//		panelHead2.setBackground(Color.WHITE);
//		panelRight.add(panelHead2, BorderLayout.NORTH);
//		
//		JLabel label = new JLabel("Food Information");
//		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		panelHead2.add(label);
//		
//		JPanel panelContent2 = new JPanel();
//		panelContent2.setBackground(Color.WHITE);
//		panelRight.add(panelContent2, BorderLayout.CENTER);
//		panelContent2.setLayout(new GridLayout(7, 2, 0, 10));
//		
//		JLabel label_1 = new JLabel("Food's ID : ");
//		panelContent2.add(label_1);
//		
//		txtFoodid = new JTextField();
//		txtFoodid.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
//		panelContent2.add(txtFoodid);
//		txtFoodid.setColumns(15);
//		
//		JLabel label_3 = new JLabel("Name of Food : ");
//		panelContent2.add(label_3);
//		
//		txtName = new JTextField();
//		txtName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
//		panelContent2.add(txtName);
//		txtName.setColumns(10);
//		
//		JLabel label_5 = new JLabel("Food Category : ");
//		panelContent2.add(label_5);
//		
//		JComboBox cboCategory = new JComboBox();
//		cboCategory.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
//		cboCategory.setBackground(Color.WHITE);
//		cboCategory.setModel(new DefaultComboBoxModel(new String[] {"Food", "Drink", "Dessert"}));
//		panelContent2.add(cboCategory);
//		
//		JLabel label_7 = new JLabel("Price : ");
//		panelContent2.add(label_7);
//		
//		txtPrice = new JTextField();
//		txtPrice.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
//		panelContent2.add(txtPrice);
//		txtPrice.setColumns(10);
		
	}
	
	public void getDetailFood(FoodClass food) {
		
		lblImage.setIcon(new ImageIcon(new ImageIcon("images/" +food.getImage()).getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH)));
		lblFoodID.setText(food.getFoodID());
		lblName.setText(food.getName());
		lblCategory.setText(food.getPrice() + "");
		lblPrice.setText(food.getCategory());
		
	}
	
}
