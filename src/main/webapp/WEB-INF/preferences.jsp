<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Preferences</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/secured/preferences" method="post">
    <select name="colorChoice">
        <option value="grey">Grey</option>
        <option value="deepskyblue">Blue</option>
        <option value="red">Red</option>
        <option value="black">Black</option>
    </select>
    <button type="submit">Ok</button>
</form>


</body>
</html>
