package library;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		LibraryManager manager = (LibraryManager)session.getAttribute("manager");
		
		if (manager != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			LibraryManager.Status i = manager.login(username, password);
			if (i == LibraryManager.Status.USER_AUTH_OK) {
				session.setAttribute("LoggedInUser", manager.getUser(username));
				response.sendRedirect("./Home");
			}
			else if (i == LibraryManager.Status.USER_DOES_NOT_EXIST){
				response.getWriter().print("User does not exist");
			}
		}
		else {
			response.getWriter().print("manager lost, recreate session by registering in");
		}
		
	}

}
