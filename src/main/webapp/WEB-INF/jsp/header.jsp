<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>
<c:if test="${not empty sessionScope.user}">
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <button type="submit">Log out</button>
    </form>
</c:if>
<br>
<h3>Header - Верх страницы. Here logout is visible only when user is login.</h3>
