<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- Head -->
<head>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- Javascript -->
<link rel="stylesheet" href="resources/css/biblioteca.css"
	type="text/css" media="all">
<script src="resources/js/biblioteca.js"></script>
<script src="https://api.filestackapi.com/filestack.js"></script>

</head>

<jsp:include page="fragments/header.jsp" />
<!-- Body -->
<body>

	<div class="container">

		<section>
			<button class="btn btn-primary">Add Book</button>
		</section>

		<section>
			<c:forEach items="${libros}" var="libro">
				<figure>
					<img src="${libro.tapa}" />
					<figcaption>
						<p>${libro.titulo}</p>
						<p>${libro.autor}</p>
					</figcaption>
				</figure>

			</c:forEach>
		</section>

	</div>

</body>
</html>