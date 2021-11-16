<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty requestScope.tickets}">
        <h1>
            Список купленных мест:
        </h1>
        <ul>
            <c:forEach var="ticket" items="${requestScope.tickets}">
                <li>${fn:toLowerCase(ticket.seatNo)} ___ !!!</li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
