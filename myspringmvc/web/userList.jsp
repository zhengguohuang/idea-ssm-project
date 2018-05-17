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
    <title>selectOne.jsp</title>
</head>
<body>
hello
    <table border="1px">
        <tr>
            <td>ID</td>
            <td>NAME</td>
            <td>AGE</td>
            <td>删除</td>
            <td>修改</td>
        </tr>
        <c:forEach items="${userList}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.age}</td>
                <td><a href='<c:url value="deleteOne?uid=${u.id}"/> '>删除</a> </td>
                <td><a href='<c:url value="editOne?uid=${u.id}"/> '>修改</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

