<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
</head>
<body>
<h2>Booking in Progress</h2>
<br>
<hr>
<br>
<form action = "bookingconfirmation" method = "post">
<% String d = (String)request.getAttribute("flightdetail"); %>
<input type = "hidden" value = d name = "fdetail">

<div align = "center">
<h3>Passenger Details</h3>
<p>Enter Name : <input type = "text" name = "name"></p>
<p>Enter email : <input type = "email" name = "email"></p>
<p>Enter Phone : +91 <input type="tel" id="phone" name="phone" pattern="[0-9]{10}"> </p>

<br>
<hr>
<br>
<h3>Payment Details</h3>
<p> Enter your Card Number : <input type = "number" name = "cnumber"> </p>
<p> Enter Name on the Card : <input type = "text" name = "chname"> </p>
<p> Enter Validity date : <input type = "date" name = "vdate" ></p>
<p> Enter CVV : <input type = "number" name = "cvv" pattern = "[0-9]{3}"></p>


<p><input type = "submit" value = "Book Ticket">

</div>


</form>

</body>
</html>