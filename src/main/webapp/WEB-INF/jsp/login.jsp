<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <br>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="emailId"><fmt:message key="page.registration.email"/>
            <input type="text" name="email" id="emailId" value="${param.email}" required>
        </label>
        <br>
        <br>
        <label for="passwordId"><fmt:message key="page.registration.password"/>
            <input type="password" name="password" id="passwordId" required>
        </label>
        <button type="submit">Login</button>
        <a href="${pageContext.request.contextPath}/registration">
            <button type="button">Registration</button>
        </a>
        <c:if test="${param.error !=null}">
            <div style="color: red">
                <span>Email or password is not correct.</span>
            </div>
        </c:if>
    </form>
    <%@include file="footer.jsp"%>
</body>
</html>
