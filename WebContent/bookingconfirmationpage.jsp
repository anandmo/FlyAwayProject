<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
</head>
<body>

<div align = "center">
<br>
<h2>Booking Details</h2>
<br>

<p><em>Congratulation your flight ticket from <%=request.getAttribute("source") %> to <%= request.getAttribute("destination") %> has been booked successfully </em></p>

<table>

<tr>
<td>Name </td>
<td><%=request.getAttribute("name") %></td>
</tr>

<tr>
<td>Email </td>
<td><%=request.getAttribute("email")%></td>
</tr>

<tr>
<td>Contact Number </td>
<td><%= request.getAttribute("phone") %></td>
</tr>

<tr>
<td> Total Amt. Paid </td>
<td><%= request.getAttribute("cost") %></td>
</tr>

<tr>
<td> Number of Passengers </td>
<td><%= request.getAttribute("count") %> </td>
</tr>

<tr>
<td> Flight Name </td>
<td> <%= request.getAttribute("flightname") %> </td>
</tr>

<tr>
<td> Boarding Airport </td>
<td> <%= request.getAttribute("source") %> </td>
</tr>

<tr>
<td>Destination Airport</td>
<td> <%= request.getAttribute("destination") %> </td>
</tr>

<tr>
<td>Date</td>
<td> <%= request.getAttribute("dateoftravel") %> </td>
</tr>

<tr>
<td>Time</td>
<td> <%= request.getAttribute("time") %> </td>
</tr>

</table>
<br>
<br>
<input type="button" value="Print Ticket" onClick="window.print()">
</div>


</body>
</html>