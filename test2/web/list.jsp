<%--
  Created by IntelliJ IDEA.
  User: 张辽
  Date: 2019/12/25
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息表</title>
</head>
<body style="padding-top: 20px">
<tr>
    <td>id</td>
    <td>name</td>
    <td>desc</td>
    <td>contact</td>
</tr>
<c:forEach items="${customerList}" var="customer">
    <tr>
        <td>${customer.id}</td>
        <td>${customer.name}</td>
        <td>${customer.desc}</td>
        <td>${customer.contact}</td>
    </tr>
</c:forEach>
</body>
</html>
