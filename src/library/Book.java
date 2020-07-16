package library;

public class Book {
	
	enum Status{
		Available,
		Booked
	};
	
	int id;
	String name;
	int copies;
	
	Book(int id, String name, int copies){
		this.name = name;
		this.id = id;
		this.copies = copies;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public String getName() {
		return name;
	}
	public int getCopies() {
		return copies;
	}
}
