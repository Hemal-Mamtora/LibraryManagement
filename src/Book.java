
public class Book {
	
	enum Status{
		Available,
		Booked
	};
	
	String name;
	String id;
	String author;
	Status status;
	
	Book(String name, String id, String author, Status status){
		this.name = name;
		this.id = id;
		this.author = author;
		this.status = status;
	}
}
