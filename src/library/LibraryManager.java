package library;
import java.util.HashMap;
//import java.util.List;

public class LibraryManager {
	HashMap<String, Person> users = new HashMap<>(); //username
	HashMap<Integer, Book> books = new HashMap<>(); // id
	HashMap<Integer, ReservationEntry> entries = new HashMap<>(); //id
	
	public static enum Status{
		USER_INSERTED,
		USER_ALREADY_EXISTS,
		USER_DOES_NOT_EXIST,
		USER_AUTH_OK,
		USER_AUTH_ERR;
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
}
