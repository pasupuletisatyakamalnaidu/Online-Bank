package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.*;
import model.User;
/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/registration")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	UserRegistrationDao userRegistrationDao=new UserRegistrationDao();
    public UserRegistrationServlet() {
        // TODO Auto-generated constructor stub
    	super();
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
		
		String name=request.getParameter("Name");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		String balance =request.getParameter("balance");
		User user=new User();
		
		user.setName(name);
		user.setDob(dob);
		user.setEmail(email);
		user.setAddress(address);
		user.setPassword(password);
		user.setBalance(balance);
		
		try {
			String iden=(userRegistrationDao.RegistrationDao(user));
			if(iden!="Exist") {
				request.setAttribute("balance",iden );
				request.getRequestDispatcher("registrationSuccess.jsp").forward(request, response);
				
			}
			else {
				response.sendRedirect("existingUserError.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
