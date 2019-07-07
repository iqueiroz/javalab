<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h1>Contacts</h1>
        <table border="1" width="80%">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${contacts}" var="contact">
                <tr>
                    <td>${contact.id}</td>
                    <td>${contact.name}</td>
                    <td>${contact.email}</td>
                    <td>${contact.phone}</td>
                    <td>
                        <a href="delete?id=${contact.id}">Delete</a>
                        <a href="update?id=${contact.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>

            </tr>
        </table>
        <a href="create">Add new contact</a>
        
    </body>
</html>