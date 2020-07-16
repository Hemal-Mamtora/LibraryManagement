package library;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		LibraryManager manager = (LibraryManager)session.getAttribute("manager");
		Person user = (Person)session.getAttribute("LoggedInUser");
		
		if (manager != null){
			List<ReservationEntry> list = manager.getMyReservations(user);
			Map<Integer, Book> books = manager.getBooksAsMap();
			
			request.setAttribute("list", list);
			request.setAttribute("books", books);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("MyBooks.jsp");
			dispatcher.forward(request, response);
		}
		else {
			writer.print("Session Expired");
		}
		
		//BooksDAO DAO = new BooksDAO();
		//List<ReservationEntry> list = DAO.mine(request.getUserPrincipal().getName());
		//Map<Integer, String> hm = DAO.map();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		LibraryManager manager = (LibraryManager)session.getAttribute("manager");
		//Person user = (Person)session.getAttribute("LoggedInUser");
		
		try {
			if (manager!=null){
				manager.returnBook(Integer.parseInt(request.getParameter("id")),
						Integer.parseInt(request.getParameter("bookid")));
			}
			else {
				writer.println("Session Expired");
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./MyBooks");
	}

}
