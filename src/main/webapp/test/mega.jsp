<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>MEGA</title>
</head>
<body>

<h2>SCRIPLET</h2>
<p>MESSAGE: ${message}</p>
<p>Date: <%=request.getAttribute("date")%></p>
<% final String msg = "123"; %>
<% for (String value: (List<String>) request.getAttribute("records")) { %>
<p>item: <%=value%>.</p>
<% } %>
<hr />

<h2>JSTL</h2>
<p>Message: <c:out value="${message}" /></p>
<p>Date: <c:out value="${date}" /></p>

<c:forEach var="record" items="#{records}" varStatus="interator" >
    <p>record: ${interator.index + 1}. <c:out value="${record}" />.</p>
</c:forEach>
</body>
</html>
