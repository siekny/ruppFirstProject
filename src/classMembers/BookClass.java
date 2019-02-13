package classMembers;

public class BookClass {
	private int id;	// is primary key of books table
	private String isbn;
	private String title;
	private String image;
	private int qty;
	private String publisher;
	private int publishedYear;
	private double price;
	private String author;
	private int edition;
	private int status;
	
	public BookClass(int id, String isbn, String title, String image, int qty, String publisher, int publishedYear, double price,
			String author, int edition, int status) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.image = image;
		this.qty = qty;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
		this.price = price;
		this.author = author;
		this.edition = edition;
		this.status = status;
	}
	
	public int getID() {
		return id;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
