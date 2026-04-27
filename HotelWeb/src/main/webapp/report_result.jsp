<h2>Report Result</h2>

<%
Object total = request.getAttribute("total");
Object from = request.getAttribute("from");
Object to = request.getAttribute("to");

if(total != null){
%>
    <h3>Total Revenue: <%= total %></h3>
<%
}

if(from != null && to != null){
%>
    <h3>Showing results from <%= from %> to <%= to %></h3>
<%
}
%>

<br>
<a href="reports.jsp">Back</a>