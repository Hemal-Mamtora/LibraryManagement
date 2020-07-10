

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageBook
 */
@WebServlet("/ManageBook")
public class ManageBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			Connection con = DatabaseConnection.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("insert into Book(name, copies) values (?, ?)");
			st.setString(1, request.getParameter("name"));
			st.setInt(2, Integer.valueOf(request.getParameter("copies")));
			
			st.executeUpdate();
			st.close();
			con.close();
			
			PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>"); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
		
}
