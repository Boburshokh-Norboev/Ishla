package wt.javaee.javaee.web;

import wt.javaee.javaee.dao.UserDao;
import wt.javaee.javaee.model.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.sendRedirect("register/register.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User employee = new User();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);

		try {
			int result = userDao.registerEmployee(employee);
			if(result == 1) request.setAttribute("NOTIFICATION", "Muvaffaqiyatli ro'yhatdan o'tdingiz !");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("NOTIFICATION", "Iltimos qaytadan urinib ko'ring!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}


	}
}
