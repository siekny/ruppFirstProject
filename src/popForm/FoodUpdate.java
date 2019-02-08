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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import classMembers.FoodClass;
import connection.DBConnection;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Cursor;

public class FoodUpdate extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblImage, lblId, lblHideImage;
	private JTextField txtFoodid;
	private JTextField txtName;
	private JTextField txtPrice;
	@SuppressWarnings("rawtypes")
	private JComboBox cboCategory;
	private JButton btnUpdateFood, btnImage;
	private String imageName;
	private File selectedPath;
	private String formattedDate;
	
	private Connection conn = DBConnection.connection();

	/**
	 * Create the panel.
	 */
	public FoodUpdate(FoodClass food, int id) {
		initialize();
		getDetailFood(food, id);
		
		JOptionPane.showOptionDialog(null	, contentPane, "Update of a Food", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		panelContent.setPreferredSize(new Dimension(600, 450));
		
		
		JPanel panelImage = new JPanel();
		panelImage.setBackground(new Color(255, 255, 255));
		panelContent.add(panelImage, BorderLayout.NORTH);
		panelImage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("images/image.png"));
		lblImage.setHorizontalTextPosition(JLabel.CENTER);
		lblImage.setVerticalTextPosition(JLabel.BOTTOM);
		panelImage.add(lblImage);
		
		lblHideImage = new JLabel("");
		panelImage.add(lblHideImage);
		
		JPanel panelDetail = new JPanel();
		panelDetail.setBackground(new Color(255, 255, 255));
		panelContent.add(panelDetail, BorderLayout.CENTER);
		
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.WHITE);
		panelDetail.add(panelRight);
		panelRight.setLayout(new BorderLayout(10, 10));
		panelRight.setPreferredSize(new Dimension(400, 350));
		
		JPanel panelHead2 = new JPanel();
		panelHead2.setBorder(new MatteBorder(0, 0, 3, 0, new Color(0,166,90)));
		panelHead2.setBackground(Color.WHITE);
		panelRight.add(panelHead2, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Food Information");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelHead2.add(label);
		
		lblId = new JLabel("ID");
		panelHead2.add(lblId);
		
		JPanel panelContent2 = new JPanel();
		panelContent2.setBackground(Color.WHITE);
		panelRight.add(panelContent2, BorderLayout.CENTER);
		panelContent2.setLayout(new GridLayout(9, 2, 0, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Image : ");
		panelContent2.add(lblNewLabel_1);
		
		btnImage = new JButton("Choose Image");
		btnImage.setFocusPainted(false);
		btnImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImage.setBorderPainted(false);
		btnImage.setBackground(new Color(220, 220, 220));
		panelContent2.add(btnImage);
		
		JLabel label_1 = new JLabel("Food's ID : ");
		panelContent2.add(label_1);
		
		txtFoodid = new JTextField();
		txtFoodid.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panelContent2.add(txtFoodid);
		txtFoodid.setColumns(15);
		
		JLabel label_3 = new JLabel("Name of Food : ");
		panelContent2.add(label_3);
		
		txtName = new JTextField();
		txtName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panelContent2.add(txtName);
		txtName.setColumns(10);
		
		JLabel label_5 = new JLabel("Food Category : ");
		panelContent2.add(label_5);
		
		cboCategory = new JComboBox();
		cboCategory.setFocusable(false);
		cboCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboCategory.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		cboCategory.setBackground(Color.WHITE);
		cboCategory.setModel(new DefaultComboBoxModel(new String[] {"Food", "Drink", "Dessert"}));
		panelContent2.add(cboCategory);
		
		JLabel label_7 = new JLabel("Price : ");
		panelContent2.add(label_7);
		
		txtPrice = new JTextField();
		txtPrice.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panelContent2.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		panelContent2.add(label_2);
		
		JPanel panelButton = new JPanel();
		FlowLayout fl_panelButton = (FlowLayout) panelButton.getLayout();
		fl_panelButton.setAlignment(FlowLayout.RIGHT);
		panelButton.setBackground(new Color(255, 255, 255));
		panelContent2.add(panelButton);
		
		btnUpdateFood = new JButton("Update");
		panelButton.add(btnUpdateFood);
		btnUpdateFood.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateFood.setForeground(new Color(255, 255, 255));
		btnUpdateFood.setFocusPainted(false);
		btnUpdateFood.setBackground(new Color(0,166,90));
		
		btnUpdateFood.addActionListener(this);
		btnImage.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnImage)
				chooseImage();
			else if(e.getSource() == btnUpdateFood)				
					updateFood();

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void getDetailFood(FoodClass food, int id) {
		
		lblImage.setIcon(new ImageIcon(new ImageIcon("images/" +food.getImage()).getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH)));
		txtName.setText(food.getName());
		txtPrice.setText(food.getPrice() + "");
		cboCategory.setSelectedItem(food.getCategory());
		txtFoodid.setText(food.getFoodID());
		lblId.setText(id + "");
		lblImage.setText(food.getImage());
		lblHideImage.setText(food.getImage());
		
	}
	
	public FoodClass getUpdateFood() throws Exception {

		if(txtFoodid.getText().isEmpty())
			throw new Exception("Invalid Food's ID");
		else if(txtName.getText().isEmpty()) 
			throw new Exception("Food Name cannot be null");
		else if(txtPrice.getText().isEmpty())
			throw new Exception("Price cannot be null");
		else if(Double.parseDouble(txtPrice.getText()) <= 0)
			throw new Exception("Price cannot be equal or less than zero");
		
		if(!lblImage.getText().equals(lblHideImage.getText())) {
			BufferedImage img = ImageIO.read(selectedPath);
			
			Date date = new Date();
		    String strDateFormat = "yyyy_MMM_dd_hh_mm_ss";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    formattedDate= dateFormat.format(date);
		    
			String location = "images/" +formattedDate + imageName;
			String format = "PNG";
			
			ImageIO.write(img, format, new File(location));
			
			File file = new File("images/" + lblHideImage.getText());
			file.delete();
		}

    	return  new FoodClass(txtFoodid.getText(), txtName.getText(), Double.parseDouble(txtPrice.getText()), cboCategory.getSelectedItem().toString(), formattedDate + lblImage.getText());

	}
	
	
	public void updateFood() {
		Statement stmt = null;
		try {
			
			stmt = conn.createStatement();
			FoodClass food = getUpdateFood();
			if(food.getImage().equals("")) {
				
			}
			String sql = "update food set foodID = '" + food.getFoodID() + "'" + ", name = '" + food.getName() + "'" + ", price = '" + food.getPrice() + "'" +", category = '" + food.getCategory() + "'" + ", image = '" + food.getImage() + "'" + " WHERE id = '" + Integer.parseInt(lblId.getText()) + "'";
	    	stmt.executeUpdate(sql);
	    	stmt.close();
	    	System.out.println(sql);
	    	JOptionPane.showMessageDialog(null, "Your Data has been updated Succesfully","", JOptionPane.CLOSED_OPTION);
		}catch(Exception e) {
			
		}
	}
	
	public void chooseImage() {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("* .Image", "jpg", "gif", "png", "jpeg");
		filechooser.addChoosableFileFilter(filter);
		
		int result = filechooser.showSaveDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			selectedPath = filechooser.getSelectedFile();
			String path = selectedPath.getAbsolutePath();
			lblImage.setIcon(resizeImage(path));
			imageName = selectedPath.getName();
			lblImage.setText(imageName);
			System.out.println(imageName);
		}
		else if(result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "No Image", "", JOptionPane.OK_OPTION);
		}
	}
	
	//Method To Resize The ImageIcon
    public ImageIcon resizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
	
}
