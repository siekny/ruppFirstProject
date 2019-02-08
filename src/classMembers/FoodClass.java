package classMembers;

public class FoodClass {
	
	private String foodID;
	private String name;
	private double price;
	private String category;
	private String image;
	
	public FoodClass(String foodID, String name, double price, String category, String image) {
		super();
		this.foodID = foodID;
		this.name = name;
		this.price = price;
		this.category = category;
		this.image = image;
	}
	
	public Object[] getRowFood(int id) {
		return new Object[] { id, foodID, name, price, category };
	}

	public String getFoodID() {
		return foodID;
	}

	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
