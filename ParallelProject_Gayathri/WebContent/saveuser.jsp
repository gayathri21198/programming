
<!DOCTYPE html>
<%-- <%@ page import ="com.ibm.pp.dao.UserRegistration" %>
<%@ page contentType="text/html"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%
     RequestDispatcher rd = request.getRequestDispatcher("/register");
     rd.forward(request, response);
%>
 --%>
 
 <%@ include file = "logininc.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<td>Register with the required details</td>
</head>
<body>

<form name = " Registration Form" method ="post" action = "registrationservice">
<br><br>
<input type="text" placeholder="FullName" name="name" >
<br><br>
<input type ="text" placeholder ="Email ID" name="email">
<br><br>
<input type ="text" placeholder ="Password" name = "password">
<br><br>

<input type = "submit"  value ="REGISTER"> 

</body>
</html>