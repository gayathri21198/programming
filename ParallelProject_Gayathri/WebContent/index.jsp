<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<td>Welcome to the Wallet Application</td>

<br>
<br>

</head>
<body>
<%
if(session.getAttribute("userid")==null)
{
%>

 <a href="login.jsp" >Login</a>
<br><br>
<a href="saveuser.jsp">Register</a>

<%
}
%>

<%-- <%@ include file = "logininc.jsp" %> --%>
</body>
</html>







 

