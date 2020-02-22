<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<td>Account Creation Details</td>

</head>
<body>

<form action="createaccountservice" name ="Account Details" method = "post">

<input type = "text" placeholder = "Enter your name" name ="customer name">
<br>
<br>
<input type ="text" placeholder ="Contact Number" name="phonenumber">
<br>
<br>
<label for ="Account type"> Account Type :</label><br>
<label for ="Savings">Savings : </label>
<input type ="radio" name ="type" value="savings"><br><br>

<label for ="Fixed">Fixed : </label>
<input type ="radio" name ="type" value ="fixed"><br><br>

<label for = "Checking">Checking : </label>
<input type ="radio" name="type" value="checking"><br><br>

<label for="Balance">Balance : </label> 
<input type = "text" placeholder="Balance" name="balance">
<br>
<br>

<input type="submit" value="SUBMIT">




</body>
</html>