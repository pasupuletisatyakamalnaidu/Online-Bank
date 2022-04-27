package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTransactionServiceDao {
	 public int Usertransaction(String userName,  String option, String amount) {
	
	Connection connection = null;
	try {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/niteesh", "root", "Niteesh@511");

	String query = "select balance from UserCreation where userid=?";
	
	//String sql = "select * from UserCreation where userid=? and pwd=?";
	
	
	PreparedStatement ps = connection.prepareStatement(query);
	ps.setString(1, userName);
	ResultSet rs = ps.executeQuery();
	if(rs.next()) {
        if(option.equals("credit")) {
        	int balance1 = Integer.valueOf(rs.getString("balance"))+Integer.valueOf(amount);
        	
        	String query1 =  "Update UserCreation Set balance=? Where userid = ?";
        	PreparedStatement ps1 = connection.prepareStatement(query1);
        	ps1.setString(1, String.valueOf(balance1));
        	ps1.setString(2, userName);
        	ps1.executeUpdate();
        	return balance1;
        }
        else {
        	if(Integer.valueOf(rs.getString("balance"))>Integer.valueOf(amount)) {
        		int balance1 = Integer.valueOf(rs.getInt("balance"))-Integer.parseInt(amount);
        		String query1 =  "Update UserCreation Set balance=? Where userid = ?";
            	PreparedStatement ps1 = connection.prepareStatement(query1);
            	ps1.setString(1, String.valueOf(balance1));
            	ps1.setString(2, userName);
            	ps1.executeUpdate();
            	return balance1;
        	}
        	else
        	return 0;
        	}
        }
    
}
catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
} 
	
finally {
	try {
		connection.close();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
}
	return 0;
	
}
}
