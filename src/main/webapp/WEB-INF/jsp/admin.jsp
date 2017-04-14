<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<c:set var="path" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<!-- Header -->
<jsp:include page="header.jsp" />

<!-- Javascript && Css Admin -->
<link rel="stylesheet" href="${path}/resources/css/admin.css"
	type="text/css" media="all">

<body>

	<jsp:include page="menu.jsp"></jsp:include>

	<div class="container-fluid main">

		<h1>Title : ${title}</h1>
		<h2>Message : ${message}</h2>

		<div class="row">
			<a type="button" class="btn btn-info" href="${path}/admin/libros">Libros</a>
		</div>
		<div class="row">
			<a type="button" class="btn btn-info" href="${path}/admin/peliculas">Peliculas</a>
		</div>

	</div>
</body>
</html>