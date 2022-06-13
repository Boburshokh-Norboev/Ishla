<%@ page contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ISHLA-Registratsiya</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container">

    <h2>Ro\yhatdan o'tish</h2>
    <div class="col-md-6 col-md-offset-3">
        <div class="alert alert-success center" role="alert">
            <p>${NOTIFICATION}</p>
        </div>

        <form action="<%=request.getContextPath()%>/register" method="post">

            <div class="form-group">
                <label for="firstname">Ism :</label>
				<input type="text"
					   class="form-control" id="firstname" placeholder="First Name" name="Boltavoy" required>
            </div>

            <div class="form-group">
                <label for="uname">Familiya :</label> <input type="text"
                                                             class="form-control" id="uname" placeholder="Teshavoyev"
                                                             name="lastName" required>
            </div>

            <div class="form-group">
                <label for="username">Login :</label> <input type="text"
                                                             class="form-control" id="username" placeholder="qalamqosh))"
                                                             name="username" required>
            </div>

            <div class="form-group">
                <label for="password">Parol :</label> <input type="password"
                                                            class="form-control" id="password" placeholder="adminadmin"
                                                            name="password" required>
            </div>

            <button type="submit" class="btn btn-primary">Ro'yhatdan o'tish</button>

        </form>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>