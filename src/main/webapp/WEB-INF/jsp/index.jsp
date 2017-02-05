<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- Head -->
<head>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>

<jsp:include page="fragments/header.jsp" />

<body>
	<div class="container">
		<h1>Bienvenido ${usuario.username}</h1>
		<a href="biblioteca">Biblioteca</a>
	</div>
</body>

<jsp:include page="fragments/footer.jsp" />

</html>