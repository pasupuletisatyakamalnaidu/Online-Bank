package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserTransactionServiceDao;
import Dao.UserTransactionEntryDao;

/**
 * Servlet implementation class UserServiceServlet
 */
@WebServlet("/service")
public class UserTransactionServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserTransactionServiceDao userServiceDao=new UserTransactionServiceDao();
	UserTransactionEntryDao userEntryTransactionDao=new UserTransactionEntryDao();
    public UserTransactionServiceServlet() {
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
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String option=request.getParameter("choice");
		String amount=request.getParameter("amount");
		
		int i=userServiceDao.Usertransaction(userName,option,amount);
		if(i!=0) {
			try {
				userEntryTransactionDao.entry(userName,option,amount,String.valueOf(i));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("balance", i);
			request.getRequestDispatcher("transactionSuccessful.jsp").forward(request, response);
			
		}
		else {
			response.sendRedirect("insufficientBalance.jsp");
		}
	}

}
