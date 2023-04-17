<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <div class="card-header text-muted d-flex justify-content-start align-items-center p-3">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3-bg.webp"
                             alt="avatar 3" style="width: 40px; height: 100%;">
                        <input type="text" class="form-control form-control-lg" id="exampleFormControlInput1"
                               placeholder="Type message">
                        <a class="ms-1 text-muted" href="#!"><i class="fas fa-paperclip"></i></a>
                        <a class="ms-3 text-muted" href="#!"><i class="fas fa-smile"></i></a>
                        <a class="ms-3" href="#!"><i class="fas fa-paper-plane"></i></a>
                    </div>

                    <div class="card-body" data-mdb-perfect-scrollbar="true">
                        <div class="d-flex flex-row justify-content-start">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3-bg.webp"
                                 alt="avatar 1" style="width: 45px; height: 100%;">
                            <div>
                                <p class="small p-2 ms-3 mb-1 rounded-3" style="background-color: #f5f6f7;">Hi</p>
                                <p class="small p-2 ms-3 mb-1 rounded-3" style="background-color: #f5f6f7;">What are you
                                    doing tomorrow? Can we come up a bar?</p>
                                <p class="small ms-3 mb-3 rounded-3 text-muted">23:58</p>
                            </div>
                        </div>

                        <div class="divider d-flex align-items-center mb-4">
                            <p class="text-center mx-3 mb-0" style="color: #a2aab7;">Today</p>
                        </div>

                        <div class="d-flex flex-row justify-content-end mb-4 pt-1">
                            <div>
                                <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary">Hiii, I'm good.</p>
                                <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary">Long time no see!
                                    Tomorrow office. will be free on sunday.</p>
                                <p class="small me-3 mb-3 rounded-3 text-muted d-flex justify-content-end">00:06</p>
                            </div>
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava4-bg.webp"
                                 alt="avatar 1" style="width: 45px; height: 100%;">
                        </div>

                        <div class="d-flex flex-row justify-content-start mb-4">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3-bg.webp"
                                 alt="avatar 1" style="width: 45px; height: 100%;">
                            <div>
                                <p class="small p-2 ms-3 mb-1 rounded-3" style="background-color: #f5f6f7;">Okay</p>
                                <p class="small p-2 ms-3 mb-1 rounded-3" style="background-color: #f5f6f7;">We will
                                    go on
                                    Sunday?</p>
                                <p class="small ms-3 mb-3 rounded-3 text-muted">00:07</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
