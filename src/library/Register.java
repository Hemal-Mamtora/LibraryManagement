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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//LibraryManager manager = new LibraryManager();
		
		HttpSession session = request.getSession();
		
		LibraryManager manager = (LibraryManager)session.getAttribute("manager");
		
		if (manager == null) {
			manager = new LibraryManager();
		}
		
		PrintWriter writer = response.getWriter();
		
		String p1 = request.getParameter("password1");
		String p2 = request.getParameter("password2");
		
		if(!p1.equals(p2)) {
			writer.println("passwords do not match. Unable to register");
		}
		else {
			LibraryManager.Status i = manager.registerUser(
				new Person(
					request.getParameter("name"),
					request.getParameter("username"),
					request.getParameter("password1"),
					Boolean.valueOf(request.getParameter("isLibrarian"))
				)
			);
			if (i == LibraryManager.Status.USER_INSERTED) {
				writer.println("User Inserted Successfully");
			}
			else if (i == LibraryManager.Status.USER_ALREADY_EXISTS)
				writer.println("Username already taken, please choose another username");
		}
		session.setAttribute("manager", manager);
	}

}
