<%--
  Created by IntelliJ IDEA.
  User: zhengguohuang
  Date: 2018/5/13
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>editUser.jsp</title>
</head>
<body>
<form action='<c:url value="/updateOne" />' method="post">
    id:<input type="hidden" name="id" value='<c:out value="${user.id}"/> '><br>
    name:<input type="text" name="name" value='<c:out value="${user.name}"/> '><br>
    age:<input type="text" name="age" value='<c:out value="${user.age}"/> '><br>
    <input type="submit" value="修改">
</form>
</body>
</html>

