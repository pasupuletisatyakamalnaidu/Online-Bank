<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
</head>
<body>
<h1>User Login</h1>
<form action="login" method="post" >
   <table style="with: 80%">
    <tr>
     <td>Account Number</td>
     <td><input type="text" name="userName" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
   <a href="registration.jsp">New user? Click here for Registration</a>
</body>
</html>