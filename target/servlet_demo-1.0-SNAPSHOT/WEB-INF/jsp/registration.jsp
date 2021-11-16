<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="header.jsp" %>

<br>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <%--        <form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
            <label for="imageId">Image:
                <input type="file" name="image" id="imageId">
            </label>
            <br><br>--%>
    <label for="nameId"><fmt:message key="page.registration.name"/>
        <input type="text" name="userName" id="nameId">
    </label>
    <br>
    <br>
    <label for="birthdayId"><fmt:message key="page.registration.birthday"/>
        <input type="date" name="birthDay" id="birthdayId" required>
    </label>
    <br>
    <br>
    <label for="emailId"><fmt:message key="page.registration.email"/>
        <input type="text" name="eMail" id="emailId">
    </label>
    <br>
    <br>
    <label for="passwordId"><fmt:message key="page.registration.password"/>
        <input type="password" name="password" id="passwordId">
    </label>
    <br>
    <br>
    <select name="role" id="roleId">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value=${role}>${role}</option>
        </c:forEach>
    </select>
    <br><br>
        <%--        <br><br>
                <select name="gender" id="genderId">
                    <c:forEach var="gender" items="${requestScope.genders}">
                        <option value=${gender}>${gender}</option>
                    </c:forEach>
                </select>
                <br><br>--%>
    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value=${gender}>${gender}
        <br>
    </c:forEach>
    <br>
    <br>
    <input type="checkbox" name="check" value="check1">Check1
    <br>
    <br>
    <input type="checkbox" name="check" value="check2">Check2
    <br>
    <br>
    <button type="reset">Reset</button>
    <button type="submit">Submit</button>
    <br>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </c:if>
</form>
<%@include file="footer.jsp" %>
</body>
</html>