<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Chat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/d43c0bef8d.js" crossorigin="anonymous"></script>
    <style>
        #chat2 .form-control {
            border-color: transparent;
        }

        #chat2 .form-control:focus {
            border-color: transparent;
            box-shadow: inset 0px 0px 0px 1px transparent;
        }

        .divider:after,
        .divider:before {
            content: "";
            flex: 1;
            height: 1px;
            background: #eee;
        }
    </style>
</head>

<c:import url="header.jsp"></c:import>

<div class="container">
    <div class="col-6 offset-3">
        <h1>Chat</h1>
        <div class="row d-flex justify-content-center">
            <div class="col">
                <div class="card" id="chat2">
                    <form action="${pageContext.request.contextPath}/secured/chat/add" method="post">
                        <div class="card-header text-muted d-flex justify-content-start align-items-center p-3">
                            <input type="text" class="form-control form-control-lg" id="exampleFormControlInput1"
                                   name="message"
                                   placeholder="Type your message">
                            <a class="ms-1 text-muted" href="#!"><i class="fas fa-paperclip"></i></a>
                            <a class="ms-3 text-muted" href="#!"><i class="fas fa-smile"></i></a>
                            <button class="ms-3 border-0" type="submit"><i class="fas fa-paper-plane"></i></button>
                        </div>
                    </form>

                    <div class="card-body" data-mdb-perfect-scrollbar="true">
                        <c:forEach var="msg" items="${messages}">

                            <%--                                <div class="divider d-flex align-items-center mb-4">--%>
                            <%--                                    <p class="text-center mx-3 mb-0" style="color: #a2aab7;">Today</p>--%>
                            <%--                                </div>--%>

                            <fmt:parseDate value="${msg.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="dateMessage"
                                           type="date"/>
                            <c:if test="${msg.sender.username != sessionScope.username}">
                                <div class="d-flex flex-row justify-content-start">
                                    <img src="${msg.sender.pictureUrl}" alt="${msg.sender.pictureUrl}"
                                         style="width: 45px; height: 100%;">
                                    <div>
                                        <p class="small p-2 ms-3 mb-1 rounded-3"
                                           style="background-color: #f5f6f7;">${msg.message}</p>
                                        <p class="small ms-3 mb-3 rounded-3 text-muted">
                                            <fmt:formatDate pattern="hh:mm" value="${dateMessage}"/>
                                        </p>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${msg.sender.username == sessionScope.username}">
                                <div class="d-flex flex-row justify-content-end mb-4 pt-1">
                                    <div>
                                        <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary">${msg.message}</p>
                                        <p class="small me-3 mb-3 rounded-3 text-muted d-flex justify-content-end">
                                            <fmt:formatDate pattern="hh:mm" value="${dateMessage}"/>
                                        </p>
                                    </div>
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava4-bg.webp"
                                         alt="avatar 1" style="width: 45px; height: 100%;">
                                </div>
                            </c:if>


                        </c:forEach>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
