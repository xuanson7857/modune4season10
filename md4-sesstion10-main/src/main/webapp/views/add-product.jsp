<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/28/2023
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/product">
    <label>name</label>
    <input type="text"name="name" required><br><br>

    <label >price</label>
    <input type="number"  name="price" required><br><br>

   <select name="category">
       <c:forEach items="${listCategory}" var="item">
           <option value="${item.id}">${item.name}</option>
       </c:forEach>

   </select>
    <button type="submit" name="action"  value="add">Add</button>
</form>
</body>
</html>
