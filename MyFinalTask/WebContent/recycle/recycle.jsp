<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Recycle</title>

<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: darkslategrey" >
        <div>
            <a class="navbar-brand"> Tasks
                App</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Your Tasks</a></li>
        </ul>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/recycleList"
                   class="nav-link">Your Recycle</a></li>
        </ul>
        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="<%=request.getContextPath()%>/logout"
                   class="nav-link">Logout</a></li>
        </ul>
    </nav>
</header>
<div class="row">
    <div class="container">
        <h3 class="text-center">Recycle</h3>
        <hr>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Description</th>
        <th>Create Date</th>
        <th>Task State</th>
        <th>User</th>
        <th>File name</th>
    </tr>
    </thead>
    <tbody>
    <!--   for (Recycle recycle: list) {  -->
    <c:forEach var="recycle" items="${list}">

                      <tr>
                            <td><c:out value="${recycle.description}" /></td>
                            <td><c:out value="${recycle.createDate}" /></td>
                            <td><c:out value="${recycle.state}" /></td>
                            <td><c:out value="${recycle.userName}" /></td>
                            <td><c:out value="${recycle.fileName}" /></td>

                         <td><a href="delete?id=<c:out value='${recycle.id}' />">Delete</a></td>
                     </tr>
                     </c:forEach>
                    </tbody>
                </table>
             </div>
        </div>
    </body>
</html>