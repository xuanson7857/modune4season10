<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/28/2023
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" >

    <label>id</label>
    <input type="text"name="id" value="${listPro.id}" disabled readonly><br><br>

    <label>name</label>
    <input type="text"name="name" value="${listPro.name}" required><br><br>

    <label >price</label>
    <input type="number" value="${listPro.price}" name="price" required><br><br>

    <select name="category">
        <c:forEach items="${listCategory}" var="item">
            <option value="${item.id}">${item.name}</option>
        </c:forEach>

    </select>
    <button type="submit" name="action"  value="edit">Edit</button>
</form>
</body>
</html>
