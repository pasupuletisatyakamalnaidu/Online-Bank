package Dao;
import java.sql.*;

import model.User;
public class UserRegistrationDao {

	public String RegistrationDao(User user) throws ClassNotFoundException,SQLException {
		
		int min = 1000;
	      int max = 10000;
	      int UserId = (int)Math.floor(Math.random()*(max-min+1)+min);
	      String userId=String.valueOf(UserId);
		
		Connection connection = null;
		
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/niteesh", "root", "Niteesh@511");
		
		String query="select * from UserCreation where email=? or userid=?";

		String sql = "INSERT INTO UserCreation VALUES (?, ?, ?, ?,?,?,?)";
		 
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getEmail());
		ps.setString(2, userId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		 
			return "Exist";
		
		}
		else {
			
		//create table UserCreation(name varchar[20],dob varchar[50],email varchar[50],address varchar(20),userid varchar(20),pwd varchar(20));
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,user.getName());
		statement.setString(2,user.getDob());
		statement.setString(3,user.getEmail());
		statement.setString(4, user.getAddress());
		statement.setString(5,userId);
		statement.setString(6,user.getPassword());
		statement.setString(7,user.getBalance());
		int i=statement.executeUpdate();
		  
		return userId;
		}
	
	}
}

	
	
	
