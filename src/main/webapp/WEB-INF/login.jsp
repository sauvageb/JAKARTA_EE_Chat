<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

<c:import url="header.jsp"></c:import>

<div class="container">

    <div class="col-6 offset-3">
        <h1>Login</h1>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group mb-2">
                <label for="username">Username</label>
                <input type="text" class="${isError ? 'form-control is-invalid' :'form-control'}" id="username"
                       name="username" placeholder="Enter username">
                <div class="invalid-feedback">Please enter a valid username.</div>
            </div>
            <div class="form-group mb-2">
                <label for="password">Password</label>
                <input type="password" class="${isError ? 'form-control is-invalid' :'form-control'}" id="password"
                       name="password" placeholder="Enter Password">
                <div class="invalid-feedback">Please enter a valid password.</div>
            </div>
            <div class="form-group mb-2">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form>
    </div>
</div>


</body>
</html>
