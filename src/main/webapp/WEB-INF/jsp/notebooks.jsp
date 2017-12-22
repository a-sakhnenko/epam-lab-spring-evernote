<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div> NotebookId: <p>${notebook.id}</p> <span> | </span> NotebookName: <p> ${notebook.name}</p></div>
    </c:forEach>

</body>
</html>
