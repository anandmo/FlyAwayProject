<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>

<table>
<tr><td><a href="./adminLogin.jsp">Administrator</a></td>
<td><a href="./createAccount.jsp">SignUp</a></td>
<td><a href="./userLogin.jsp">Login</a></td>
</table>

<h2 align = "center">Book A Flight Now !!</h2>
<br>
<hr>
<br>
<form action = "findFlight" method = "post">

<div align = "center">
   <table>
   
   <tr>
   <td> From </td>  
   <td><input type = "text"></td>
   </tr>
   
   <tr><td>To</td></tr>
   
   <tr> <td>Destination</td> <td><input type = "text"></td> </tr>
   
   <tr> <td>Journey Date</td> <td><input type = "datetime-local"></td>
   <tr><td><br></td></tr>
   <tr><td><input type = "submit" value = "Find Flights"></td></tr>
   
   
   </table>  
</div>
</form>

</body>
</html>