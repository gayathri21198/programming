<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href = " index.jsp">Home</a>
<br><br>
<%
   if((session.getAttribute("userid")!=null))
   {
    %>
    <a href = "Welcome.jsp">My account</a>
    <br><br>
    <a href = "logout.jsp">Logout</a>
<%
   }
   %>


</body>
</html>