<%@ page import="java.util.*,model.Reservation" %>

<h2>All Reservations</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Room</th>
    <th>CheckIn</th>
    <th>CheckOut</th>
    <th>Amount</th>
    <th>Delete</th>
</tr>

<%
List<Reservation> list = (List<Reservation>)request.getAttribute("list");

if(list != null){
    for(Reservation r : list){
%>
<tr>
    <td><%=r.getId()%></td>
    <td><%=r.getName()%></td>
    <td><%=r.getRoom()%></td>
    <td><%=r.getCheckIn()%></td>
    <td><%=r.getCheckOut()%></td>
    <td><%=r.getAmount()%></td>
    <td><a href="delete?id=<%=r.getId()%>">Delete</a></td>
</tr>
<%
    }
}
%>
</table>

<br>
<a href="index.jsp">Back</a>