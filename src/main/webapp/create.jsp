<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Create</title>
    </head>
    <body>
        <h1>Create</h1>
        <form method="POST" action="create">
            <p>
                <label>
                    Name:
                    <input type="text" name="name" />
                </label>
            </p>
            <p>
                <label>
                    Email:
                    <input type="email" name="email" />
                </label>
            </p>
            <p>
                <label>
                    Phone:
                    <input type="text" name="phone" />
                </label>
            </p>
            <p>
                <input type="submit" value="Submit" />
            </p>
        </form>
        
    </body>
</html>