<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<br>
<div>
    <fmt:setLocale value="${sessionScope.lang !=null ? sessionScope.lang : (param.lang !=null ? param.lang : 'en_US')}"/>
    <fmt:setBundle basename="translations"/>
    <c:if test="${not empty sessionScope.user}">
        <div>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit"><fmt:message key="page.registration.logout"/></button>

            </form>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/" method="get">
                <button type="submit"><fmt:message key="page.registration.index"/></button>
            </form>
        </div>
    </c:if>
    <div>
        <form action="${pageContext.request.contextPath}/locale" method="post">
            <button type="submit" name="lang" value="ru_RU">RU</button>
            <button type="submit" name="lang" value="en_EN">EN</button>
        </form>
        <form action="${pageContext.request.contextPath}/login" method="get">
            <button type="submit"><fmt:message key="page.registration.login"/></button>
        </form>
    </div>
    <h3><fmt:message key="page.registration.header"/></h3>
    <br>
</div>

