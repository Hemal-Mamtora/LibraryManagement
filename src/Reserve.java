

import java.io.IOException; 
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
		BooksDAO booksDAO = new BooksDAO();
		try {
			List<Book> books = booksDAO.get();
			
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
			
			BooksDAO booksDAO = new BooksDAO();
			
			booksDAO.reserveBook(bookid, request.getUserPrincipal().getName());
			response.getWriter().print("Book reserved sucessfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
