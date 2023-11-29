<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/28/2023
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="product?action=add">Them moi san pham</a>
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>pice</th>
        <th>danh muc</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="item" >
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.category.name}</td>
            <td><a href="/product?action=edit&id=${item.id}">Edit</a></td>
            <td><a href="/product?action=delete&id=${item.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
