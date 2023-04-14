<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    body {
        background-color: ${userColor};
    }
</style>

<body>

<form action="${pageContext.request.contextPath}/secured" method="post">
    <input type="text" name="firstnameInput" placeholder="Your firstname..">
    <button type="submit">Ok</button>
</form>

<a href="${pageContext.request.contextPath}/secured/logout">Close Session</a>

<c:forEach items="${sessionScope.users}" var="firstname">
    <p>${firstname}</p>
</c:forEach>

</body>
</html>
