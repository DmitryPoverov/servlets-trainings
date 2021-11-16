<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br>
<div>
    <c:if test="${not empty sessionScope.user}">
        <div>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit">Log out</button>
            </form>
        </div>
    </c:if>
    <div>
        <form action="${pageContext.request.contextPath}/locale" method="post">
            <button type="submit" name="lang" value="ru_RU">RU</button>
            <button type="submit" name="lang" value="en_EN">EN</button>
        </form>
    </div>
    <br>
    <h3>Header - Верх страницы. Here logout is visible only when user is login.</h3>
    <fmt:setLocale value="${sessionScope.lang !=null ? sessionScope.lang : (param.lang !=null ? param.lang : 'en_US')}"/>
    <fmt:setBundle basename="translations"/>
</div>

