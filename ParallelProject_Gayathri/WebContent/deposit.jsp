<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<td>Deposit Action</td>
</head>
<body>
<form action="depositservice" method ="post">

<input type ="text" placeholder="Amount to be deposited" name="amount">
<br>
<br>
<td>Enter the Account Number to be deposited : </td>
<br>
<br>
<input type="text" placeholder ="AccountID" name="accid">
<br>
<br>
<input type ="submit" value="DEPOSIT">

</body>
</html>