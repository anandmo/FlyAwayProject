<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ page import="java.util.List" %>
    <%@ page import="com.flyaway.daoimpl.AdminDaoImpl" %>
    <%@ page import="com.flyaway.model.PlaceObject" %>
    <%@ page import="com.flyaway.model.FlightObject" %>
    <%@ page import="java.util.Iterator" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>

<table>
<tr><td><a href="./adminLogin.jsp">Administrator</a></td>
<td>  </td>
<td><a href="./createAccount.jsp">SignUp</a></td>
<td>  </td>
<td><a href="./userLogin.jsp">Login</a></td>
</table>

<h2 align = "center">Book A Flight Now !!</h2>
<br>
<hr>
<br>
<form action = "findflight" method = "post">

<div align = "center">

<label>Boarding</label>
<select name = "fromplace" class = "form-control" style = "width: 250px;">
<option value = -1 >From</option>
<%
AdminDaoImpl admindaoimpl = new AdminDaoImpl();
PlaceObject tempplaceobject;
List<PlaceObject> placelist = admindaoimpl.fetchAllPlaceInDB();
Iterator<PlaceObject> placeiterator = placelist.iterator();
while(placeiterator.hasNext()){
	tempplaceobject = placeiterator.next();
    %>
      <option value = <%= tempplaceobject.getCityname() %> > <%= tempplaceobject.getCityname() %> </option>
    <% 
}
%>
</select>

&nbsp;
&nbsp;
<label>Destination</label>
<select name = "toplace" class = "form-control" style = "width: 250px;">
<option value = -1 >To</option>
<%
Iterator<PlaceObject> placeiterator2 = placelist.iterator();
while(placeiterator2.hasNext()){
	tempplaceobject = placeiterator2.next();
    %>
      <option value = <%= tempplaceobject.getCityname() %> > <%= tempplaceobject.getCityname() %> </option>
    <% 
}
%>
</select>   
  
<br>
<br>

 <p> Date of Travel : <input type = "date" name = "dateoftravel">   
 <p> How people are traveling with you : <input type = "number" placeholder = "0" min = "0" max = "10" name = "cop">
 
 
  <br>
  <br>
   <input type = "submit" value = "Find Flights"> 
   
   
   <br>
   <br>

 
   </div>

</form>

</body>
</html>