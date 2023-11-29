<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/28/2023
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCategory}" var="item" >
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.status}</td>
            <td><a href="/category?action=edit&id=${item.id}">Edit</a></td>
            <td><a href="/category?action=delete&id=${item.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
