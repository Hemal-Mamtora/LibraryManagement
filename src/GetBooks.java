import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
}
