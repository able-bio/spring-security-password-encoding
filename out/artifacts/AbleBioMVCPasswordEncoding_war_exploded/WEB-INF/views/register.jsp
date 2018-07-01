<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Please fill in your credentials to register:</h2>

<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="user">
    <h4>Username</h4>
    <label for="username">Username: </label>
    <form:input path="username" id="username"/>

    <h4>Password</h4>
    <label for="password">Password: </label>
    <form:password path="password" id="password"/>

    <input type="submit" value="Register">
</form:form>
</body>
</html>
