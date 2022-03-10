package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTransactionEntryDao {

	public void entry(String userName,String option,String amount, String balance)throws ClassNotFoundException,SQLException {
		
		Connection connection = null;
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/niteesh", "root", "Niteesh@511");

		String sql = "INSERT INTO transactions VALUES (?, ?, ?,?,?)";
		 
		
		//create table UserCreation(name varchar[20],userid varchar[20],phoneNumber varchar[10],accountNumber int,balance int);
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,userName);
		statement.setString(2,option);
		statement.setString(3,amount);
		statement.setString(4, balance);
		statement.setTimestamp(5,new java.sql.Timestamp(new java.util.Date().getTime()));
		
		
		statement.executeUpdate();
		
		
	
	}
}

