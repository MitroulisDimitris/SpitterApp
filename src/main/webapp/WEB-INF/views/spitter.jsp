<%@ page import="spitter_maven.entities.Spitter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Spitter List</title>
</head>
<body>
<h1>Spitter List</h1>
<table border="1">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Retrieve the list of Spitters from the request attribute
        List<Spitter> spitters = (List<Spitter>) request.getAttribute("spitters");
        if (spitters != null) {
            for (Spitter spitter : spitters) {
    %>
    <tr>
        <td><%= spitter.getFirstName() %></td>
        <td><%= spitter.getLastName() %></td>
        <td><%= spitter.getPassword() %></td>

    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">No Spitters Found</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
