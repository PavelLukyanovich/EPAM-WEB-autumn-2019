<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Your Tasks</title>

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

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Tasks</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Add Task</a>
                <a href="<%=request.getContextPath()%>/recycle"
                   class="btn btn-success">Recycle</a>
			</div>
			<br>
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
					<!--   for (Tasks task: tasks) {  -->
					<c:forEach var="tasks" items="${listTasks}">

						<tr>
							<td><c:out value="${tasks.description}" /></td>
							<td><c:out value="${tasks.createDate}" /></td>
							<td><c:out value="${tasks.state}" /></td>
							<td><c:out value="${tasks.userName}" /></td>
							<td><c:out value="${tasks.fileName}" /></td>

							<td><a href="edit?id=<c:out value='${tasks.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${tasks.id}' />">Delete</a>
								<a href="editToRecycle?id=<c:out value='${tasks.id}' />">Recycle</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
