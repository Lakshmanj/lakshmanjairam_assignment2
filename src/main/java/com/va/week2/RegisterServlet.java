package com.va.week2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
//	private RegisterDao rtDao;
	private RegisterDao rtDao = new RegisterDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
//		String userId = request.getParameter("userId"); -- wasnt included in the client side, so commented out temporarily.
		String password = request.getParameter("password");

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobileNumber");

		System.out.println("User: " + username);
		System.out.println("Email: " + email);
		System.out.println("Mobile: " + mobile);



		RegisterForm rf = new RegisterForm();
//		rf.setUser_id(userId);
		rf.setUsername(username);
		rf.setPassword(password);
		rf.setEmail(email);
		rf.setMobileNumber(mobile);
		
		/*add the database code here.. */

		// this is for calling the insert method from the DAO
		String result = rtDao.registerForm(rf);

		response.setContentType("text/html");
		response.getWriter().println("<html><body style='text-align:center; font-family:Arial;'>");


		/* Call the specfic method you wish .. */


		// this is to verify that the insertion was a success
		if(result.equals("Data entered successfully")) {
			response.getWriter().println("<h1 style='color:green;'>Registration Successful!</h1>");
			response.getWriter().println("<p><b>Username:</b> " + username + "</p>");

			// testing to see if the select logic works by calling it
			response.getWriter().println("<hr><h3>Registered Users:</h3><ul style='list-style-position: inside;'>");
			for(RegisterForm user : rtDao.getAllUsers()) {
				response.getWriter().println("<li>" + user.getUsername() + " (" + user.getEmail() + ")</li>");
			}
			response.getWriter().println("</ul>");

		} else {
			response.getWriter().println("<h1 style='color:red;'>Registration Failed</h1>");
		}

		response.getWriter().println("<br><a href='RegistrationPage.jsp'>Go Back</a>");
		response.getWriter().println("</body></html>");

	}

}
