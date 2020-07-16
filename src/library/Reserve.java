package library;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		
		LibraryManager manager = (LibraryManager)session.getAttribute("manager");
			
		try {
			
			if(manager != null) {
				List<Book> books = manager.getAvailableBooks();
				request.setAttribute("books", books);
				
			}
			
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
		PrintWriter writer = response.getWriter();
		try {
			
			HttpSession session = request.getSession();
			LibraryManager manager = (LibraryManager)session.getAttribute("manager");
			
			if (manager != null) {
				int bookid = Integer.parseInt(request.getParameter("books"));
				
				manager.reserveBook(bookid, (Person)session.getAttribute("LoggedInUser"));
				writer.print("Book reserved sucessfully");
			}
			else {
				writer.print("Session Expired");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
