<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="tech.aistar.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: js
  Date: 2019/6/12
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User u1 = new User(1,"tom","123",new Date(),"xx.png",1);
    User u2 = new User(2,"jack","123",new Date(),"xx.png",1);
    User u3 = new User(3,"mike","123",new Date(),"xx.png",1);
    User u4 = new User(4,"lili","123",new Date(),"xx.png",1);
    User u5 = new User(5,"success","123",new Date(),"xx.png",1);

    List<User> users = new ArrayList<>();

    users.add(u1);
    users.add(u2);
    users.add(u3);
    users.add(u4);
    users.add(u5);

    request.setAttribute("users",users);
%>

<c:if test="${empty users}">sorry 没有该用户</c:if>
<c:if test="${!empty users}">
<table>
    <tr>
        <th>索引</th>
        <th>序号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>生日</th>
    </tr>
<tr>
    <c:forEach items="${users}" varStatus="vs" var="u" begin="0" end="4" step="1">
    <td>${vs.index}</td>
    <td>${vs.count}</td>
    <td>${u.username}</td>
    <td>${u.password}</td>
        </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>
