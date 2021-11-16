<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <div>
        <br>
        <span>Content. Содержимое.</span>
        <p>Size: ${requestScope.flights.size()}</p>
        <p>Id: ${requestScope.flights.get(0).description}</p>       <%-- Not Null-safe--%>
        <p>Id 2: ${requestScope.flights[1].id}</p>                  <%-- Null-safe--%>
        <p>Map Id 2: ${sessionScope.flightsMap[1].toString()}</p>   <%-- Null-safe--%>
        <p>JSESSIONID: ${cookie["JSESSIONID"].value}</p>
        <p>Header: ${header["Cookie"]}</p>
        <p>Param Id: ${param.id}</p>                                <%-- Null-safe--%>
        <p>Param test: ${param.test}</p>                            <%-- Null-safe--%>
        <p>Is list not empty: ${not empty requestScope.flights}</p>
        <br>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
