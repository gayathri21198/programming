<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

 <%@ include file = "logininc.jsp" %>
 
<%-- <%@ include file = "login.jsp" %> --%> 
<html>
<head>
<meta charset="ISO-8859-1">
<td>Facilities Provided</td>
<br>
<br>
</head>
<body>

<%
if(session.getAttribute("username")!=null && session.getAttribute("pwd")!=null)
{

%>
<td>Welcome and Choose any of the options</td>

<a href="CreateAccount.jsp"> Create Account</a>
<br>
<br>
<a href = "deposit.jsp">Deposit</a>
<br>
<br>
<a href ="withdraw.jsp">Withdraw</a>
<br>
<br>
<a href = "fetchaccountdetails.jsp">Fetch Account Details</a>
<br>
<br>
<a href = "checkbalance.jsp">Check Balance</a>
<br>
<br>
<a href = "fundtransfer.jsp">Fund Transfer</a>
<br>
<br>
<a href = "printTransaction.jsp">Print Transactions</a>

<%
}
%>
<br>
<br>
<%@ include file ="logout.jsp" %>
</body>
</html>