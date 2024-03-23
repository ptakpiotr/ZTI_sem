<%--
  Created by IntelliJ IDEA.
  User: piter
  Date: 23.03.2024
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a car</title>
</head>
<body>
    <h1>Add a car</h1>
<form action="managecar" method="POST">
    <div>
        <label for="make">Make</label>
        <input type="string" id="make" name="make" required />
    </div>
    <div>
        <label for="model">Model</label>
        <input type="string" id="model" name="model" required />
    </div>
    <button type="submit">Add</button>
</form>
</body>
</html>
