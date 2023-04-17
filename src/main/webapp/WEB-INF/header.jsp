<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    body {
        background-color: ${userColor};
    }
</style>
<body>
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="x-circle-fill" viewBox="0 0 16 16">
        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"></path>
    </symbol>
</svg>
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="arrow-right-short" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
              d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8z"></path>
    </symbol>
    <symbol id="x-lg" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
              d="M13.854 2.146a.5.5 0 0 1 0 .708l-11 11a.5.5 0 0 1-.708-.708l11-11a.5.5 0 0 1 .708 0Z"></path>
        <path fill-rule="evenodd"
              d="M2.146 2.146a.5.5 0 0 0 0 .708l11 11a.5.5 0 0 0 .708-.708l-11-11a.5.5 0 0 0-.708 0Z"></path>
    </symbol>
</svg>

<header class="mb-4">
    <nav class="navbar navbar-expand-md navbar-dark bg-primary">
        <div class="container-fluid">
            <img src="https://img.icons8.com/color/64/null/doughnut-chart--v1.png"/>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">WChat</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <c:choose>

                        <c:when test="${!empty sessionScope.username}">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page"
                                   href="${pageContext.request.contextPath}/secured">Chat</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page"
                                   href="${pageContext.request.contextPath}/secured/preferences">Preferences</a>
                            </li>
                        </c:when>

                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page"
                                   href="${pageContext.request.contextPath}/login">Login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page"
                                   href="${pageContext.request.contextPath}/register">Register</a>
                            </li>
                        </c:otherwise>

                    </c:choose>

                </ul>
            </div>
            <c:if test="${!empty sessionScope.username}">
                <a href="${pageContext.request.contextPath}/secured/logout"
                   class="btn btn-outline-primary rounded-circle p-3 lh-1 bg-light" type="button">
                    <svg class="bi" width="24" height="24">
                        <use xlink:href="#x-lg"></use>
                    </svg>
                    <span class="visually-hidden">Dismiss</span>
                </a>
            </c:if>

        </div>
    </nav>
</header>
