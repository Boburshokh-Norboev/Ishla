<%@ page contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>ISHLA-Kirish</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Tizimga kirish</h1>
		<form action="<%=request.getContextPath()%>/login" method="post">

			<div class="form-group">
				<label for="username">Login:</label> <input type="text"
					class="form-control" id="username" placeholder="Login"
					name="username" required>
			</div>

			<div class="form-group">
				<label for="password">Parol:</label> <input type="password"
					class="form-control" id="password" placeholder="Parol"
					name="password" required>
			</div>


			<button type="submit" class="btn btn-primary">Kirish</button>
		</form>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>