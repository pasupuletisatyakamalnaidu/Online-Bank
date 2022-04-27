package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginDao {
	public boolean Uservalidation(String userName, String password) {
		Connection connection = null;
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/niteesh", "root", "Niteesh@511");

		String sql = "select * from UserCreation where userid=? and pwd=?";
		
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, password);
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

