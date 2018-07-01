<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name == null}">
    <h1>Please <a href="/login">login</a> or <a href="/register">register</a>.</h1>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h1>Welcome ${pageContext.request.userPrincipal.name}! | <a href="<c:url value="/j_spring_security_logout"/>">Logout</a></h1>
</c:if>
</body>
</html>
