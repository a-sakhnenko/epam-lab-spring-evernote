<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nb
  Date: 18.12.2017
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Notebook</title>
</head>
<body>
<p>${notebook.id} ${notebook.name}</p>
    <c:forEach items="${notebook.notes}" var="note">
        <p>${note.id} ${note.name}</p>
        <p>${note.body}</p>
    </c:forEach>
</body>
</html>
