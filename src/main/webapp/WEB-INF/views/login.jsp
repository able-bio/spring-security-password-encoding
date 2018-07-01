<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
        <div id="login-box">

            <h2>Log in using your credentials!</h2>

            <c:if test="${not empty msg}">
                <div class="msg">
                        ${msg}
                </div>
            </c:if>


            <form name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post"">

                <c:if test="${not empty error}">
                    <div class="error" style="color:red">${error}</div>
                </c:if>

                <div class="form-group">
                    <label for="username">Username: </label>
                    <input type="text" id="username" name="username" class="form-control"/>

                </div>

                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>

                <input type="submit" value="Login" class="btn btn-default"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            </form>
        </div>

</body>
</html>

