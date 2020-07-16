package library;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
//import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryManager {
	HashMap<String, Person> users = new HashMap<>(); //username
	HashMap<Integer, Book> books = new HashMap<>(); // id
	HashMap<Integer, ReservationEntry> entries = new HashMap<>(); //id
	int i = 0;
	public static enum Status{
		USER_INSERTED,
		USER_ALREADY_EXISTS,
		USER_DOES_NOT_EXIST,
		USER_AUTH_OK,
		USER_AUTH_ERR,
		BOOK_INSERTED,
		BOOK_COPIES_UPDATED,
		BOOK_RESERVED
	}
	
	Status registerUser(Person user){
		if(users.containsKey(user.getUsername()))
			return Status.USER_ALREADY_EXISTS;
		users.put(user.username, user);
		return Status.USER_INSERTED;
	}
	
	Status login(String username,String password) {
		Person user = users.get(username);
		
		if (user == null) {
			System.out.println("User with username: "+ username + " does not exist");
			return Status.USER_DOES_NOT_EXIST;
		}
			
		if (user.getPwd().equals(password)){
			return Status.USER_AUTH_OK;
		}
		return Status.USER_AUTH_ERR;
	}
	
	Person getUser(String username) {
		return users.get(username);
	}

	public Status addBook(Book book) {
		
		Book libBook = books.get(book.getId()); 
		
		if (libBook != null) {
			libBook.setCopies(libBook.getCopies() + book.copies);
			return Status.BOOK_COPIES_UPDATED;
		}
		else {
			books.put(book.getId(), book);
			return Status.BOOK_INSERTED;
		}
	}

	public List<Book> getAvailableBooks() {
		
		ArrayList<Book> bookList = (ArrayList<Book>) books.entrySet().stream()
			.filter(bk -> bk.getValue().getCopies() > 0)
			.map(java.util.Map.Entry::getValue)
			.collect(Collectors.toList());
		
		return bookList;
	}

	public Status reserveBook(int bookid, Person person) {
		i++;
		Calendar calendar = Calendar.getInstance();
		Date start = calendar.getTime();
		calendar.setTime(start);
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		Date end = calendar.getTime();
		
		entries.put(i,
			new ReservationEntry(
				i,
				bookid,
				person.getUsername(),
				start,
				end,
				false
			)
		);
		
		int copies = books.get(bookid).getCopies() - 1;
		
		books.get(bookid).setCopies(copies);
		
		return Status.BOOK_RESERVED;
	}

	public List<ReservationEntry> getMyReservations(Person person) {
		
		ArrayList<ReservationEntry> list = (ArrayList<ReservationEntry>)entries.entrySet().stream()
			.filter(entry -> person.getUsername().equals(entry.getValue().getUsername()) && !entry.getValue().isReturned())
			.map(java.util.Map.Entry::getValue)
			.collect(Collectors.toList());
		
		return list;
	}

	public Map<Integer, Book> getBooksAsMap() {
		return books;
	}

	public void returnBook(int id, int bookid) {
		
		entries.get(id).setReturned(true);
		
		int copies = books.get(bookid).getCopies() + 1;
		books.get(bookid).setCopies(copies);
		
	}
}
