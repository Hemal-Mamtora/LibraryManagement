

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reserve
 */
@WebServlet("/Reserve")
public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BooksDAO DAOBooks = new BooksDAO();
		try {
			List<Book> books = DAOBooks.get();
			
			request.setAttribute("books", books);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Reserve.jsp");
            
			dispatcher.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int bookid = Integer.parseInt(request.getParameter("books"));
			
			Connection con = DatabaseConnection.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("insert into Reservation(bookid, username, fromDate, toDate, returned) values (?, ?, ?, ?, ?)");
			
			
			
			
			java.util.Date dateFrom = new java.util.Date();
			
			Calendar c = Calendar.getInstance();
			c.setTime(dateFrom);
			c.add(Calendar.DAY_OF_YEAR, 7);
			
			java.util.Date dateTo = c.getTime();
			
			st.setInt(1, bookid);
			st.setString(2, request.getUserPrincipal().getName());
			st.setDate(3, new Date(dateFrom.getTime()));
			st.setDate(4, new Date(dateTo.getTime()));
			st.setBoolean(5, false);
			
			st.executeUpdate();
			
			PreparedStatement s2 = con.prepareStatement("update Book set copies = copies - 1 where id = ?;");
			s2.setInt(1, bookid);
			
			s2.executeUpdate();
			
			con.close();
			st.close();
			s2.close();
			response.getWriter().print("Book reserved sucessfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
