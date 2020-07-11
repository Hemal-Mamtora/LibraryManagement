import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetBooks {
	
	List<Book> get() throws Exception{
		List<Book> books = new ArrayList<Book>();
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("Select * from Book Order by name");
			
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int copies = result.getInt("copies");
				if (copies > 1)
					books.add(new Book(id, name, copies));
			}
			st.close();
			con.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
	Map<Integer, String> map(){
		Map<Integer, String> hm = new HashMap<Integer, String>();
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("Select * from Book;");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				hm.put(id, name);
			}
			
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return hm;	
	}
	
	List<ReservationEntry> mine(String username){
		List<ReservationEntry> list = new ArrayList<ReservationEntry>();
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("Select * from Reservation where username = '"+username+"' and returned = 0");
			
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int id = result.getInt("id");
				int bookid = result.getInt("bookid");
				Date fromDate = result.getDate("fromDate");
				Date toDate = result.getDate("toDate");
				boolean returned = result.getBoolean("returned");
				list.add(new ReservationEntry(id, bookid,username,fromDate,toDate,returned));
			}
			
			st.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
