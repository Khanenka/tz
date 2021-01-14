<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="it.academy.data.DaoFactory"%>
<%@page import="it.academy.data.Expenses"%>
<%@ page import="java.util.List"%>
<html>
<table border="1">
<tr>
<th>num</th>
<th>paydate</th>
<th>receiver</th>
<th>value</th>
</tr>

<% for (Expenses exp:(List<Expenses>)request.getAttribute("expenses")){

out.print("<tr><td>" +exp.getNum()+"</td>");
out.print("<td>" +exp.getPaydate()+"</td>");
out.print("<td>" +exp.getReceiver()+"</td>");
out.print("<td>" +exp.getValue()+"</td></tr>");

} %>
</table>
</html>