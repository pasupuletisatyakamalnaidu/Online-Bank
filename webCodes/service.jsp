<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Page</title>
</head>
<body>
<h1>Transaction Page</h1>
<form action="service" method="post" >
   <table style="with: 80%">
   <tr>
     <td>Enter Account Number</td>
     <td><input type="text" name="userName" /></td>
    </tr>
    
    <tr>
    <label for="choice">Choose a option:</label>
     <select name="choice">
    <option value="credit">credit</option>
    <option value="debit">debit</option>
  	</select>
  	<br>
    </tr>
    <tr>
     <td>Enter Amount</td>
     <td><input type="text" name="amount" /></td>
    </tr>
   </table>
   
   <input type="submit" value="Submit" />
   
</body>
</html>