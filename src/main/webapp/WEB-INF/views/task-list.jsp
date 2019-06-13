<%@ page import="ru.kravchenko.ee.constant.FieldConst" %>
<%@ page import="ru.kravchenko.ee.entity.Task" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<jsp:include page="prefix.jsp">--%>
<%--    <jsp:param name="title" value="PROJECTS" />--%>
<%--</jsp:include>--%>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Project</title>
</head>

<body>
<script src="js/bootstrap.min.js"></script>
<nav class="navbar fixed-top navbar-dark navbar-expand bg-dark">
    <%--    <a class="navbar-brand" href="#">Brand</a>--%>
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="main">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="project-list">PROJECT</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="task-list">TASK</a>
        </li>
    </ul>
</nav>

<h1>TASK MANAGEMENT</h1>

<%
    final Object projectsObject = request.getAttribute(FieldConst.TASKS);
    final Collection<Task> tasks = (Collection<Task>) projectsObject;
%>
<%--<table width="100%" cellpadding="10" cellspacing="10" border="1" style="...">--%>

<div class="col-lg-9 col-md-8">
    <div class="table-responsive">
        <table class="table table-striped">
            <thead class="thead-inverse">

    <tr>
        <th width="60" nowrap="nowrap" >№</th>
        <th width="200" nowrap="nowrap" align="left">NAME</th>
        <th width="100%" align="left">DESCRIPRION</th>
        <th nowrap="nowrap"></th>
        <th nowrap="nowrap"></th>
        <th nowrap="nowrap"></th>
    </tr>

            </thead>
            <tbody>

    <% int index = 1; %>
    <% for (final Task task: tasks) { %>
    <tr>
        <td align="center"><%=index%>.</td>
        <td align="left"><%=task.getName()%></td>
        <td align="left"><%=task.getDescription()%></td>
        <td align="center">
            <a href="task-list?taskId=<%=task.getId()%>" target="_blank" style="color: black">TASKS</a>
        </td>
        <td align="center">
            <a href="task-edit?id=<%=task.getId()%>" style="color: black">EDIT</a>
        </td>
        <td align="center">
            <a href="task-remove?id=<%=task.getId()%>" style="color: black">REMOVE</a>
        </td>
    </tr>
    <% index++;%>
    <% } %>
<%--</table>--%>

            </tbody>
        </table>
    </div>
</div>


<br />

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td nowrap="nowrap">
            <form action="task-create">
                <button type="submit" class="green">CREATE TASKS</button>
            </form>
        </td>
        <td width="20" nowrap="nowrap">&nbsp;</td>
        <td nowrap="nowrap">
            <form>
                <input type="hidden" name="time" value="<%=System.currentTimeMillis()%>" />
                <button type="submit" class="gray">REFRESH</button>
            </form>
        </td>
        <td width="100%">
            &nbsp;
        </td>
    <tr/>
</table>

</body>
</html>
<%--<jsp:include page="posfix.jsp" />--%>
