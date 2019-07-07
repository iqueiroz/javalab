<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Create</title>
    </head>
    <body>
        <h1>Create</h1>
        <form method="POST" action="update">
            <p>
                <label>
                    Name:
                    <input type="text" name="name" value="${contact.name}" />
                </label>
            </p>
            <p>
                <label>
                    Email:
                    <input type="email" name="email" value="${contact.email}" />
                </label>
            </p>
            <p>
                <label>
                    Phone:
                    <input type="text" name="phone" value="${contact.phone}" />
                </label>
            </p>
            <p>
                <input type="hidden" name="id" value="${contact.id}" />
                <input type="submit" value="Submit" />
            </p>
        </form>
        
    </body>
</html>