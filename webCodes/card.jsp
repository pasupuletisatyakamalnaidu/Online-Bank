<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit Card Transaction</title>
</head>
<body>
<h1>Credit Card Transaction</h1>
<form action="card" method="post" >
   <table style="with: 80%">
    <tr>
     <td>Account Number</td>
     <td><input type="text" name="userName" /></td>
    </tr>
    <tr>
     <td>Credit Card Number</td>
     <td><input type="text" name="cardNumber" /></td>
    </tr>
    <tr>
     <td>CVV</td>
     <td><input type="password" name="cvv" /></td>
    </tr>
    <tr>
     <td>Amount</td>
     <td><input type="text" name="amount" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
   <a href="index.jsp">Log Out</a>
</body>
</html>