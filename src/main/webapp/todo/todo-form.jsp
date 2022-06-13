<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ISHLA</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> ISHLA</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Barcha vazifalar</a></li>
			</ul>
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Chiqish</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${todo != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${todo == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${todo != null}">
            			Edit Todo
            		</c:if>
						<c:if test="${todo == null}">
            			Add New Todo
            		</c:if>
					</h2>
				</caption>

				<c:if test="${todo != null}">
					<input type="hidden" name="id" value="<c:out value='${todo.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label for="title">Nomi </label>
					<input type="text"
						value="<c:out value='${todo.title}' />" class="form-control"
						name="title" id="title" required="required" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label for="description">Ta'rifi</label> <input type="text"
						value="<c:out value='${todo.description}' />" class="form-control"
						name="description" id="description" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label for="isDone">Holati</label> <select class="form-control"
						name="isDone" id="isDone">
						<option value="false">In Progress</option>
						<option value="true">Complete</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label for="targetDate">Muddati</label> <input type="date"
						value="<c:out value='${todo.targetDate}' />" class="form-control"
						name="targetDate" id="targetDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Saqlash</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
