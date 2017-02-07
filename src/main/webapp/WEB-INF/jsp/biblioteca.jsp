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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css"
	type="text/css" media="all">
	<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/dataTables.material.min.css"
	type="text/css" media="all">
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.13/js/dataTables.material.min.js"></script>

<!-- Body -->
<body>

	<div class="container">
		<div class="row">
			<section>
				<button type="button" class="btn btn-primary btn-lg" id="btnAddBook">Add
					Book</button>
				<button type="button" class="btn btn-primary btn-lg" id="btnCovers"
					onclick="showCovers()">Covers</button>
				<button type="button" class="btn btn-primary btn-lg" id="btnTabla"
					onclick="showTabla()">Tabla</button>
			</section>
			<section>
				<div class="error">
					<c:if test="${not empty errorMessage}">
						<c:out value="${errorMessage}" />
					</c:if>
				</div>
			</section>
			<c:if test="${fn:length(libros)>0}">
				<section id="sectionCovers">
					<c:forEach items="${libros}" var="libro" varStatus="status">
						<figure id="libro_${status.index}">
							<img src="${libro.tapa}" />
							<figcaption>
								<p>${libro.titulo}</p>
								<p>${libro.autor}</p>
								<p id="id_${status.index}" class="hidden">${libro.id}</p>
								<button class="btn btn-danger text-center" type="button"
									onclick="removeLibro(${status.index});">X</button>
								<button type="button" class="btn btn-info"
									onclick="detalleLibro(${status.index});">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</figcaption>
						</figure>
					</c:forEach>
				</section>

				<section id="sectionTable">

					<table id="tableLibros" class="mdl-data-table" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<td class="text-left" width="*">Titulo</td>
								<td class="text-left" width="*">Autor</td>
								<td class="text-left" width="*">Genero</td>
								<td class="text-left hidden"></td>
								<td class="text-left" width="5%">&nbsp;</td>
								<td class="text-left" width="5%">&nbsp;</td>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${libros}" var="libro" varStatus="status">
								<tr id="fila_${status.index}">
									<td><c:out value="${libro.titulo}" /></td>
									<td><c:out value="${libro.autor}" /></td>
									<td><c:out value="${libro.genero}" /></td>
									<td class="hidden"><c:out value="${libro.id}" /></td>
									<td width="5%"><button class="btn btn-danger text-center"
											type="button" onclick="removeLibro(${status.index});">X</button>
									</td>
									<td><button type="button" class="btn btn-info"
											onclick="detalleLibro(${status.index});">
											<span class="glyphicon glyphicon-search"></span>
										</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

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