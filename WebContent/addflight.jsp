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

<h1>Administrator Page</h1>
<br>
<hr>
<br>

<p>Flight Id : <input type = "text" name = "flightid"></p>
<p>Flight Name : <input type = "text" name = "flightname"></p>
<p>Flight Capacity : <input type = "text" name = "flightcapacity"></p>
<p>Flight Max. Speed : <input type = "text" name = "flightspeed"></p>
<p>Flight Provider : <input type = "text" name = "flightprovider"></p>

<input type = "submit" value = "Add Flight">

</div>
</form>
</body>
</html>