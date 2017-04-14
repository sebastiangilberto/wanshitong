<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="url" value="${pageContext.request.requestURL}"/>
<c:set var="server" value="${pageContext.request.serverName}" />
<c:set var="localName" value="${pageContext.request.localName}" />
<c:set var="scheme" value="${pageContext.request.scheme}" />
<c:set var="servletContextPath" value="${pageContext.servletContext.contextPath}" />
<c:set var="servletContextName" value="${pageContext.servletContext.servletContextName}" />
<c:set var="uri" value="${pageContext.request.requestURI}" />
<c:set var="page" value="${pageContext.page}" />

<!DOCTYPE html>
<html lang="en">

<!-- Header -->
<jsp:include page="fragments/header.jsp" />

<!-- Javascript -->
<link rel="stylesheet" href="${path}/resources/css/admin.css"
	type="text/css" media="all">
<script src="https://api.filestackapi.com/filestack.js"></script>
<script src="${path}/resources/js/alertUtils.js"></script>
<script src="${path}/resources/js/admin.js"></script>
<script src="${path}/resources/js/serviceAdmin.js"></script>
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

	<jsp:include page="fragments/menu.jsp"></jsp:include>

	<p>PATH: <c:out value="${path}"></c:out></p>
	<p>URL: <c:out value="${url}"></c:out></p>
	<p>SERVER:<c:out value="${server}"></c:out></p>
	<p>LOCALNAME: <c:out value="${localName}"></c:out></p>
	<p>SCHEME: <c:out value="${scheme}"></c:out></p>
	<p>SERVLETCONTEXTPATH: <c:out value="${servletContextPath}"></c:out></p>
	<p>SERVLETCONTEXTNAME: <c:out value="${servletContextName}"></c:out></p>
	<p>URI: <c:out value="${uri}"></c:out></p>
	<p>PAGE: <c:out value="${page}"></c:out></p>
	
	<div class="container-fluid main">
		<div class="row">
			<div class="messages-list span12"></div>
		</div>

		<div class="row">
			<button type="button" class="btn btn-primary btn-lg"
				id="btnAgregarLibro">Add Book</button>
		</div>

		<!-- Catalogo -->
		<div class="row">
			<div id="movies_catalog">
				<div id="catalog_scroller">
					<c:if test="${fn:length(libros)>0}">
						<section id="sectionTable">

							<table id="tablaLibros" class="mdl-data-table" cellspacing="0"
								width="100%">
								<thead>
									<tr>
										<td class="text-left" width="*">Titulo</td>
										<td class="text-left" width="*">Autor</td>
										<td class="text-left" width="*">Genero</td>
										<td class="text-left" width="5%">&nbsp;</td>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${libros}" var="libro" varStatus="status">
										<tr id="libro_${status.index}" data-id="${libro.id}">
											<td><c:out value="${libro.titulo}" /></td>
											<td><c:out value="${libro.autor}" /></td>
											<td><c:out value="${libro.genero}" /></td>
											<td width="5%">
												<button class="btn btn-danger text-center btnEliminarLibro"
													type="button">X</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</section>
					</c:if>
				</div>
			</div>
		</div>

		<!-- Modal Add Book -->
		<jsp:include page="modalAgregarLibro.jsp"></jsp:include>

		<!-- Modal Add Book -->
		<jsp:include page="modalConfirmacion.jsp"></jsp:include>

	</div>
</body>
</html>
