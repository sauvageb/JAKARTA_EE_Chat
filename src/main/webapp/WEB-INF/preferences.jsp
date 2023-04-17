<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Preferences</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

<c:import url="header.jsp"></c:import>

<div class="container">

    <div class="col-6 offset-3">
        <h1>Preferences</h1>

        <form action="${pageContext.request.contextPath}/secured/preferences" method="post">
            <div class="form-group mb-2">
                <label for="color">Background color :</label>
                <select name="colorChoice" id="color" class="form-select">
                    <option value="white">Default</option>
                    <option value="grey">Grey</option>
                    <option value="deepskyblue">Blue</option>
                    <option value="black">Black</option>
                </select>
            </div>
            <div class="form-group mb-2">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
