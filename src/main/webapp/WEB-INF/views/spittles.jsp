<%@ page import="spitter_maven.entities.Spittle" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Spittle List</title>
</head>
<body>
<h1>Spittle List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Content</th>
        <th>Date Posted</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Retrieve the list of spittles from the request attribute
        List<Spittle> spittles = (List<Spittle>) request.getAttribute("spittles");
        if (spittles != null) {
            for (Spittle spittle : spittles) {
    %>
    <tr>
        <td><%= spittle.getContent() %></td>
        <td><%= spittle.getDatePosted() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">No Spittles Found</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
