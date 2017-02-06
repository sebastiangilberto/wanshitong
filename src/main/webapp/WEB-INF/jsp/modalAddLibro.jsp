<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Modal -->
<div class="modal fade" id="modalAddLibro" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="padding: 35px 50px;">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>
					<span class="glyphicons glyphicons-book-open"></span> Nuevo Libro
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form:form id="loginForm" method="POST"
					action="${pageContext.request.contextPath}/biblioteca/addLibro"
					commandName="LibroDto">
					<div class="form-group">
						<form:input path="titulo" placeholder="Titulo" required="required"/>
					</div>
					<div class="form-group">
						<form:input path="autor" placeholder="Autor" required="required"/>
					</div>
					<div class="form-group">
						<form:input path="genero" placeholder="Genero" required="required"/>
					</div>
					<div class="form-group">
						<form:input type="filepicker" path="tapa"
							data-fp-button-text="Agregar Tapa"
							data-fp-apikey="A3Lel4pTUQ0uP92Q4qpHSz"
							data-fp-mimetypes="image/*" data-fp-container="window"
							data-fp-services="IMAGE_SEARCH,COMPUTER,URL"
							onchange="console.log(event.fpfile.url)"/>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="glyphicons glyphicons-ok"></span> Confirmar
					</button>
				</form:form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-danger btn-default pull-right"
					data-dismiss="modal">
					<span class="glyphicon glyphicon-remove"></span> Cancel
				</button>
			</div>
		</div>

	</div>
</div>