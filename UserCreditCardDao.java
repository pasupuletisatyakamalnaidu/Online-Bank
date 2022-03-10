package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCreditCardDao {

	public boolean validation(String userName,String card,String cvv) {
		Connection connection = null;
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/niteesh", "root", "Niteesh@511");

		String sql = "select * from creditcard where cardNumber=? and cvv=?";
		
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, card);
		ps.setString(2, cvv);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		 return true;
		}
		else {
			return false;
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
		return false;
	}
}
