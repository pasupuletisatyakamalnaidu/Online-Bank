<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.transactions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Information</title>
</head>
<body>
<h3>Previous Transactions Information </h3>

<% List<transactions> t1 = (List<transactions>)request.getAttribute("t1");
 
if(t1.size()>0){
    for(transactions t11 : t1)
    {
        out.print("Account Number: " + t11.getUserId());
        out.print("<br/>");
        out.print("Type: " +t11.getChoice());
        out.print("<br/>");
        out.print("Amount "+t11.getChoice()+"ed "+ t11.getAmount());
        out.print("<br/>");
        out.println("Current Balance: "+t11.getBalance());
        out.print("<br/>");
        out.println("Time: "+t11.getDate());
        out.print("<br/>");
        out.println("      ");
        out.print("<br/>");
    }
   
}
else{
	out.println("No transactions");
}

 
%>
<br>
 <a href="index.jsp">Click here to logout</a>
 <br>
  <a href="bankservices.jsp">Click here to go back</a>
</body>
</html>