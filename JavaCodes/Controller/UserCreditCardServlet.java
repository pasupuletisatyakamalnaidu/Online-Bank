package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserCreditCardDao;
import Dao.UserTransactionEntryDao;
import Dao.UserTransactionServiceDao;

/**
 * Servlet implementation class UserCreditCardServlet
 */
@WebServlet("/card")
public class UserCreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreditCardServlet() {
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
	UserTransactionEntryDao userEntryTransactionDao=new UserTransactionEntryDao();
	UserCreditCardDao userCreditCardDao=new UserCreditCardDao();
	UserTransactionServiceDao userTransactionServiceDao=new UserTransactionServiceDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String cardNumber=request.getParameter("cardNumber");
		String cvv=request.getParameter("cvv");
		String amount=request.getParameter("amount");
		
		if(userCreditCardDao.validation(userName, cardNumber, cvv)) {
			int i=userTransactionServiceDao.Usertransaction(userName,"debit",amount);
			if(i!=0) {
				try {
					userEntryTransactionDao.entry(userName,"Credit Card Transaction",amount,String.valueOf(i));
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
		else {
			response.sendRedirect("CardNotIssued.jsp");
		}

		doGet(request, response);
	}

}
