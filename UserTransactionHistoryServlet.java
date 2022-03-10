package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import Dao.UserTransactionHistoryDao;

/**
 * Servlet implementation class UserTransactionServlet
 */
@WebServlet("/History")
public class UserTransactionHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserTransactionHistoryDao userTransactionDao=new UserTransactionHistoryDao();
    public UserTransactionHistoryServlet() {
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
		//String fromDate=request.getParameter("fromDate");
		//String toDate=request.getParameter("ToDate");
		
		List t1=userTransactionDao.transaction(userName,"12","11");
		
		
		RequestDispatcher requestd=request.getRequestDispatcher("transactionData.jsp");
		request.setAttribute("t1", t1);
		requestd.forward(request, response);
		
		
	}

}
