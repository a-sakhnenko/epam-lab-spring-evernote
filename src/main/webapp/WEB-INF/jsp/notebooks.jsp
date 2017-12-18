<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nb
  Date: 18.12.2017
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Notebooks</title>
</head>
<body>
    <c:forEach items="${notebooks}" var="notebook">
        <p>${notebook.id} ${notebook.name}</p>
    </c:forEach>
</body>
</html>
