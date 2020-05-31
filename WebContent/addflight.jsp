<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flight</title>
</head>
<body>
<form action="addnewflight" method = "post">
<div align = "center">

<h1>Add Flight</h1>
<br>
<hr>
<br>

<p>Flight Id : <input type = "text" name = "flightid"></p>
<p>Flight Name : <input type = "text" name = "flightname"></p>
<p>Flight Capacity : <input type = "text" name = "flightcapacity"></p>
<p>Flight Max. Speed : <input type = "text" name = "flightspeed"></p>
<p>Flight Provider : <input type = "text" name = "flightprovider"></p>

<input type = "submit" value = "Add Flight">

<p><a href = "./manageflight.jsp">Back to Manage Flight Page</a></p>
<p><a href = "./adminpage.jsp">Back to Main Menu</a></p>
<p> <a href = "./welcome.jsp">Back to Welcome Page</a> </p>

</div>
</form>
</body>
</html>