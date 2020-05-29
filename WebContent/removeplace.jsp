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
<div align="center">

<label>Select Place to delete</label>
<select class = "form-control" style = "width: 250px;">
<option value = -1 >Select Place</option>
<%
AdminDaoImpl admindaoimpl = new AdminDaoImpl();
List<PlaceObject> placelist = admindaoimpl.fetchAllPlaceInDB();
Iterator<PlaceObject> placeiterator = placelist.iterator();

while(placeiterator.hasNext()){

    %>
      <option><%= placeiterator.next().getCityname() %></option>
    <% 
}

%>

</select>
</div>
</body>
</html>