<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.flyaway.daoimpl.AdminDaoImpl" %>
    <%@ page import="com.flyaway.model.PlaceObject" %>
    <%@ page import="java.util.Iterator" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Place</title>
</head>
<body>
<form action = "deleteplace" method = "post">
<div align="center">
<h2>Delete Place</h2>
<br>
<hr>
<br>
<label>Select Place to delete</label>
<select name = "place" class = "form-control" style = "width: 250px;">
<option value = -1 >Select Place</option>
<%
AdminDaoImpl admindaoimpl = new AdminDaoImpl();
PlaceObject tempplaceobject;
List<PlaceObject> placelist = admindaoimpl.fetchAllPlaceInDB();
Iterator<PlaceObject> placeiterator = placelist.iterator();
while(placeiterator.hasNext()){
	tempplaceobject = placeiterator.next();
    %>
      <option value = <%= tempplaceobject.getPincode() %> > <%= tempplaceobject.getCityname() %> </option>
    <% 
}
%>
</select>
<input type = "submit" value = "Delete">
<br>
<p><a href = "./manageplace.jsp"> Back to Manage Place</a></p>
<p><a href = "./adminpage.jsp">Back to Main Menu</a></p>
</div>
</form>
</body>
</html>