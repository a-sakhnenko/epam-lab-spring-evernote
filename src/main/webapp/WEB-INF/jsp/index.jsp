<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>
</head>

<body>
<h2>${message}</h2>
<div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="post" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Current User: ${pageContext.request.userPrincipal.name}</h2>
        <h3><a onclick="document.forms['logoutForm'].submit()">Logout</a></h3>
    </c:if>
</div>
</body>
</html>