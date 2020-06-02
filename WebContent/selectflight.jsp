<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.flyaway.daoimpl.AdminDaoImpl" %>
    <%@ page import="com.flyaway.model.PlaceObject" %>
    <%@ page import="com.flyaway.model.FlightObject" %>
    <%@ page import="com.flyaway.model.FlightScheduleObject" %>
    <%@ page import="java.util.Iterator" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Flight</title>
</head>
<body>
<form action="bookflight" method = "post">
<div align = "center">
<h1>Select A Flight</h1>
<br>
<hr>
<br>

<table border ="1" > 
         <tr bgcolor="00FF7F"> 
         <th><b>Flight Id</b></th>
          <th><b>Flight Name</b></th> 
          <th><b>Boarding</b></th> 
          <th><b>Destination</b></th> 
          <th><b>Date</b></th> 
          <th><b>Time</b></th> 
         </tr>   
        <% AdminDaoImpl admindaoimpl = new AdminDaoImpl();
        if(request.getAttribute("flightschedulelist") != null){
        
        @SuppressWarnings("unchecked")
        ArrayList<FlightScheduleObject> fslist = (ArrayList<FlightScheduleObject>)request.getAttribute("flightschedulelist"); 
        
        for(FlightScheduleObject s:fslist){%> 

            <tr> 
                <td><%=s.getFlightid()%></td> 
                <td><%=s.getFlightName()%></td> 
                <td><%=s.getFromplace()%></td> 
                <td><%=s.getToplace()%></td>
                <td><%=s.getDateoftravel()%></td> 
                <td><%=s.getDepaturetime()%></td> 
                 <td><input type= "submit" value = "Book Now" name = <%=s.getFlightid() %>>
            </tr> 
            <%} } else {
            
            }
 
            %> 
        </table>  

</div>
</form>

</body>
</html>