package classMembers;

public class BookClass {
	private int id;	// is primary key of books table
	private String isbn;
	private String title;
	private String image;
	private int qty;
	private double price;
	private String author;
	private int edition;
	private int numBorrow; // check when books have been borrowed
	
	public BookClass() {}
	
	public BookClass(String isbn, String title, String image, int qty, double price,
			String author, int edition, int numBorrow) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.image = image;
		this.qty = qty;
		this.price = price;
		this.author = author;
		this.edition = edition;
		this.numBorrow = numBorrow;
	}
	
	public BookClass(int id, String isbn, String title, String image, int qty, double price,
			String author, int edition, int numBorrow) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.image = image;
		this.qty = qty;
		this.price = price;
		this.author = author;
		this.edition = edition;
		this.numBorrow = numBorrow;
	}
	
	public int numBookAvailable(int numBorrow) {
		return qty - numBorrow;
	}
	
	public Object[] getBookList() {
		return new Object[] {id, isbn, title, author, edition, qty, price, numBookAvailable(numBorrow)};
	}
	
	public Object[] getBookListLIST() {
		return new Object[] {id, isbn, title, author, edition, qty, numBorrow, numBookAvailable(numBorrow)};
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getNumBorrow() {
		return numBorrow;
	}
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	
	
	
	
}
