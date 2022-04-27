<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h1>User Registration</h1>
  <form action="registration" method="post"  >
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="Name" /></td>
    </tr>
    <tr>
     <td>Date of Birth[DD-MM-YYYY]</td>
     <td><input type="text" name="dob" /></td>
    </tr>
    <tr>
     <td>Aadhar</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Wished Amount to credit during Creation</td>
     <td><input type="text" name="balance" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
   
  </form>
  <a href="login.jsp">Login page</a>
</body>
</html>