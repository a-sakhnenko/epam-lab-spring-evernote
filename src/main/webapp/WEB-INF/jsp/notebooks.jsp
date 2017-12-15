<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr_Sakhnenko
  Date: 12/15/2017
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All notebooks</title>
</head>
    <body>
        <c:forEach items="${notebooks}" var="notebook">
            <%--<td><c:out value="${notebook.name}"/></td>--%>
            <a href="/notebooks?id=<c:out value="${notebook.id}"/>">
        </c:forEach>
    </body>
</html>
