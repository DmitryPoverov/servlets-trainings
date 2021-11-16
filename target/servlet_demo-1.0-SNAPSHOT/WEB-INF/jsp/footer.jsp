<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Footer - Низ страницы. Here logout is always visible.</h3>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit">Log out</button>
</form>