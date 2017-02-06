<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<!-- Header -->
<jsp:include page="fragments/header.jsp" />

<!-- Javascript -->
<link rel="stylesheet" href="resources/css/biblioteca.css"
	type="text/css" media="all">
<script src="https://api.filestackapi.com/filestack.js"></script>
<script src="resources/js/biblioteca.js"></script>

<!-- Body -->
<body>

	<div class="container">
		<div class="row">
			<section>
				<button type="button" class="btn btn-primary btn-lg" id="btnAddBook">Add
					Book</button>
			</section>
			<section>
				<div class="error">
					<c:if test="${not empty errorMessage}">
						<c:out value="${errorMessage}" />
					</c:if>
				</div>
			</section>
			<c:if test="${fn:length(libros)>0}">
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
			</c:if>
		</div>
	</div>

	<!-- Modal Upload -->
	<%@include file="modalAddLibro.jsp"%>

</body>

<!-- Footer -->
<jsp:include page="fragments/footer.jsp" />

</html>