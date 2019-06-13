<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 13.06.2019
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>index</title>

    <style>
        .b1 {
            background: #808080; /* Синий цвет фона */
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }

        .b2 {
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }
    </style>
</head>
<body>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<nav class="navbar fixed-top navbar-dark navbar-expand bg-dark">
<%--    <a class="navbar-brand" href="#">Brand</a>--%>
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="index">Home <span class="sr-only">(current)</span></a>
        </li>
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link" href="project-list">PROJECT</a>--%>
<%--        </li>--%>
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link" href="task-list">TASK</a>--%>
<%--        </li>--%>

<%--        <li class="form-inline">--%>
<%--            <input type="text" class="form-control input-sm" placeholder="Email">--%>
<%--        </li>--%>


        <form class="form-inline" target="_blank" method="POST" action="authorization">
            <input type="text" class="form-control input-sm" name="login" placeholder="login">
            <input type="password" class="form-control input-sm" name="password" placeholder="password">
<%--            <label class="checkbox" >--%>
<%--                <input type="checkbox" class="b2">Remember me--%>
<%--            </label>--%>
            <button type="submit" class="b1">Sign in</button></form>



    </ul>
</nav>

<%--<a href="index" style="color: white">MAIN</a> &nbsp;|&nbsp;--%>
<%--<a href="project-list" style="color: white">PROJECT</a> &nbsp;|&nbsp;--%>
<%--<a href="task-list" style="color: white">TASKS</a>--%>
<div class="container text-center">
    <h1>Bootstrap 4 starter template</h1>
    <p class="lead">WELCOME TO REGISTRY MENU TASK MANAGER.</p>

<%--    <div class="row">--%>
<%--        <div class="col-md-4">--%>
<%--            <div class="card card-body">Card</div>--%>
<%--        </div>--%>
<%--        <div class="col-md-4">--%>
<%--            <div class="card card-body">Card</div>--%>
<%--        </div>--%>
<%--        <div class="col-md-4">--%>
<%--            <div class="card card-body">Card</div>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>

</body>
</html>
