<%--
  Created by IntelliJ IDEA.
  User: 张辽
  Date: 2019/12/25
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
</head>
<body style="padding-top: 20px">
<tr>
    <td>id</td>
    <td>name</td>
    <td>desc</td>
    <td>contact</td>
</tr>
<form action="insert.jsp"method="post">
    <table align="center" cellpadding="10" cellspacing="10" border="1" width="60px">
        <tr>
            <td>id</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>desc</td>
            <td><input type="text" name="desc"></td>
        </tr>
        <tr>
            <td>desc</td>
            <td><input type="text" name="contact"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
</body>
</html>
