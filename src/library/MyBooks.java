package library;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyBooks
 */
@WebServlet("/MyBooks")
public class MyBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BooksDAO DAO = new BooksDAO();
		List<ReservationEntry> list = DAO.mine(request.getUserPrincipal().getName());
		Map<Integer, String> hm = DAO.map();
		
		request.setAttribute("list", list);
		request.setAttribute("hm", hm);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MyBooks.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BooksDAO DAO = new BooksDAO();
		try {
			DAO.returnBook(Integer.parseInt(request.getParameter("id")),
					Integer.parseInt(request.getParameter("bookid")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("./MyBooks");
	}

}
