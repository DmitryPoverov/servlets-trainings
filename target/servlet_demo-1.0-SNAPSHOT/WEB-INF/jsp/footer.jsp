<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<br>
<br>
<h3><fmt:message key="page.registration.footer"/></h3>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit"><fmt:message key="page.registration.logout"/></button>
    <br>
    <c:if test="${not empty sessionScope.user}">
        <div>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                Now this logout is visible. ->
                <button type="submit"><fmt:message key="page.registration.logout"/></button>
            </form>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/" method="get">
                <button type="submit"><fmt:message key="page.registration.index"/></button>
            </form>
        </div>
    </c:if>
</form>