package library;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ManageBook.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			HttpSession session = request.getSession();
			
			LibraryManager manager = (LibraryManager)session.getAttribute("manager");
			
			if(manager == null) {
				response.getWriter().println("Session expired, data loss, register again");
				return;
			}
			
			manager.addBook(new Book(
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("name"),
				Integer.parseInt(request.getParameter("copies"))
			));
			
			PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>"); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
		
}
