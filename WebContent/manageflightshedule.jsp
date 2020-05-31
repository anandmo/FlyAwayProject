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
<title>Flight Schedule</title>
</head>
<body>

<form action = "addflightschedule" method = "post">
   <div align = "center">
   <br>
   <h1>Schedule A Flight</h1>
   <br>
   <hr>
   <br>
   
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
      <option value = <%= tempplaceobject.getPincode() %> > <%= tempplaceobject.getCityname() %> </option>
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
      <option value = <%= tempplaceobject.getPincode() %> > <%= tempplaceobject.getCityname() %> </option>
    <% 
}
%>
</select>   
  
<br>
<br>

<label>Flight</label>
<select name = "flight" class = "form-control" style = "width: 250px;">
<option value = -1 >Select</option>
<%
FlightObject tempflightobject;
List<FlightObject> flightlist = admindaoimpl.fetchAllFlightInDB();
Iterator<FlightObject> flightiterator = flightlist.iterator();
while(flightiterator.hasNext()){
	tempflightobject = flightiterator.next();
    %>
      <option value = <%= tempflightobject.getFlightId() %> > <%= tempflightobject.getFlightName() %> </option>
    <% 
}
%>
</select>      
 <br>  
 <p> Date of Travel : <input type = "date" name = "dateoftravel">   
   &nbsp;
&nbsp;
  <label for="depaturetime">Select a time:</label>
  <input type="time" id="depaturetime" name="depaturetime">  
  <br>
  <br>
   <input type = "submit" value = "Add Flight Schedule"> 
   
   <br>
   <br>
   
   <p><a href = "./manageplace.jsp"> Back to Manage Place</a></p>
<p><a href = "./adminpage.jsp">Back to Main Menu</a></p>
 <p><a href = "./welcome.jsp">Back to Welcome Page</a></p>  
 
   </div>
   
 </form> 
 
 

</body>
</html>