package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.transactions;

public class UserTransactionHistoryDao {

	public List<transactions> transaction(String userName,String fromDate,String toDate) {
		Connection connection = null;
		List<transactions>t1=new ArrayList<transactions>();
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/niteesh", "root", "Niteesh@511");

		String sql = "select * from transactions where userid=?";
		
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, userName);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
            transactions t=new transactions();
            t.setUserId(rs.getString("userid"));
            t.setChoice(rs.getString("optionss"));
            t.setAmount(rs.getString("amount"));
            t.setBalance(rs.getString("balance"));
            t.setDate(rs.getTimestamp("date"));
            t1.add(t);
 
		}
	} 
	
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	} 
		
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return t1;
		
  }

	
}

