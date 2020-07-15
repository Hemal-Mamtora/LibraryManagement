package library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAO {
	
	boolean register(Person person) throws SQLException {
		
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("insert into Person(name, username, pwd, isLibrarian)"
					+ "values (?,?,?,?)");
			st.setString(1, person.getName());
			st.setString(2, person.getUsername());
			st.setString(3, person.getPwd());
			st.setBoolean(4, person.isLibrarian());
			
			st.executeUpdate();
			
			st.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	Person get() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
