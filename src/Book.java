
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
	public String getName() {
		return name;
	}
	public int getCopies() {
		return copies;
	}
}
