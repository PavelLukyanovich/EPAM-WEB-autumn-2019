<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Tasks Management</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: darkslategrey">
			<div>
				<a class="navbar-brand"> Tasks
					App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Tasks</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${tasks != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${tasks == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${tasks != null}">
            			Edit Task
            		</c:if>
						<c:if test="${tasks == null}">
            			Add New Task
            		</c:if>
					</h2>
				</caption>

				<c:if test="${tasks != null}">
					<input type="hidden" name="id" value="<c:out value='${tasks.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Task description</label> <input type="text"
						value="<c:out value='${tasks.description}' />" class="form-control"
						name="description" required="required" minlength="1">
				</fieldset>

				<fieldset class="form-group">
					<label>Task create date</label> <input type="date"
						value="<c:out value='${tasks.createDate}' />" class="form-control"
						name="createDate" minlength="1">
				</fieldset>

				<fieldset class="form-group">
					<label>Task state</label> <select class="form-control"
						name="isDone">
						<option value="false">In Progress</option>
						<option value="true">Complete</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Task user </label> <input type="text"
						value="<c:out value='${tasks.userName}' />" class="form-control"
						name="userName" required="required">
				</fieldset>

                <fieldset class="form-group">
                    <label>File namme </label> <input type="file" formmethod="post" formenctype="multipart/form-data"
                         value="<c:out value='${tasks.fileName}' />" class="form-control"
                         name="fileName">
                </fieldset>

				<button type="submit" class="btn btn-success">Save task</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
