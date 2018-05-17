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
    <title>reg.jsp</title>
</head>
<body>
<form action='<c:url value="/reg.jsp" />' method="post">
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>

